package View;

public class LUONGNHANSU {
	private String MaLuong, MaNhanVien, ThoiDiemNhanLuong,
	MaNhanThuong, MaNhanPhuCap, LoaiPhuCap, NgayNhanPhuCap,
	LoaiThuong, NgayNhanThuong;
	private double luongCoBan;
	public LUONGNHANSU() {};
	public LUONGNHANSU(String maLuong, String maNhanVien, String thoiDiemNhanLuong, String maNhanThuong,
			String maNhanPhuCap, String loaiPhuCap, String ngayNhanPhuCap, String loaiThuong, String ngayNhanThuong,
			double luongCoBan) {
		MaLuong = maLuong;
		MaNhanVien = maNhanVien;
		ThoiDiemNhanLuong = thoiDiemNhanLuong;
		MaNhanThuong = maNhanThuong;
		MaNhanPhuCap = maNhanPhuCap;
		LoaiPhuCap = loaiPhuCap;
		NgayNhanPhuCap = ngayNhanPhuCap;
		LoaiThuong = loaiThuong;
		NgayNhanThuong = ngayNhanThuong;
		this.luongCoBan = luongCoBan;
	}
	public String getMaLuong() {
		return MaLuong;
	}
	public void setMaLuong(String maLuong) {
		MaLuong = maLuong;
	}
	public String getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
	}
	public String getThoiDiemNhanLuong() {
		return ThoiDiemNhanLuong;
	}
	public void setThoiDiemNhanLuong(String thoiDiemNhanLuong) {
		ThoiDiemNhanLuong = thoiDiemNhanLuong;
	}
	public String getMaNhanThuong() {
		return MaNhanThuong;
	}
	public void setMaNhanThuong(String maNhanThuong) {
		MaNhanThuong = maNhanThuong;
	}
	public String getMaNhanPhuCap() {
		return MaNhanPhuCap;
	}
	public void setMaNhanPhuCap(String maNhanPhuCap) {
		MaNhanPhuCap = maNhanPhuCap;
	}
	public String getLoaiPhuCap() {
		return LoaiPhuCap;
	}
	public void setLoaiPhuCap(String loaiPhuCap) {
		LoaiPhuCap = loaiPhuCap;
	}
	public String getNgayNhanPhuCap() {
		return NgayNhanPhuCap;
	}
	public void setNgayNhanPhuCap(String ngayNhanPhuCap) {
		NgayNhanPhuCap = ngayNhanPhuCap;
	}
	public String getLoaiThuong() {
		return LoaiThuong;
	}
	public void setLoaiThuong(String loaiThuong) {
		LoaiThuong = loaiThuong;
	}
	public String getNgayNhanThuong() {
		return NgayNhanThuong;
	}
	public void setNgayNhanThuong(String ngayNhanThuong) {
		NgayNhanThuong = ngayNhanThuong;
	}
	public double getLuongCoBan() {
		return luongCoBan;
	}
	public void setLuongCoBan(double luongCoBan) {
		this.luongCoBan = luongCoBan;
	}
	
	
	
}
