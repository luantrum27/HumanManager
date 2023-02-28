package Model;

public class ChucVu {
	private String MaChucVu;
	private String TenChucVu;
	private double HeSoPhuCap;
	
	public ChucVu() {
		
	}
	
	public ChucVu(String maChucVu, String tenChucVu, double heSoPhuCap) {
		MaChucVu = maChucVu;
		TenChucVu = tenChucVu;
		HeSoPhuCap = heSoPhuCap;
	}

	public String getMaChucVu() {
		return MaChucVu;
	}

	public void setMaChucVu(String maChucVu) {
		MaChucVu = maChucVu;
	}

	public String getTenChucVu() {
		return TenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		TenChucVu = tenChucVu;
	}

	public double getHeSoPhuCap() {
		return HeSoPhuCap;
	}

	public void setHeSoPhuCap(double heSoPhuCap) {
		HeSoPhuCap = heSoPhuCap;
	}
	
	
	
	
}
