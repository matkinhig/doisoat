package doisoat.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import doisoat.utils.StringUtils;

import doisoat.models.VNPayModel;
import doisoat.utils.Configs;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBServices { //xong roi chay lai di

    private static SimpleDateFormat dftDate = new SimpleDateFormat("MMdd");
    private static SimpleDateFormat dftTime = new SimpleDateFormat("HHmmss");
    private static SimpleDateFormat dftCreated = new SimpleDateFormat("dd-MM-yyyy");

    public static ArrayList<VNPayModel> getDb(String fromDate, String toDate)
            throws ClassNotFoundException, SQLException {

        String dname = Configs.driverClassName;
        String url = Configs.DB_URL;
        String username = Configs.USERNAME;
        String password = Configs.PASSWORD;
        Class.forName(dname);
        Connection con = DriverManager.getConnection(url, username, password);

        DateFormat dft1 = new SimpleDateFormat("yyyy-MM-dd");
        Date dateF = null;
        Date dateT = null;
        String newFromDate = "";
        String newToDate = "";
        try {
            dateF = dft1.parse(fromDate);
            dateT = dft1.parse(toDate);

            newFromDate = dftCreated.format(dateF);
            newToDate = dftCreated.format(dateT);
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        String sql = "select tr.from_account,tr.trans_trace,tr.amount,tr.trans_ref,tr.trans_code,tr.trans_note,tr.qr_info,trdetail.created_date "
                + "from HALONG.MB_TRANSACTION tr, HALONG.MB_TRANSACTION_DETAIL trdetail "
                + "where tr.trans_trace = trdetail.trans_trace and to_char(trdetail.created_date,'dd-mm-yyyy') >= ? and to_char(trdetail.created_date,'dd-mm-yyyy') <= ? and trdetail.trans_detail_steps = ?"
                + " and trdetail.res_code in(00,08)";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, newFromDate);
        preparedStatement.setString(2, newToDate);
        preparedStatement.setString(3, "4");

        ResultSet rs = preparedStatement.executeQuery();
        ArrayList<VNPayModel> list = new ArrayList<VNPayModel>();

        while (rs.next()) {
            VNPayModel model = new VNPayModel();
            model.loaiBanGhi = "0002";
            model.mti = "0210";
            model.setAccountNumber("970475" + rs.getString("from_account"));
            model.processingCode = "000002"; // rs.getString("trans_trace")
            String amount = rs.getString("amount");

            if (amount.length() < 12) {
                String spaces = "";
                for (int i = 0; i < 12 - amount.length(); i++) {
                    spaces += "0";
                }
                model.amount = spaces + amount;
            } else {
                model.amount = amount;
            }
            model.setSystemTrace(rs.getString("trans_trace"));
            model.setTransactionCode(rs.getString("trans_trace"));
            model.deviceType = "6010";
            model.maKhoiTaoGiaoDich = "Vietbank";
            model.soGiaoDich = "000000";
            model.maSoThietBiChapNhanThe = "        ";
            model.processingCompareCode = rs.getString("trans_code");
            model.setInfoBonus(rs.getString("trans_note"));
            model.setMerchant(rs.getString("qr_info"));

            String strdate = rs.getString("created_date");
            if (!StringUtils.isEmpty(strdate)) {
                try {
                    DateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = dft.parse(strdate);

                    model.transactionDate = dftDate.format(date);
                    model.transactionTime = dftTime.format(date);
                    model.paymentDate = dftDate.format(date);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            list.add(model);
        }

        con.close();
        return list;
    }

    public static ArrayList<VNPayModel> getDb1(String fromDate, String toDate)
            throws ClassNotFoundException, SQLException {

        String dname = Configs.driverClassName;
        String url = Configs.DB_URL;
        String username = Configs.USERNAME;
        String password = Configs.PASSWORD;
        Class.forName(dname);
        Connection con = DriverManager.getConnection(url, username, password);

        DateFormat dft1 = new SimpleDateFormat("yyyy-MM-dd");
        Date dateF = null;
        Date dateT = null;
        String newFromDate = "";
        String newToDate = "";
        try {
            Date dateFtmp = dft1.parse(fromDate);
            Date dateTtmp = dft1.parse(toDate);
            
            dft1 = new SimpleDateFormat("ddMMyyyy");
            newFromDate = dft1.format(dateFtmp);
            newToDate = dft1.format(dateTtmp);
            
            dateF = dft1.parse(newFromDate);
            dateT = dft1.parse(newToDate);
            
            

//
//            newFromDate = dftCreated.format(dateF);
//            newToDate = dftCreated.format(dateT);
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        String sql = "select tr.from_account,tr.trans_trace,tr.amount,tr.trans_ref,tr.trans_code,tr.trans_note,tr.qr_info,trdetail.created_date "
                + "from HALONG.MB_TRANSACTION tr, HALONG.MB_TRANSACTION_DETAIL trdetail "
                + "where tr.trans_trace = trdetail.trans_trace and trdetail.created_date >= to_timestamp(? , 'dd-mm-yyyy hh24:mi:ss') and trdetail.created_date <= to_timestamp(? , 'dd-mm-yyyy hh24:mi:ss')  and trdetail.trans_detail_steps = ?"
                + " and trdetail.res_code in(00,08)";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, newFromDate);
        preparedStatement.setString(2, newToDate);
        preparedStatement.setString(3, "4");

        ResultSet rs = preparedStatement.executeQuery();
        ArrayList<VNPayModel> list = new ArrayList<VNPayModel>();

        while (rs.next()) {
            VNPayModel model = new VNPayModel();
            model.loaiBanGhi = "0002";
            model.mti = "0210";
            model.setAccountNumber("970475" + rs.getString("from_account"));
            model.processingCode = "000002"; // rs.getString("trans_trace")
            String amount = rs.getString("amount");

            if (amount.length() < 12) {
                String spaces = "";
                for (int i = 0; i < 12 - amount.length(); i++) {
                    spaces += "0";
                }
                model.amount = spaces + amount;
            } else {
                model.amount = amount;
            }
            model.setSystemTrace(rs.getString("trans_trace"));
            model.setTransactionCode(rs.getString("trans_trace"));
            model.deviceType = "6010";
            model.maKhoiTaoGiaoDich = "Vietbank";
            model.soGiaoDich = "000000";
            model.maSoThietBiChapNhanThe = "        ";
            model.processingCompareCode = rs.getString("trans_code");
            model.setInfoBonus(rs.getString("trans_note"));
            model.setMerchant(rs.getString("qr_info"));

            String strdate = rs.getString("created_date");
            if (!StringUtils.isEmpty(strdate)) {
                try {
                    DateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = dft.parse(strdate);

                    model.transactionDate = dftDate.format(date);
                    model.transactionTime = dftTime.format(date);
                    model.paymentDate = dftDate.format(date);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            list.add(model);
        }

        con.close();
        return list;
    }

    public static void insertDB(ArrayList<VNPayModel> list) throws ClassNotFoundException, SQLException {
        String dname = Configs.driverClassName;
        String url = Configs.DB_URL;
        String username = Configs.USERNAME;
        String password = Configs.PASSWORD;
        Class.forName(dname);
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql;
        for (VNPayModel item : list) {
            if((item.systemTrace).equals("")){
                
            }           
            
            sql = "INSERT INTO HALONG.MB_TRANSACTION_QRPAY_RESULT (BANGGHI,MTI,ACCOUNTNUMBER,PROCESSINGCODE,AMOUNT,SYSTEMTRACE,DEVICETYPE,"
                    + "BANKCODETRANS,TRANSACTIONNUMBER,REPONSECOMPARECODE,DEVICEACCEPTABLECODE,"
                    + "INFOMATION,MERCHANTNAME,TRANSACTIONCODE,TRANSACTIONDATE,PAYMENTDATE, RESPONSECODE,TRANSACTIONTIME)"
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);

            pstmt.setString(1, item.loaiBanGhi.trim());
            pstmt.setString(2, item.mti);
            pstmt.setString(3, item.accountNumber);
            pstmt.setString(4, item.processingCode);
            pstmt.setString(5, item.amount);
            pstmt.setString(6, item.systemTrace);
            pstmt.setString(7, item.deviceType);
            pstmt.setString(8, item.maKhoiTaoGiaoDich);
            pstmt.setString(9, item.soGiaoDich);
            pstmt.setString(10, item.processingCompareCode);
            pstmt.setString(11, item.maSoThietBiChapNhanThe);
            pstmt.setString(12, item.thongTinBonus);
            pstmt.setString(13, item.merchantName);
            pstmt.setString(14, item.transactionCode);
            pstmt.setString(15, item.transactionDate);
            pstmt.setString(16, item.paymentDate);
            pstmt.setString(17, item.responseCode);
            pstmt.setString(18, item.transactionTime);

            pstmt.executeQuery();
        }

        conn.close();
    }

    public static ArrayList<VNPayModel> getTransactionByTrace(String trace, String dateF, String dateT, String accountNumber,
            String amount, int status) throws ClassNotFoundException, SQLException {
        /**
         * status 0: all 1: 31 2: 35
         */

        String dname = Configs.driverClassName;
        String url = Configs.DB_URL;
        String username = Configs.USERNAME;
        String password = Configs.PASSWORD;
        Class.forName(dname);
        Connection conn = DriverManager.getConnection(url, username, password);
        String traceTmp = trace.replaceAll(trace, "%" + trace + "%");
        String sql = "select * from HALONG.MB_TRANSACTION_QRPAY_RESULT tr " + " where trim(tr.SYSTEMTRACE) like trim(?) ";
        if (!StringUtils.isEmpty(accountNumber)) {
            sql += " and trim(tr.ACCOUNTNUMBER) = " + accountNumber.trim();
        }
        if (!StringUtils.isEmpty(dateF) && StringUtils.isEmpty(dateT)) {

            try {
                System.out.println(dateF);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date dt = formatter.parse(dateF);

                formatter = new SimpleDateFormat("MMdd");
                String dateTmp = formatter.format(dt);
                System.out.print(dateTmp);
                sql += " and tr.transactiondate = " + dateTmp;
            } catch (ParseException ex) {
                Logger.getLogger(DBServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!StringUtils.isEmpty(dateF) && !StringUtils.isEmpty(dateT)) {

            try {
                SimpleDateFormat formatterF = new SimpleDateFormat("yyyy-MM-dd");
                Date dtF = formatterF.parse(dateF);
                formatterF = new SimpleDateFormat("MMdd");
                String dateTmpF = formatterF.format(dtF);

                SimpleDateFormat formatterT = new SimpleDateFormat("yyyy-MM-dd");
                Date dtT = formatterT.parse(dateT);
                formatterT = new SimpleDateFormat("MMdd");
                String dateTmpT = formatterT.format(dtT);
                sql += " and tr.transactiondate >= " + dateTmpF + "and tr.transactiondate <=" + dateTmpT;
            } catch (ParseException ex) {
                Logger.getLogger(DBServices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!StringUtils.isEmpty(amount)) {
            sql += " and tr.AMOUNT = " + amount;
        }
        if (status == 1) {
            sql += " and tr.REPONSECOMPARECODE = '31'";
        } else if (status == 2) {
            sql += " and tr.REPONSECOMPARECODE = '35'";
        }

        PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
        pstmt.setString(1, traceTmp);

        ResultSet rs = pstmt.executeQuery();

        ArrayList<VNPayModel> list = new ArrayList<>();
        while (rs.next()) {
            VNPayModel model = new VNPayModel();
            model.loaiBanGhi = rs.getString("BANGGHI");
            model.mti = rs.getString("MTI");
            model.setAccountNumber(rs.getString("ACCOUNTNUMBER"));
            model.processingCode = rs.getString("PROCESSINGCODE");
            model.amount = rs.getString("AMOUNT");
            model.setSystemTrace(rs.getString("SYSTEMTRACE"));
            model.deviceType = rs.getString("DEVICETYPE");
            model.maKhoiTaoGiaoDich = rs.getString("BANKCODETRANS");
            model.soGiaoDich = rs.getString("TRANSACTIONNUMBER");
            model.processingCompareCode = rs.getString("REPONSECOMPARECODE");
            model.maSoThietBiChapNhanThe = rs.getString("DEVICEACCEPTABLECODE");
            model.setInfoBonus(rs.getString("INFOMATION"));
            model.merchantName = rs.getString("MERCHANTNAME");
            model.transactionDate = rs.getString("TRANSACTIONDATE");
            model.transactionTime = rs.getString("TRANSACTIONTIME");
            model.paymentDate = rs.getString("PAYMENTDATE");
            model.responseCode = rs.getString("RESPONSECODE");
            model.transactionCode = rs.getString("TRANSACTIONCODE");
            list.add(model);
        }

        return list;

    }

    public static ArrayList<VNPayModel> getTransactionByDate(String fromdate, String todate, int status)
            throws ClassNotFoundException, SQLException {
        /**
         * status 0: all 1: 31 2: 35
         */

        String dname = Configs.driverClassName;
        String url = Configs.DB_URL;
        String username = Configs.USERNAME;
        String password = Configs.PASSWORD;
        Class.forName(dname);
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "select * from HALONG.MB_TRANSACTION_QRPAY_RESULT tr "
                + " where tr.transactiondate >= ? and tr.transactiondate <= ?";

        DateFormat dft1 = new SimpleDateFormat("MM-dd-yyyy");
        Date dateF;
        Date dateT;
        String newFromDate = "";
        String newToDate = "";
        try {
            dateF = dft1.parse(fromdate);
            dateT = dft1.parse(todate);

            newFromDate = dftDate.format(dateF);
            newToDate = dftDate.format(dateT);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }

        if (status == 1) {
            sql += " and tr.REPONSECOMPARECODE = '31'";
        } else if (status == 2) {
            sql += " and tr.REPONSECOMPARECODE = '35'";
        }

        PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
        pstmt.setString(1, newFromDate);
        pstmt.setString(2, newToDate);

        ResultSet rs = pstmt.executeQuery();

        ArrayList<VNPayModel> list = new ArrayList<VNPayModel>();
        while (rs.next()) {
            VNPayModel model = new VNPayModel();

            model.loaiBanGhi = rs.getString("BANGGHI");
            model.mti = rs.getString("MTI");
            model.setAccountNumber(rs.getString("ACCOUNTNUMBER"));
            model.processingCode = rs.getString("PROCESSINGCODE");
            model.amount = rs.getString("AMOUNT");
            model.setSystemTrace(rs.getString("SYSTEMTRACE"));
            model.deviceType = rs.getString("DEVICETYPE");
            model.maKhoiTaoGiaoDich = rs.getString("BANKCODETRANS");
            model.soGiaoDich = rs.getString("TRANSACTIONNUMBER");
            model.processingCompareCode = rs.getString("REPONSECOMPARECODE");
            model.maSoThietBiChapNhanThe = rs.getString("DEVICEACCEPTABLECODE");
            model.setInfoBonus(rs.getString("INFOMATION"));
            model.merchantName = rs.getString("MERCHANTNAME");
            model.transactionDate = rs.getString("TRANSACTIONDATE");
            model.transactionTime = rs.getString("TRANSACTIONTIME");
            model.paymentDate = rs.getString("PAYMENTDATE");
            model.responseCode = rs.getString("RESPONSECODE");
            model.transactionCode = rs.getString("TRANSACTIONCODE");

            list.add(model);

        }

        return list;

    }
}
