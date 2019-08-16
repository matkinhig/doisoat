package doisoat.models;

// 0001970479260619
public class VNPayHeaderModel {
	public String LoaiBanGhi;
	public String MaSoBank;
	public String NgayGiaoDich;

	public static VNPayHeaderModel convertHeader(String strValue) {
		if (strValue == null || "".equalsIgnoreCase(strValue))
			return null;
		VNPayHeaderModel dataHeader = new VNPayHeaderModel();
		int index = 4;
		dataHeader.LoaiBanGhi = strValue.substring(0, index);
		dataHeader.MaSoBank = strValue.substring(index, index += 6);
		dataHeader.NgayGiaoDich = strValue.substring(index, index += 6);
		return dataHeader;
	}
}
