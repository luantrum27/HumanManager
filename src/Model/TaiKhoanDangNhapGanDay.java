package Model;

import java.util.ArrayList;

import Controller.ChucNang;
import View.DangNhapView;

public class TaiKhoanDangNhapGanDay {
	private ArrayList<QuanLiTaiKhoan> list ;
	public TaiKhoanDangNhapGanDay() throws ClassNotFoundException {
		this.list = new ArrayList<QuanLiTaiKhoan>();
			new DangNhapView(this.list);
		
	}
}
