package Model;

import java.util.ArrayList;

public class DanhSachNhanVien {
	private ArrayList<NhanVien> danhSachNhanVien;

	public DanhSachNhanVien() {
		this.danhSachNhanVien = new ArrayList<NhanVien>();
	}
	
	public DanhSachNhanVien(ArrayList<NhanVien> danhSachNhanVien) {
		this.danhSachNhanVien = danhSachNhanVien;
	}

	public ArrayList<NhanVien> getDanhSachNhanVien() {
		return danhSachNhanVien;
	}

	public void setDanhSachNhanVien(ArrayList<NhanVien> danhSachNhanVien) {
		this.danhSachNhanVien = danhSachNhanVien;
	}
	public void display() {
		for (NhanVien nhanVien : danhSachNhanVien) {
			nhanVien.output();
			System.out.println("-----------------------------------------------------------");
		}
	}
	
	public void update(String maNhanVien, String hoTen, String ngaySinh, String gioiTinh, String cCCD, String diaChi,
			String sDT, String email, String maChucVu, String maPhongBan) {
		for (NhanVien nhanVien : danhSachNhanVien) {
			if(nhanVien.getMaNhanVien().equals(maNhanVien)) {
				nhanVien.setHoTen(hoTen);
				nhanVien.setCCCD(cCCD);
				nhanVien.setDiaChi(diaChi);
				nhanVien.setEmail(email);
				nhanVien.setMaChucVu(maChucVu);
				nhanVien.setMaPhongBan(maPhongBan);
				nhanVien.setGioiTinh(gioiTinh);
				nhanVien.setSDT(sDT);
				nhanVien.setNgaySinh(ngaySinh);
			}
		}
	}
	
	
}
