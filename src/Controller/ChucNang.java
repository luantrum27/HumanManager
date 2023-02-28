package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

import Model.DanhSachLuong;
import Model.DanhSachNghiPhep;
import Model.DanhSachNhanVien;
import Model.DanhSachTangCa;
import Model.NhanVien;
import View.DangNhapView;
import View.ViewQuanLi;

public class ChucNang {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLiNhanSu;user=sa;password=123456";
	ViewQuanLi ql;
	DangNhapView dn;
	Connection con;
	ResultSet rs;
	Statement stmt;
	int count = 2;
	DanhSachNhanVien dsNV;
	DanhSachNghiPhep dsNP;
	DanhSachLuong dsLuong;
	DanhSachTangCa dsTC;
	public ChucNang(ViewQuanLi ql) throws ClassNotFoundException {
		this.ql = ql;
		connect_java();
		dsNV = new DanhSachNhanVien();
		dsNP = new DanhSachNghiPhep();
		dsLuong = new DanhSachLuong();
		dsTC = new DanhSachTangCa();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public void connect_java() throws ClassNotFoundException {
		try {
			String connection_URL = "jdbc:sqlserver://localhost:1433;databaseName=QuanLiNhanSu;user=sa;password=123456";
			con = DriverManager.getConnection(connection_URL);
			stmt = con.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void them_DL_chinh_NhanVien() {
		String maNV = this.ql.t_maNV_nv.getText();
		System.out.println(maNV);
		String HoDem = this.ql.t_hovaTen.getText();
		System.out.println(HoDem);
		String cv = "";
		String pb = "";
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		String GioiTinh = "";
		String CCCD = this.ql.t_CCCD.getText();
		String DiaChi = this.ql.t_address_nv.getText();
		String sdt = this.ql.t_phone_nv.getText();
		String email = this.ql.t_email.getText();
		Date dateBD;
		int d = CCCD.length();
		int len = sdt.length(), countSDT = 1, countCCCD = 1, check = 0;
		try {

			if (this.ql.t_cv.getSelectedIndex() != -1) {
				cv = this.ql.t_cv.getItemAt(this.ql.t_cv.getSelectedIndex()) + "";
			}
			if (this.ql.t_pb.getSelectedIndex() != -1) {
				pb = this.ql.t_pb.getItemAt(this.ql.t_pb.getSelectedIndex()) + "";
			}
			if (this.ql.t_gioiTinh.getSelectedIndex() != -1) {
				GioiTinh = this.ql.t_gioiTinh.getItemAt(this.ql.t_gioiTinh.getSelectedIndex()) + "";
			}
			String outNS = null, ngaySinh = null;
			try {
				DateFormat inputBD = new SimpleDateFormat("dd/MM/yyyy");
				DateFormat outputBD = new SimpleDateFormat("yyyy-MM-dd");

				ngaySinh = dateformat.format(this.ql.date.getDate());

				dateBD = inputBD.parse(ngaySinh);
				outNS = outputBD.format(dateBD);

			} catch (Exception e) {
				// TODO Auto-generated catch block

//				JOptionPane.showMessageDialog(this.ql, "Ngày sinh không hợp lệ", "Thông báo",
//						JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();

			}
			

			if (sdt.charAt(len-1) == ' ') {
				for (int i = 0; i < len - 1; i++) {
					if (sdt.charAt(i) < '0' || sdt.charAt(i) > '9') {
						countSDT = 0;
						break;
					} else if (sdt.charAt(i) >= '0' && sdt.charAt(i) <= '9') {
						countSDT++;
					}
				}
			} else{
				for (int i = 0; i < len; i++) {
					if (sdt.charAt(i) < '0' || sdt.charAt(i) > '9') {
						countSDT = 0;
						break;
					} else if (sdt.charAt(i) >= '0' && sdt.charAt(i) <= '9') {
						countSDT++;
					}
				}
			}

			for (int i = 0; i < d; i++) {
				if (CCCD.charAt(i) < '0' || CCCD.charAt(i) > '9') {
					countCCCD = 0;
					break;
				} else if (CCCD.charAt(i) >= '0' && CCCD.charAt(i) <= '9') {
					countCCCD++;
				}
			}
			NhanVien nv = new NhanVien(maNV, HoDem, outNS, GioiTinh, CCCD, DiaChi, sdt, email, cv, pb);
			dsNV.getDanhSachNhanVien().add(nv);
			dsNV.display();
			stmt.executeUpdate("Exec Them_DL_chinh_NhanVien " + "'" + maNV + "'" + "," + "N'" + HoDem + "'" + "," + "'"
					+ outNS + "'" + "," + GioiTinh + "," + CCCD + "," + "N'" + DiaChi + "'" + "," + sdt + "," + "'"
					+ email + "'" + "," + cv + "," + pb);
			

			JOptionPane.showMessageDialog(this.ql, "Thêm thông tin thành công");
			UpdateComboBoxNhanVien();
			this.ql.dm.addRow(new String[] { this.ql.t_maNV_nv.getText(), this.ql.t_hovaTen.getText(), ngaySinh,
					GioiTinh, this.ql.t_CCCD.getText(), this.ql.t_address_nv.getText(), this.ql.t_phone_nv.getText(),
					this.ql.t_email.getText(), cv, pb, });
			reset_nv();

		} catch (Exception e1) {
			CHECK_MaNV();
			if (maNV.equals("") || HoDem.equals("") || cv.equals("") || pb.equals("") || GioiTinh.equals("")
					|| CCCD.equals("") || DiaChi.equals("") || sdt.equals("") || email.equals("")) {
				JOptionPane.showMessageDialog(this.ql, "Thông tin không được trống! Vui lòng thử lại", "Thông báo",
						JOptionPane.WARNING_MESSAGE);
			}

			if (d > 9) {
				JOptionPane.showMessageDialog(this.ql, "Chứng minh nhân dân phải là 9 số");
			}
			
			if (len < 10 || len > 11) {
				JOptionPane.showMessageDialog(this.ql, "Số điện thoại chưa đúng", "Thông báo", JOptionPane.WARNING_MESSAGE);
			}
			if (countSDT == 0) {
				System.out.println(countSDT);
				JOptionPane.showMessageDialog(this.ql, "Số điện thoại phải là kí tự số", "Thông báo",
						JOptionPane.WARNING_MESSAGE);
			}
			if (countCCCD == 0) {
				JOptionPane.showMessageDialog(this.ql, "Chứng minh nhân dân phải là kí tự số", "Thông báo",
						JOptionPane.WARNING_MESSAGE);
			}
		}

	}

	public void UpdateComboBoxNhanVien() {
		this.ql.t_MaNhanVien.removeAllItems();
		LoadCBX(this.ql.t_MaNhanVien, "SELECT * FROM NHANVIEN", 1);
		this.ql.t_maNV.removeAllItems();
		LoadCBX(this.ql.t_maNV, "SELECT * FROM NHANVIEN", 1);
		this.ql.t_maNV_luong.removeAllItems();
		LoadCBX(this.ql.t_maNV_luong, "SELECT * FROM NHANVIEN", 1);

	}

	public void CHECK_MaNV() {
		String sql = "SELECT dbo.CHECK_MaNV('" + this.ql.t_maNV_nv.getText() + "')";

		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString(1).equals("T")) {
					JOptionPane.showMessageDialog(this.ql, "Mã nhân viên đã tồn tại", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void CHECK_MaNP() {
		String sql = "SELECT dbo.CHECK_MaNP('" + this.ql.t_MaNghiPhep.getText() + "')";

		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString(1).equals("T")) {
					JOptionPane.showMessageDialog(this.ql, "Mã nghỉ phép đã tồn tại", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void CHECK_MaPB() {
		String sql = "SELECT dbo.CHECK_MaPB('" + this.ql.c_maPhongBan.getText() + "')";

		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString(1).equals("T")) {
					JOptionPane.showMessageDialog(this.ql, "Mã phòng ban đã tồn tại", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void CHECK_MaThuong() {
		String sql = "SELECT dbo.CHECK_MaThuong('" + this.ql.t_mThuong.getText() + "')";

		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString(1).equals("T")) {
					JOptionPane.showMessageDialog(this.ql, "Mã thưởng đã tồn tại", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void CHECK_MaPhuCap() {
		String sql = "SELECT dbo.CHECK_MaPhuCap('" + this.ql.t_maPhuCap.getText() + "')";

		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString(1).equals("T")) {
					JOptionPane.showMessageDialog(this.ql, "Mã phụ cấp đã tồn tại", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void CHECK_MaTangCa() {
		String sql = "SELECT dbo.CHECK_TangCa('" + this.ql.t_maTC.getText() + "')";

		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString(1).equals("T")) {
					JOptionPane.showMessageDialog(this.ql, "Mã tăng ca đã tồn tại", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void CHECK_MaLuong() {
		String sql = "SELECT dbo.CHECK_MaLuong('" + this.ql.ma_luong.getText() + "')";

		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString(1).equals("T")) {
					JOptionPane.showMessageDialog(this.ql, "Mã lương đã tồn tại", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Xoa_DL_chinh_NhanVien() {

		try (Connection con = DriverManager.getConnection(url); Statement stmt = con.createStatement()) {
			int row = this.ql.jt.getSelectedRow();
			String ma_NV = this.ql.jt.getValueAt(row, 0) + "";
			int a = JOptionPane.showConfirmDialog(this.ql, "Bạn có chắn chắn xóa dữ liệu này?");
			if (a == JOptionPane.YES_OPTION) {
				this.ql.dm.removeRow(row);
				stmt.executeUpdate("Exec Xoa_DL_chinh_NhanVien " + "'" + ma_NV + "'");
				JOptionPane.showMessageDialog(this.ql, "Xóa dữ liệu thành công");
				UpdateComboBoxNhanVien();
				reset_nv();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.ql, "Lỗi kết nối. Vui lòng thử lại!");
			e.printStackTrace();
		}

	}

	public void showNHANVIEN() {

		try {
			String sql = "Select * From NHANVIEN";
			ResultSet rs = stmt.executeQuery(sql);
			this.ql.dm.setRowCount(0);
			String outNS = null;

			while (rs.next()) {
				try {
					DateFormat outputBD = new SimpleDateFormat("dd/MM/yyyy");
					DateFormat inputBD = new SimpleDateFormat("yyyy-MM-dd");
					Date dateBD;
					dateBD = inputBD.parse(rs.getString(3));
					outNS = outputBD.format(dateBD);

				} catch (Exception e) {
					// TODO Auto-generated catch block
				}
				NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
				dsNV.getDanhSachNhanVien().add(nv);
				dsNV.display();
				this.ql.dm.addRow(new String[] { rs.getString(1), rs.getString(2), outNS, rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), });
				dsNV.display();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.ql, "Lỗi kết nối. Vui lòng thử lại!");
			e.printStackTrace();
		}
	}

	public void ThongTinChiTiet() {
		String MaNV = null;
		if (this.ql.t_maNV_luong.getSelectedIndex() != -1) {
			MaNV = this.ql.t_maNV_luong.getItemAt(this.ql.t_maNV_luong.getSelectedIndex()) + "";
		}
		String sql = "EXEC THONGTINCHITIET '" + MaNV + "'";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				this.ql.tt_maNV.setText(rs.getString(1));
				this.ql.tt_hoten.setText(rs.getString(2));
				this.ql.tt_ngaysinh.setText(SQLInJAVADate(rs.getString(3)));
				this.ql.tt_gioitinh.setText(rs.getString(4));
				this.ql.tt_cccd.setText(rs.getString(5));
				this.ql.tt_diachi.setText(rs.getString(6));
				this.ql.tt_sdt.setText(rs.getString(7));
				this.ql.tt_email.setText(rs.getString(8));
				this.ql.tt_macv.setText(rs.getString(9));
				this.ql.tt_mapb.setText(rs.getString(10));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void timKiemNhanVien() {
		String option = this.ql.t_name_nhanvien.getText();
		if (option.equals("")) {
			showNHANVIEN();
		} else {
			try {
				String sql = "EXEC TIMKIEMNHANVIEN N'" + option + "'";
				this.ql.dm.setRowCount(0);
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String manv = rs.getString(1);
					String hoten = rs.getString(2);
					String ngaysinh = SQLInJAVADate(rs.getString(3));
					String gioitinh = rs.getString(4);
					String cccd = rs.getString(5);
					String diachi = rs.getString(6);
					String sodt = rs.getString(7);
					String email = rs.getString(8);
					String macv = rs.getString(9);
					String mapb = rs.getString(10);
					this.ql.dm.addRow(
							new String[] { manv, hoten, ngaysinh, gioitinh, cccd, diachi, sodt, email, macv, mapb });
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void timKiemNhanVien_theoMa() {
		String option = this.ql.t_name_nhanvien.getText();
		if (option.equals("")) {
			showNHANVIEN();
		} else {
			try {
				String sql = "EXEC TIMKIEMTHEOMA '" + option + "'";
				this.ql.dm.setRowCount(0);
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String manv = rs.getString(1);
					String hoten = rs.getString(2);
					String ngaysinh = SQLInJAVADate(rs.getString(3));
					String gioitinh = rs.getString(4);
					String cccd = rs.getString(5);
					String diachi = rs.getString(6);
					String sodt = rs.getString(7);
					String email = rs.getString(8);
					String macv = rs.getString(9);
					String mapb = rs.getString(10);
					this.ql.dm.addRow(
							new String[] { manv, hoten, ngaysinh, gioitinh, cccd, diachi, sodt, email, macv, mapb });
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void SapXep_theoTuoi() {

	}

	public void SapXep_theoTen() {

		try {
			this.ql.dm.setRowCount(0);
			String sql = "EXEC SapXep_theoTen";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				this.ql.dm.addRow(new String[] { rs.getString(1), rs.getString(2), SQLInJAVADate(rs.getString(3)),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10) });
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this.ql, "Vui lòng thử lại!");
		}
	}

	public void CapNhat_DL_chinh_NhanVien() {
		String maNV = this.ql.t_maNV_nv.getText();
		String HoDem = this.ql.t_hovaTen.getText();
		String cv = "";
		String pb = "";
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		String GioiTinh = "";
		String CCCD = this.ql.t_CCCD.getText();
		String DiaChi = this.ql.t_address_nv.getText();
		String sdt = this.ql.t_phone_nv.getText();
		String email = this.ql.t_email.getText();
		int d = CCCD.length();
		int len = sdt.length(), countSDT = 1, countCCCD = 1, check = 0;
		try {

			if (this.ql.t_cv.getSelectedIndex() != -1) {
				cv = this.ql.t_cv.getItemAt(this.ql.t_cv.getSelectedIndex()) + "";
			}
			if (this.ql.t_pb.getSelectedIndex() != -1) {
				pb = this.ql.t_pb.getItemAt(this.ql.t_pb.getSelectedIndex()) + "";
			}
			if (this.ql.t_gioiTinh.getSelectedIndex() != -1) {
				GioiTinh = this.ql.t_gioiTinh.getItemAt(this.ql.t_gioiTinh.getSelectedIndex()) + "";
			}

			String outNS = null, ngaySinh = null;
			try {
				DateFormat inputBD = new SimpleDateFormat("dd/MM/yyyy");
				DateFormat outputBD = new SimpleDateFormat("yyyy-MM-dd");
				Date dateBD;
				ngaySinh = dateformat.format(this.ql.date.getDate());
				dateBD = inputBD.parse(ngaySinh);
				outNS = outputBD.format(dateBD);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this.ql, "Ngày sinh không hợp lệ", "Thông báo",
						JOptionPane.WARNING_MESSAGE);
			}
			
			int row = this.ql.jt.getSelectedRow();
			stmt.executeUpdate("Exec CapNhat_DL_chinh_NhanVien " + "'" + maNV + "'" + "," + "N'" + HoDem + "'" + ","
					+ "'" + outNS + "'" + "," + GioiTinh + "," + CCCD + "," + "N'" + DiaChi + "'" + "," + sdt + ","
					+ "'" + email + "'" + "," + cv + "," + pb);

			this.ql.dm.removeRow(row);
			this.ql.dm.addRow(new String[] { this.ql.t_maNV_nv.getText(), this.ql.t_hovaTen.getText(), ngaySinh,
					GioiTinh, this.ql.t_CCCD.getText(), this.ql.t_address_nv.getText(), this.ql.t_phone_nv.getText(),
					this.ql.t_email.getText(), cv, pb, });
			JOptionPane.showMessageDialog(this.ql, "Cập nhật thông tin thành công");
			System.out.println(ngaySinh);
			UpdateComboBoxNhanVien();
			reset_nv();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.ql, "Cập nhật thông tin thất bại");
			e.printStackTrace();
		}
	}

	public void show_phongBan() {

		try {
			String sql = "Select * From PHONGBAN";
			ResultSet rs = stmt.executeQuery(sql);

			this.ql.dm_phongBan.setRowCount(0);
			while (rs.next()) {
				this.ql.dm_phongBan.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3) });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.ql, "Vui lòng thử lại!");
		}
	}

	public void LoadCBX(JComboBox c, String sql, int cot) {
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				c.addItem(rs.getString(cot));
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this.ql, "Vui lòng thử lại");
		}
	}

	public void Them_DL_PhongBan() {
		String maPB = this.ql.c_maPhongBan.getText() + "";
		String tenPB = this.ql.c_tenPhongBan.getText() + "";
		String SDT = this.ql.c_sdtPhongBan.getText() + "";
		try {
			
			stmt.executeUpdate(
					"Exec Them_DL_PhongBan " + "'" + maPB + "'" + "," + "N'" + tenPB + "'" + "," + "'" + SDT + "'");

			this.ql.dm_phongBan.setRowCount(0);
			this.ql.t_pb.removeAllItems();
			LoadCBX(this.ql.t_pb, "SELECT * FROM PHONGBAN", 1);
			show_phongBan();
			JOptionPane.showMessageDialog(this.ql, "Thêm thông tin phòng ban thành công");
			reset_pb();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			CHECK_MaPB();
			if (maPB.equals("") || tenPB.equals("") || SDT.equals("")) {
				JOptionPane.showMessageDialog(this.ql, "Thông tin không được trống! Vui lòng thử lại", "Thông báo",
						JOptionPane.WARNING_MESSAGE);
			}
			
		}
	}

	public void CapNhat_DL_PhongBan() {
		String sql = "EXEC CapNhat_DL_PhongBan " + "'" + this.ql.c_maPhongBan.getText() + "', '"
				+ this.ql.c_tenPhongBan.getText() + "', '" + this.ql.c_sdtPhongBan.getText() + "'";
		try {
			int a = JOptionPane.showConfirmDialog(this.ql, "Bạn có chắn chắn cập nhật dữ liệu này?");
			if (a == JOptionPane.YES_OPTION) {
				this.ql.dm_phongBan.setRowCount(0);
				stmt.executeUpdate(sql);
				show_phongBan();
				this.ql.t_pb.removeAllItems();
				LoadCBX(this.ql.t_pb, "SELECT * FROM PHONGBAN", 1);
				JOptionPane.showMessageDialog(this.ql, "Cập nhật dữ liệu thành công");
				reset_nv();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.ql, "Cập nhật dữ liệu thưởng thất bại, vui lòng thử lại", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void Xoa_DL_PhongBan() {

		try {
			int row = this.ql.table_phongBan.getSelectedRow();
			String ma_PB = this.ql.table_phongBan.getValueAt(row, 0) + "";
			int a = JOptionPane.showConfirmDialog(this.ql, "Bạn có chắn chắn xóa dữ liệu này?");
			if (a == JOptionPane.YES_OPTION) {
				this.ql.dm_phongBan.removeRow(row);
				stmt.executeUpdate("Exec Xoa_DL_PhongBan " + "'" + ma_PB + "'");
				this.ql.t_pb.removeAllItems();
				LoadCBX(this.ql.t_pb, "SELECT * FROM PHONGBAN", 1);
				JOptionPane.showMessageDialog(this.ql, "Xóa dữ liệu thành công");
				reset_pb();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.ql, "Vui lòng thử lại!");
		}
	}

	public void Them_TangCa() {
		try {
			String maTC = this.ql.t_maTC.getText() + "";
			String maNV = "";
			if (this.ql.t_maNV.getSelectedIndex() != -1) {
				maNV = this.ql.t_maNV.getItemAt(this.ql.t_maNV.getSelectedIndex()) + "";
			}
			String soGio = this.ql.t_gioGioTC.getText();
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
			String outBD = null, outKT = null, BD = null, KT = null;
			try {
				DateFormat inputBD = new SimpleDateFormat("dd/MM/yyyy");
				DateFormat outputBD = new SimpleDateFormat("yyyy-MM-dd");
				Date dateBD;
				BD = dateformat.format(this.ql.ngayBatDauTC.getDate());
				KT = dateformat.format(this.ql.ngayKetThucTC.getDate());

				dateBD = inputBD.parse(BD);
				outBD = outputBD.format(dateBD);

				DateFormat inputKT = new SimpleDateFormat("dd/MM/yyyy");
				DateFormat outputKT = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date dateKT;

				dateKT = inputKT.parse(KT);
				outKT = outputKT.format(dateKT);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			stmt.executeUpdate("Exec Them_DL_TangCa " + "'" + maTC + "'" + "," + "N'" + maNV + "'" + ", "
					+ Integer.parseInt(soGio) + "," + "'" + outBD + "'" + "," + "'" + outKT + "'");

			show_TangCa();

			JOptionPane.showMessageDialog(this.ql, "Thêm thông tin tăng ca thành công");
			reset_tangCa();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			CHECK_MaTangCa();
		}
	}

	public void show_TangCa() {

		try {
			String sql = "Select * From TANGCA";
			ResultSet rs = stmt.executeQuery(sql);
			this.ql.dm_tc.setRowCount(0);
			String outBD = null, outKT = null;
			while (rs.next()) {
				try {
					DateFormat outputBD = new SimpleDateFormat("dd/MM/yyyy");
					DateFormat inputBD = new SimpleDateFormat("yyyy-MM-dd");
					Date dateBD;
					dateBD = inputBD.parse(rs.getString(4));
					outBD = outputBD.format(dateBD);

					DateFormat outputKT = new SimpleDateFormat("dd/MM/yyyy");
					DateFormat inputKT = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date dateKT;

					dateKT = inputKT.parse(rs.getString(5));
					outKT = outputKT.format(dateKT);
				} catch (Exception e) {
					// TODO Auto-generated catch block
				}
				String dateBD = rs.getString(4);
				this.ql.dm_tc.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), outBD, outKT });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.ql, "Vui lòng thử lại!");
			e.printStackTrace();
		}
	}

	public void Xoa_DL_TangCa() {

		try {
			int row = this.ql.table_tc.getSelectedRow();
			String maTC = this.ql.table_tc.getValueAt(row, 0) + "";
			int a = JOptionPane.showConfirmDialog(this.ql, "Bạn có chắn chắn xóa dữ liệu này?");
			if (a == JOptionPane.YES_OPTION) {
				this.ql.dm_tc.setRowCount(0);
				stmt.executeUpdate("Exec Xoa_DL_TangCa " + "'" + maTC + "'");
				show_TangCa();
				JOptionPane.showMessageDialog(this.ql, "Xóa dữ liệu thành công");
				reset_tangCa();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.ql, "Vui lòng thử lại!");
		}
	}

	public void CapNhat_TangCa() {
		try {
			String maTC = this.ql.t_maTC.getText() + "";
			String maNV = "";
			if (this.ql.t_maNV.getSelectedIndex() != -1) {
				maNV = this.ql.t_maNV.getItemAt(this.ql.t_maNV.getSelectedIndex()) + "";
			}
			String soGio = this.ql.t_gioGioTC.getText();
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
			String outBD = null, outKT = null, BD = null, KT = null;
			try {
				DateFormat inputBD = new SimpleDateFormat("dd/MM/yyyy");
				DateFormat outputBD = new SimpleDateFormat("yyyy-MM-dd");
				Date dateBD;
				BD = dateformat.format(this.ql.ngayBatDauTC.getDate());
				KT = dateformat.format(this.ql.ngayKetThucTC.getDate());

				dateBD = inputBD.parse(BD);
				outBD = outputBD.format(dateBD);

				DateFormat inputKT = new SimpleDateFormat("dd/MM/yyyy");
				DateFormat outputKT = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date dateKT;

				dateKT = inputKT.parse(KT);
				outKT = outputKT.format(dateKT);
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			int a = JOptionPane.showConfirmDialog(this.ql, "Bạn có chắn chắn cập nhật dữ liệu này?");
			if (a == JOptionPane.YES_OPTION) {
				this.ql.dm_tc.setRowCount(0);
				stmt.executeUpdate("Exec CapNhat_DL_TangCa " + "'" + maTC + "'" + "," + "'" + maNV + "'" + ","
						+ Integer.parseInt(soGio) + "," + "'" + outBD + "'" + "," + "'" + outKT + "'");
				show_TangCa();
				JOptionPane.showMessageDialog(this.ql, "Cập nhật dữ liệu thành công");
				reset_tangCa();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.ql, "Vui lòng thử lại!");
		}
	}

	public void Them_DL_Thuong() {
		String sql = "EXEC THEM_DL_THUONG " + "'" + this.ql.t_mThuong.getText() + "', N'" + this.ql.t_tThuong.getText()
				+ "', '" + this.ql.t_sThuong.getText() + "'";
		try {
			stmt.executeUpdate(sql);
			this.ql.dm_thuong.addRow(new String[] { this.ql.t_mThuong.getText(), this.ql.t_tThuong.getText(),
					this.ql.t_sThuong.getText() });
			JOptionPane.showMessageDialog(this.ql, "Thêm thông tin thành công");
			this.ql.t_thuong.removeAllItems();
			LoadCBX(this.ql.t_thuong, "SELECT * FROM THUONG", 2);
			reset_bonus();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			CHECK_MaThuong();
		}
	}

	public void HienThi_DL_Thuong() {
		String sql = "SELECT * FROM THUONG";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			this.ql.dm_thuong.setRowCount(0);
			while (rs.next()) {
				this.ql.dm_thuong.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3) });

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.ql, "Không thể hiện thị dữ liệu", "Thong báo",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void Xoa_DL_Thuong() {
		try {
			int row = this.ql.table_thuong.getSelectedRow();
			String maThuong = this.ql.table_thuong.getValueAt(row, 0) + "";
			int a = JOptionPane.showConfirmDialog(this.ql, "Bạn có chắn chắn xóa dữ liệu này?");
			if (a == JOptionPane.YES_OPTION) {
				this.ql.dm_thuong.removeRow(row);
				stmt.executeUpdate("Exec Xoa_DL_Thuong " + "'" + maThuong + "'");
				JOptionPane.showMessageDialog(this.ql, "Xóa dữ liệu thành công");
				this.ql.t_thuong.removeAllItems();
				LoadCBX(this.ql.t_thuong, "SELECT * FROM THUONG", 2);
				reset_bonus();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.ql, "Vui lòng thử lại!");
			e.printStackTrace();
		}
	}

	public void CapNhat_DL_Thuong() {
		String sql = "EXEC CapNhat_DL_Thuong " + "'" + this.ql.t_mThuong.getText() + "', N'"
				+ this.ql.t_tThuong.getText() + "', '" + this.ql.t_sThuong.getText() + "'";
		try {
			int a = JOptionPane.showConfirmDialog(this.ql, "Bạn có chắn chắn cập nhật dữ liệu này?");
			if (a == JOptionPane.YES_OPTION) {
				this.ql.dm_thuong.setRowCount(0);
				stmt.executeUpdate(sql);
				HienThi_DL_Thuong();
				JOptionPane.showMessageDialog(this.ql, "Cập nhật dữ liệu thành công");
				this.ql.t_thuong.removeAllItems();
				LoadCBX(this.ql.t_thuong, "SELECT * FROM THUONG", 2);
				reset_bonus();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.ql, "Cập nhật dữ liệu thưởng thất bại, vui lòng thử lại", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void Them_DL_PhuCap() {
		String sql = "EXEC Them_DL_PhuCap " + "'" + this.ql.t_maPhuCap.getText() + "', N'"
				+ this.ql.t_tenPhuCap.getText() + "', '" + this.ql.t_tienPhuCap.getText() + "'";
		try {
			stmt.executeUpdate(sql);
			this.ql.dm_thuong.addRow(new String[] { this.ql.t_maPhuCap.getText(), this.ql.t_tenPhuCap.getText(),
					this.ql.t_tienPhuCap.getText() });
			JOptionPane.showMessageDialog(this.ql, "Thêm thông tin thành công");
			this.ql.t_pc.removeAllItems();
			LoadCBX(this.ql.t_pc, "SELECT * FROM PHUCAP", 2);
			reset_phuCap();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			CHECK_MaPhuCap();
		}
	}

	public void HienThi_DL_PhuCap() {
		String sql = "SELECT * FROM PHUCAP";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			this.ql.dm_phuCap.setRowCount(0);
			while (rs.next()) {
				this.ql.dm_phuCap.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3) });

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.ql, "Không thể hiện thị dữ liệu", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void Xoa_DL_PhuCap() {
		try {
			int row = this.ql.table_phuCap.getSelectedRow();
			String maPhuCap = this.ql.table_phuCap.getValueAt(row, 0) + "";
			int a = JOptionPane.showConfirmDialog(this.ql, "Bạn có chắn chắn xóa dữ liệu này?");
			if (a == JOptionPane.YES_OPTION) {
				this.ql.dm_phuCap.setRowCount(0);
				stmt.executeUpdate("Exec Xoa_DL_PhuCap " + "'" + maPhuCap + "'");
				HienThi_DL_PhuCap();
				JOptionPane.showMessageDialog(this.ql, "Xóa dữ liệu thành công");
				this.ql.t_pc.removeAllItems();
				LoadCBX(this.ql.t_pc, "SELECT * FROM PHUCAP", 2);
				reset_phuCap();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.ql, "Vui lòng thử lại!");
			e.printStackTrace();
		}
	}

	public void CapNhat_DL_PhuCap() {
		String sql = "EXEC CapNhat_DL_PhuCap " + "'" + this.ql.t_maPhuCap.getText() + "', N'"
				+ this.ql.t_tenPhuCap.getText() + "', '" + this.ql.t_tienPhuCap.getText() + "'";
		try {
			int a = JOptionPane.showConfirmDialog(this.ql, "Bạn có chắn chắn cập nhật dữ liệu này?");
			if (a == JOptionPane.YES_OPTION) {
				this.ql.dm_phuCap.setRowCount(0);
				stmt.executeUpdate(sql);
				HienThi_DL_PhuCap();
				JOptionPane.showMessageDialog(this.ql, "Cập nhật dữ liệu thành công");
				this.ql.t_pc.removeAllItems();
				LoadCBX(this.ql.t_pc, "SELECT * FROM PHUCAP", 2);
				reset_phuCap();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.ql, "Cập nhật dữ liệu thưởng thất bại, vui lòng thử lại", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void Them_DL_LUONG() throws SQLException {
		String TongLuong = TongLuong() + "";
		String maNV = null, TenLoaiPhuCap = null, TenLoaiThuong = null;
		if (this.ql.t_pc.getSelectedIndex() != -1) {
			TenLoaiPhuCap = this.ql.t_pc.getItemAt(this.ql.t_pc.getSelectedIndex()) + "";
		}
		if (this.ql.t_maNV_luong.getSelectedIndex() != -1) {
			maNV = this.ql.t_maNV_luong.getItemAt(this.ql.t_maNV_luong.getSelectedIndex()) + "";
		}
		if (this.ql.t_thuong.getSelectedIndex() != -1) {
			TenLoaiThuong = this.ql.t_thuong.getItemAt(this.ql.t_thuong.getSelectedIndex()) + "";
		}
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		String ngayNhanLuong = null, ngayNhanPhuCap = null, BD = null, KT = null, ngayNhanThuong = null, NT = null;
		try {
			DateFormat inputBD = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat outputBD = new SimpleDateFormat("yyyy-MM-dd");
			Date dateBD;
			BD = dateformat.format(this.ql.ngayNhanLuong.getDate());
			KT = dateformat.format(this.ql.datePhuCap.getDate());

			dateBD = inputBD.parse(BD);
			ngayNhanLuong = outputBD.format(dateBD);
			DateFormat inputNT = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat outputNT = new SimpleDateFormat("yyyy-MM-dd");
			Date dateNT = null;
			NT = dateformat.format(this.ql.dateThuong.getDate());
			dateNT = inputNT.parse(NT);
			ngayNhanThuong = outputNT.format(dateNT);

			DateFormat inputKT = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat outputKT = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date dateKT;

			dateKT = inputKT.parse(KT);
			ngayNhanPhuCap = outputKT.format(dateKT);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		String sql = "EXEC THEM_LUONG '" + this.ql.ma_luong.getText() + "', '" + maNV + "', '" + ngayNhanLuong + "', "
				+ Double.parseDouble(this.ql.luong_coBan.getText()) + ", " + "N'" + TenLoaiPhuCap + "', '"
				+ ngayNhanPhuCap + "', " + "N'" + TenLoaiThuong + "', '" + ngayNhanThuong + "', " + TongLuong;
		try {
			stmt.executeUpdate(sql);
			SHOW_LUONG();
			JOptionPane.showMessageDialog(this.ql, "Thêm dữ liệu thành công");
			reset_luong();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			CHECK_MaLuong();
//			e.printStackTrace();
//			JOptionPane.showMessageDialog(this.ql, "Lỗi thêm dữ liệu, vui lòng thử lại.", "Thông báo",
//					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void Xoa_DL_LUONG() {
		try {
			int row = this.ql.table_luong.getSelectedRow();
			String maLuong = this.ql.table_luong.getValueAt(row, 0) + "";
			int a = JOptionPane.showConfirmDialog(this.ql, "Bạn có chắn chắn xóa dữ liệu này?");
			if (a == JOptionPane.YES_OPTION) {
				this.ql.dm_luong.removeRow(row);
				stmt.executeUpdate("Exec XOA_LUONG " + "'" + maLuong + "'");
				JOptionPane.showMessageDialog(this.ql, "Xóa dữ liệu thành công");
				reset_luong();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.ql, "Vui lòng thử lại!");
			e.printStackTrace();
		}
	}

	public void CapNhat_DL_LUONG() throws SQLException {
		String TongLuong = TongLuong() + "";
		String maNV = null, TenLoaiPhuCap = null, TenLoaiThuong = null;
		if (this.ql.t_pc.getSelectedIndex() != -1) {
			TenLoaiPhuCap = this.ql.t_pc.getItemAt(this.ql.t_pc.getSelectedIndex()) + "";
		}
		if (this.ql.t_maNV_luong.getSelectedIndex() != -1) {
			maNV = this.ql.t_maNV_luong.getItemAt(this.ql.t_maNV_luong.getSelectedIndex()) + "";
		}
		if (this.ql.t_thuong.getSelectedIndex() != -1) {
			TenLoaiThuong = this.ql.t_thuong.getItemAt(this.ql.t_thuong.getSelectedIndex()) + "";
		}
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		String ngayNhanLuong = null, ngayNhanPhuCap = null, BD = null, KT = null, ngayNhanThuong = null, NT = null;
		try {
			DateFormat inputBD = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat outputBD = new SimpleDateFormat("yyyy-MM-dd");
			Date dateBD;
			BD = dateformat.format(this.ql.ngayNhanLuong.getDate());
			KT = dateformat.format(this.ql.datePhuCap.getDate());

			dateBD = inputBD.parse(BD);
			ngayNhanLuong = outputBD.format(dateBD);
			DateFormat inputNT = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat outputNT = new SimpleDateFormat("yyyy-MM-dd");
			Date dateNT = null;
			NT = dateformat.format(this.ql.dateThuong.getDate());
			dateNT = inputNT.parse(NT);
			ngayNhanThuong = outputNT.format(dateNT);

			DateFormat inputKT = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat outputKT = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date dateKT;

			dateKT = inputKT.parse(KT);
			ngayNhanPhuCap = outputKT.format(dateKT);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}

		System.out.println("Tổng Lương: " + TongLuong);
		String sql = "EXEC CAPNHAT_DL_LUONG '" + this.ql.ma_luong.getText() + "', '" + maNV + "', '" + ngayNhanLuong
				+ "', " + Double.parseDouble(this.ql.luong_coBan.getText()) + ", " + "N'" + TenLoaiPhuCap + "', '"
				+ ngayNhanPhuCap + "', " + "N'" + TenLoaiThuong + "', '" + ngayNhanThuong + "', " + TongLuong;
		try {
			int a = JOptionPane.showConfirmDialog(this.ql, "Bạn có chắn chắn cập nhật dữ liệu này?");
			if (a == JOptionPane.YES_OPTION) {
				this.ql.dm_luong.setRowCount(0);
				stmt.executeUpdate(sql);
				SHOW_LUONG();
				JOptionPane.showMessageDialog(this.ql, "Cập nhật dữ liệu thành công");
				reset_luong();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this.ql, "Lỗi cập nhật dữ liệu, vui lòng thử lại.", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void SHOW_LUONG() {
		String sql = "SELECT * FROM LUONG";
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			this.ql.dm_luong.setRowCount(0);
			while (rs.next()) {
				this.ql.dm_luong.addRow(new String[] { rs.getString(1), rs.getString(2), SQLInJAVADate(rs.getString(3)),
						rs.getString(4), rs.getString(5), SQLInJAVADate(rs.getString(6)), rs.getString(7),
						SQLInJAVADate(rs.getString(8)), rs.getString(9) });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.ql, "Hiện thị dữ liệu không thành công. Vui lòng thử lại");
		}

	}

	public void Them_DL_nghiPhep() {
		String maNV = null;
		if (this.ql.t_MaNhanVien.getSelectedIndex() != -1) {
			maNV = this.ql.t_MaNhanVien.getItemAt(this.ql.t_MaNhanVien.getSelectedIndex()) + "";
		}
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		String outBD = null, outKT = null, BD = null, KT = null;
		try {
			DateFormat inputBD = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat outputBD = new SimpleDateFormat("yyyy-MM-dd");
			Date dateBD;
			BD = dateformat.format(this.ql.ngayBatDauNghiPhep.getDate());
			KT = dateformat.format(this.ql.ngayKetThucNghiPhep.getDate());

			dateBD = inputBD.parse(BD);
			outBD = outputBD.format(dateBD);

			DateFormat inputKT = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat outputKT = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date dateKT;

			dateKT = inputKT.parse(KT);
			outKT = outputKT.format(dateKT);
		} catch (Exception e) {
			// TODO: handle exception
		}
		String sql = "EXEC THEM_NGHIPHEP '" + this.ql.t_MaNghiPhep.getText() + "', '" + maNV + "', N'"
				+ this.ql.t_TenLoaiNghiPhep.getText() + "', " + Integer.parseInt(this.ql.t_SoGioNghi.getText()) + ", '"
				+ outBD + "', '" + outKT + "', N'" + this.ql.t_chuThich_nghi.getText() + "'";
		try {
			stmt.executeUpdate(sql);
			SHOW_NGHIPHEP();
			JOptionPane.showMessageDialog(this.ql, "Thêm dữ liệu thành công");
			reset_nghiPhep();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			JOptionPane.showMessageDialog(this.ql, "Thêm dữ liệu không thành công, vui lòng thử lại", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			CHECK_MaNP();
		}
	}

	public void SHOW_NGHIPHEP() {
		String sql = "SELECT * FROM NGHIPHEP";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			this.ql.dm_nghi_phep.setRowCount(0);

			while (rs.next()) {
				this.ql.dm_nghi_phep
						.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
								SQLInJAVADate(rs.getString(5)), SQLInJAVADate(rs.getString(6)), rs.getString(7) });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void CapNhat_DL_nghiPhep() {
		String maNV = null;
		if (this.ql.t_MaNhanVien.getSelectedIndex() != -1) {
			maNV = this.ql.t_MaNhanVien.getItemAt(this.ql.t_MaNhanVien.getSelectedIndex()) + "";
		}
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		String outBD = null, outKT = null, BD = null, KT = null;
		try {
			DateFormat inputBD = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat outputBD = new SimpleDateFormat("yyyy-MM-dd");
			Date dateBD;
			BD = dateformat.format(this.ql.ngayBatDauNghiPhep.getDate());
			KT = dateformat.format(this.ql.ngayKetThucNghiPhep.getDate());

			dateBD = inputBD.parse(BD);
			outBD = outputBD.format(dateBD);

			DateFormat inputKT = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat outputKT = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date dateKT;

			dateKT = inputKT.parse(KT);
			outKT = outputKT.format(dateKT);
		} catch (Exception e) {
			// TODO: handle exception
		}
		String sql = "EXEC CAPNHAT_NGHIPHEP '" + this.ql.t_MaNghiPhep.getText() + "', '" + maNV + "', N'"
				+ this.ql.t_TenLoaiNghiPhep.getText() + "', " + Integer.parseInt(this.ql.t_SoGioNghi.getText()) + ", '"
				+ outBD + "', '" + outKT + "', N'" + this.ql.t_chuThich_nghi.getText() + "'";
		try {
			int a = JOptionPane.showConfirmDialog(this.ql, "Bạn có chắn chắn cập nhật dữ liệu này?");
			if (a == JOptionPane.YES_OPTION) {
				this.ql.dm_nghi_phep.setRowCount(0);
				stmt.executeUpdate(sql);
				SHOW_NGHIPHEP();
				JOptionPane.showMessageDialog(this.ql, "Cập nhật dữ liệu thành công");
				reset_nghiPhep();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this.ql, "Cập nhật dữ liệu không thành công, vui lòng thử lại", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void Xoa_DL_nghiPhep() {
		try {
			int row = this.ql.table_nghi_phep.getSelectedRow();
			String maNghiPhep = this.ql.table_nghi_phep.getValueAt(row, 0) + "";
			int a = JOptionPane.showConfirmDialog(this.ql, "Bạn có chắn chắn xóa dữ liệu này?");
			if (a == JOptionPane.YES_OPTION) {
				this.ql.dm_nghi_phep.removeRow(row);
				stmt.executeUpdate("Exec XOA_NGHIPHEP " + "'" + maNghiPhep + "'");
				JOptionPane.showMessageDialog(this.ql, "Xóa dữ liệu thành công");
				reset_nghiPhep();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.ql, "Vui lòng thử lại!");
		}

	}

	public void CapNhat_TaiKhoan() {
		String sql = "EXEC UPDATE_ACCOUNT '" + this.ql.TenDangNhap + "', N'" + this.ql.t_hoTen.getText() + "', '"
				+ this.ql.t_lienhe.getText() + "'";
		try {
			stmt.executeUpdate(sql);
			this.ql.l_hoTen.setText(this.ql.t_hoTen.getText());
			this.ql.l_lienhe.setText(this.ql.t_lienhe.getText());
			JOptionPane.showMessageDialog(this.ql, "Cập nhật thành công");
			this.ql.card.show(this.ql.p_card, "qltk");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.ql, "Cập nhật thất bại", "Thông báo", JOptionPane.WARNING_MESSAGE);
		}
	}

	public void DoiMK() {
		String new_password = null;
		String password = JOptionPane.showInputDialog(this.ql, "Nhập mật khẩu cũ");
		if (password.equals(this.ql.MatKhau)) {
			new_password = JOptionPane.showInputDialog(this.ql, "Nhập mật khẩu mới");
			if (new_password.equals(password)) {
				do {
					JOptionPane.showMessageDialog(this.ql, "Mật khẩu này bạn đã dùng, thử lại với mật khẩu khác.",
							"Thông báo", JOptionPane.WARNING_MESSAGE);
					new_password = JOptionPane.showInputDialog(this.ql, "Nhập mật khẩu mới");
				} while (new_password.equals(password));
			}

			String sql = "EXEC CHANGE_PASSWORD '" + this.ql.TenDangNhap + "' , '" + new_password + "'";

			try {
				stmt.executeUpdate(sql);
				System.out.println(new_password);
				JOptionPane.showMessageDialog(this.ql, "Đã lưu thay đổi");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			do {
				if (count <= 3) {
					JOptionPane.showMessageDialog(this.ql, "Mật khẩu không đúng, vui lòng thử lại", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
					password = JOptionPane.showInputDialog(this.ql, "Nhập mật khẩu cũ");
					count++;
				} else {
					JOptionPane.showMessageDialog(this.ql, "Mật khẩu không đúng, vui lòng thử lại", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
					JOptionPane.showMessageDialog(this.ql, "Phiên đăng nhập đã hết hạn", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
					try {
						this.ql.DangXuat();
						break;
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			} while (password != this.ql.MatKhau);

		}

	}

	public String javaInSQLDate(String date) {
		String outNT = null;
		try {
			DateFormat inputBD = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat outputBD = new SimpleDateFormat("yyyy-MM-dd");
			Date dateNT;
			dateNT = inputBD.parse(date);
			outNT = outputBD.format(dateNT);

		} catch (Exception e) {

		}
		return outNT;
	}

	public String SQLInJAVADate(String date) {
		String outNT = null;
		try {
			DateFormat outputBD = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat inputBD = new SimpleDateFormat("yyyy-MM-dd");
			Date dateNT;
			dateNT = inputBD.parse(date);
			outNT = outputBD.format(dateNT);

		} catch (Exception e) {
		}
		return outNT;
	}

	public void Them_DL_CHUCVU() {
		String sql = "EXEC THEM_DL_CHUCVU " + "'" + this.ql.t_maCV.getText() + "', N'" + this.ql.t_tenCV.getText()
				+ "', '" + this.ql.t_tienCV.getText() + "'";
		try {
			stmt.executeUpdate(sql);
			this.ql.dm_cv.addRow(
					new String[] { this.ql.t_maCV.getText(), this.ql.t_tenCV.getText(), this.ql.t_tienCV.getText() });
			JOptionPane.showMessageDialog(this.ql, "Thêm thông tin thành công");
			this.ql.t_cv.removeAllItems();
			LoadCBX(this.ql.t_cv, "SELECT * FROM CHUCVU", 1);
			reset_cv();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}

	public void HienThi_DL_CHUCVU() {
		String sql = "SELECT * FROM CHUCVU";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			this.ql.dm_cv.setRowCount(0);
			while (rs.next()) {
				this.ql.dm_cv.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3) });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.ql, "Không thể hiện thị dữ liệu", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void Xoa_DL_CHUCVU() {
		try {
			int row = this.ql.table_chucvu.getSelectedRow();
			String maCV = this.ql.table_chucvu.getValueAt(row, 0) + "";
			int a = JOptionPane.showConfirmDialog(this.ql, "Bạn có chắn chắn xóa dữ liệu này?");
			if (a == JOptionPane.YES_OPTION) {
				this.ql.dm_cv.removeRow(row);
				stmt.executeUpdate("Exec Xoa_DL_PhuCap " + "'" + maCV + "'");
				this.ql.t_cv.removeAllItems();
				LoadCBX(this.ql.t_cv, "SELECT * FROM CHUCVU", 1);
				JOptionPane.showMessageDialog(this.ql, "Xóa dữ liệu thành công");
				reset_cv();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.ql, "Vui lòng thử lại!");
			e.printStackTrace();
		}
	}

	public void CapNhat_DL_CHUCVU() {
		String sql = "EXEC CAPNHAT_DL_CHUCVU " + "'" + this.ql.t_maCV.getText() + "', N'" + this.ql.t_tenCV.getText()
				+ "', '" + this.ql.t_tienCV.getText() + "'";
		try {
			int a = JOptionPane.showConfirmDialog(this.ql, "Bạn có chắn chắn cập nhật dữ liệu này?");
			if (a == JOptionPane.YES_OPTION) {
				this.ql.dm_cv.setRowCount(0);
				stmt.executeUpdate(sql);
				HienThi_DL_CHUCVU();
				this.ql.t_cv.removeAllItems();
				LoadCBX(this.ql.t_cv, "SELECT * FROM CHUCVU", 1);
				JOptionPane.showMessageDialog(this.ql, "Cập nhật dữ liệu thành công");
				reset_cv();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this.ql, "Cập nhật dữ liệu thưởng thất bại, vui lòng thử lại", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public String TienNghiPhep() throws SQLException {
		String tienNghiPhep = null, tien = null;
		String maNV = null, TenThuong = null, TenPhuCap = null;
		if (this.ql.t_maNV_luong.getSelectedIndex() != -1) {
			maNV = this.ql.t_maNV_luong.getItemAt(this.ql.t_maNV_luong.getSelectedIndex()) + "";
		}
		if (this.ql.t_thuong.getSelectedIndex() != -1) {
			TenThuong = this.ql.t_thuong.getItemAt(this.ql.t_thuong.getSelectedIndex()) + "";
		}
		if (this.ql.t_pc.getSelectedIndex() != -1) {
			TenPhuCap = this.ql.t_pc.getItemAt(this.ql.t_pc.getSelectedIndex()) + "";
		}
		String sql = "SELECT dbo.TIENNGHIPHEP ('" + maNV + "')";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println("Tiền nghỉ phép: " + rs.getString(1));
			tien = rs.getString(1);
		}
		if (tien != null) {
			tienNghiPhep = tien;
		} else
			tienNghiPhep = "0";

		return tienNghiPhep;

	}

	public String TienThuong() throws SQLException {
		String tienThuong = null, tien = null;
		String maNV = null, TenThuong = null, TenPhuCap = null;
		if (this.ql.t_maNV_luong.getSelectedIndex() != -1) {
			maNV = this.ql.t_maNV_luong.getItemAt(this.ql.t_maNV_luong.getSelectedIndex()) + "";
		}
		if (this.ql.t_thuong.getSelectedIndex() != -1) {
			TenThuong = this.ql.t_thuong.getItemAt(this.ql.t_thuong.getSelectedIndex()) + "";
		}
		if (this.ql.t_pc.getSelectedIndex() != -1) {
			TenPhuCap = this.ql.t_pc.getItemAt(this.ql.t_pc.getSelectedIndex()) + "";
		}
		String sql = "SELECT dbo.TIEN_THUONG (N'" + TenThuong + "')";

		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println("Tiền thưởng: " + rs.getString(1));
			tien = rs.getString(1);
		}
		if (tien != (null)) {
			tienThuong = tien;
		} else
			tienThuong = "0";

		return tienThuong;

	}

	public String TIENPHUCAP() throws SQLException {

		String tienPhuCap = null, tien = null;
		String maNV = null, TenThuong = null, TenPhuCap = null;
		if (this.ql.t_maNV_luong.getSelectedIndex() != -1) {
			maNV = this.ql.t_maNV_luong.getItemAt(this.ql.t_maNV_luong.getSelectedIndex()) + "";
		}
		if (this.ql.t_thuong.getSelectedIndex() != -1) {
			TenThuong = this.ql.t_thuong.getItemAt(this.ql.t_thuong.getSelectedIndex()) + "";
		}
		if (this.ql.t_pc.getSelectedIndex() != -1) {
			TenPhuCap = this.ql.t_pc.getItemAt(this.ql.t_pc.getSelectedIndex()) + "";
		}
		String sql = "SELECT dbo.TIEN_PC (N'" + TenPhuCap + "')";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println("Tiền phụ cấp: " + rs.getString(1));
			tien = rs.getString(1);
		}
		if (tien != (null)) {
			tienPhuCap = tien;
		} else
			tienPhuCap = "0";

		return tienPhuCap;

	}

	public String LuongPhuCap() throws SQLException {
		String LuongPhuCap = null, tien = null;
		String maNV = null, TenThuong = null, TenPhuCap = null;
		if (this.ql.t_maNV_luong.getSelectedIndex() != -1) {
			maNV = this.ql.t_maNV_luong.getItemAt(this.ql.t_maNV_luong.getSelectedIndex()) + "";
		}
		if (this.ql.t_thuong.getSelectedIndex() != -1) {
			TenThuong = this.ql.t_thuong.getItemAt(this.ql.t_thuong.getSelectedIndex()) + "";
		}
		if (this.ql.t_pc.getSelectedIndex() != -1) {
			TenPhuCap = this.ql.t_pc.getItemAt(this.ql.t_pc.getSelectedIndex()) + "";
		}
		String sql = "SELECT dbo.LUONGCHUCVU ('" + maNV + "', " + Double.parseDouble(this.ql.luong_coBan.getText())
				+ ")";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println("Lương phụ cấp" + rs.getString(1));
			tien = rs.getString(1);
		}
		if (tien != (null)) {
			LuongPhuCap = tien;
		} else
			LuongPhuCap = "0";

		return LuongPhuCap;

	}

	public String TienTangCa() throws SQLException {
		String TienTangCa = null, tien = null;
		String maNV = null, TenThuong = null, TenPhuCap = null;
		if (this.ql.t_maNV_luong.getSelectedIndex() != -1) {
			maNV = this.ql.t_maNV_luong.getItemAt(this.ql.t_maNV_luong.getSelectedIndex()) + "";
		}
		if (this.ql.t_thuong.getSelectedIndex() != -1) {
			TenThuong = this.ql.t_thuong.getItemAt(this.ql.t_thuong.getSelectedIndex()) + "";
		}
		if (this.ql.t_pc.getSelectedIndex() != -1) {
			TenPhuCap = this.ql.t_pc.getItemAt(this.ql.t_pc.getSelectedIndex()) + "";
		}
		String sql = "SELECT dbo.TienTangCa ('" + maNV + "')";

		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println("Tiền tăng ca: " + rs.getString(1));
			tien = rs.getString(1);
		}
		if (tien != (null)) {
			TienTangCa = tien;
		} else
			TienTangCa = "0";

		return TienTangCa;

	}

	public Double TongLuong() throws NumberFormatException, SQLException {
		Double tienThuong = Double.parseDouble(TienThuong());
		Double tienPC = Double.parseDouble(TIENPHUCAP());
		Double TienNghiPhep = Double.parseDouble(TienNghiPhep());
		Double LuongCV = Double.parseDouble(LuongPhuCap());
		Double tienTC = Double.parseDouble(TienTangCa());

		Double TongLuong = tienThuong + tienPC + LuongCV + tienTC - TienNghiPhep;

		return TongLuong;

	}

	public void ThongKeNVpb() {
		String TenPB = null, SoLuong = null;
		if (this.ql.phongBan.getSelectedIndex() != -1) {
			TenPB = this.ql.phongBan.getItemAt(this.ql.phongBan.getSelectedIndex()) + "";
		}
		String sql = "EXEC NVPB N'" + TenPB + "'";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				SoLuong = rs.getString(1);
			}
			this.ql.r_soLuongNVpb.setText(SoLuong + "       ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ChucNangThongKe(String sql, JLabel l) {
		String SoLuong = null;
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				SoLuong = rs.getString(1);
			}
			l.setText(SoLuong);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ThongKeNhanVien() {
		ChucNangThongKe("EXEC SL_NV", this.ql.r_tongSoNV);
		ChucNangThongKe("EXEC MINAGE ", this.ql.r_doTuoiBeNhat);
		ChucNangThongKe("EXEC MAXAGE ", this.ql.r_doTuoiLonNhat);
		ChucNangThongKe("EXEC SOLUONGQL", this.ql.r_soLuongQL);
		ChucNangThongKe("EXEC SOLUONGNV", this.ql.r_soLuongNV);
		ChucNangThongKe("EXEC AVGAGE", this.ql.r_doTuoiTrungBinh);
		ChucNangThongKe("EXEC SoLuongNam", this.ql.r_soNVNam);
		ChucNangThongKe("EXEC SoLuongNu", this.ql.r_soNVNu);
		ChucNangThongKe("EXEC SoLuongKhac", this.ql.r_soNVKhac);
		ThongKeNVpb();
	}

	public void BieuDo(double LuongThap, double LuongTrungBinh, double LuongCao) {
		// -----------------------------BIỂU ĐỒ HÌNH TRÒN-------------------------------

		DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue("Tỉ lệ nhân viên lương thấp", new Double(LuongThap));
		pieDataset.setValue("Tỉ lệ nhân viên lương cao", new Double(LuongCao));
		pieDataset.setValue("Tỉ lệ nhân viên lương trung bình", new Double(LuongTrungBinh));
		JFreeChart chart = ChartFactory.createPieChart3D("Biểu đồ đánh giá mức lương", pieDataset, true, true, true);
		PiePlot3D p = (PiePlot3D) chart.getPlot();

		ChartFrame frame = new ChartFrame("Biểu đồ tròn", chart);
		frame.setVisible(true);
		frame.setSize(520, 260);
		frame.setLocationRelativeTo(null);
		// ----------------------------------------------------------------------------
	}

	public Double LuongThap(int month, int year, double luongBacThap) {
		String sql = "SELECT dbo.LUONGTHAP (" + month + ", " + year + ", " + luongBacThap + ")";
		ResultSet rs;
		String kq = null;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				kq = rs.getString(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double ketqua;
		if (kq != null) {
			ketqua = Double.parseDouble(kq);
		} else {
			ketqua = 0;
		}
		return ketqua;
	}

	public Double LuongCao(int month, int year, double luongBacCao) {
		String sql = "SELECT dbo.LUONGCAO (" + month + ", " + year + ", " + luongBacCao + ")";
		ResultSet rs;
		String kq = null;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				kq = rs.getString(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double ketqua;
		if (kq != null) {
			ketqua = Double.parseDouble(kq);
		} else {
			ketqua = 0;
		}
		return ketqua;
	}

	public Double LuongTrungBinh(int month, int year, double luongBacThap, double luongBacCao) {
		String sql = "SELECT dbo.LUONGTRUNGBINH (" + month + ", " + year + ", " + luongBacThap + ", " + luongBacCao
				+ ")";
		ResultSet rs;
		String kq = null;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				kq = rs.getString(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double ketqua;
		if (kq != null) {
			ketqua = Double.parseDouble(kq);
		} else {
			ketqua = 0;
		}
		return ketqua;
	}

	public void ThongKeLuong(JLabel l1, JLabel l2, JLabel l3, JLabel l4, String maxluong, String minluong,
			String avgluong, String sumluong) {
		l1.setText(maxluong);
		l2.setText(minluong);
		l3.setText(avgluong);
		l4.setText(sumluong);
	}

	public String MaxLuong(int month, int year) {
		String sql = "EXEC MAXLUONG " + month + ", " + year;
		String ketqua = null;
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ketqua = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String kq;
		if (ketqua != null) {
			kq = ketqua;
		} else {
			kq = "0";
		}
		return kq;
	}

	public String MinLuong(int month, int year) {
		String sql = "EXEC MINLUONG " + month + ", " + year;
		String ketqua = null;
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ketqua = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String kq;
		if (ketqua != null) {
			kq = ketqua;
		} else {
			kq = "0";
		}
		return kq;
	}

	public String AvgLuong(int month, int year) {
		String sql = "EXEC AVGLUONG " + month + ", " + year;
		String ketqua = null;
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ketqua = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String kq;
		if (ketqua != null) {
			kq = ketqua;
		} else {
			kq = "0";
		}
		return kq;
	}

	public String SumLuong(int month, int year) {
		String sql = "EXEC SUMLUONG " + month + ", " + year;
		String ketqua = null;
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ketqua = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String kq;
		if (ketqua != null) {
			kq = ketqua;
		} else {
			kq = "0";
		}
		return kq;
	}

	public void reset_cv() {
		this.ql.t_maCV.setText("");
		this.ql.t_tenCV.setText("");
		this.ql.t_tienCV.setText("");
	}

	public void reset_nv() {
		this.ql.t_ngaySinh.setText("");
		this.ql.t_maNV_nv.setText("");
		this.ql.t_hovaTen.setText("");
		this.ql.t_CCCD.setText("");
		this.ql.t_address_nv.setText("");
		this.ql.t_phone_nv.setText("");
		this.ql.t_email.setText("");
	}

	public void reset_pb() {
		this.ql.c_maPhongBan.setText("");
		this.ql.c_tenPhongBan.setText("");
		this.ql.c_sdtPhongBan.setText("");
	}

	public void reset_bonus() {
		this.ql.t_mThuong.setText("");
		this.ql.t_tThuong.setText("");
		this.ql.t_sThuong.setText("");
	}

	public void reset_phuCap() {
		this.ql.t_maPhuCap.setText("");
		this.ql.t_tenPhuCap.setText("");
		this.ql.t_tienPhuCap.setText("");
	}

	public void reset_tangCa() {
		this.ql.t_maTC.setText("");
		this.ql.t_gioGioTC.setText("");
		this.ql.t_thoiGianBD.setText("");
		this.ql.t_thoiGianKT.setText("");
	}

	public void reset_nghiPhep() {
		this.ql.t_MaNghiPhep.setText("");
		this.ql.t_TenLoaiNghiPhep.setText("");
		this.ql.t_SoGioNghi.setText("");
		this.ql.t_BDnghi.setText("");
		this.ql.t_KTnghi.setText("");
		this.ql.t_chuThich_nghi.setText("");
	}

	public void reset_luong() {
		this.ql.ma_luong.setText("");
		this.ql.luong_coBan.setText("");
		this.ql.t_tdNhanLuong.setText("");
		this.ql.t_ngayNhanpc.setText("");
		this.ql.t_ngayNhanThuong.setText("");
		this.ql.t_chuThich_nghi.setText("");
	}
}
