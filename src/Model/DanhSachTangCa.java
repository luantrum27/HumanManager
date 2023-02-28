package Model;

import java.util.ArrayList;

public class DanhSachTangCa {
	private ArrayList<TangCa> danhSachTangCa;

	public DanhSachTangCa() {
		
	}
	
	public DanhSachTangCa(ArrayList<TangCa> danhSachTangCa) {
		this.danhSachTangCa = danhSachTangCa;
	}

	public ArrayList<TangCa> getDanhSachTangCa() {
		return danhSachTangCa;
	}

	public void setDanhSachTangCa(ArrayList<TangCa> danhSachTangCa) {
		this.danhSachTangCa = danhSachTangCa;
	}
	
}
