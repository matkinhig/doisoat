package doisoat.services;

import doisoat.conn.ConnectionUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import doisoat.models.VNPayFooterModel;
import doisoat.models.VNPayHeaderModel;
import doisoat.models.VNPayModel;
import doisoat.services.IResultCompare;
import doisoat.servlet.VnPayCompareListServlet;
import doisoat.utils.ReadFileUtils;
import doisoat.utils.StringUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TransactionServiceImpl {

    private VNPayHeaderModel dataHeader;
    private VNPayFooterModel dataFooter;
    private ArrayList<VNPayModel> results = null; // get set
    private ArrayList<VNPayModel> errorList = null;

    public void setResults(ArrayList<VNPayModel> results) {
        this.results = results;
    }

    public void setErrorList(ArrayList<VNPayModel> errorList) {
        this.errorList = errorList;
    }

    public ArrayList<VNPayModel> getResults() {
        return results;
    }

    public ArrayList<VNPayModel> getErrorList() {
        return errorList;
    }

    private static final String CODE_VNPAY_CO_VIETBANK_KHONG = "35";
    private static final String CODE_VNPAY_KHONG_VIETBANK_CO = "31";

    private static SimpleDateFormat dftDate = new SimpleDateFormat("MMdd");
    private static SimpleDateFormat dftTime = new SimpleDateFormat("HHmmss");
    private static SimpleDateFormat dftCreated = new SimpleDateFormat("dd-MM-yyyy");

    private int checkExistItem(VNPayModel item, ArrayList<VNPayModel> ls) {
        for (int i = 0; i < ls.size(); i++) {
            if (item.systemTrace.trim().equalsIgnoreCase(ls.get(i).systemTrace.trim())) {
                return i;
            }
        }
        return -1;
    }

    public boolean compareData(File file, String fromDate, String toDate) {
        if (file == null || StringUtils.isEmpty(fromDate) || StringUtils.isEmpty(toDate)) {
            return false;
        }
        ArrayList<VNPayModel> resultsTemp = new ArrayList<>();
        ArrayList<VNPayModel> errorListTemp = new ArrayList<>();

        ArrayList<VNPayModel> vnpays = getContentFile(file);
        ArrayList<VNPayModel> localTransactions = new ArrayList<>();
        try {
            localTransactions = DBServices.getDb1(fromDate, toDate);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println(localTransactions);
        // COMPARE DU LIEU
        if (vnpays.size() > 0 && localTransactions.isEmpty()) {
            for (VNPayModel item : vnpays) {
                item.processingCompareCode = CODE_VNPAY_CO_VIETBANK_KHONG;
                errorListTemp.add(item);
                resultsTemp.add(item);
            }
        } else if (vnpays.isEmpty() && localTransactions.size() > 0) {
            for (VNPayModel item : localTransactions) {
                item.processingCompareCode = CODE_VNPAY_KHONG_VIETBANK_CO;
                errorListTemp.add(item);
                resultsTemp.add(item);
            }
        } else {
            for (int i = localTransactions.size() - 1; i >= 0; i--) {
                VNPayModel dataLocal = localTransactions.get(i);
                int index = checkExistItem(dataLocal, vnpays);
                if (index == -1) {
                    dataLocal.processingCompareCode = CODE_VNPAY_KHONG_VIETBANK_CO;

                    resultsTemp.add(dataLocal);
                    errorListTemp.add(dataLocal);
                } else {
                    VNPayModel vnpay = vnpays.get(index);
                    if (dataLocal.compareData(vnpay)) {
                        dataLocal.responseCode = vnpay.responseCode;
                    } else {
                        dataLocal.processingCompareCode = CODE_VNPAY_KHONG_VIETBANK_CO;
                        vnpay.processingCompareCode = CODE_VNPAY_CO_VIETBANK_KHONG;
                        errorListTemp.add(dataLocal);
                        errorListTemp.add(vnpay);
                        resultsTemp.add(vnpay);
                    }
                    vnpays.remove(index);
                    resultsTemp.add(dataLocal);
                }

                localTransactions.remove(i);
            } // end if check list Bank

            for (int i = 0; i < vnpays.size(); i++) {
                VNPayModel item = vnpays.get(i);
                item.processingCompareCode = CODE_VNPAY_CO_VIETBANK_KHONG;

                errorListTemp.add(item);
                resultsTemp.add(item);
            }
        } // end if doisoat
        this.results = resultsTemp;
        this.errorList = errorListTemp;
        return true;
    }

    public ArrayList<VNPayModel> getContentFile(File file) {
        String value = ReadFileUtils.getContentFile(file);
        String[] arr = value.split("\n");
        ArrayList<VNPayModel> listContent = new ArrayList<>();
        if (arr.length > 0) {
            for (String arr1 : arr) {
                if (arr1.length() == 16) {
                    dataHeader = VNPayHeaderModel.convertHeader(arr1); //đọc header
                } else if (arr1.length() == 45) {
                    dataFooter = VNPayFooterModel.convertHeader(arr1); //đọc footer
                } else {
                    VNPayModel model = VNPayModel.convertData(arr1); //đọc data
                    listContent.add(model);
                }
            }
        }
        return listContent;
    }

    public String exportExcel(ArrayList<VNPayModel> list) {
        if (list == null || list.isEmpty()) {
            return "Không có dữ liệu";
        }
        String[] columns = {"Loại bản ghi", "Mã định dạng thông điệp (NTI)", "Số tài khoản", "Mã xử lý",
            "Số tiền giao dịch", "Số trace hệ thống", "Mã giao dịch", "Giờ giao dịch", "Ngày giao dịch",
            "Ngày thanh toán", "Loại thiết bị", "Mã tổ chức khởi tạo giao dịch", "Số cấp phép giao dịch",
            "Mã số trả lời giao dịch", "Mã số xử lý giao dịch", "Mã số thiết bị chấp nhận thẻ",
            "Thông tin bổ sung"};
        Workbook workbook = new XSSFWorkbook();
        CreationHelper createHelper = workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet("DOI SOAT ZALOPAY");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setColor(IndexedColors.BLACK.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Row headerRow = sheet.createRow(0);
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
            sheet.setColumnWidth(i, 5000);
        }

        for (int i = 0; i < list.size(); i++) {
            VNPayModel item = list.get(i);
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(item.loaiBanGhi);
            row.createCell(1).setCellValue(item.mti);
            row.createCell(2).setCellValue(item.accountNumber);
            row.createCell(3).setCellValue(item.processingCode);
            row.createCell(4).setCellValue(item.amount);
            row.createCell(5).setCellValue(item.systemTrace);
            row.createCell(6).setCellValue(item.transactionCode);
            row.createCell(7).setCellValue(item.transactionTime);
            row.createCell(8).setCellValue(item.transactionDate);
            row.createCell(9).setCellValue(item.paymentDate);
            row.createCell(10).setCellValue(item.deviceType);
            row.createCell(11).setCellValue(item.maKhoiTaoGiaoDich);
            row.createCell(12).setCellValue(item.soGiaoDich);
            row.createCell(13).setCellValue(item.responseCode);
            row.createCell(14).setCellValue(item.processingCompareCode);
            row.createCell(15).setCellValue(item.maSoThietBiChapNhanThe);
            row.createCell(16).setCellValue(item.thongTinBonus);
        }

        SimpleDateFormat dft = new SimpleDateFormat("yyMMdd");
        String curDate = dft.format(new Date());

        String path = "D:/" + curDate + "_SOLVED_DISPUTE.xlsx";
        FileOutputStream fileOutput;
        File file;
        try {
            file = new File(path);
            //file.getParentFile().mkdirs();
            fileOutput = new FileOutputStream(file);
            workbook.write(fileOutput);
            return "Xuất file thành công";
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return "Xuất file thất bại";
    }

// lưu dữ liệu success vô bảng database
    public String writeData(ArrayList<VNPayModel> list, ArrayList<VNPayModel> errors, String des) throws ClassNotFoundException, SQLException {
        String content = "";
        if (list.size() > 0) {
            try {
                DBServices.insertDB(list);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return "Gửi thông tin qua VNPay thất bại";
            } catch (SQLException e) {
                e.printStackTrace();
                return "Gửi thông tin qua VNPay thất bại";
            }

        }
        if (errors.size() > 0) {
            if (dataHeader != null) {
                content = dataHeader.LoaiBanGhi + dataHeader.MaSoBank + dataHeader.NgayGiaoDich;
            }
            long total = 0;
            for (VNPayModel item : errors) {
                content += "\n" + item.toString();
                total += Long.parseLong(item.amount);
            }
            if (dataFooter != null) {
                content += "\n" + dataFooter.convertData(list.size(), total + "");
            }
        }
        try {
            PrintWriter writer = new PrintWriter(des, "UTF-8");
            writer.print(content);
            writer.close();
            return "Đã gửi thông tin qua VNPay thành công";
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "Gửi thông tin qua VNPay thất bại";
    }

    public ArrayList<VNPayModel> searchByTrace(String trace, String dateF, String dateT, String accountNumber,
            String amount, int status) {
        try {
            ArrayList<VNPayModel> list = DBServices.getTransactionByTrace(trace, dateF, dateT, accountNumber, amount,
                    status);
            return list;
        } catch (ClassNotFoundException | SQLException e) {
        }
        return null;
    }

    public ArrayList<VNPayModel> searchByDate(String fromdate, String todate, int status) {
        try {
            ArrayList<VNPayModel> list = DBServices.getTransactionByDate(fromdate, todate, status);
            return list;
        } catch (ClassNotFoundException | SQLException e) {
        }
        return null;
    }
}
