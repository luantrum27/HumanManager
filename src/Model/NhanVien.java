package Model;

import java.util.Date;

public class NhanVien {
	private String MaNhanVien;
	private String HoTen;
	private String NgaySinh;
	private String GioiTinh;
	private String CCCD;
	private String DiaChi;
	private String SDT;
	private String Email;
	private String MaChucVu;
	private String MaPhongBan;
	
	
	public NhanVien() {
		
	}


	public NhanVien(String maNhanVien, String hoTen, String ngaySinh, String gioiTinh, String cCCD, String diaChi,
			String sDT, String email, String maChucVu, String maPhongBan) {
		MaNhanVien = maNhanVien;
		HoTen = hoTen;
		NgaySinh = ngaySinh;
		GioiTinh = gioiTinh;
		CCCD = cCCD;
		DiaChi = diaChi;
		SDT = sDT;
		Email = email;
		MaChucVu = maChucVu;
		MaPhongBan = maPhongBan;
	}


	public String getMaNhanVien() {
		return MaNhanVien;
	}


	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
	}


	public String getHoTen() {
		return HoTen;
	}


	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}


	public String getNgaySinh() {
		return NgaySinh;
	}


	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}


	public String getGioiTinh() {
		return GioiTinh;
	}


	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}


	public String getCCCD() {
		return CCCD;
	}


	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}


	public String getDiaChi() {
		return DiaChi;
	}


	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}


	public String getSDT() {
		return SDT;
	}


	public void setSDT(String sDT) {
		SDT = sDT;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getMaChucVu() {
		return MaChucVu;
	}


	public void setMaChucVu(String maChucVu) {
		MaChucVu = maChucVu;
	}


	public String getMaPhongBan() {
		return MaPhongBan;
	}


	public void setMaPhongBan(String maPhongBan) {
		MaPhongBan = maPhongBan;
	}
	
	public void output() {
		System.out.println("MaNV: " + this.MaNhanVien);
		System.out.println("HoTen: " + this.HoTen);
		System.out.println("NgaySinh: " + this.NgaySinh);
		System.out.println("GioiTinh: " + this.GioiTinh);
		System.out.println("CCCD: " + this.CCCD);
		System.out.println("DiaChi: " + this.DiaChi);
		System.out.println("SDT: " + this.SDT);
		System.out.println("Email: " + this.Email);
		System.out.println("MaChucVu: " + this.MaChucVu);
		System.out.println("MaPhongBan: " + this.MaPhongBan);

	}
	
	
}