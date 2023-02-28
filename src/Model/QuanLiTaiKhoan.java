package Model;

public class QuanLiTaiKhoan{
	private String HoTen, Email, GioiTinh, TenDangNhap, MatKhau;

	public QuanLiTaiKhoan() {};
	public QuanLiTaiKhoan(String hoTen, String email, String gioiTinh, String tenDangNhap, String matKhau) {
		HoTen = hoTen;
		Email = email;
		GioiTinh = gioiTinh;
		TenDangNhap = tenDangNhap;
		MatKhau = matKhau;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public String getTenDangNhap() {
		return TenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return MatKhau;
	}

	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	
}
