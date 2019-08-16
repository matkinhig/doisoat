/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doisoat.models;

/**
 *
 * @author lucnt
 */
import doisoat.utils.StringUtils;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class VNPayModel {
	public String loaiBanGhi;
	public String mti;
	public String accountNumber;
	public String processingCode;
	public String amount;
	public String systemTrace;
	public String transactionCode;
	public String transactionTime;
	public String transactionDate;
	public String paymentDate;
	public String deviceType;
	public String maKhoiTaoGiaoDich;
	public String soGiaoDich;
	public String responseCode = "";
	public String processingCompareCode;
	public String maSoThietBiChapNhanThe;
	public String thongTinBonus;
	public String merchantName = "";
	public String date = "";
        
        public String getMaKhoiTao() {
            return maKhoiTaoGiaoDich;
        }

    public VNPayModel(String loaiBanGhi, String mti, String accountNumber, String processingCode, String amount, String SystemTrace, String transactionCode, String TransactionTime, String transactionDate, String paymentDate, String deviceType, String maKhoiTaoGiaoDich, String soGiaoDich, String processingCompareCode, String maSoThietBiChapNhanThe, String thongTinBonus) {
        this.loaiBanGhi = loaiBanGhi;
        this.mti = mti;
        this.accountNumber = accountNumber;
        this.processingCode = processingCode;
        this.amount = amount;
        this.systemTrace = SystemTrace;
        this.transactionCode = transactionCode;
        this.transactionTime = TransactionTime;
        this.transactionDate = transactionDate;
        this.paymentDate = paymentDate;
        this.deviceType = deviceType;
        this.maKhoiTaoGiaoDich = maKhoiTaoGiaoDich;
        this.soGiaoDich = soGiaoDich;
        this.processingCompareCode = processingCompareCode;
        this.maSoThietBiChapNhanThe = maSoThietBiChapNhanThe;
        this.thongTinBonus = thongTinBonus;
    }

    public VNPayModel() {
    }

    public VNPayModel(String LoaiBanGhi, String MTI, String AccountNumber, String ProcessingCode, String Amount, String SystemTrace, String TransactionCode, String TransactionTime, String TransactionDate, String PaymentDate, String DeviceType, String MaKhoiTaoGiaoDich, String SoGiaoDich, String ResponseCode, String ProcessingCompareCode, String MaSoThietBiChapNhanThe, String ThongTinBonus, String MerchantName, String date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getLoaiBanGhi() {
        return loaiBanGhi;
    }

    public void setLoaiBanGhi(String LoaiBanGhi) {
        this.loaiBanGhi = LoaiBanGhi;
    }

    public String getMTI() {
        return mti;
    }

    public void setMTI(String mTI) {
        this.mti = mTI;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String AccountNumber) {
        String space = "";
		for (int i = 0; i < 21 - AccountNumber.length(); i++)
			space += " ";
		this.accountNumber = space + AccountNumber;
    }

    public String getProcessingCode() {
        return processingCode;
    }

    public void setProcessingCode(String ProcessingCode) {
        this.processingCode = ProcessingCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSystemTrace() {
        return systemTrace;
    }

    public void setSystemTrace(String SystemTrace) {
        if (StringUtils.isEmpty(SystemTrace)) {
			for (int i = 0; i < 40; i++)
				this.systemTrace += " ";
		} else {
			String spaces = "";
			for (int i = 0; i < 40 - SystemTrace.length(); i++) {
				spaces += " ";
			}
			this.systemTrace = spaces + SystemTrace;
		}
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String TransactionCode) {
        this.transactionCode = TransactionCode;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String TransactionTime) {
        this.transactionTime = TransactionTime;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String TransactionDate) {
        this.transactionDate = TransactionDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String PaymentDate) {
        this.paymentDate = PaymentDate;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String DeviceType) {
        this.deviceType = DeviceType;
    }

    public String getMaKhoiTaoGiaoDich() {
        return maKhoiTaoGiaoDich;
    }

    public void setMaKhoiTaoGiaoDich(String MaKhoiTaoGiaoDich) {
        this.maKhoiTaoGiaoDich = MaKhoiTaoGiaoDich;
    }

    public String getSoGiaoDich() {
        return soGiaoDich;
    }

    public void setSoGiaoDich(String SoGiaoDich) {
        this.soGiaoDich = SoGiaoDich;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String ResponseCode) {
        this.responseCode = ResponseCode;
    }

    public String getProcessingCompareCode() {
        return processingCompareCode;
    }

    public void setProcessingCompareCode(String ProcessingCompareCode) {
        this.processingCompareCode = ProcessingCompareCode;
    }

    public String getMaSoThietBiChapNhanThe() {
        return maSoThietBiChapNhanThe;
    }

    public void setMaSoThietBiChapNhanThe(String MaSoThietBiChapNhanThe) {
        this.maSoThietBiChapNhanThe = MaSoThietBiChapNhanThe;
    }

    public String getThongTinBonus() {
        return thongTinBonus;
    }

    public void setThongTinBonus(String ThongTinBonus) {
        this.thongTinBonus = ThongTinBonus;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String MerchantName) {
        this.merchantName = MerchantName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    public void setInfoBonus(String bonus) {
		if (bonus == null || "".equals(bonus)) {
			for (int i = 0; i < 30; i++)
				this.thongTinBonus += " ";
		} else {
			String space = "";
			for (int i = 0; i < (30 - bonus.length()); i++)
				space += " ";

			this.thongTinBonus = space + bonus;
		}
	}

	public void setMerchant(String strJson) {
		if (strJson == null || "".equals(strJson)) {
			for (int i = 0; i < 60; i++)
				this.merchantName += " ";
		} else {
                    try {
                        JSONObject root = new JSONObject(strJson);
                        if (root != null) {
                            String merchant = root.optString("merchantName");
                            String space = "";
                            for (int i = 0; i < 60 - merchant.length(); i++)
                                space += " ";
                            this.merchantName = space + merchant;
                        }
                    } catch (JSONException ex) {
                        Logger.getLogger(VNPayModel.class.getName()).log(Level.SEVERE, null, ex);
                    }
		}
	}
        
        public static VNPayModel convertData(String strValue) {
		if (strValue == null || "".equalsIgnoreCase(strValue))
			return null;
		VNPayModel data = new VNPayModel();

		int index = 0 + 4;
		data.loaiBanGhi = strValue.substring(0, index);
		data.mti = strValue.substring(index, index += 4);
		data.accountNumber = strValue.substring(index, index += 21);
		data.processingCode = strValue.substring(index, index += 6);
		data.amount = strValue.substring(index, index += 12);
		data.systemTrace = strValue.substring(index, index += 40);
		data.transactionCode = strValue.substring(index, index += 20);
		data.transactionTime = strValue.substring(index, index += 6);
		data.transactionDate = strValue.substring(index, index += 4);
		data.paymentDate = strValue.substring(index, index += 4);
		data.deviceType = strValue.substring(index, index += 4);
		data.maKhoiTaoGiaoDich = strValue.substring(index, index += 6);
		data.soGiaoDich = strValue.substring(index, index += 6);
		data.responseCode = strValue.substring(index, index += 2);
		data.processingCompareCode = strValue.substring(index, index += 2);
		data.maSoThietBiChapNhanThe = strValue.substring(index, index += 8);
		data.thongTinBonus = strValue.substring(index, index += 30);
		data.merchantName = strValue.substring(index, index += 60);

		return data;
	}

	@Override
	public String toString() {
		return loaiBanGhi + mti + accountNumber + processingCode + amount + systemTrace + transactionCode
				+ transactionTime + transactionDate + paymentDate + deviceType + maKhoiTaoGiaoDich + soGiaoDich
				+ responseCode + processingCompareCode + maSoThietBiChapNhanThe + thongTinBonus + merchantName;
	}

	public boolean compareData(VNPayModel model) {
		if (!this.systemTrace.trim().equalsIgnoreCase(model.systemTrace.trim()))
			return false;
		if (!this.transactionCode.equalsIgnoreCase(model.transactionCode))
			return false;
		if (!this.transactionTime.equalsIgnoreCase(model.transactionTime))
			return false;
		if (!this.transactionDate.equalsIgnoreCase(model.transactionDate))
			return false;
		if (!this.paymentDate.equalsIgnoreCase(model.paymentDate))
			return false;
		return true;
	}

	public String getFormatSystemTrace() {
		return systemTrace.trim();
	}

	public String getFormatCurrency() {
		try {
			DecimalFormat formatter = new DecimalFormat("###,###");
			return formatter.format(Double.parseDouble(amount));
		} catch (Exception e) {
		}
		return amount;

	}
	
}

