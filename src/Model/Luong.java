package Model;

import java.util.Date;

public class Luong {
	private String MaLuong;
	private String MaNhanVien;
	private Date ThoiDiemNhanLuong;
	private double LuongCoBan;
	private String LoaiPhuCap;
	private Date NgayNhanPhuCap;
	private String LoaiThuong;
	private Date NgayNhanThuong;
	private double TongLuong;
	
	public Luong() {
		
	}
	
	public Luong(String maLuong, String maNhanVien, Date thoiDiemNhanLuong, double luongCoBan, String loaiPhuCap,
			Date ngayNhanPhuCap, String loaiThuong, Date ngayNhanThuong, double tongLuong) {
		MaLuong = maLuong;
		MaNhanVien = maNhanVien;
		ThoiDiemNhanLuong = thoiDiemNhanLuong;
		LuongCoBan = luongCoBan;
		LoaiPhuCap = loaiPhuCap;
		NgayNhanPhuCap = ngayNhanPhuCap;
		LoaiThuong = loaiThuong;
		NgayNhanThuong = ngayNhanThuong;
		TongLuong = tongLuong;
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

	public Date getThoiDiemNhanLuong() {
		return ThoiDiemNhanLuong;
	}

	public void setThoiDiemNhanLuong(Date thoiDiemNhanLuong) {
		ThoiDiemNhanLuong = thoiDiemNhanLuong;
	}

	public double getLuongCoBan() {
		return LuongCoBan;
	}

	public void setLuongCoBan(double luongCoBan) {
		LuongCoBan = luongCoBan;
	}

	public String getLoaiPhuCap() {
		return LoaiPhuCap;
	}

	public void setLoaiPhuCap(String loaiPhuCap) {
		LoaiPhuCap = loaiPhuCap;
	}

	public Date getNgayNhanPhuCap() {
		return NgayNhanPhuCap;
	}

	public void setNgayNhanPhuCap(Date ngayNhanPhuCap) {
		NgayNhanPhuCap = ngayNhanPhuCap;
	}

	public String getLoaiThuong() {
		return LoaiThuong;
	}

	public void setLoaiThuong(String loaiThuong) {
		LoaiThuong = loaiThuong;
	}

	public Date getNgayNhanThuong() {
		return NgayNhanThuong;
	}

	public void setNgayNhanThuong(Date ngayNhanThuong) {
		NgayNhanThuong = ngayNhanThuong;
	}

	public double getTongLuong() {
		return TongLuong;
	}

	public void setTongLuong(double tongLuong) {
		TongLuong = tongLuong;
	}
	
	
	
	
}
