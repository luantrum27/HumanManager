package Model;

public class PhongBan {
	private String MaPhongBan;
	private String TenPhongBan;
	private String SDT;
	
	
	public PhongBan() {
		
	}
	
	public PhongBan(String maPhongBan, String tenPhongBan, String sDT) {
		MaPhongBan = maPhongBan;
		TenPhongBan = tenPhongBan;
		SDT = sDT;
	}
	public String getMaPhongBan() {
		return MaPhongBan;
	}
	public void setMaPhongBan(String maPhongBan) {
		MaPhongBan = maPhongBan;
	}
	public String getTenPhongBan() {
		return TenPhongBan;
	}
	public void setTenPhongBan(String tenPhongBan) {
		TenPhongBan = tenPhongBan;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	
	
}
