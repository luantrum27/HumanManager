package Model;

import java.util.Date;

public class TangCa {
	private String MaTangCa;
	private String MaNhanVien;
	private double SoGioTangCa;
	private Date ThoiGianBatDau;
	private Date ThoiGianKetThuc;
	
	public TangCa() {
		
	}
	
	public TangCa(String maTangCa, String maNhanVien, double soGioTangCa, Date thoiGianBatDau, Date thoiGianKetThuc) {
		MaTangCa = maTangCa;
		MaNhanVien = maNhanVien;
		SoGioTangCa = soGioTangCa;
		ThoiGianBatDau = thoiGianBatDau;
		ThoiGianKetThuc = thoiGianKetThuc;
	}

	public String getMaTangCa() {
		return MaTangCa;
	}

	public void setMaTangCa(String maTangCa) {
		MaTangCa = maTangCa;
	}

	public String getMaNhanVien() {
		return MaNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
	}

	public double getSoGioTangCa() {
		return SoGioTangCa;
	}

	public void setSoGioTangCa(double soGioTangCa) {
		SoGioTangCa = soGioTangCa;
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
	
}
