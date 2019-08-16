package doisoat.models;

import java.text.SimpleDateFormat;
import java.util.Date;

// 0009000000008           BATCH JOB090525270619
public class VNPayFooterModel {
	public String LoaiBanGhi;
	public String SoDongGiaoDich;
	public String NguoiTao;
	public String GioTaoFile;
	public String NgayTaoFile;

	public static VNPayFooterModel convertHeader(String strValue) {
		if (strValue == null || "".equalsIgnoreCase(strValue))
			return null;
		VNPayFooterModel dataFooter = new VNPayFooterModel();
		int index = 4;
		dataFooter.LoaiBanGhi = strValue.substring(0, index);
		dataFooter.SoDongGiaoDich = strValue.substring(index, index += 9);
		dataFooter.NguoiTao = strValue.substring(index, index += 20);
		dataFooter.GioTaoFile = strValue.substring(index, index += 6);
		dataFooter.NgayTaoFile = strValue.substring(index, index += 6);
		return dataFooter;
	}

	public String convertData(int size, String totalPrice) {
		SimpleDateFormat dft = new SimpleDateFormat("HHmmss");
		String time = dft.format(new Date());
		dft = new SimpleDateFormat("ddMMyy");
		String date = dft.format(new Date());
		String strTotal = totalPrice;
		if (totalPrice.length() < 14) {
			String spaces = "";
			for (int i = 0; i < 14 - totalPrice.length(); i++)
				spaces += "0";
			strTotal = spaces + totalPrice;
		}

		return LoaiBanGhi + size + NguoiTao + time + date + size + strTotal;
	}
}
