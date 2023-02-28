package Model;

import java.util.ArrayList;

public class DanhSachNghiPhep {
	private ArrayList<NghiPhep> danhSachNghiPhep;

	public DanhSachNghiPhep(ArrayList<NghiPhep> danhSachNghiPhep) {
		this.danhSachNghiPhep = danhSachNghiPhep;
	}
	
	public DanhSachNghiPhep() {
		
	}

	public ArrayList<NghiPhep> getDanhSachNghiPhep() {
		return danhSachNghiPhep;
	}

	public void setDanhSachNghiPhep(ArrayList<NghiPhep> danhSachNghiPhep) {
		this.danhSachNghiPhep = danhSachNghiPhep;
	}
	
}
