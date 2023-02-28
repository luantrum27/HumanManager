package Model;

import java.util.Date;

public class NghiPhep {
	private String MaNghiPhep;
	private String MaNhanVien;
	private String TenLoaiNghiPhep;
	private double SoGioNghi;
	private Date ThoiGianBatDau;
	private Date ThoiGianKetThuc;
	private String ChuThich;
	
	
	public NghiPhep() {
		
	}
	
	public NghiPhep(String maNghiPhep, String maNhanVien, String tenLoaiNghiPhep, double soGioNghi, Date thoiGianBatDau,
			Date thoiGianKetThuc, String chuThich) {
		MaNghiPhep = maNghiPhep;
		MaNhanVien = maNhanVien;
		TenLoaiNghiPhep = tenLoaiNghiPhep;
		SoGioNghi = soGioNghi;
		ThoiGianBatDau = thoiGianBatDau;
		ThoiGianKetThuc = thoiGianKetThuc;
		ChuThich = chuThich;
	}

	public String getMaNghiPhep() {
		return MaNghiPhep;
	}

	public void setMaNghiPhep(String maNghiPhep) {
		MaNghiPhep = maNghiPhep;
	}

	public String getMaNhanVien() {
		return MaNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
	}

	public String getTenLoaiNghiPhep() {
		return TenLoaiNghiPhep;
	}

	public void setTenLoaiNghiPhep(String tenLoaiNghiPhep) {
		TenLoaiNghiPhep = tenLoaiNghiPhep;
	}

	public double getSoGioNghi() {
		return SoGioNghi;
	}

	public void setSoGioNghi(double soGioNghi) {
		SoGioNghi = soGioNghi;
	}

	public Date getThoiGianBatDau() {
		return ThoiGianBatDau;
	}

	public void setThoiGianBatDau(Date thoiGianBatDau) {
		ThoiGianBatDau = thoiGianBatDau;
	}

	public Date getThoiGianKetThuc() {
		return ThoiGianKetThuc;
	}

	public void setThoiGianKetThuc(Date thoiGianKetThuc) {
		ThoiGianKetThuc = thoiGianKetThuc;
	}

	public String getChuThich() {
		return ChuThich;
	}

	public void setChuThich(String chuThich) {
		ChuThich = chuThich;
	}
	
	
	
	
}
