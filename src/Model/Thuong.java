package Model;

public class Thuong {
	private String MaLoaiThuong;
	private String TenLoaiThuong;
	private double SoTien;
	
	
	public Thuong() {
		
	}
	
	public Thuong(String maLoaiThuong, String tenLoaiThuong, double soTien) {
		MaLoaiThuong = maLoaiThuong;
		TenLoaiThuong = tenLoaiThuong;
		SoTien = soTien;
	}

	public String getMaLoaiThuong() {
		return MaLoaiThuong;
	}

	public void setMaLoaiThuong(String maLoaiThuong) {
		MaLoaiThuong = maLoaiThuong;
	}

	public String getTenLoaiThuong() {
		return TenLoaiThuong;
	}

	public void setTenLoaiThuong(String tenLoaiThuong) {
		TenLoaiThuong = tenLoaiThuong;
	}

	public double getSoTien() {
		return SoTien;
	}

	public void setSoTien(double soTien) {
		SoTien = soTien;
	}
	
	
	
}
