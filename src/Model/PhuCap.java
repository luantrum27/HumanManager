package Model;

public class PhuCap {
	private String MaPhuCap;
	private String TenLoaiPhuCap;
	private double SoTien;
	
	
	public PhuCap() {
		
	}
	
	public PhuCap(String maPhuCap, String tenLoaiPhuCap, double soTien) {
		MaPhuCap = maPhuCap;
		TenLoaiPhuCap = tenLoaiPhuCap;
		SoTien = soTien;
	}

	public String getMaPhuCap() {
		return MaPhuCap;
	}

	public void setMaPhuCap(String maPhuCap) {
		MaPhuCap = maPhuCap;
	}

	public String getTenLoaiPhuCap() {
		return TenLoaiPhuCap;
	}

	public void setTenLoaiPhuCap(String tenLoaiPhuCap) {
		TenLoaiPhuCap = tenLoaiPhuCap;
	}

	public double getSoTien() {
		return SoTien;
	}

	public void setSoTien(double soTien) {
		SoTien = soTien;
	}
	
	
	
	
}
