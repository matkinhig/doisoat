package doisoat.utils;

import doisoat.models.UserModel;
import doisoat.models.VNPayModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lucnt
 */
public class DBUtils {

    public static UserModel findUser(Connection conn, //
            String userName, String password) throws SQLException {

        String sql = "Select a.User_Name, a.password from HALONG.User_Account a " //
                + " where a.User_Name = ? and a.password= ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            UserModel user = new UserModel();
            user.setUserName(userName);
            user.setPassword(password);
            return user;
        }
        return null;
    }

    public static UserModel findUser(Connection conn, String userName) throws SQLException {

        String sql = "Select a.User_Name, a.Password from HALONG.User_Account a "//
                + " where a.User_Name = ? ";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);

        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            String password = rs.getString("Password");
            UserModel user = new UserModel();
            user.setUserName(userName);
            user.setPassword(password);
            return user;
        }
        return null;
    }

    public static List<VNPayModel> queryTransactionResult(Connection conn) throws SQLException {
        String sql = "Select m.ACCOUNTNUMBER, m.PROCESSINGCODE, m.AMOUNT,m.SYSTEMTRACE, m.DEVICETYPE,"
                + "m.BANKCODETRANS, m.TRANSACTIONNUMBER,m.REPONSECOMPARECODE, m.DEVICEACCEPTABLECODE,"
                + " m.INFOMATION, m.MERCHANTNAME, m.TRANSACTIONCODE,m.TRANSACTIONDATE, m.PAYMENTDATE,"
                + " m.BANGGHI,m.MTI,m.RESPONSECODE, m.TRANSACTIONTIME, m.CREATEAT from HALONG.MB_TRANSACTION_QRPAY_RESULT m ";

        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        List<VNPayModel> list = new ArrayList<VNPayModel>();
        while (rs.next()) {
            String LoaiBanGhi = rs.getString("BANGGHI");
            String MTI = rs.getString("MTI");
            String AccountNumber = rs.getString("ACCOUNTNUMBER");
            String ProcessingCode = rs.getString("PROCESSINGCODE");
            String Amount = rs.getString("AMOUNT");
            String SystemTrace = rs.getString("SYSTEMTRACE");
            String TransactionCode = rs.getString("TRANSACTIONCODE");
            String TransactionTime = rs.getString("TRANSACTIONTIME");
            String TransactionDate = rs.getString("TRANSACTIONDATE");
            String PaymentDate = rs.getString("PAYMENTDATE");
            String DeviceType = rs.getString("DEVICETYPE");
            String MaKhoiTaoGiaoDich = rs.getString("BANKCODETRANS");
            String SoGiaoDich = rs.getString("TRANSACTIONNUMBER");
            String ResponseCode = rs.getString("RESPONSECODE");
            String ProcessingCompareCode = rs.getString("REPONSECOMPARECODE");
            String MaSoThietBiChapNhanThe = rs.getString("DEVICEACCEPTABLECODE");
            String ThongTinBonus = rs.getString("INFOMATION");
            String MerchantName = rs.getString("MERCHANTNAME");
            String date = rs.getString("CREATEAT");

            VNPayModel vnPayModel = new VNPayModel();
            vnPayModel.setLoaiBanGhi(LoaiBanGhi);
            vnPayModel.setMTI(MTI);
            vnPayModel.setAccountNumber(AccountNumber);
            vnPayModel.setProcessingCode(ProcessingCode);
            vnPayModel.setAmount(Amount);
            vnPayModel.setSystemTrace(SystemTrace);
            vnPayModel.setTransactionCode(TransactionCode);
            vnPayModel.setTransactionTime(TransactionTime);
            vnPayModel.setTransactionDate(TransactionDate);
            vnPayModel.setPaymentDate(PaymentDate);
            vnPayModel.setDeviceType(DeviceType);
            vnPayModel.setMaKhoiTaoGiaoDich(MaKhoiTaoGiaoDich);
            vnPayModel.setSoGiaoDich(SoGiaoDich);
            vnPayModel.setResponseCode(ResponseCode);
            vnPayModel.setProcessingCompareCode(ProcessingCompareCode);
            vnPayModel.setMaSoThietBiChapNhanThe(MaSoThietBiChapNhanThe);
            vnPayModel.setThongTinBonus(ThongTinBonus);
            vnPayModel.setMerchantName(MerchantName);
            vnPayModel.setDate(date);
            list.add(vnPayModel);
        }
        return list;
    }

    public static VNPayModel findTransactionResult(Connection conn, String SYSTEMTRACE) throws SQLException {
        String sql = "Select m.ACCOUNTNUMBER, m.PROCESSINGCODE, m.AMOUNT,m.SYSTEMTRACE, m.DEVICETYPE,"
                + "m.BANKCODETRANS, m.TRANSACTIONNUMBER,m.REPONSECOMPARECODE, m.DEVICEACCEPTABLECODE,"
                + " m.INFOMATION, m.MERCHANTNAME, m.TRANSACTIONCODE,m.TRANSACTIONDATE, m.PAYMENTDATE,"
                + " m.BANGGHI,m.MTI,m.RESPONSECODE, m.TRANSACTIONTIME, m.CREATEAT from HALONG.MB_TRANSACTION_QRPAY_RESULT m  where m.SYSTEMTRACE=?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, SYSTEMTRACE);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            String LoaiBanGhi = rs.getString("LoaiBanGhi");
            String MTI = rs.getString("MTI");
            String AccountNumber = rs.getString("ACCOUNTNUMBER");
            String ProcessingCode = rs.getString("PROCESSINGCODE");
            String Amount = rs.getString("AMOUNT");
            String TransactionCode = rs.getString("TRANSACTIONCODE");
            String TransactionTime = rs.getString("TRANSACTIONTIME");
            String TransactionDate = rs.getString("TRANSACTIONDATE");
            String PaymentDate = rs.getString("PAYMENTDATE");
            String DeviceType = rs.getString("DEVICETYPE");
            String MaKhoiTaoGiaoDich = rs.getString("BANKCODETRANS");
            String SoGiaoDich = rs.getString("TRANSACTIONNUMBER");
            String ResponseCode = rs.getString("RESPONSECODE");
            String ProcessingCompareCode = rs.getString("REPONSECOMPARECODE");
            String MaSoThietBiChapNhanThe = rs.getString("DEVICEACCEPTABLECODE");
            String ThongTinBonus = rs.getString("INFOMATION");
            String MerchantName = rs.getString("MERCHANTNAME");
            String date = rs.getString("CREATEAT");

            VNPayModel vNPayModelResult = new VNPayModel(LoaiBanGhi, MTI, AccountNumber, ProcessingCode, Amount, SYSTEMTRACE,
                    TransactionCode, TransactionTime, TransactionDate,
                    PaymentDate, DeviceType, MaKhoiTaoGiaoDich, SoGiaoDich, ResponseCode, ProcessingCompareCode,
                    MaSoThietBiChapNhanThe, ThongTinBonus, MerchantName, date
            );
            return vNPayModelResult;
        }
        return null;
    }

    public static void updateTransaction(Connection conn, VNPayModel vNPayModel) throws SQLException {
        String sql = "Update HALONG.MB_TRANSACTION_QRPAY_RESULT set LoaiBanGhi =?, MTI=? , ACCOUNTNUMBER=?, PROCESSINGCODE=?,AMOUNT=?, TRANSACTIONCODE=?,"
                + "TRANSACTIONTIME=?, TRANSACTIONDATE=?,PAYMENTDATE=?, DEVICETYPE=?,BANKCODETRANS=?,  TRANSACTIONNUMBER=?, REPONSECOMPARECODE=?,DEVICEACCEPTABLECODE=?,"
                + " INFOMATION=?, MERCHANTNAME=?,   TRANSACTIONCODE=?,     TRANSACTIONDATE=?,   PAYMENTDATE=?,"
                + "  BANGGHI=?,    MTI=?  ,RESPONSECODE=?,   TRANSACTIONTIME=?,    CREATEAT=?"
                + "where SYSTEMTRACE=?";

        PreparedStatement pstm = conn.prepareStatement(sql);

        //+ "m.BANKCODETRANS, m.TRANSACTIONNUMBER,m.REPONSECOMPARECODE, m.DEVICEACCEPTABLECODE,"
        //+ " m.INFOMATION, m.MERCHANTNAME, m.TRANSACTIONCODE,m.TRANSACTIONDATE, m.PAYMENTDATE,"
        //+ " m.BANGGHI,m.MTI,m.RESPONSECODE, m.TRANSACTIONTIME, m.CREATEAT from MB_TRANSACTION_QRPAY_RESULT m  where m.SYSTEMTRACE=?";
        //pstm.setString(1, vNPayModel.getName());
        //pstm.setFloat(2, vNPayModel.getPrice());
        // pstm.setString(3, vNPayModel.getCode());
        
        
        pstm.setString(1,vNPayModel.getLoaiBanGhi().trim());
        pstm.setString(2,vNPayModel.getMTI());
        pstm.setString(3,vNPayModel.getAccountNumber());
        pstm.setString(4,vNPayModel.getProcessingCode());
        pstm.setString(5,vNPayModel.getAmount());
        pstm.setString(6,vNPayModel.getTransactionCode());
        pstm.setString(7,vNPayModel.getTransactionTime());
        pstm.setString(8,vNPayModel.getTransactionDate());
        pstm.setString(9,vNPayModel.getPaymentDate());
        pstm.setString(10,vNPayModel.getDeviceType());
        pstm.setString(11,vNPayModel.getMaKhoiTaoGiaoDich());
        pstm.setString(12,vNPayModel.getSoGiaoDich());
        pstm.setString(13,vNPayModel.getResponseCode());
        pstm.setString(14,vNPayModel.getProcessingCompareCode());
        pstm.setString(15,vNPayModel.getMaSoThietBiChapNhanThe());
        pstm.setString(16,vNPayModel.getThongTinBonus());
        pstm.setString(17,vNPayModel.getMerchantName());
        pstm.setString(18,vNPayModel.getDate());
        pstm.setString(19,vNPayModel.getSystemTrace());
        
        
        pstm.executeUpdate();
    }

    public static void deleteTransaction(Connection conn, String SYSTEMTRACE) throws SQLException {
        String sql = "Delete From HALONG.MB_TRANSACTION_QRPAY_RESULT where SYSTEMTRACE= ?";

        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, SYSTEMTRACE);

        pstm.executeUpdate();
    }
    
    public static int countTransaction(Connection conn){
        
        
        return 0;
    }

}
