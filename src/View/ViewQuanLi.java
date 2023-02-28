package View;

import java.awt.*;

import java.awt.event.*;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.MenuKeyEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.w3c.dom.html.HTMLInputElement;
import org.xml.sax.InputSource;

import com.toedter.calendar.JDateChooser;

import Controller.ChucNang;
import Model.QuanLiTaiKhoan;
import Model.TaiKhoanDangNhapGanDay;

public class ViewQuanLi extends JFrame {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLiNhanSu;user=sa;password=123456";
	public String t_gioi_tinh_ql;
	public String t_gioitinh_nv;
	public JLabel label_chon;
	public JButton button_quanli;
	public JButton button_nhanvien;
	public JLabel label_empty1, label_empty2, label_empty3;
	public JButton l_add, l_update, l_remove, l_sort, l_search;
	public JTextField t_maNV_nv, t_name_nv, t_address_nv, t_nam_nv, t_phone_nv;
	public JPanel p_nhap_main;
	public CardLayout card;
	public DefaultTableModel dm;
	public JButton l_add_ql;
	public JButton l_add_nv;
	public DefaultTableModel dm_ht;
	public JTable jt;
	public JTextField t_Ten;
	public JComboBox t_gioiTinh;
	public JTextField t_CCCD;
	public JTextField t_email;
	public JComboBox t_cv;
	public JComboBox t_pb;
	public JTextField c_maPhongBan;
	public JTextField c_tenPhongBan;
	public JTextField c_sdtPhongBan;
	public DefaultTableModel dm_phongBan;
	public JTable table_phongBan;
	public JButton l_them_pb;
	public JButton l_capNhat_pb;
	public JButton l_xoa_pb;
	public JButton l_thoat_pb;
	public JComboBox t_maNV;
	public JTextField t_maTC;
	public JTextField t_gioGioTC;
	public JTextField t_thoiGianBD;
	public JTextField t_thoiGianKT;
	public JButton b_them_tc;
	public JButton b_capNhat_tc;
	public JButton b_xoa_tc;
	public JButton b_thoat_tc;
	public DefaultTableModel dm_tc;
	public JTable table_tc;
	public JLabel l_maNV;
	public JLabel l_maNV_nv;
	public JLabel l_name_nv;
	public JTextField ma_luong;
	public JTextField luong_coBan;
	public JTextField t_tdNhanLuong;
	public JComboBox t_thuong;
	public JTextField t_ngayNhanThuong;
	public JComboBox t_pc;
	public JTextField t_ngayNhanpc;
	public DefaultTableModel dm_luong;
	public JTable table_luong;
	public JButton b_tinh_luong;
	public JButton b_capNhat_luong;
	public JButton b_xoa_luong;
	public JButton b_thoat_luong;
	public JComboBox t_maNV_luong;
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	public ArrayList<QuanLiTaiKhoan> list;
	public JTextField t_hovaTen;
	public JComboBox t_date;
	public JComboBox t_month;
	public JComboBox t_year;
	public JButton l_hienThi_pb;
	public JPanel p_card;
	public JButton b_hienthi_tc;
	public JTextField t_mThuong;
	public JTextField t_tThuong;
	public JTextField t_sThuong;
	public DefaultTableModel dm_thuong;
	public JTable table_thuong;
	public JTextField t_maPhuCap;
	public JTextField t_tenPhuCap;
	public JTextField t_tienPhuCap;
	public DefaultTableModel dm_phuCap;
	public JTable table_phuCap;
	public JButton b_hienThi_thuong;
	public JButton b_them_thuong;
	public JButton b_capNhat_thuong;
	public JButton b_xoa_thuong;
	public JButton b_thoat_thuong;
	public JButton b_hienThi_phuCap;
	public JButton b_them_phuCap;
	public JButton b_capNhat_phuCap;
	public JButton b_xoa_phuCap;
	public JButton b_thoat_phuCap;
	public JTextField t_ngaySinh;
	public JTextField t_maNhanThuong;
	public JTextField t_maNhanPhuCap;
	public JButton b_hienthi_luong;
	public DefaultTableModel dm_nghi_phep;
	public JTable table_nghi_phep;

	public JTextField t_chuThich_nghi;
	public JTextField t_KTnghi;
	public JTextField t_BDnghi;
	public JTextField t_SoGioNghi;
	public JComboBox t_MaNhanVien;
	public JTextField t_MaNghiPhep;
	public JTextField t_TenLoaiNghiPhep;
	public JButton b_them_nghi_phep;
	public JButton b_capNhat_nghi_phep;
	public JButton b_xoa_nghi_phep;
	public JButton b_thoat_nghi_phep;
	public JButton b_hienthi_nghiphep;
	public String name, lienHe, TenDangNhap, MatKhau;
	public JButton button_doiMK;
	public JButton button_edit;
	public JButton button_thoat;
	public JTextField t_hoTen;
	public JTextField t_lienhe;
	public JButton button_save_chinhsua;
	public JButton button_thoat_chinhsua;
	ChucNang cn;
	public JLabel l_hoTen;
	public JLabel l_lienhe;
	public JTextField t_maCV;
	public JTextField t_tenCV;
	public JTextField t_tienCV;
	public JTable table_chucvu;
	public DefaultTableModel dm_cv;
	public JButton b_thoat_cv;
	public JButton b_xoa_cv;
	public JButton b_capNhat_cv;
	public JButton b_them_cv;
	public JButton b_hienthi_chucvu;
	public CardLayout card_ttnv;
	public JTextField t_name_nhanvien;
	public CardLayout card_ttct;
	public JButton b_ttct_luong;
	public JLabel tt_maNV;
	public JLabel tt_hoten;
	public JLabel tt_ngaysinh;
	public JLabel tt_gioitinh;
	public JLabel tt_cccd;
	public JLabel tt_diachi;
	public JLabel tt_sdt;
	public JLabel tt_email;
	public JLabel tt_mapb;
	public JLabel tt_macv;
	public JButton b_thoat_ttct;
	public JComboBox phongBan;
	public JLabel r_tongSoNV;
	public JLabel r_soLuongQL;
	public JLabel r_soLuongNV;
	public JLabel r_soNVNam;
	public JLabel r_soNVNu;
	public JLabel r_soNVKhac;
	public JLabel r_soLuongNVpb;
	public JButton b_thoat_tk;
	public JButton b_reset;
	public JLabel r_doTuoiLonNhat;
	public JLabel r_doTuoiBeNhat;
	public JLabel r_doTuoiTrungBinh;
	public JDateChooser date;
	public JDateChooser ngayBatDauTC;
	public JDateChooser ngayKetThucTC;
	public JDateChooser ngayBatDauNghiPhep;
	public JDateChooser ngayKetThucNghiPhep;
	public JDateChooser ngayNhanLuong;
	public JDateChooser datePhuCap;
	public JDateChooser dateThuong;
	private JButton b_reset_luong_1;
	private JButton b_thoat_tk_luong_1;
	private JLabel r_maxLuong;
	private JLabel r_minLuong;
	private JLabel r_sumLuong;
	private JLabel r_avgLuong;
	private JLabel r_luongBacCao;
	private JLabel r_luongBacThap;
	private JButton b_pieChart_1;
	private JButton b_pieChart_2;
	private JButton b_thoat_tk_luong_2;
	private JLabel r_maxLuong2;
	private JLabel r_minLuong2;
	private JLabel r_luongBacCao2;
	private JLabel r_luongBacThap2;
	private JLabel r_sumLuong2;
	private JLabel r_avgLuong2;
	private JButton b_pieChart_3;
	private JButton b_thoat_tk_luong_3;
	private JLabel r_maxLuong3;
	private JLabel r_minLuong3;
	private JLabel r_luongBacCao3;
	private JLabel r_luongBacThap3;
	private JLabel r_sumLuong3;
	private JLabel r_avgLuong3;
	private JButton b_pieChart_4;
	private JButton b_thoat_tk_luong_4;
	private JLabel r_maxLuong4;
	private JLabel r_minLuong4;
	private JLabel r_luongBacCao4;
	private JLabel r_luongBacThap4;
	private JLabel r_sumLuong4;
	private JLabel r_avgLuong4;
	private JButton b_pieChart_5;
	private JButton b_thoat_tk_luong_5;
	private JLabel r_maxLuong5;
	private JLabel r_minLuong5;
	private JLabel r_luongBacCao5;
	private JLabel r_luongBacThap5;
	private JLabel r_sumLuong5;
	private JLabel r_avgLuong5;
	private JButton b_pieChart_6;
	private JButton b_thoat_tk_luong_6;
	private JLabel r_maxLuong6;
	private JLabel r_minLuong6;
	private JLabel r_luongBacCao6;
	private JLabel r_luongBacThap6;
	private JLabel r_sumLuong6;
	private JLabel r_avgLuong6;
	private JButton b_pieChart_7;
	private JButton b_thoat_tk_luong_7;
	private JLabel r_maxLuong7;
	private JLabel r_minLuong7;
	private JLabel r_luongBacCao7;
	private JLabel r_luongBacThap7;
	private JLabel r_sumLuong7;
	private JLabel r_avgLuong7;
	private JButton b_pieChart_8;
	private JButton b_thoat_tk_luong_8;
	private JLabel r_maxLuong8;
	private JLabel r_minLuong8;
	private JLabel r_luongBacCao8;
	private JLabel r_luongBacThap8;
	private JLabel r_sumLuong8;
	private JLabel r_avgLuong8;
	private JButton b_pieChart_9;
	private JButton b_thoat_tk_luong_9;
	private JLabel r_minLuong9;
	private JLabel r_maxLuong9;
	private JLabel r_luongBacCao9;
	private JLabel r_luongBacThap9;
	private JLabel r_sumLuong9;
	private JLabel r_avgLuong9;
	private JButton b_pieChart_10;
	private JButton b_thoat_tk_luong_10;
	private JLabel r_maxLuong10;
	private JLabel r_minLuong10;
	private JLabel r_luongBacCao10;
	private JLabel r_luongBacThap10;
	private JLabel r_sumLuong10;
	private JLabel r_avgLuong10;
	private JButton b_pieChart_11;
	private JButton b_thoat_tk_luong_11;
	private JLabel r_maxLuong11;
	private JLabel r_minLuong11;
	private JLabel r_luongBacCao11;
	private JLabel r_luongBacThap11;
	private JLabel r_sumLuong11;
	private JLabel r_avgLuong11;
	private JButton b_pieChart_12;
	private JButton b_thoat_tk_luong_12;
	private JLabel r_maxLuong12;
	private JLabel r_minLuong12;
	private JLabel r_luongBacCao12;
	private JLabel r_luongBacThap12;
	private JLabel r_sumLuong12;
	private JLabel r_avgLuong12;
	private JComboBox cbboxOption;

	public ViewQuanLi(ArrayList<QuanLiTaiKhoan> list) throws ClassNotFoundException, SQLException {
		this.list = list;
		cn = new ChucNang(this);
		this.setting();
		this.setVisible(true);

	}

	public void setting() {
		this.setTitle("QUẢN LÍ NHÂN SỰ");
		this.setSize(1080, 520);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String[] gender = { "Nam", "Nữ", "Khác" };
		card = new CardLayout();
		p_card = new JPanel();
		p_card.setLayout(card);
		JPanel p_main = new JPanel();
		p_main.setLayout(new BorderLayout());

		// --------------------------------------------------------------------------------
		Font font = new Font("Arial", Font.BOLD, 20);
		// ----------------------------------------------------------------------------
		JPanel p_chon = new JPanel();
		p_chon.setLayout(new GridLayout(7, 1));
		label_chon = new JLabel("Welcome", 0);
		label_chon.setBackground(Color.BLACK);
		label_chon.setForeground(Color.WHITE);
		label_chon.setOpaque(true);
		label_empty1 = new JLabel("");
		label_empty2 = new JLabel("");
		label_empty3 = new JLabel("");
		button_quanli = new JButton();
		button_quanli.setBackground(Color.YELLOW);
		button_nhanvien = new JButton();
		button_nhanvien.setBackground(Color.GREEN);
		p_chon.add(label_chon);
		p_chon.add(label_empty1);
		p_chon.add(button_quanli);
		p_chon.add(label_empty3);
		p_chon.add(button_nhanvien);
		// ----------------------------------------------------------------------------
		JLabel l_title = new JLabel("QUẢN LÍ NHÂN SỰ", 0);
		l_title.setFont(font);
		JPanel p_thong_tin = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder t_border = BorderFactory.createTitledBorder(border, "*");

		JPanel p_nhap = new JPanel();
		p_nhap.setLayout(new GridLayout(0, 2, 10, 10));
		p_nhap_main = new JPanel();
		p_nhap_main.setLayout(new BorderLayout());
		// --------------------GIAO DIỆN THÔNG TIN NHÂN VIÊN---------------------
		JPanel p_ttnv = new JPanel();
		p_ttnv.setBackground(Color.GREEN);
		p_ttnv.setLayout(new GridLayout(5, 2, 10, 10));
		Border bnv = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder tbnv = BorderFactory.createTitledBorder(bnv, "Thông tin chính");
		p_ttnv.setBorder(tbnv);
		l_maNV_nv = new JLabel("Mã nhân viên: ", 0);
		l_name_nv = new JLabel("Họ và tên: ", 0);
		JLabel l_address_nv = new JLabel("Địa chỉ: ", 0);
		JLabel l_nam_nv = new JLabel("Ngày sinh: ", 0);
		JLabel l_phone_nv = new JLabel("Số điện thoại: ", 0);
		JLabel l_so_sp = new JLabel("Số sản phẩm bán được: ", 0);
		JLabel l_gioitinh_nv = new JLabel("Giới tính", 0);
		JLabel l_email = new JLabel("Email", 0);
		JLabel l_cv = new JLabel("Mã chức vụ", 0);
		JLabel l_pb = new JLabel("Mã phòng ban", 0);
		JLabel l_CCCD = new JLabel("CCCD/CMND", 0);
		JLabel l_hovaten = new JLabel("Họ và tên", 0);

		t_maNV_nv = new JTextField(50);
		t_hovaTen = new JTextField(50);

		t_gioiTinh = new JComboBox(gender);
		t_CCCD = new JTextField(50);
		t_address_nv = new JTextField(50);
		t_nam_nv = new JTextField(50);
		t_phone_nv = new JTextField(50);
		t_email = new JTextField(50);
		t_cv = new JComboBox();
		t_pb = new JComboBox();
		t_ngaySinh = new JTextField(50);
		JPanel p_ngaySinh = new JPanel();
		date = new JDateChooser();
		date.setDateFormatString("dd/MM/yyyy");

		p_ttnv.add(l_maNV_nv);
		p_ttnv.add(t_maNV_nv);
		p_ttnv.add(l_hovaten);
		p_ttnv.add(t_hovaTen);
		p_ttnv.add(l_nam_nv);
		p_ttnv.add(date);
		p_ttnv.add(l_cv);
		p_ttnv.add(t_cv);
		p_ttnv.add(l_pb);
		p_ttnv.add(t_pb);
		p_nhap_main.add(p_ttnv, BorderLayout.CENTER);
		// --------------------------------------------

		p_nhap.add(p_nhap_main);

		// --------------------------GIAODIENTHONGTINKHAC---------------------------------
		card_ttnv = new CardLayout();
		JPanel p_tt_khac = new JPanel();
//		p_tt_khac.setLayout(new BorderLayout());
		p_tt_khac.setLayout(card_ttnv);
		JPanel p_nhap_khac = new JPanel();
		p_nhap_khac.setLayout(new GridLayout(5, 2, 10, 10));
		Border bm = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder tbm = BorderFactory.createTitledBorder(bm, "Thông tin khác");
		p_nhap_khac.setBorder(tbm);
		Border btable_hienthi = BorderFactory.createLineBorder(Color.RED);
		TitledBorder t_table_hienthi = BorderFactory.createTitledBorder(btable_hienthi, "Danh sách nhân sự");

		p_nhap_khac.add(l_CCCD);
		p_nhap_khac.add(t_CCCD);
		p_nhap_khac.add(l_CCCD);
		p_nhap_khac.add(t_CCCD);
		p_nhap_khac.add(l_address_nv);
		p_nhap_khac.add(t_address_nv);
		p_nhap_khac.add(l_phone_nv);
		p_nhap_khac.add(t_phone_nv);
		p_nhap_khac.add(l_email);
		p_nhap_khac.add(t_email);
		p_nhap_khac.add(l_gioitinh_nv);
		p_nhap_khac.add(t_gioiTinh);
		p_tt_khac.add(p_nhap_khac, "ttnv");
		card_ttnv.show(p_tt_khac, "ttnv");
		// -------------------------GIAODIENTIMKIEM-----------------------------------
		JPanel p_tim_kiemNV = new JPanel();
		p_tim_kiemNV.setLayout(new BorderLayout());

		JLabel tk_top = new JLabel();
		tk_top.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_top.png")));
		JLabel tk_bottom = new JLabel();
		tk_bottom.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tkiem_b.png")));
		JLabel tk_left = new JLabel();
		tk_left.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tkiem_l.png")));
		JLabel tk_right = new JLabel();
		tk_right.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tkiem_l.png")));
		JPanel content_timkiem = new JPanel();
		content_timkiem.setLayout(new BorderLayout());
		JLabel nhap_ten = new JLabel("Nhập thông tin: ", 0);
		JLabel l_option = new JLabel("Lựa chọn:          ", 0);
		content_timkiem.setBackground(Color.WHITE);
		t_name_nhanvien = new JTextField(50);
		t_name_nhanvien.addKeyListener(new KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				String luaChon = "";
				if (cbboxOption.getSelectedIndex() != -1) {
					luaChon = cbboxOption.getItemAt(cbboxOption.getSelectedIndex()) + "";
				}
				if (luaChon.equals("Tìm kiếm theo tên nhân viên")) {
					cn.timKiemNhanVien();
				} else if (luaChon.equals("Tìm kiếm theo mã nhân viên")) {
					cn.timKiemNhanVien_theoMa();
				}

			}

		});
		JPanel p_thongTinTimKiem = new JPanel();
		p_thongTinTimKiem.setLayout(new GridLayout(2, 0));
		String[] option = { "Tìm kiếm theo tên nhân viên", "Tìm kiếm theo mã nhân viên" };
		cbboxOption = new JComboBox(option);

		JPanel p_Option = new JPanel();
		p_Option.setLayout(new BorderLayout());
		p_Option.setBackground(Color.WHITE);
		p_Option.add(l_option, BorderLayout.WEST);
		p_Option.add(cbboxOption, BorderLayout.CENTER);
		content_timkiem.add(nhap_ten, BorderLayout.WEST);
		content_timkiem.add(t_name_nhanvien, BorderLayout.CENTER);
		p_thongTinTimKiem.add(p_Option);
		p_thongTinTimKiem.add(content_timkiem);
		p_tim_kiemNV.add(tk_top, BorderLayout.NORTH);
		p_tim_kiemNV.add(tk_bottom, BorderLayout.SOUTH);
		p_tim_kiemNV.add(tk_left, BorderLayout.EAST);
		p_tim_kiemNV.add(tk_right, BorderLayout.WEST);
		p_tim_kiemNV.add(p_thongTinTimKiem, BorderLayout.CENTER);
		p_tt_khac.add(p_tim_kiemNV, "tknv");

		// ------------------------GIAO DIEN PHÒNG BAN-------------------------------
		JPanel p_all_phongBan = new JPanel();
		p_all_phongBan.setLayout(new BorderLayout());
		JPanel p_phongBan_top = new JPanel();
		p_phongBan_top.setLayout(new BorderLayout());
		p_phongBan_top.setBackground(Color.YELLOW);
		JPanel p_bia = new JPanel();
		p_bia.setLayout(new GridLayout(0, 2));
		JPanel p_phongBan_center = new JPanel();
		p_phongBan_center.setLayout(new GridLayout(5, 3, 10, 10));
		JPanel p_phongBan_cn = new JPanel();
		p_phongBan_cn.setLayout(new GridLayout(0, 9));
		Border pb = BorderFactory.createLineBorder(Color.RED);
		TitledBorder tpb = BorderFactory.createTitledBorder(pb, "Thông tin phòng ban");
		p_phongBan_top.setBorder(tpb);
		JLabel em1 = new JLabel();
		JLabel em2 = new JLabel();
		JLabel em3 = new JLabel();
		JLabel em4 = new JLabel();
		JLabel em5 = new JLabel();
		JLabel em6 = new JLabel();
		JLabel em7 = new JLabel();
		JLabel em8 = new JLabel();
		JLabel em9 = new JLabel();

		JLabel em10 = new JLabel();
		JLabel em11 = new JLabel();
		JLabel em12 = new JLabel();
		JLabel em13 = new JLabel();
		JLabel ma_phongBan = new JLabel("Mã phòng ban", 0);
		JLabel ten_phongBan = new JLabel("Tên phòng ban", 0);
		JLabel sdt_phongBan = new JLabel("Số điện thoại", 0);
		l_hienThi_pb = new JButton("Hiển thị");
		l_hienThi_pb.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_eye.png")));
		l_hienThi_pb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.show_phongBan();
			}

		});
		l_hienThi_pb.setBackground(Color.CYAN);
		l_them_pb = new JButton("Thêm");
		l_them_pb.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_add.png")));

		l_them_pb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.Them_DL_PhongBan();
			}

		});
		l_them_pb.setBackground(Color.CYAN);
		l_capNhat_pb = new JButton("Cập Nhật");
		l_capNhat_pb.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_update.png")));
		l_capNhat_pb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.CapNhat_DL_PhongBan();
			}

		});
		l_capNhat_pb.setBackground(Color.CYAN);
		l_xoa_pb = new JButton("Xóa");
		l_xoa_pb.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_remove.png")));

		l_xoa_pb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.Xoa_DL_PhongBan();
			}

		});
		l_xoa_pb.setBackground(Color.CYAN);
		l_thoat_pb = new JButton("Thoát");
		l_thoat_pb.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_exit.png")));

		l_thoat_pb.setBackground(Color.CYAN);
		l_thoat_pb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "3");
			}

		});
		c_maPhongBan = new JTextField(50);
		c_tenPhongBan = new JTextField(50);
		c_sdtPhongBan = new JTextField(50);

		p_phongBan_center.add(em1);
		p_phongBan_center.add(em2);
		p_phongBan_center.add(em5);
		p_phongBan_cn.add(em10);
		p_phongBan_cn.add(em11);
		p_phongBan_center.add(ma_phongBan);
		p_phongBan_center.add(c_maPhongBan);
		p_phongBan_center.add(em6);
		p_phongBan_cn.add(l_hienThi_pb);
		p_phongBan_cn.add(l_them_pb);
		p_phongBan_center.add(ten_phongBan);
		p_phongBan_center.add(c_tenPhongBan);
		p_phongBan_center.add(em7);
		p_phongBan_cn.add(l_capNhat_pb);
		p_phongBan_center.add(sdt_phongBan);
		p_phongBan_center.add(c_sdtPhongBan);
		p_phongBan_center.add(em8);
		p_phongBan_cn.add(l_xoa_pb);
		p_phongBan_center.add(em3);
		p_phongBan_center.add(em4);
		p_phongBan_center.add(em9);
		p_phongBan_cn.add(l_thoat_pb);
		p_phongBan_cn.add(em12);
		p_phongBan_cn.add(em13);

		JLabel bia_phongBan = new JLabel("");
		bia_phongBan.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/phongBan_bia.png")));
		p_bia.add(bia_phongBan);
		p_bia.add(p_phongBan_center);
		p_phongBan_top.add(p_bia, BorderLayout.CENTER);

		dm_phongBan = new DefaultTableModel();
		dm_phongBan.addColumn("Mã phòng ban");
		dm_phongBan.addColumn("Tên phòng ban");
		dm_phongBan.addColumn("Số điện thoại");
		table_phongBan = new JTable(dm_phongBan);
		table_phongBan.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table_phongBan.getSelectedRow();
				c_maPhongBan.setText(table_phongBan.getValueAt(row, 0) + "");
				c_tenPhongBan.setText(table_phongBan.getValueAt(row, 1) + "");
				c_sdtPhongBan.setText(table_phongBan.getValueAt(row, 2) + "");

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		JPanel p_table_pb = new JPanel();
		p_table_pb.setLayout(new BorderLayout());
		p_table_pb.add(p_phongBan_cn, BorderLayout.NORTH);
		JScrollPane sc_phongBan = new JScrollPane(table_phongBan);
		p_all_phongBan.add(p_phongBan_top, BorderLayout.NORTH);
		p_table_pb.add(sc_phongBan, BorderLayout.CENTER);
		p_all_phongBan.add(p_table_pb, BorderLayout.CENTER);
		cn.LoadCBX(t_pb, "Select * From PHONGBAN", 1);
		cn.LoadCBX(t_cv, "SELECT * FROM CHUCVU", 1);

		// ------------------------------------------------------------------------
		p_nhap.add(p_tt_khac);
		p_thong_tin.setBorder(t_border);
		p_thong_tin.setLayout(new BorderLayout());
		p_thong_tin.add(l_title, BorderLayout.NORTH);
		p_thong_tin.add(p_nhap, BorderLayout.CENTER);
		// ------------------------GIAODIENTHONGTINCHITIET-------------------------

		JPanel p_trangtri_ttct = new JPanel();
		p_trangtri_ttct.setLayout(new BorderLayout());
		JLabel ttct_left = new JLabel();
		ttct_left.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/ttct_l.png")));
		JLabel ttct_right = new JLabel();
		ttct_right.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/ttct_l.png")));
		JLabel ttct_top = new JLabel();
		ttct_top.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/ttct_top.png")));
		JLabel ttct_bottom = new JLabel();
		JPanel p_content = new JPanel();
		p_content.setLayout(new BorderLayout());
		JPanel content_center = new JPanel();
		content_center.setLayout(new GridLayout(5, 4));
		JLabel MaNV = new JLabel("Mã nhân viên", 0);
		tt_maNV = new JLabel();
		JLabel hoten = new JLabel("Họ và tên", 0);
		tt_hoten = new JLabel();
		JLabel NgaySinh = new JLabel("Ngày sinh", 0);
		tt_ngaysinh = new JLabel();
		JLabel GioiTinh = new JLabel("Giới tính", 0);
		tt_gioitinh = new JLabel();
		JLabel cccd = new JLabel("Căn cước công dân", 0);
		tt_cccd = new JLabel();
		JLabel diachi = new JLabel("Địa chỉ", 0);
		tt_diachi = new JLabel();
		JLabel sdt = new JLabel("Số điện thoại", 0);
		tt_sdt = new JLabel();
		JLabel email = new JLabel("Email", 0);
		tt_email = new JLabel();
		JLabel mapb = new JLabel("Mã phòng ban", 0);
		tt_mapb = new JLabel();
		JLabel macv = new JLabel("Mã chức vụ", 0);
		tt_macv = new JLabel();
		JPanel button_ttct = new JPanel();
		button_ttct.setLayout(new GridLayout(0, 9));
		JLabel e_ttct_1 = new JLabel();
		JLabel e_ttct_2 = new JLabel();
		JLabel e_ttct_3 = new JLabel();
		JLabel e_ttct_4 = new JLabel();
		JLabel e_ttct_5 = new JLabel();
		JLabel e_ttct_6 = new JLabel();
		JLabel e_ttct_7 = new JLabel();
		JLabel e_ttct_8 = new JLabel();
		b_thoat_ttct = new JButton();
		b_thoat_ttct.setBackground(Color.CYAN);
		b_thoat_ttct.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "luong");
			}

		});
		b_thoat_ttct.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_exit.png")));
		button_ttct.add(e_ttct_1);
		button_ttct.add(e_ttct_2);
		button_ttct.add(e_ttct_5);
		button_ttct.add(e_ttct_6);
		button_ttct.add(b_thoat_ttct);
		button_ttct.add(e_ttct_7);
		button_ttct.add(e_ttct_8);
		button_ttct.add(e_ttct_3);
		button_ttct.add(e_ttct_4);

		content_center.add(MaNV);
		content_center.add(tt_maNV);
		content_center.add(GioiTinh);
		content_center.add(tt_gioitinh);
		content_center.add(hoten);
		content_center.add(tt_hoten);
		content_center.add(cccd);
		content_center.add(tt_cccd);
		content_center.add(NgaySinh);
		content_center.add(tt_ngaysinh);
		content_center.add(diachi);
		content_center.add(tt_diachi);
		content_center.add(mapb);
		content_center.add(tt_mapb);
		content_center.add(sdt);
		content_center.add(tt_sdt);
		content_center.add(macv);
		content_center.add(tt_macv);
		content_center.add(email);
		content_center.add(tt_email);
		p_content.add(content_center, BorderLayout.CENTER);
		p_content.add(button_ttct, BorderLayout.SOUTH);
		ttct_bottom.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/ttct_bottom.png")));
		p_trangtri_ttct.add(ttct_left, BorderLayout.WEST);
		p_trangtri_ttct.add(ttct_right, BorderLayout.EAST);
		p_trangtri_ttct.add(p_content, BorderLayout.CENTER);
		p_trangtri_ttct.add(ttct_top, BorderLayout.NORTH);
		p_trangtri_ttct.add(ttct_bottom, BorderLayout.SOUTH);
		p_card.add(p_trangtri_ttct, "ttct");

		// ------------------------GIAO DIEN TANG CA-------------------------------
		JPanel p_all_tangCa = new JPanel();
		p_all_tangCa.setLayout(new BorderLayout());
		JPanel p_tangCa_top = new JPanel();
		p_tangCa_top.setLayout(new BorderLayout());
		p_tangCa_top.setBackground(Color.GREEN);
		Border tc = BorderFactory.createLineBorder(Color.RED);
		TitledBorder t_tc = BorderFactory.createTitledBorder(tc, "Thông tin tăng ca");
		p_tangCa_top.setBorder(t_tc);
		JPanel p_tangCa_cn = new JPanel();
		p_tangCa_cn.setLayout(new GridLayout(0, 9, 10, 10));
		JPanel p_tangCa_trai = new JPanel();
		p_tangCa_trai.setLayout(new GridLayout(1, 2, 10, 10));
		JPanel p_tangCa_center = new JPanel();
		p_tangCa_center.setLayout(new GridLayout(4, 4, 10, 10));
		JPanel p_table_tc = new JPanel();
		p_table_tc.setLayout(new BorderLayout());
		JLabel l_maTC = new JLabel("Mã tăng ca", 0);
		l_maNV = new JLabel("Mã nhân viên", 0);
		JLabel l_soGioTC = new JLabel("Số giờ tăng", 0);
		JLabel l_thoiGianBD = new JLabel("Thời gian bắt đầu", 0);
		JLabel l_thoiGianKT = new JLabel("Thời gian kết thúc", 0);
		JLabel tc1 = new JLabel();
		JLabel tc2 = new JLabel();
		JLabel tc3 = new JLabel();
		JLabel tc4 = new JLabel();
		JLabel tc5 = new JLabel();
		JLabel tc6 = new JLabel();
		JLabel tc7 = new JLabel();
		JLabel tc8 = new JLabel();
		JLabel tc9 = new JLabel();
		JLabel tc10 = new JLabel();
		ngayBatDauTC = new JDateChooser();
		ngayKetThucTC = new JDateChooser();
		ngayBatDauTC.setDateFormatString("dd/MM/yyyy");
		ngayKetThucTC.setDateFormatString("dd/MM/yyyy");

		t_maTC = new JTextField(50);
		t_maNV = new JComboBox();
		cn.LoadCBX(t_maNV, "Select * From NHANVIEN", 1);
		t_gioGioTC = new JTextField(24);
		t_thoiGianBD = new JTextField(50);
		t_thoiGianKT = new JTextField(50);

		b_hienthi_tc = new JButton("Hiển thị");
		b_hienthi_tc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.show_TangCa();
			}

		});
		b_hienthi_tc.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_eye.png")));

		b_hienthi_tc.setBackground(Color.CYAN);
		b_them_tc = new JButton("Thêm");
		b_them_tc.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_add.png")));

		b_them_tc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.Them_TangCa();

			}

		});
		b_them_tc.setBackground(Color.CYAN);
		b_capNhat_tc = new JButton("Cập Nhật");
		b_capNhat_tc.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_update.png")));

		b_capNhat_tc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.CapNhat_TangCa();
			}

		});
		b_capNhat_tc.setBackground(Color.CYAN);
		b_xoa_tc = new JButton("Xóa");
		b_xoa_tc.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_remove.png")));

		b_xoa_tc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.Xoa_DL_TangCa();
			}

		});
		b_xoa_tc.setBackground(Color.CYAN);
		b_thoat_tc = new JButton("Thoát");
		b_thoat_tc.setBackground(Color.CYAN);
		b_thoat_tc.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_exit.png")));

		b_thoat_tc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "3");
			}

		});

		p_tangCa_trai.add(tc5);
		p_tangCa_trai.add(tc6);

		p_tangCa_cn.add(tc1);
		p_tangCa_cn.add(tc2);
		p_tangCa_cn.add(b_hienthi_tc);
		p_tangCa_cn.add(b_them_tc);
		p_tangCa_cn.add(b_capNhat_tc);
		p_tangCa_cn.add(b_xoa_tc);
		p_tangCa_cn.add(b_thoat_tc);
		p_tangCa_cn.add(tc3);
		p_tangCa_cn.add(tc4);
		dm_tc = new DefaultTableModel();
		dm_tc.addColumn("Mã tăng ca");
		dm_tc.addColumn("Mã nhân viên");
		dm_tc.addColumn("Số giờ tăng ca");
		dm_tc.addColumn("Thời gian bắt đầu");
		dm_tc.addColumn("Thời gian kết thúc");

		table_tc = new JTable(dm_tc);
		table_tc.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table_tc.getSelectedRow();
				try {
					Date dateformatBD = new SimpleDateFormat("dd/MM/yyyy")
							.parse((String) table_tc.getValueAt(row, 3).toString());
					Date dateformatKT = new SimpleDateFormat("dd/MM/yyyy")
							.parse((String) table_tc.getValueAt(row, 4).toString());
					ngayBatDauTC.setDate(dateformatBD);
					ngayKetThucTC.setDate(dateformatKT);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				t_maTC.setText(table_tc.getValueAt(row, 0) + "");
				t_maNV.setSelectedItem(table_tc.getValueAt(row, 1) + "");
				t_gioGioTC.setText(table_tc.getValueAt(row, 2) + "");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		JScrollPane sc_tc = new JScrollPane(table_tc);
		p_table_tc.add(sc_tc, BorderLayout.CENTER);
		p_table_tc.add(p_tangCa_cn, BorderLayout.NORTH);

		p_tangCa_center.add(tc7);
		p_tangCa_center.add(tc5);
		p_tangCa_center.add(tc8);
		p_tangCa_center.add(tc6);
		p_tangCa_center.add(l_maTC);
		p_tangCa_center.add(t_maTC);
		p_tangCa_center.add(l_soGioTC);
		p_tangCa_center.add(t_gioGioTC);
		p_tangCa_center.add(l_maNV);
		p_tangCa_center.add(t_maNV);
		p_tangCa_center.add(l_thoiGianBD);
		p_tangCa_center.add(ngayBatDauTC);
		p_tangCa_center.add(tc9);
		p_tangCa_center.add(tc10);
		p_tangCa_center.add(l_thoiGianKT);
		p_tangCa_center.add(ngayKetThucTC);

		p_tangCa_top.add(p_tangCa_center, BorderLayout.CENTER);
		p_all_tangCa.add(p_tangCa_top, BorderLayout.NORTH);
		p_all_tangCa.add(p_table_tc, BorderLayout.CENTER);
		// --------------------GIAO DIỆN LƯƠNG-----------------------------------

		JPanel p_all_luong = new JPanel();
		p_all_luong.setLayout(new BorderLayout());
		JPanel p_luong_top = new JPanel();
		p_luong_top.setLayout(new BorderLayout());
		JPanel p_luong_center = new JPanel();
		p_luong_center.setLayout(new GridLayout(4, 4, 10, 10));
		JPanel p_luong_cn = new JPanel();
		p_luong_cn.setLayout(new GridLayout(0, 10));
		Border luong = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder t_luong = BorderFactory.createTitledBorder(luong, "Thông tin tăng ca");
		p_luong_top.setBorder(t_luong);
		p_luong_top.setBackground(Color.PINK);
		JLabel l_maLuong = new JLabel("Mã lương", 0);
		JLabel l_maNV_luong = new JLabel("Mã nhân viên", 0);
		JLabel luong_cb = new JLabel("Lương cơ bản", 0);
		JLabel thoiDiem_nhanLuong = new JLabel("Thời điểm nhận lương", 0);
		JLabel l_thuong = new JLabel("Loại thưởng", 0);
		JLabel l_ngayNhan = new JLabel("Ngày nhận thưởng", 0);
		JLabel l_phuCap = new JLabel("Loại phụ cấp", 0);
		JLabel l_ngayNhanpc = new JLabel("Ngày nhận phụ cấp", 0);
		JLabel ma_nhanThuong = new JLabel("Mã nhận thưởng", 0);
		JLabel ma_nhanPhuCap = new JLabel("Mã nhận phụ cấp", 0);
		JLabel l1 = new JLabel();
		JLabel l2 = new JLabel();
		JLabel l3 = new JLabel();
		JLabel l4 = new JLabel();

		ngayNhanLuong = new JDateChooser();
		datePhuCap = new JDateChooser();
		dateThuong = new JDateChooser();
		ngayNhanLuong.setDateFormatString("dd/MM/yyyy");
		datePhuCap.setDateFormatString("dd/MM/yyyy");
		dateThuong.setDateFormatString("dd/MM/yyyy");

		ma_luong = new JTextField(50);
		t_maNV_luong = new JComboBox();
		cn.LoadCBX(t_maNV_luong, "Select * From NHANVIEN", 1);
		luong_coBan = new JTextField(50);
		t_tdNhanLuong = new JTextField(50);
		t_thuong = new JComboBox();
		cn.LoadCBX(t_thuong, "Select * From THUONG", 2);
		t_ngayNhanThuong = new JTextField(50);
		t_pc = new JComboBox();
		cn.LoadCBX(t_pc, "Select * From PHUCAP", 2);
		t_ngayNhanpc = new JTextField(50);
		t_maNhanThuong = new JTextField(50);
		t_maNhanPhuCap = new JTextField(50);

		b_hienthi_luong = new JButton("Hiển thị");
		b_hienthi_luong.setBackground(Color.CYAN);
		b_hienthi_luong.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_eye.png")));
		b_hienthi_luong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.SHOW_LUONG();
			}

		});
		b_tinh_luong = new JButton("Tính lương");
		b_tinh_luong.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_cal.png")));
		b_tinh_luong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					cn.Them_DL_LUONG();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		b_tinh_luong.setBackground(Color.CYAN);
		b_capNhat_luong = new JButton("Cập nhật");
		b_capNhat_luong.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_update.png")));

		b_capNhat_luong.setBackground(Color.CYAN);
		b_capNhat_luong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					cn.CapNhat_DL_LUONG();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		b_xoa_luong = new JButton("Xóa");
		b_xoa_luong.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_remove.png")));
		b_xoa_luong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.Xoa_DL_LUONG();
			}

		});
		b_xoa_luong.setBackground(Color.CYAN);
		b_thoat_luong = new JButton("Thoát");
		b_thoat_luong.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_exit.png")));
		b_thoat_luong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "3");
			}

		});
		b_thoat_luong.setBackground(Color.CYAN);
		b_ttct_luong = new JButton("Chi tiết");
		b_ttct_luong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.ThongTinChiTiet();
				card.show(p_card, "ttct");
			}

		});
		b_ttct_luong.setBackground(Color.CYAN);
		b_thoat_luong.setBackground(Color.CYAN);

		p_luong_center.add(l_maLuong);
		p_luong_center.add(ma_luong);
		p_luong_center.add(l_thuong);
		p_luong_center.add(t_thuong);
		p_luong_center.add(l_maNV_luong);
		p_luong_center.add(t_maNV_luong);
		p_luong_center.add(l_ngayNhan);
		p_luong_center.add(dateThuong);
		p_luong_center.add(luong_cb);
		p_luong_center.add(luong_coBan);
		p_luong_center.add(l_phuCap);
		p_luong_center.add(t_pc);
		p_luong_center.add(thoiDiem_nhanLuong);
		p_luong_center.add(ngayNhanLuong);
		p_luong_center.add(l_ngayNhanpc);
		p_luong_center.add(datePhuCap);

		p_luong_cn.add(l1);
		p_luong_cn.add(l2);
		p_luong_cn.add(b_hienthi_luong);
		p_luong_cn.add(b_tinh_luong);
		p_luong_cn.add(b_capNhat_luong);
		p_luong_cn.add(b_xoa_luong);
		p_luong_cn.add(b_ttct_luong);
		p_luong_cn.add(b_thoat_luong);
		p_luong_cn.add(l3);
		p_luong_cn.add(l4);

		p_luong_top.add(p_luong_center, BorderLayout.CENTER);

		dm_luong = new DefaultTableModel();
		dm_luong.addColumn("Mã lương");
		dm_luong.addColumn("Mã nhân viên");
		dm_luong.addColumn("Thời điểm nhận lương");
		dm_luong.addColumn("Lương cơ bản");
		dm_luong.addColumn("Loại phụ cấp");
		dm_luong.addColumn("Ngày nhận phụ cấp");
		dm_luong.addColumn("Loại thưởng");
		dm_luong.addColumn("Ngày nhận thưởng");
		dm_luong.addColumn("Tổng lương");
		table_luong = new JTable(dm_luong);
		table_luong.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table_luong.getSelectedRow();

				try {
					Date dateformatLuong = new SimpleDateFormat("dd/MM/yyyy")
							.parse((String) table_luong.getValueAt(row, 2).toString());
					Date dateformatPC = new SimpleDateFormat("dd/MM/yyyy")
							.parse((String) table_luong.getValueAt(row, 5).toString());
					Date dateformatThuong = new SimpleDateFormat("dd/MM/yyyy")
							.parse((String) table_luong.getValueAt(row, 7).toString());
					ngayNhanLuong.setDate(dateformatLuong);
					datePhuCap.setDate(dateformatPC);
					dateThuong.setDate(dateformatThuong);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ma_luong.setText(table_luong.getValueAt(row, 0) + "");
				t_maNV_luong.setSelectedItem(table_luong.getValueAt(row, 1) + "");
				t_tdNhanLuong.setText(table_luong.getValueAt(row, 2) + "");
				luong_coBan.setText(table_luong.getValueAt(row, 3) + "");
				t_thuong.setSelectedItem(table_luong.getValueAt(row, 6) + "");
				t_ngayNhanThuong.setText(table_luong.getValueAt(row, 7) + "");
				t_pc.setSelectedItem(table_luong.getValueAt(row, 4) + "");
				t_ngayNhanpc.setText(table_luong.getValueAt(row, 5) + "");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		JScrollPane sc_luong = new JScrollPane(table_luong);
		JPanel p_table_luong = new JPanel();
		p_table_luong.setLayout(new BorderLayout());

		p_table_luong.add(p_luong_cn, BorderLayout.NORTH);
		p_table_luong.add(sc_luong, BorderLayout.CENTER);
		p_all_luong.add(p_luong_top, BorderLayout.NORTH);
		p_all_luong.add(p_table_luong, BorderLayout.CENTER);
		// --------------------------------QUẢN LÍ NGHỈ PHÉP----------------------------
		JPanel p_all_nghi_phep = new JPanel();
		p_all_nghi_phep.setLayout(new BorderLayout());
		Border nghiPhep = BorderFactory.createLineBorder(Color.RED);
		TitledBorder t_nghiphep = BorderFactory.createTitledBorder(nghiPhep, "Thông tin nghỉ phép");
		JPanel p_chua_nghi_phep_top = new JPanel();
		p_chua_nghi_phep_top.setLayout(new BorderLayout());
		JPanel p_nghi_phep_top = new JPanel();
		p_nghi_phep_top.setLayout(new GridLayout(4, 4, 10, 10));
		p_nghi_phep_top.setBorder(t_nghiphep);
		p_nghi_phep_top.setBackground(Color.GREEN);
		JPanel p_table_nghi_phep = new JPanel();
		p_table_nghi_phep.setLayout(new BorderLayout());

		JLabel MaNghiPhep = new JLabel("Mã nghỉ phép", 0);
		JLabel MaNhanVien = new JLabel("Mã nhân viên", 0);
		JLabel TenLoaiNghiPhep = new JLabel("Tên loại nghỉ phép", 0);
		JLabel SoGioNghi = new JLabel("Số giờ nghỉ hôm nay", 0);
		JLabel ThoiGianBDNghi = new JLabel("Thời gian bắt đầu", 0);
		JLabel ThoiGianKTNghi = new JLabel("Thời gian kết thúc", 0);
		JLabel ChuThich = new JLabel("Chú thích", 0);

		ngayBatDauNghiPhep = new JDateChooser();
		ngayKetThucNghiPhep = new JDateChooser();
		ngayBatDauNghiPhep.setDateFormatString("dd/MM/yyyy");
		ngayKetThucNghiPhep.setDateFormatString("dd/MM/yyyy");

		t_MaNghiPhep = new JTextField(50);
		t_MaNhanVien = new JComboBox();
		cn.LoadCBX(t_MaNhanVien, "SELECT * FROM NHANVIEN", 1);
		t_TenLoaiNghiPhep = new JTextField(50);
		t_SoGioNghi = new JTextField(50);
		t_BDnghi = new JTextField(50);
		t_KTnghi = new JTextField(50);
		t_chuThich_nghi = new JTextField();

		p_nghi_phep_top.add(MaNghiPhep);
		p_nghi_phep_top.add(t_MaNghiPhep);
		p_nghi_phep_top.add(MaNhanVien);
		p_nghi_phep_top.add(t_MaNhanVien);
		p_nghi_phep_top.add(TenLoaiNghiPhep);
		p_nghi_phep_top.add(t_TenLoaiNghiPhep);
		p_nghi_phep_top.add(SoGioNghi);
		p_nghi_phep_top.add(t_SoGioNghi);
		p_nghi_phep_top.add(ThoiGianBDNghi);
		p_nghi_phep_top.add(ngayBatDauNghiPhep);
		p_nghi_phep_top.add(ThoiGianKTNghi);
		p_nghi_phep_top.add(ngayKetThucNghiPhep);
		p_nghi_phep_top.add(ChuThich);
		p_nghi_phep_top.add(t_chuThich_nghi);

		JPanel button_nghi_phep = new JPanel();
		button_nghi_phep.setLayout(new GridLayout(0, 9, 10, 10));
		b_hienthi_nghiphep = new JButton("Hiển thị");
		b_hienthi_nghiphep.setBackground(Color.CYAN);
		b_hienthi_nghiphep.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_eye.png")));
		b_hienthi_nghiphep.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				cn.SHOW_NGHIPHEP();
			}

		});
		b_them_nghi_phep = new JButton("Thêm");
		b_them_nghi_phep.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_cal.png")));
		b_them_nghi_phep.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.Them_DL_nghiPhep();

			}

		});

		b_them_nghi_phep.setBackground(Color.CYAN);
		b_capNhat_nghi_phep = new JButton("Cập nhật");
		b_capNhat_nghi_phep.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_update.png")));

		b_capNhat_nghi_phep.setBackground(Color.CYAN);
		b_capNhat_nghi_phep.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.CapNhat_DL_nghiPhep();
			}

		});
		b_xoa_nghi_phep = new JButton("Xóa");
		b_xoa_nghi_phep.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_remove.png")));
		b_xoa_nghi_phep.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.Xoa_DL_nghiPhep();
			}

		});
		b_xoa_nghi_phep.setBackground(Color.CYAN);
		b_thoat_nghi_phep = new JButton("Thoát");
		b_thoat_nghi_phep.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_exit.png")));
		b_thoat_nghi_phep.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "3");
			}

		});
		b_thoat_nghi_phep.setBackground(Color.CYAN);
		JLabel n = new JLabel();
		JLabel n1 = new JLabel();
		JLabel n2 = new JLabel();
		JLabel n3 = new JLabel();

		button_nghi_phep.add(n);
		button_nghi_phep.add(n1);
		button_nghi_phep.add(b_hienthi_nghiphep);
		button_nghi_phep.add(b_them_nghi_phep);
		button_nghi_phep.add(b_capNhat_nghi_phep);
		button_nghi_phep.add(b_xoa_nghi_phep);
		button_nghi_phep.add(b_thoat_nghi_phep);
		button_nghi_phep.add(n2);
		button_nghi_phep.add(n3);

		dm_nghi_phep = new DefaultTableModel();
		dm_nghi_phep.addColumn("Mã nghỉ phép");
		dm_nghi_phep.addColumn("Mã nhân viên");
		dm_nghi_phep.addColumn("Tên loại nghỉ phép");
		dm_nghi_phep.addColumn("Số giờ nghỉ");
		dm_nghi_phep.addColumn("Thời gian bắt đầu nghỉ");
		dm_nghi_phep.addColumn("Thời gian kết thúc nghỉ");
		dm_nghi_phep.addColumn("Chú thích");
		table_nghi_phep = new JTable(dm_nghi_phep);
		table_nghi_phep.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table_nghi_phep.getSelectedRow();
				try {
					Date dateformatBD = new SimpleDateFormat("dd/MM/yyyy")
							.parse((String) table_nghi_phep.getValueAt(row, 4).toString());
					Date dateformatKT = new SimpleDateFormat("dd/MM/yyyy")
							.parse((String) table_nghi_phep.getValueAt(row, 5).toString());
					ngayBatDauNghiPhep.setDate(dateformatBD);
					ngayKetThucNghiPhep.setDate(dateformatKT);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				t_MaNghiPhep.setText(table_nghi_phep.getValueAt(row, 0) + "");
				t_MaNhanVien.setSelectedItem(table_nghi_phep.getValueAt(row, 1) + "");
				t_TenLoaiNghiPhep.setText(table_nghi_phep.getValueAt(row, 2) + "");
				t_SoGioNghi.setText(table_nghi_phep.getValueAt(row, 3) + "");
				t_chuThich_nghi.setText(table_nghi_phep.getValueAt(row, 6) + "");

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		JScrollPane sc_nghi_phep = new JScrollPane(table_nghi_phep);
		JLabel nghiphep_left = new JLabel();
		nghiphep_left.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/2.png")));

		JLabel nghiphep_right = new JLabel();
		nghiphep_right.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/2.png")));

		JLabel nghiphep_top = new JLabel();
		nghiphep_top.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/1.png")));

		JLabel nghiphep_bottom = new JLabel();
		nghiphep_bottom.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/1.png")));

		p_table_nghi_phep.add(sc_nghi_phep, BorderLayout.CENTER);
		p_chua_nghi_phep_top.add(p_nghi_phep_top, BorderLayout.CENTER);
		p_chua_nghi_phep_top.add(button_nghi_phep, BorderLayout.SOUTH);
		p_all_nghi_phep.add(p_chua_nghi_phep_top, BorderLayout.NORTH);
		p_all_nghi_phep.add(p_table_nghi_phep, BorderLayout.CENTER);

		// -------------------------------QUẢN LÍ THƯỞNG-------------------------------
		JPanel p_all_bonus = new JPanel();
		p_all_bonus.setLayout(new BorderLayout());
		JLabel bonus_left = new JLabel();
		bonus_left.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/bonus.png")));
		JLabel bonus_right = new JLabel();
		bonus_right.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/bunus_1.png")));
		JLabel bonus_bottom = new JLabel();
		bonus_bottom.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/bonus_bottom.png")));
		JPanel p_bonus_center = new JPanel();
		p_bonus_center.setLayout(new BorderLayout());
		Border thuong = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder t_thuong = BorderFactory.createTitledBorder(thuong, "Thông tin thưởng");
		JPanel p_bonus_center_top = new JPanel();
		p_bonus_center_top.setLayout(new GridLayout(3, 2, 10, 10));
		p_bonus_center_top.setBorder(t_thuong);
		p_bonus_center_top.setBackground(Color.PINK);
		JLabel l_ma_tien_thuong = new JLabel("Mã loại thưởng", 0);
		JLabel l_ten_loai_thuong = new JLabel("Tên loại thưởng", 0);
		JLabel l_soTien_thuong = new JLabel("Số tiền thưởng", 0);

		t_mThuong = new JTextField(10);
		t_tThuong = new JTextField(50);
		t_sThuong = new JTextField(12);

		b_hienThi_thuong = new JButton("Hiển thị");
		b_hienThi_thuong.setBackground(Color.CYAN);
		b_hienThi_thuong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.HienThi_DL_Thuong();
			}

		});
		b_hienThi_thuong.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_eye.png")));
		b_them_thuong = new JButton("Thêm");
		b_them_thuong.setBackground(Color.CYAN);
		b_them_thuong.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_add.png")));
		b_them_thuong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.Them_DL_Thuong();
			}

		});
		b_capNhat_thuong = new JButton("Cập nhật");
		b_capNhat_thuong.setBackground(Color.CYAN);
		b_capNhat_thuong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.CapNhat_DL_Thuong();
			}

		});
		b_capNhat_thuong.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_update.png")));
		b_xoa_thuong = new JButton("Xóa");
		b_xoa_thuong.setBackground(Color.CYAN);
		b_xoa_thuong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.Xoa_DL_Thuong();
			}

		});
		b_xoa_thuong.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_remove.png")));
		b_thoat_thuong = new JButton("Thoát");
		b_thoat_thuong.setBackground(Color.CYAN);
		b_thoat_thuong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "3");
			}

		});
		b_thoat_thuong.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_exit.png")));

		JPanel p_button_thuong = new JPanel();
		p_button_thuong.setLayout(new GridLayout(0, 5));
		p_button_thuong.add(b_hienThi_thuong);
		p_button_thuong.add(b_them_thuong);
		p_button_thuong.add(b_capNhat_thuong);
		p_button_thuong.add(b_xoa_thuong);
		p_button_thuong.add(b_thoat_thuong);

		p_bonus_center_top.add(l_ma_tien_thuong);
		p_bonus_center_top.add(t_mThuong);
		p_bonus_center_top.add(l_ten_loai_thuong);
		p_bonus_center_top.add(t_tThuong);
		p_bonus_center_top.add(l_soTien_thuong);
		p_bonus_center_top.add(t_sThuong);

		dm_thuong = new DefaultTableModel();
		dm_thuong.addColumn("Mã loại thưởng");
		dm_thuong.addColumn("Tên loại thưởng");
		dm_thuong.addColumn("Số tiền thưởng");

		table_thuong = new JTable(dm_thuong);
		table_thuong.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table_thuong.getSelectedRow();
				t_mThuong.setText(table_thuong.getValueAt(row, 0) + "");
				t_tThuong.setText(table_thuong.getValueAt(row, 1) + "");
				t_sThuong.setText(table_thuong.getValueAt(row, 2) + "");

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		JPanel p_table_thuong = new JPanel();
		p_table_thuong.setLayout(new BorderLayout());
		JScrollPane sc_thuong = new JScrollPane(table_thuong);
		p_table_thuong.add(sc_thuong, BorderLayout.CENTER);
		p_table_thuong.add(p_button_thuong, BorderLayout.NORTH);
		p_bonus_center.add(p_table_thuong, BorderLayout.CENTER);
		p_bonus_center.add(p_bonus_center_top, BorderLayout.NORTH);
		p_bonus_center.add(bonus_bottom, BorderLayout.SOUTH);
		p_all_bonus.add(p_bonus_center, BorderLayout.CENTER);
		p_all_bonus.add(bonus_left, BorderLayout.WEST);
		p_all_bonus.add(bonus_right, BorderLayout.EAST);
		// -------------------------------QUẢN LÍ CHỨC
		// VỤ--------------------------------
		JPanel p_all_cv = new JPanel();
		p_all_cv.setLayout(new BorderLayout());
		JLabel cv_left = new JLabel();
		cv_left.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/cv_left.png")));
		JLabel cv_right = new JLabel();
		cv_right.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/cv_right.png")));
		JLabel cv_bottom = new JLabel();
		cv_bottom.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/cv_bottom.png")));
		JPanel p_cv_center = new JPanel();
		p_cv_center.setLayout(new BorderLayout());
		Border chucvu = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder t_chucvu = BorderFactory.createTitledBorder(chucvu, "Thông tin chức vụ");
		JPanel p_cv_center_top = new JPanel();
		p_cv_center_top.setLayout(new GridLayout(3, 2, 10, 10));
		p_cv_center_top.setBorder(t_chucvu);
		p_cv_center_top.setBackground(Color.YELLOW);
		JLabel maChucVu = new JLabel("Mã chức vụ", 0);
		JLabel tenChucVu = new JLabel("Tên chức vụ", 0);
		JLabel tienChucVu = new JLabel("Hệ số chức vụ", 0);

		t_maCV = new JTextField(10);
		t_tenCV = new JTextField(50);
		t_tienCV = new JTextField(12);

		b_hienthi_chucvu = new JButton("Hiển thị");
		b_hienthi_chucvu.setBackground(Color.CYAN);
		b_hienthi_chucvu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.HienThi_DL_CHUCVU();
			}

		});
		b_hienthi_chucvu.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_eye.png")));
		b_them_cv = new JButton("Thêm");
		b_them_cv.setBackground(Color.CYAN);
		b_them_cv.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_add.png")));
		b_them_cv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.Them_DL_CHUCVU();
			}

		});
		b_capNhat_cv = new JButton("Cập nhật");
		b_capNhat_cv.setBackground(Color.CYAN);
		b_capNhat_cv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.CapNhat_DL_CHUCVU();
			}

		});
		b_capNhat_cv.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_update.png")));
		b_xoa_cv = new JButton("Xóa");
		b_xoa_cv.setBackground(Color.CYAN);
		b_xoa_cv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.Xoa_DL_CHUCVU();
			}

		});
		b_xoa_cv.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_remove.png")));
		b_thoat_cv = new JButton("Thoát");
		b_thoat_cv.setBackground(Color.CYAN);
		b_thoat_cv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "3");
			}

		});
		b_thoat_cv.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_exit.png")));

		JPanel p_button_chucvu = new JPanel();
		p_button_chucvu.setLayout(new GridLayout(0, 5));
		p_button_chucvu.add(b_hienthi_chucvu);
		p_button_chucvu.add(b_them_cv);
		p_button_chucvu.add(b_capNhat_cv);
		p_button_chucvu.add(b_xoa_cv);
		p_button_chucvu.add(b_thoat_cv);

		p_cv_center_top.add(maChucVu);
		p_cv_center_top.add(t_maCV);
		p_cv_center_top.add(tenChucVu);
		p_cv_center_top.add(t_tenCV);
		p_cv_center_top.add(tienChucVu);
		p_cv_center_top.add(t_tienCV);

		dm_cv = new DefaultTableModel();
		dm_cv.addColumn("Mã chức vụ");
		dm_cv.addColumn("Tên chức vụ");
		dm_cv.addColumn("Hệ số phụ cấp chức vụ");

		table_chucvu = new JTable(dm_cv);
		table_chucvu.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table_chucvu.getSelectedRow();
				t_maCV.setText(table_chucvu.getValueAt(row, 0) + "");
				t_tenCV.setText(table_chucvu.getValueAt(row, 1) + "");
				t_tienCV.setText(table_chucvu.getValueAt(row, 2) + "");

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		JPanel p_table_chucvu = new JPanel();
		p_table_chucvu.setLayout(new BorderLayout());
		JScrollPane sc_chucvu = new JScrollPane(table_chucvu);
		p_table_chucvu.add(sc_chucvu, BorderLayout.CENTER);
		p_table_chucvu.add(p_button_chucvu, BorderLayout.NORTH);
		p_cv_center.add(p_table_chucvu, BorderLayout.CENTER);
		p_cv_center.add(p_cv_center_top, BorderLayout.NORTH);
		p_cv_center.add(cv_bottom, BorderLayout.SOUTH);
		p_all_cv.add(p_cv_center, BorderLayout.CENTER);
		p_all_cv.add(cv_left, BorderLayout.WEST);
		p_all_cv.add(cv_right, BorderLayout.EAST);
		// ------------------------------QUẢN LÍ PHỤ CÂP--------------------------------
		JPanel p_all_phucap = new JPanel();
		p_all_phucap.setLayout(new BorderLayout());
		JPanel p_chua_phuCap = new JPanel();
		p_chua_phuCap.setLayout(new BorderLayout());
		JLabel phuCap_left = new JLabel();
		phuCap_left.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/phu_cap.png")));
		JLabel phuCap_right = new JLabel();
		phuCap_right.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/phu_cap_1.png")));
		JLabel phuCap_top = new JLabel();
		phuCap_top.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/phucap_top.png")));
		JLabel phuCap_bottom = new JLabel();
		phuCap_bottom.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/phucap_top.png")));
		JPanel p_phuCap_center = new JPanel();
		p_phuCap_center.setLayout(new BorderLayout());
		Border phuCap = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder t_phuCap = BorderFactory.createTitledBorder(phuCap, "Thông tin phụ cấp");
		JPanel p_phuCap_center_top = new JPanel();
		p_phuCap_center_top.setLayout(new GridLayout(3, 2));
		p_phuCap_center_top.setBorder(t_phuCap);
		p_phuCap_center_top.setBackground(Color.PINK);
		JLabel l_maPhuCap = new JLabel("Mã phụ cấp", 0);
		JLabel l_tenPhuCap = new JLabel("Tên phụ cấp", 0);
		JLabel l_soTien_phuCap = new JLabel("Số tiền phụ cấp", 0);
		t_maPhuCap = new JTextField(10);
		t_tenPhuCap = new JTextField(50);
		t_tienPhuCap = new JTextField(12);

		b_hienThi_phuCap = new JButton("Hiển thị");
		b_hienThi_phuCap.setBackground(Color.CYAN);
		b_hienThi_phuCap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.HienThi_DL_PhuCap();
			}

		});
		b_hienThi_phuCap.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_eye.png")));
		b_them_phuCap = new JButton("Thêm");
		b_them_phuCap.setBackground(Color.CYAN);
		b_them_phuCap.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_add.png")));
		b_them_phuCap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.Them_DL_PhuCap();
			}

		});
		b_capNhat_phuCap = new JButton("Cập nhật");
		b_capNhat_phuCap.setBackground(Color.CYAN);
		b_capNhat_phuCap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.CapNhat_DL_PhuCap();
			}

		});
		b_capNhat_phuCap.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_update.png")));
		b_xoa_phuCap = new JButton("Xóa");
		b_xoa_phuCap.setBackground(Color.CYAN);
		b_xoa_phuCap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.Xoa_DL_PhuCap();
			}

		});
		b_xoa_phuCap.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_remove.png")));
		b_thoat_phuCap = new JButton("Thoát");
		b_thoat_phuCap.setBackground(Color.CYAN);
		b_thoat_phuCap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "3");
			}

		});
		b_thoat_phuCap.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_exit.png")));
		p_phuCap_center_top.add(l_maPhuCap);
		p_phuCap_center_top.add(t_maPhuCap);
		p_phuCap_center_top.add(l_tenPhuCap);
		p_phuCap_center_top.add(t_tenPhuCap);
		p_phuCap_center_top.add(l_soTien_phuCap);
		p_phuCap_center_top.add(t_tienPhuCap);

		dm_phuCap = new DefaultTableModel();
		dm_phuCap.addColumn("Mã phụ cấp");
		dm_phuCap.addColumn("Tên phụ cấp");
		dm_phuCap.addColumn("Số tiền phụ cấp");

		table_phuCap = new JTable(dm_phuCap);
		table_phuCap.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table_phuCap.getSelectedRow();
				t_maPhuCap.setText(table_phuCap.getValueAt(row, 0) + "");
				t_tenPhuCap.setText(table_phuCap.getValueAt(row, 1) + "");
				t_tienPhuCap.setText(table_phuCap.getValueAt(row, 2) + "");

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		JPanel p_button_phuCap = new JPanel();
		p_button_phuCap.setLayout(new GridLayout(0, 5));
		p_button_phuCap.add(b_hienThi_phuCap);
		p_button_phuCap.add(b_them_phuCap);
		p_button_phuCap.add(b_capNhat_phuCap);
		p_button_phuCap.add(b_xoa_phuCap);
		p_button_phuCap.add(b_thoat_phuCap);
		JPanel p_table_phuCap = new JPanel();
		p_table_phuCap.setLayout(new BorderLayout());
		JScrollPane sc_phuCap = new JScrollPane(table_phuCap);

		p_table_phuCap.add(p_button_phuCap, BorderLayout.NORTH);
		p_table_phuCap.add(sc_phuCap, BorderLayout.CENTER);
		p_phuCap_center.add(p_table_phuCap, BorderLayout.CENTER);
		p_phuCap_center.add(p_phuCap_center_top, BorderLayout.NORTH);
		p_phuCap_center.add(phuCap_bottom, BorderLayout.SOUTH);
		p_chua_phuCap.add(phuCap_top, BorderLayout.NORTH);
		p_chua_phuCap.add(p_phuCap_center, BorderLayout.CENTER);
		p_all_phucap.add(p_chua_phuCap, BorderLayout.CENTER);
		p_all_phucap.add(phuCap_left, BorderLayout.WEST);
		p_all_phucap.add(phuCap_right, BorderLayout.EAST);
		// -----------------------------------------------------------------------------
		JPanel p_chuc_nang = new JPanel();
		p_chuc_nang.setLayout(new GridLayout(6, 0, 10, 10));
		JLabel j_chuc_nang = new JLabel("Chức năng", 0);
		j_chuc_nang.setBackground(Color.BLACK);
		j_chuc_nang.setForeground(Color.WHITE);
		j_chuc_nang.setOpaque(true);
		l_add_ql = new JButton("Hiển thị");
		l_add_ql.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_eye.png")));
		l_add_nv = new JButton("Thêm nhân viên");
		l_add_ql.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_add.png")));
		l_add_ql.setBackground(Color.CYAN);
		l_add_nv.setBackground(Color.CYAN);

		l_add_ql.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.showNHANVIEN();
			}

		});

		l_add_nv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.them_DL_chinh_NhanVien();
			}
		});
		l_update = new JButton("Cập nhật");
		l_update.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_update.png")));
		l_update.setBackground(Color.CYAN);
		l_remove = new JButton("Xóa");
		l_remove.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_remove.png")));
		l_remove.setBackground(Color.CYAN);
		l_remove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.Xoa_DL_chinh_NhanVien();
			}

		});
		l_update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.CapNhat_DL_chinh_NhanVien();
			}

		});
		l_sort = new JButton("Sắp xếp");
		l_sort.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_sort.png")));
		l_sort.setBackground(Color.CYAN);
		l_sort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String input = JOptionPane.showInputDialog(null, "Bạn muốn chọn sắp xếp theo?");
				if (input.equals("Tên")) {
					cn.SapXep_theoTen();
				}
			}

		});
		l_search = new JButton("Tìm kiếm");
		l_search.setBackground(Color.CYAN);
		l_search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card_ttnv.show(p_tt_khac, "tknv");

			}

		});
		l_search.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_search.png")));

		p_chuc_nang.add(j_chuc_nang);
		p_chuc_nang.add(l_add_ql);
		p_chuc_nang.add(l_add_nv);
		p_chuc_nang.add(l_update);
		p_chuc_nang.add(l_remove);
		p_chuc_nang.add(l_search);
		// ----------------------------------------------------------------------------

		p_main.add(p_chon, BorderLayout.WEST);
		p_main.add(p_thong_tin, BorderLayout.CENTER);
		p_main.add(p_chuc_nang, BorderLayout.EAST);

		// -----------------------------HIỂN THỊ NHÂN
		// VIÊN-------------------------------
		JPanel p_table = new JPanel();
		p_table.setLayout(new BorderLayout());
		Border btable = BorderFactory.createLineBorder(Color.RED);
		TitledBorder t_table = BorderFactory.createTitledBorder(btable, "Danh sách nhân sự");
		dm = new DefaultTableModel();
		dm.addColumn("Mã Nhân Viên");
		dm.addColumn("Họ và tên");
		dm.addColumn("Ngày Sinh");
		dm.addColumn("Giới Tính");
		dm.addColumn("CCCD/CMND");
		dm.addColumn("Địa chỉ");
		dm.addColumn("Số điện thoại");
		dm.addColumn("Email");
		dm.addColumn("Mã chức vụ");
		dm.addColumn("Mã phòng ban");
		jt = new JTable(dm);
		jt.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = jt.getSelectedRow();
				try {
					Date dateformat = new SimpleDateFormat("dd/MM/yyyy").parse(jt.getValueAt(row, 2).toString());
					date.setDate(dateformat);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				card_ttnv.show(p_tt_khac, "ttnv");
				t_maNV_nv.setText(jt.getValueAt(row, 0) + "");
				t_hovaTen.setText(jt.getValueAt(row, 1) + "");
//				t_ngaySinh.setText(jt.getValueAt(row, 2) + "");
				t_gioiTinh.setSelectedItem(jt.getValueAt(row, 3));
				t_CCCD.setText(jt.getValueAt(row, 4) + "");
				t_address_nv.setText(jt.getValueAt(row, 5) + "");
				t_phone_nv.setText(jt.getValueAt(row, 6) + "");
				t_email.setText(jt.getValueAt(row, 7) + "");
				t_cv.setSelectedItem(jt.getValueAt(row, 8));
				t_pb.setSelectedItem(jt.getValueAt(row, 9));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		JScrollPane sp = new JScrollPane(jt);

		p_table.add(sp, BorderLayout.CENTER);
		p_table.setBorder(t_table);
		// ------------------------------QUẢN LÍ TÀI
		// KHOẢN-------------------------------

		JPanel p_all_taikhoan = new JPanel();
		p_all_taikhoan.setLayout(new BorderLayout());
//		p_all_taikhoan.setBackground(Color.BLACK);
		JPanel p_chua_center_taikhoan = new JPanel();
		p_chua_center_taikhoan.setLayout(new BorderLayout());
		JPanel p_center_taikhoan = new JPanel();
		p_center_taikhoan.setLayout(new BorderLayout());
		JPanel p_center_label = new JPanel();
		p_center_label.setBackground(Color.WHITE);
		p_center_label.setLayout(new GridLayout(6, 2, 10, 10));

		JLabel HoTen = new JLabel("Họ và tên:", 0);
		JLabel LienHe = new JLabel("Liên Hệ:", 0);
		JLabel e = new JLabel();
		JLabel e1 = new JLabel();
		JLabel e2 = new JLabel();
		JLabel e4 = new JLabel();
		JLabel e5 = new JLabel();
		JLabel e6 = new JLabel();
		JLabel e7 = new JLabel();
		JLabel e8 = new JLabel();

		for (QuanLiTaiKhoan tk : list) {
			name = tk.getHoTen();
			lienHe = tk.getEmail();
			TenDangNhap = tk.getTenDangNhap();
			MatKhau = tk.getMatKhau();
		}

		l_hoTen = new JLabel(name);
		l_lienhe = new JLabel(lienHe);

		JLabel left = new JLabel();
		left.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_l.png")));
		JLabel right = new JLabel();
		right.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_r.png")));
		JLabel top_1 = new JLabel();
		top_1.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_b.png")));
		JLabel bottom_1 = new JLabel();
		bottom_1.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_b.png")));

		JLabel left_2 = new JLabel();
		JLabel right_2 = new JLabel();
		JLabel top_2 = new JLabel();
		top_2.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/ac_top.png")));
		JLabel bottom_2 = new JLabel();

		button_doiMK = new JButton("Đổi mật khẩu");
		button_doiMK.setBackground(Color.PINK);
		button_doiMK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.DoiMK();
			}

		});
		button_edit = new JButton("Chỉnh sửa");
		button_edit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "chinhsua");
			}

		});
		button_edit.setBackground(Color.PINK);
		button_thoat = new JButton("Trở về");
		button_thoat.setBackground(Color.PINK);
		button_thoat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "3");
			}

		});
		JPanel button = new JPanel();
		button.setLayout(new GridLayout(0, 3));

		button.add(button_edit);
		button.add(button_doiMK);
		button.add(button_thoat);
		p_center_label.add(e4);
		p_center_label.add(e6);
		p_center_label.add(e);
		p_center_label.add(e2);
		p_center_label.add(HoTen);
		p_center_label.add(l_hoTen);
		p_center_label.add(LienHe);
		p_center_label.add(l_lienhe);
		p_center_label.add(e1);
		p_center_label.add(e5);
		p_center_label.add(e7);
		p_center_label.add(e8);
		p_center_taikhoan.add(p_center_label, BorderLayout.CENTER);
		p_center_taikhoan.add(button, BorderLayout.SOUTH);

		p_chua_center_taikhoan.add(p_center_taikhoan, BorderLayout.CENTER);
		p_chua_center_taikhoan.add(top_2, BorderLayout.NORTH);
		p_chua_center_taikhoan.add(bottom_2, BorderLayout.SOUTH);
		p_chua_center_taikhoan.add(left_2, BorderLayout.WEST);
		p_chua_center_taikhoan.add(right_2, BorderLayout.EAST);
		p_all_taikhoan.add(top_1, BorderLayout.NORTH);
		p_all_taikhoan.add(bottom_1, BorderLayout.SOUTH);

		p_all_taikhoan.add(left, BorderLayout.WEST);
		p_all_taikhoan.add(right, BorderLayout.EAST);
		p_all_taikhoan.add(p_chua_center_taikhoan, BorderLayout.CENTER);
		// ------------------------------------------------------------------------------

		JPanel p_all_taikhoan_chinhsua = new JPanel();
		p_all_taikhoan_chinhsua.setLayout(new BorderLayout());
		JPanel p_chua_center_taikhoan_chinhsua = new JPanel();
		p_chua_center_taikhoan_chinhsua.setLayout(new BorderLayout());
		JPanel p_center_taikhoan_chinhsua = new JPanel();
		p_center_taikhoan_chinhsua.setLayout(new BorderLayout());
		JPanel p_center_label_chinhsua = new JPanel();
		p_center_label_chinhsua.setBackground(Color.WHITE);
		p_center_label_chinhsua.setLayout(new GridLayout(6, 2, 10, 10));

		JLabel HoTen_chinhsua = new JLabel("Họ và tên:", 0);
		JLabel LienHe_chinhsua = new JLabel("Liên Hệ:", 0);
		JLabel l = new JLabel();
		JLabel t1 = new JLabel();
		JLabel t2 = new JLabel();
		JLabel t4 = new JLabel();
		JLabel t5 = new JLabel();
		JLabel t6 = new JLabel();
		JLabel t7 = new JLabel();
		JLabel t8 = new JLabel();

		t_hoTen = new JTextField(50);
		t_lienhe = new JTextField(50);
		t_hoTen.setText(name);
		t_lienhe.setText(lienHe);

		JLabel left_3 = new JLabel();
		left_3.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_l.png")));
		JLabel right_3 = new JLabel();
		right_3.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_r.png")));
		JLabel top_3 = new JLabel();
		top_3.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_b.png")));
		JLabel bottom_3 = new JLabel();
		bottom_3.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_b.png")));

		JLabel left_4 = new JLabel();
		JLabel right_4 = new JLabel();
		JLabel top_4 = new JLabel();
		top_4.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/ac_top.png")));
		JLabel bottom_4 = new JLabel();

		button_save_chinhsua = new JButton("Lưu thay đổi");
		button_save_chinhsua.setBackground(Color.PINK);
		button_save_chinhsua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.CapNhat_TaiKhoan();
			}

		});
		button_thoat_chinhsua = new JButton("Trở về");
		button_thoat_chinhsua.setBackground(Color.PINK);
		button_thoat_chinhsua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "qltk");
			}

		});

		JPanel button_chinhsua = new JPanel();
		button_chinhsua.setLayout(new GridLayout(0, 2, 10, 10));

		button_chinhsua.add(button_save_chinhsua);
		button_chinhsua.add(button_thoat_chinhsua);
		p_center_label_chinhsua.add(t1);
		p_center_label_chinhsua.add(t6);
		p_center_label_chinhsua.add(t2);
		p_center_label_chinhsua.add(t4);
		p_center_label_chinhsua.add(HoTen_chinhsua);
		p_center_label_chinhsua.add(t_hoTen);
		p_center_label_chinhsua.add(LienHe_chinhsua);
		p_center_label_chinhsua.add(t_lienhe);
		p_center_label_chinhsua.add(l);
		p_center_label_chinhsua.add(t5);
		p_center_label_chinhsua.add(t7);
		p_center_label_chinhsua.add(t8);
		p_center_taikhoan_chinhsua.add(p_center_label_chinhsua, BorderLayout.CENTER);
		p_center_taikhoan_chinhsua.add(button_chinhsua, BorderLayout.SOUTH);

		p_chua_center_taikhoan_chinhsua.add(p_center_taikhoan_chinhsua, BorderLayout.CENTER);
		p_chua_center_taikhoan_chinhsua.add(top_4, BorderLayout.NORTH);

		p_all_taikhoan_chinhsua.add(top_3, BorderLayout.NORTH);
		p_all_taikhoan_chinhsua.add(bottom_3, BorderLayout.SOUTH);

		p_all_taikhoan_chinhsua.add(left_3, BorderLayout.WEST);
		p_all_taikhoan_chinhsua.add(right_3, BorderLayout.EAST);
		p_all_taikhoan_chinhsua.add(p_chua_center_taikhoan_chinhsua, BorderLayout.CENTER);
		// --------------------------------THỐNG KÊ NHÂN
		// VIÊN-------------------------------
		JPanel p_all_tk_nv = new JPanel();
		p_all_tk_nv.setLayout(new BorderLayout());
		p_all_tk_nv.setBackground(Color.WHITE);
		JLabel thongKe_top = new JLabel();
		thongKe_top.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_top.png")));
		JLabel thongKe_bottom = new JLabel();
		thongKe_bottom.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_bottom.png")));
		JLabel thongKe_left = new JLabel();
		thongKe_left.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JLabel thongKe_right = new JLabel();
		thongKe_right.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JPanel p_content_thongKe = new JPanel();
		p_content_thongKe.setBackground(Color.WHITE);
		p_content_thongKe.setLayout(new GridLayout(5, 6));
		JPanel p_chua_content_thongKe = new JPanel();
		p_chua_content_thongKe.setLayout(new BorderLayout());
		p_chua_content_thongKe.setBackground(Color.WHITE);
		JPanel p_chua_button_thongKe = new JPanel();
		p_chua_button_thongKe.setLayout(new GridLayout(2, 0));
		p_chua_button_thongKe.setBackground(Color.WHITE);
		JLabel space = new JLabel();
		JPanel p_button_thongKe = new JPanel();
		p_button_thongKe.setLayout(new GridLayout(0, 6));
		p_button_thongKe.setBackground(Color.WHITE);
		b_reset = new JButton("Đặt lại");
		b_reset.setBackground(Color.CYAN);
		b_reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.ThongKeNhanVien();
			}

		});
		b_thoat_tk = new JButton("Thoát");
		b_thoat_tk.setBackground(Color.CYAN);
		b_thoat_tk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "3");
			}

		});
		b_thoat_tk.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_exit.png")));
		JLabel b_emty = new JLabel();
		JLabel b_emty1 = new JLabel();
		JLabel b_emty2 = new JLabel();
		JLabel b_emty3 = new JLabel();
		p_button_thongKe.add(b_emty);
		p_button_thongKe.add(b_emty1);
		p_button_thongKe.add(b_reset);
		p_button_thongKe.add(b_thoat_tk);
		p_button_thongKe.add(b_emty2);
		p_button_thongKe.add(b_emty3);
		p_chua_button_thongKe.add(space);
		p_chua_button_thongKe.add(p_button_thongKe);
		JLabel tongSoNV = new JLabel("Tổng số nhân sự: ", 0);
		r_tongSoNV = new JLabel();
		JLabel soLuongQL = new JLabel("Số lượng quản lí: ", 0);
		r_soLuongQL = new JLabel();
		JLabel soLuongNV = new JLabel("Số lượng nhân viên: ", 0);
		r_soLuongNV = new JLabel();
		JLabel soNVNam = new JLabel("Số lượng nhân viên nam: ", 0);
		r_soNVNam = new JLabel();
		JLabel soNVNu = new JLabel("Số lượng nhân viên nữ: ", 0);
		r_soNVNu = new JLabel();
		JLabel soNVKh = new JLabel("Số lượng nhân viên khác: ", 0);
		r_soNVKhac = new JLabel();
		JLabel soLuongNVpb = new JLabel("Số lượng nhân viên ở ", 0);
		r_soLuongNVpb = new JLabel("", 0);
		phongBan = new JComboBox();
		cn.LoadCBX(phongBan, "SELECT * FROM PHONGBAN", 1);
		JLabel doTuoiLonNhat = new JLabel("Độ tuổi lớn nhất: ", 0);
		r_doTuoiLonNhat = new JLabel();
		JLabel doTuoiBeNhat = new JLabel("Độ tuổi bé nhất: ", 0);
		r_doTuoiBeNhat = new JLabel();
		JLabel doTuoiTrungBinh = new JLabel("Độ tuổi trung bình: ", 0);
		r_doTuoiTrungBinh = new JLabel();

		JLabel tk_emty1 = new JLabel();
		JLabel tk_emty2 = new JLabel();
		JLabel tk_emty3 = new JLabel();
		JLabel tk_emty4 = new JLabel();
		JLabel tk_emty5 = new JLabel();
		JLabel tk_emty6 = new JLabel();
		JLabel tk_emty7 = new JLabel();
		JLabel tk_emty8 = new JLabel();
		JLabel tk_emty9 = new JLabel();

		p_content_thongKe.add(tongSoNV);
		p_content_thongKe.add(r_tongSoNV);
		p_content_thongKe.add(tk_emty1);
		p_content_thongKe.add(soLuongQL);
		p_content_thongKe.add(r_soLuongQL);
		p_content_thongKe.add(tk_emty2);
		p_content_thongKe.add(soLuongNV);
		p_content_thongKe.add(r_soLuongNV);
		p_content_thongKe.add(tk_emty3);
		p_content_thongKe.add(soNVNam);
		p_content_thongKe.add(r_soNVNam);
		p_content_thongKe.add(tk_emty9);
		p_content_thongKe.add(soNVNu);
		p_content_thongKe.add(r_soNVNu);
		p_content_thongKe.add(tk_emty4);
		p_content_thongKe.add(soNVKh);
		p_content_thongKe.add(r_soNVKhac);
		p_content_thongKe.add(tk_emty5);
		p_content_thongKe.add(doTuoiLonNhat);
		p_content_thongKe.add(r_doTuoiLonNhat);
		p_content_thongKe.add(tk_emty6);
		p_content_thongKe.add(doTuoiBeNhat);
		p_content_thongKe.add(r_doTuoiBeNhat);
		p_content_thongKe.add(tk_emty7);
		p_content_thongKe.add(doTuoiTrungBinh);
		p_content_thongKe.add(r_doTuoiTrungBinh);
		p_content_thongKe.add(tk_emty8);
		p_content_thongKe.add(soLuongNVpb);
		p_content_thongKe.add(phongBan);
		p_content_thongKe.add(r_soLuongNVpb);

		p_chua_content_thongKe.add(p_content_thongKe, BorderLayout.CENTER);
		p_chua_content_thongKe.add(p_chua_button_thongKe, BorderLayout.SOUTH);
		p_all_tk_nv.add(thongKe_top, BorderLayout.NORTH);
		p_all_tk_nv.add(thongKe_bottom, BorderLayout.SOUTH);
		p_all_tk_nv.add(p_chua_content_thongKe, BorderLayout.CENTER);
		p_all_tk_nv.add(thongKe_left, BorderLayout.WEST);
		p_all_tk_nv.add(thongKe_right, BorderLayout.EAST);

		// -----------------------------------------------------------------------------

		JPanel baoquat = new JPanel();
		baoquat.setLayout(new GridLayout(2, 0, 10, 10));
		baoquat.add(p_main);
		baoquat.add(p_table);
		// -----------------------------------------------------------------------------
		JPanel p_qlTK = new JPanel();
		p_qlTK.setLayout(new BorderLayout());

		// --------------------------THỐNG KÊ LƯƠNG THÁNG
		// 1--------------------------------
		JPanel p_all_tk_luong_1 = new JPanel();
		p_all_tk_luong_1.setLayout(new BorderLayout());
		p_all_tk_luong_1.setBackground(Color.WHITE);
		JLabel thongKeluong_top_1 = new JLabel();
		thongKeluong_top_1.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/t1.png")));
		JLabel thongKeluong_bottom_1 = new JLabel();
		thongKeluong_bottom_1.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_bottom.png")));
		JLabel thongKeluong_left_1 = new JLabel();
		thongKeluong_left_1.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JLabel thongKeluong_right_1 = new JLabel();
		thongKeluong_right_1.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JPanel p_content_thongKeluong_1 = new JPanel();
		p_content_thongKeluong_1.setBackground(Color.WHITE);
		p_content_thongKeluong_1.setLayout(new GridLayout(3, 4));
		JPanel p_chua_content_thongKeluong_1 = new JPanel();
		p_chua_content_thongKeluong_1.setLayout(new BorderLayout());
		p_chua_content_thongKeluong_1.setBackground(Color.WHITE);
		JPanel p_chua_button_thongKeluong_1 = new JPanel();
		p_chua_button_thongKeluong_1.setLayout(new GridLayout(2, 0));
		p_chua_button_thongKeluong_1.setBackground(Color.WHITE);
		JLabel space_luong_1 = new JLabel();
		JPanel p_button_thongKeluong_1 = new JPanel();
		p_button_thongKeluong_1.setLayout(new GridLayout(0, 6));
		p_button_thongKeluong_1.setBackground(Color.WHITE);
		b_pieChart_1 = new JButton("Biểu đồ");
		b_pieChart_1.setBackground(Color.CYAN);
		b_pieChart_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String avgluong = cn.AvgLuong(1, 2021);
				Double luongBacCao = Double.parseDouble(avgluong) + 1500000;
				Double luongBacThap = Double.parseDouble(avgluong) - 1500000;
				double luongThap = cn.LuongThap(1, 2021, luongBacThap);
				double luongTB = cn.LuongTrungBinh(1, 2021, luongBacThap, luongBacCao);
				double luongCao = cn.LuongCao(1, 2021, luongBacCao);
				cn.BieuDo(luongThap, luongTB, luongCao);
			}

		});
		b_thoat_tk_luong_1 = new JButton("Thoát");
		b_thoat_tk_luong_1.setBackground(Color.CYAN);
		b_thoat_tk_luong_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "3");
			}

		});
		b_thoat_tk_luong_1.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_exit.png")));
		JLabel b_emty_tkluong_1 = new JLabel();
		JLabel b_emty_tkluong_2 = new JLabel();
		JLabel b_emty_tkluong_4 = new JLabel();
		JLabel b_emty_tkluong_3 = new JLabel();
		p_button_thongKeluong_1.add(b_emty_tkluong_1);
		p_button_thongKeluong_1.add(b_emty_tkluong_2);
		p_button_thongKeluong_1.add(b_pieChart_1);
		p_button_thongKeluong_1.add(b_thoat_tk_luong_1);
		p_button_thongKeluong_1.add(b_emty_tkluong_4);
		p_button_thongKeluong_1.add(b_emty_tkluong_3);
		p_chua_button_thongKeluong_1.add(space_luong_1);
		p_chua_button_thongKeluong_1.add(p_button_thongKeluong_1);
		Font f = new Font("Arial", Font.BOLD, 20);
		JLabel luongCaoNhat = new JLabel("Lương cao nhất: ", 0);
		r_maxLuong = new JLabel();
		luongCaoNhat.setFont(f);
		r_maxLuong.setFont(f);
		JLabel luongThapNhat = new JLabel("Lương thấp nhất: ", 0);
		r_minLuong = new JLabel();
		luongThapNhat.setFont(f);
		r_minLuong.setFont(f);
		JLabel luongBacCao = new JLabel("Lương bậc cao: ", 0);
		r_luongBacCao = new JLabel();
		luongBacCao.setFont(f);
		r_luongBacCao.setFont(f);
		JLabel luongBacThap = new JLabel("Lương bậc thấpt: ", 0);
		r_luongBacThap = new JLabel();
		luongBacThap.setFont(f);
		r_luongBacThap.setFont(f);
		JLabel tongLuong = new JLabel("Tổng lương nhân sự: ", 0);
		r_sumLuong = new JLabel();
		tongLuong.setFont(f);
		r_sumLuong.setFont(f);
		JLabel luongTrungBinh = new JLabel("Lương trung bình: ", 0);
		r_avgLuong = new JLabel();
		luongTrungBinh.setFont(f);
		r_avgLuong.setFont(f);

		p_content_thongKeluong_1.add(luongCaoNhat);
		p_content_thongKeluong_1.add(r_maxLuong);
		p_content_thongKeluong_1.add(luongThapNhat);
		p_content_thongKeluong_1.add(r_minLuong);
		p_content_thongKeluong_1.add(luongBacCao);
		p_content_thongKeluong_1.add(r_luongBacCao);
		p_content_thongKeluong_1.add(luongBacThap);
		p_content_thongKeluong_1.add(r_luongBacThap);
		p_content_thongKeluong_1.add(luongTrungBinh);
		p_content_thongKeluong_1.add(r_avgLuong);
		p_content_thongKeluong_1.add(tongLuong);
		p_content_thongKeluong_1.add(r_sumLuong);

		p_chua_content_thongKeluong_1.add(p_content_thongKeluong_1, BorderLayout.CENTER);
		p_chua_content_thongKeluong_1.add(p_chua_button_thongKeluong_1, BorderLayout.SOUTH);
		p_all_tk_luong_1.add(thongKeluong_top_1, BorderLayout.NORTH);
		p_all_tk_luong_1.add(thongKeluong_bottom_1, BorderLayout.SOUTH);
		p_all_tk_luong_1.add(p_chua_content_thongKeluong_1, BorderLayout.CENTER);
		p_all_tk_luong_1.add(thongKeluong_left_1, BorderLayout.WEST);
		p_all_tk_luong_1.add(thongKeluong_right_1, BorderLayout.EAST);
		// -----------------------------------------------------------------------------
		// --------------------------THỐNG KÊ LƯƠNG THÁNG
		// 2--------------------------------
		JPanel p_all_tk_luong_2 = new JPanel();
		p_all_tk_luong_2.setLayout(new BorderLayout());
		p_all_tk_luong_2.setBackground(Color.WHITE);
		JLabel thongKeluong_top_2 = new JLabel();
		thongKeluong_top_2.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/t2.png")));
		JLabel thongKeluong_bottom_2 = new JLabel();
		thongKeluong_bottom_2.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_bottom.png")));
		JLabel thongKeluong_left_2 = new JLabel();
		thongKeluong_left_2.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JLabel thongKeluong_right_2 = new JLabel();
		thongKeluong_right_2.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JPanel p_content_thongKeluong_2 = new JPanel();
		p_content_thongKeluong_2.setBackground(Color.WHITE);
		p_content_thongKeluong_2.setLayout(new GridLayout(3, 4));
		JPanel p_chua_content_thongKeluong_2 = new JPanel();
		p_chua_content_thongKeluong_2.setLayout(new BorderLayout());
		p_chua_content_thongKeluong_2.setBackground(Color.WHITE);
		JPanel p_chua_button_thongKeluong_2 = new JPanel();
		p_chua_button_thongKeluong_2.setLayout(new GridLayout(2, 0));
		p_chua_button_thongKeluong_2.setBackground(Color.WHITE);
		JLabel space_luong_2 = new JLabel();
		JPanel p_button_thongKeluong_2 = new JPanel();
		p_button_thongKeluong_2.setLayout(new GridLayout(0, 6));
		p_button_thongKeluong_2.setBackground(Color.WHITE);
		b_pieChart_2 = new JButton("Biểu đồ");
		b_pieChart_2.setBackground(Color.CYAN);
		b_pieChart_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String avgluong = cn.AvgLuong(2, 2021);
				Double luongBacCao = Double.parseDouble(avgluong) + 1500000;
				Double luongBacThap = Double.parseDouble(avgluong) - 1500000;
				double luongThap = cn.LuongThap(2, 2021, luongBacThap);
				double luongTB = cn.LuongTrungBinh(2, 2021, luongBacThap, luongBacCao);
				double luongCao = cn.LuongCao(2, 2021, luongBacCao);
				System.out.println(luongThap);
				System.out.println(luongTB);
				System.out.println(luongCao);
				cn.BieuDo(luongThap, luongTB, luongCao);
			}

		});
		b_thoat_tk_luong_2 = new JButton("Thoát");
		b_thoat_tk_luong_2.setBackground(Color.CYAN);
		b_thoat_tk_luong_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "3");
			}

		});
		b_thoat_tk_luong_2.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_exit.png")));
		JLabel b_emty_tkluong2_1 = new JLabel();
		JLabel b_emty_tkluong2_2 = new JLabel();
		JLabel b_emty_tkluong2_4 = new JLabel();
		JLabel b_emty_tkluong2_3 = new JLabel();
		p_button_thongKeluong_2.add(b_emty_tkluong2_1);
		p_button_thongKeluong_2.add(b_emty_tkluong2_2);
		p_button_thongKeluong_2.add(b_pieChart_2);
		p_button_thongKeluong_2.add(b_thoat_tk_luong_2);
		p_button_thongKeluong_2.add(b_emty_tkluong2_4);
		p_button_thongKeluong_2.add(b_emty_tkluong2_3);
		p_chua_button_thongKeluong_2.add(space_luong_2);
		p_chua_button_thongKeluong_2.add(p_button_thongKeluong_2);
		JLabel luongCaoNhat2 = new JLabel("Lương cao nhất: ", 0);
		r_maxLuong2 = new JLabel();
		luongCaoNhat2.setFont(f);
		r_maxLuong2.setFont(f);
		JLabel luongThapNhat2 = new JLabel("Lương thấp nhất: ", 0);
		r_minLuong2 = new JLabel();
		luongThapNhat2.setFont(f);
		r_minLuong2.setFont(f);
		JLabel luongBacCao2 = new JLabel("Lương bậc cao: ", 0);
		r_luongBacCao2 = new JLabel();
		luongBacCao2.setFont(f);
		r_luongBacCao2.setFont(f);
		JLabel luongBacThap2 = new JLabel("Lương bậc thấp: ", 0);
		r_luongBacThap2 = new JLabel();
		luongBacThap2.setFont(f);
		r_luongBacThap2.setFont(f);
		JLabel tongLuong2 = new JLabel("Tổng lương nhân sự: ", 0);
		r_sumLuong2 = new JLabel();
		tongLuong2.setFont(f);
		r_sumLuong2.setFont(f);
		JLabel luongTrungBinh2 = new JLabel("Lương trung bình: ", 0);
		r_avgLuong2 = new JLabel();
		luongTrungBinh2.setFont(f);
		r_avgLuong2.setFont(f);

		p_content_thongKeluong_2.add(luongCaoNhat2);
		p_content_thongKeluong_2.add(r_maxLuong2);
		p_content_thongKeluong_2.add(luongThapNhat2);
		p_content_thongKeluong_2.add(r_minLuong2);
		p_content_thongKeluong_2.add(luongBacCao2);
		p_content_thongKeluong_2.add(r_luongBacCao2);
		p_content_thongKeluong_2.add(luongBacThap2);
		p_content_thongKeluong_2.add(r_luongBacThap2);
		p_content_thongKeluong_2.add(luongTrungBinh2);
		p_content_thongKeluong_2.add(r_avgLuong2);
		p_content_thongKeluong_2.add(tongLuong2);
		p_content_thongKeluong_2.add(r_sumLuong2);

		p_chua_content_thongKeluong_2.add(p_content_thongKeluong_2, BorderLayout.CENTER);
		p_chua_content_thongKeluong_2.add(p_chua_button_thongKeluong_2, BorderLayout.SOUTH);
		p_all_tk_luong_2.add(thongKeluong_top_2, BorderLayout.NORTH);
		p_all_tk_luong_2.add(thongKeluong_bottom_2, BorderLayout.SOUTH);
		p_all_tk_luong_2.add(p_chua_content_thongKeluong_2, BorderLayout.CENTER);
		p_all_tk_luong_2.add(thongKeluong_left_2, BorderLayout.WEST);
		p_all_tk_luong_2.add(thongKeluong_right_2, BorderLayout.EAST);
		// -----------------------------------------------------------------------------
		// --------------------------THỐNG KÊ LƯƠNG THÁNG
		// 3--------------------------------
		JPanel p_all_tk_luong_3 = new JPanel();
		p_all_tk_luong_3.setLayout(new BorderLayout());
		p_all_tk_luong_3.setBackground(Color.WHITE);
		JLabel thongKeluong_top_3 = new JLabel();
		thongKeluong_top_3.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/t3.png")));
		JLabel thongKeluong_bottom_3 = new JLabel();
		thongKeluong_bottom_3.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_bottom.png")));
		JLabel thongKeluong_left_3 = new JLabel();
		thongKeluong_left_3.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JLabel thongKeluong_right_3 = new JLabel();
		thongKeluong_right_3.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JPanel p_content_thongKeluong_3 = new JPanel();
		p_content_thongKeluong_3.setBackground(Color.WHITE);
		p_content_thongKeluong_3.setLayout(new GridLayout(3, 4));
		JPanel p_chua_content_thongKeluong_3 = new JPanel();
		p_chua_content_thongKeluong_3.setLayout(new BorderLayout());
		p_chua_content_thongKeluong_3.setBackground(Color.WHITE);
		JPanel p_chua_button_thongKeluong_3 = new JPanel();
		p_chua_button_thongKeluong_3.setLayout(new GridLayout(2, 0));
		p_chua_button_thongKeluong_3.setBackground(Color.WHITE);
		JLabel space_luong_3 = new JLabel();
		JPanel p_button_thongKeluong_3 = new JPanel();
		p_button_thongKeluong_3.setLayout(new GridLayout(0, 6));
		p_button_thongKeluong_3.setBackground(Color.WHITE);
		b_pieChart_3 = new JButton("Biểu đồ");
		b_pieChart_3.setBackground(Color.CYAN);
		b_pieChart_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String avgluong = cn.AvgLuong(3, 2021);
				Double luongBacCao = Double.parseDouble(avgluong) + 1500000;
				Double luongBacThap = Double.parseDouble(avgluong) - 1500000;
				double luongThap = cn.LuongThap(3, 2021, luongBacThap);
				double luongTB = cn.LuongTrungBinh(3, 2021, luongBacThap, luongBacCao);
				double luongCao = cn.LuongCao(3, 2021, luongBacCao);
				cn.BieuDo(luongThap, luongTB, luongCao);
			}

		});
		b_thoat_tk_luong_3 = new JButton("Thoát");
		b_thoat_tk_luong_3.setBackground(Color.CYAN);
		b_thoat_tk_luong_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "3");
			}

		});
		b_thoat_tk_luong_3.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_exit.png")));
		JLabel b_emty_tkluong3_1 = new JLabel();
		JLabel b_emty_tkluong3_2 = new JLabel();
		JLabel b_emty_tkluong3_4 = new JLabel();
		JLabel b_emty_tkluong3_3 = new JLabel();
		p_button_thongKeluong_3.add(b_emty_tkluong3_1);
		p_button_thongKeluong_3.add(b_emty_tkluong3_2);
		p_button_thongKeluong_3.add(b_pieChart_3);
		p_button_thongKeluong_3.add(b_thoat_tk_luong_3);
		p_button_thongKeluong_3.add(b_emty_tkluong3_4);
		p_button_thongKeluong_3.add(b_emty_tkluong3_3);
		p_chua_button_thongKeluong_3.add(space_luong_3);
		p_chua_button_thongKeluong_3.add(p_button_thongKeluong_3);
		JLabel luongCaoNhat3 = new JLabel("Lương cao nhất: ", 0);
		r_maxLuong3 = new JLabel();
		luongCaoNhat3.setFont(f);
		r_maxLuong3.setFont(f);
		JLabel luongThapNhat3 = new JLabel("Lương thấp nhất: ", 0);
		r_minLuong3 = new JLabel();
		luongThapNhat3.setFont(f);
		r_minLuong3.setFont(f);
		JLabel luongBacCao3 = new JLabel("Lương bậc cao: ", 0);
		r_luongBacCao3 = new JLabel();
		luongBacCao3.setFont(f);
		r_luongBacCao3.setFont(f);
		JLabel luongBacThap3 = new JLabel("Lương bậc thấp : ", 0);
		r_luongBacThap3 = new JLabel();
		luongBacThap3.setFont(f);
		r_luongBacThap3.setFont(f);
		JLabel tongLuong3 = new JLabel("Tổng lương nhân sự: ", 0);
		r_sumLuong3 = new JLabel();
		tongLuong3.setFont(f);
		r_sumLuong3.setFont(f);
		JLabel luongTrungBinh3 = new JLabel("Lương trung bình: ", 0);
		r_avgLuong3 = new JLabel();
		luongTrungBinh3.setFont(f);
		r_avgLuong3.setFont(f);

		p_content_thongKeluong_3.add(luongCaoNhat3);
		p_content_thongKeluong_3.add(r_maxLuong3);
		p_content_thongKeluong_3.add(luongThapNhat3);
		p_content_thongKeluong_3.add(r_minLuong3);
		p_content_thongKeluong_3.add(luongBacCao3);
		p_content_thongKeluong_3.add(r_luongBacCao3);
		p_content_thongKeluong_3.add(luongBacThap3);
		p_content_thongKeluong_3.add(r_luongBacThap3);
		p_content_thongKeluong_3.add(luongTrungBinh3);
		p_content_thongKeluong_3.add(r_avgLuong3);
		p_content_thongKeluong_3.add(tongLuong3);
		p_content_thongKeluong_3.add(r_sumLuong3);

		p_chua_content_thongKeluong_3.add(p_content_thongKeluong_3, BorderLayout.CENTER);
		p_chua_content_thongKeluong_3.add(p_chua_button_thongKeluong_3, BorderLayout.SOUTH);
		p_all_tk_luong_3.add(thongKeluong_top_3, BorderLayout.NORTH);
		p_all_tk_luong_3.add(thongKeluong_bottom_3, BorderLayout.SOUTH);
		p_all_tk_luong_3.add(p_chua_content_thongKeluong_3, BorderLayout.CENTER);
		p_all_tk_luong_3.add(thongKeluong_left_3, BorderLayout.WEST);
		p_all_tk_luong_3.add(thongKeluong_right_3, BorderLayout.EAST);
		// -----------------------------------------------------------------------------
		// --------------------------THỐNG KÊ LƯƠNG THÁNG
		// 4--------------------------------
		JPanel p_all_tk_luong_4 = new JPanel();
		p_all_tk_luong_4.setLayout(new BorderLayout());
		p_all_tk_luong_4.setBackground(Color.WHITE);
		JLabel thongKeluong_top_4 = new JLabel();
		thongKeluong_top_4.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/t4.png")));
		JLabel thongKeluong_bottom_4 = new JLabel();
		thongKeluong_bottom_4.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_bottom.png")));
		JLabel thongKeluong_left_4 = new JLabel();
		thongKeluong_left_4.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JLabel thongKeluong_right_4 = new JLabel();
		thongKeluong_right_4.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JPanel p_content_thongKeluong_4 = new JPanel();
		p_content_thongKeluong_4.setBackground(Color.WHITE);
		p_content_thongKeluong_4.setLayout(new GridLayout(3, 4));
		JPanel p_chua_content_thongKeluong_4 = new JPanel();
		p_chua_content_thongKeluong_4.setLayout(new BorderLayout());
		p_chua_content_thongKeluong_4.setBackground(Color.WHITE);
		JPanel p_chua_button_thongKeluong_4 = new JPanel();
		p_chua_button_thongKeluong_4.setLayout(new GridLayout(2, 0));
		p_chua_button_thongKeluong_4.setBackground(Color.WHITE);
		JLabel space_luong_4 = new JLabel();
		JPanel p_button_thongKeluong_4 = new JPanel();
		p_button_thongKeluong_4.setLayout(new GridLayout(0, 6));
		p_button_thongKeluong_4.setBackground(Color.WHITE);
		b_pieChart_4 = new JButton("Biểu đồ");
		b_pieChart_4.setBackground(Color.CYAN);
		b_pieChart_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String avgluong = cn.AvgLuong(4, 2021);
				Double luongBacCao = Double.parseDouble(avgluong) + 1500000;
				Double luongBacThap = Double.parseDouble(avgluong) - 1500000;
				double luongThap = cn.LuongThap(4, 2021, luongBacThap);
				double luongTB = cn.LuongTrungBinh(4, 2021, luongBacThap, luongBacCao);
				double luongCao = cn.LuongCao(4, 2021, luongBacCao);
				cn.BieuDo(luongThap, luongTB, luongCao);
			}

		});
		b_thoat_tk_luong_4 = new JButton("Thoát");
		b_thoat_tk_luong_4.setBackground(Color.CYAN);
		b_thoat_tk_luong_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "3");
			}

		});
		b_thoat_tk_luong_4.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_exit.png")));
		JLabel b_emty_tkluong4_1 = new JLabel();
		JLabel b_emty_tkluong4_2 = new JLabel();
		JLabel b_emty_tkluong4_4 = new JLabel();
		JLabel b_emty_tkluong4_3 = new JLabel();
		p_button_thongKeluong_4.add(b_emty_tkluong4_1);
		p_button_thongKeluong_4.add(b_emty_tkluong4_2);
		p_button_thongKeluong_4.add(b_pieChart_4);
		p_button_thongKeluong_4.add(b_thoat_tk_luong_4);
		p_button_thongKeluong_4.add(b_emty_tkluong4_4);
		p_button_thongKeluong_4.add(b_emty_tkluong4_3);
		p_chua_button_thongKeluong_4.add(space_luong_4);
		p_chua_button_thongKeluong_4.add(p_button_thongKeluong_4);
		JLabel luongCaoNhat4 = new JLabel("Lương cao nhất: ", 0);
		r_maxLuong4 = new JLabel();
		luongCaoNhat4.setFont(f);
		r_maxLuong4.setFont(f);
		JLabel luongThapNhat4 = new JLabel("Lương thấp nhất: ", 0);
		r_minLuong4 = new JLabel();
		luongThapNhat4.setFont(f);
		r_minLuong4.setFont(f);
		JLabel luongBacCao4 = new JLabel("Lương bậc cao: ", 0);
		r_luongBacCao4 = new JLabel();
		luongBacCao4.setFont(f);
		r_luongBacCao4.setFont(f);
		JLabel luongBacThap4 = new JLabel("Lương bậc thấp: ", 0);
		r_luongBacThap4 = new JLabel();
		luongBacThap4.setFont(f);
		r_luongBacThap4.setFont(f);
		JLabel tongLuong4 = new JLabel("Tổng lương nhân sự: ", 0);
		r_sumLuong4 = new JLabel();
		tongLuong4.setFont(f);
		r_sumLuong4.setFont(f);
		JLabel luongTrungBinh4 = new JLabel("Lương trung bình: ", 0);
		r_avgLuong4 = new JLabel();
		luongTrungBinh4.setFont(f);
		r_avgLuong4.setFont(f);

		p_content_thongKeluong_4.add(luongCaoNhat4);
		p_content_thongKeluong_4.add(r_maxLuong4);
		p_content_thongKeluong_4.add(luongThapNhat4);
		p_content_thongKeluong_4.add(r_minLuong4);
		p_content_thongKeluong_4.add(luongBacCao4);
		p_content_thongKeluong_4.add(r_luongBacCao4);
		p_content_thongKeluong_4.add(luongBacThap4);
		p_content_thongKeluong_4.add(r_luongBacThap4);
		p_content_thongKeluong_4.add(luongTrungBinh4);
		p_content_thongKeluong_4.add(r_avgLuong4);
		p_content_thongKeluong_4.add(tongLuong4);
		p_content_thongKeluong_4.add(r_sumLuong4);

		p_chua_content_thongKeluong_4.add(p_content_thongKeluong_4, BorderLayout.CENTER);
		p_chua_content_thongKeluong_4.add(p_chua_button_thongKeluong_4, BorderLayout.SOUTH);
		p_all_tk_luong_4.add(thongKeluong_top_4, BorderLayout.NORTH);
		p_all_tk_luong_4.add(thongKeluong_bottom_4, BorderLayout.SOUTH);
		p_all_tk_luong_4.add(p_chua_content_thongKeluong_4, BorderLayout.CENTER);
		p_all_tk_luong_4.add(thongKeluong_left_4, BorderLayout.WEST);
		p_all_tk_luong_4.add(thongKeluong_right_4, BorderLayout.EAST);
		// -----------------------------------------------------------------------------
		// --------------------------THỐNG KÊ LƯƠNG THÁNG
		// 5--------------------------------
		JPanel p_all_tk_luong_5 = new JPanel();
		p_all_tk_luong_5.setLayout(new BorderLayout());
		p_all_tk_luong_5.setBackground(Color.WHITE);
		JLabel thongKeluong_top_5 = new JLabel();
		thongKeluong_top_5.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/t5.png")));
		JLabel thongKeluong_bottom_5 = new JLabel();
		thongKeluong_bottom_5.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_bottom.png")));
		JLabel thongKeluong_left_5 = new JLabel();
		thongKeluong_left_5.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JLabel thongKeluong_right_5 = new JLabel();
		thongKeluong_right_5.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JPanel p_content_thongKeluong_5 = new JPanel();
		p_content_thongKeluong_5.setBackground(Color.WHITE);
		p_content_thongKeluong_5.setLayout(new GridLayout(3, 4));
		JPanel p_chua_content_thongKeluong_5 = new JPanel();
		p_chua_content_thongKeluong_5.setLayout(new BorderLayout());
		p_chua_content_thongKeluong_5.setBackground(Color.WHITE);
		JPanel p_chua_button_thongKeluong_5 = new JPanel();
		p_chua_button_thongKeluong_5.setLayout(new GridLayout(2, 0));
		p_chua_button_thongKeluong_5.setBackground(Color.WHITE);
		JLabel space_luong_5 = new JLabel();
		JPanel p_button_thongKeluong_5 = new JPanel();
		p_button_thongKeluong_5.setLayout(new GridLayout(0, 6));
		p_button_thongKeluong_5.setBackground(Color.WHITE);
		b_pieChart_5 = new JButton("Biểu đồ");
		b_pieChart_5.setBackground(Color.CYAN);
		b_pieChart_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String avgluong = cn.AvgLuong(5, 2021);
				Double luongBacCao = Double.parseDouble(avgluong) + 1500000;
				Double luongBacThap = Double.parseDouble(avgluong) - 1500000;
				double luongThap = cn.LuongThap(5, 2021, luongBacThap);
				double luongTB = cn.LuongTrungBinh(5, 2021, luongBacThap, luongBacCao);
				double luongCao = cn.LuongCao(5, 2021, luongBacCao);
				cn.BieuDo(luongThap, luongTB, luongCao);
			}

		});
		b_thoat_tk_luong_5 = new JButton("Thoát");
		b_thoat_tk_luong_5.setBackground(Color.CYAN);
		b_thoat_tk_luong_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "3");
			}

		});
		b_thoat_tk_luong_5.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_exit.png")));
		JLabel b_emty_tkluong5_1 = new JLabel();
		JLabel b_emty_tkluong5_2 = new JLabel();
		JLabel b_emty_tkluong5_4 = new JLabel();
		JLabel b_emty_tkluong5_3 = new JLabel();
		p_button_thongKeluong_5.add(b_emty_tkluong5_1);
		p_button_thongKeluong_5.add(b_emty_tkluong5_2);
		p_button_thongKeluong_5.add(b_pieChart_5);
		p_button_thongKeluong_5.add(b_thoat_tk_luong_5);
		p_button_thongKeluong_5.add(b_emty_tkluong5_4);
		p_button_thongKeluong_5.add(b_emty_tkluong5_3);
		p_chua_button_thongKeluong_5.add(space_luong_5);
		p_chua_button_thongKeluong_5.add(p_button_thongKeluong_5);
		JLabel luongCaoNhat5 = new JLabel("Lương cao nhất: ", 0);
		r_maxLuong5 = new JLabel();
		luongCaoNhat5.setFont(f);
		r_maxLuong5.setFont(f);
		JLabel luongThapNhat5 = new JLabel("Lương thấp nhất: ", 0);
		r_minLuong5 = new JLabel();
		luongThapNhat5.setFont(f);
		r_minLuong5.setFont(f);
		JLabel luongBacCao5 = new JLabel("Lương bậc cao: ", 0);
		r_luongBacCao5 = new JLabel();
		luongBacCao5.setFont(f);
		r_luongBacCao5.setFont(f);
		JLabel luongBacThap5 = new JLabel("Lương bậc thấp: ", 0);
		r_luongBacThap5 = new JLabel();
		luongBacThap5.setFont(f);
		r_luongBacThap5.setFont(f);
		JLabel tongLuong5 = new JLabel("Tổng lương nhân sự: ", 0);
		r_sumLuong5 = new JLabel();
		tongLuong5.setFont(f);
		r_sumLuong5.setFont(f);
		JLabel luongTrungBinh5 = new JLabel("Lương trung bình: ", 0);
		r_avgLuong5 = new JLabel();
		luongTrungBinh5.setFont(f);
		r_avgLuong5.setFont(f);

		p_content_thongKeluong_5.add(luongCaoNhat5);
		p_content_thongKeluong_5.add(r_maxLuong5);
		p_content_thongKeluong_5.add(luongThapNhat5);
		p_content_thongKeluong_5.add(r_minLuong5);
		p_content_thongKeluong_5.add(luongBacCao5);
		p_content_thongKeluong_5.add(r_luongBacCao5);
		p_content_thongKeluong_5.add(luongBacThap5);
		p_content_thongKeluong_5.add(r_luongBacThap5);
		p_content_thongKeluong_5.add(luongTrungBinh5);
		p_content_thongKeluong_5.add(r_avgLuong5);
		p_content_thongKeluong_5.add(tongLuong5);
		p_content_thongKeluong_5.add(r_sumLuong5);

		p_chua_content_thongKeluong_5.add(p_content_thongKeluong_5, BorderLayout.CENTER);
		p_chua_content_thongKeluong_5.add(p_chua_button_thongKeluong_5, BorderLayout.SOUTH);
		p_all_tk_luong_5.add(thongKeluong_top_5, BorderLayout.NORTH);
		p_all_tk_luong_5.add(thongKeluong_bottom_5, BorderLayout.SOUTH);
		p_all_tk_luong_5.add(p_chua_content_thongKeluong_5, BorderLayout.CENTER);
		p_all_tk_luong_5.add(thongKeluong_left_5, BorderLayout.WEST);
		p_all_tk_luong_5.add(thongKeluong_right_5, BorderLayout.EAST);
		// -----------------------------------------------------------------------------
		// --------------------------THỐNG KÊ LƯƠNG THÁNG
		// 6--------------------------------
		JPanel p_all_tk_luong_6 = new JPanel();
		p_all_tk_luong_6.setLayout(new BorderLayout());
		p_all_tk_luong_6.setBackground(Color.WHITE);
		JLabel thongKeluong_top_6 = new JLabel();
		thongKeluong_top_6.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/t6.png")));
		JLabel thongKeluong_bottom_6 = new JLabel();
		thongKeluong_bottom_6.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_bottom.png")));
		JLabel thongKeluong_left_6 = new JLabel();
		thongKeluong_left_6.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JLabel thongKeluong_right_6 = new JLabel();
		thongKeluong_right_6.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JPanel p_content_thongKeluong_6 = new JPanel();
		p_content_thongKeluong_6.setBackground(Color.WHITE);
		p_content_thongKeluong_6.setLayout(new GridLayout(3, 4));
		JPanel p_chua_content_thongKeluong_6 = new JPanel();
		p_chua_content_thongKeluong_6.setLayout(new BorderLayout());
		p_chua_content_thongKeluong_6.setBackground(Color.WHITE);
		JPanel p_chua_button_thongKeluong_6 = new JPanel();
		p_chua_button_thongKeluong_6.setLayout(new GridLayout(2, 0));
		p_chua_button_thongKeluong_6.setBackground(Color.WHITE);
		JLabel space_luong_6 = new JLabel();
		JPanel p_button_thongKeluong_6 = new JPanel();
		p_button_thongKeluong_6.setLayout(new GridLayout(0, 6));
		p_button_thongKeluong_6.setBackground(Color.WHITE);
		b_pieChart_6 = new JButton("Biểu đồ");
		b_pieChart_6.setBackground(Color.CYAN);
		b_pieChart_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String avgluong = cn.AvgLuong(6, 2021);
				Double luongBacCao = Double.parseDouble(avgluong) + 1500000;
				Double luongBacThap = Double.parseDouble(avgluong) - 1500000;
				double luongThap = cn.LuongThap(6, 2021, luongBacThap);
				double luongTB = cn.LuongTrungBinh(6, 2021, luongBacThap, luongBacCao);
				double luongCao = cn.LuongCao(6, 2021, luongBacCao);
				cn.BieuDo(luongThap, luongTB, luongCao);
			}

		});
		b_thoat_tk_luong_6 = new JButton("Thoát");
		b_thoat_tk_luong_6.setBackground(Color.CYAN);
		b_thoat_tk_luong_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "3");
			}

		});
		b_thoat_tk_luong_6.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_exit.png")));
		JLabel b_emty_tkluong6_1 = new JLabel();
		JLabel b_emty_tkluong6_2 = new JLabel();
		JLabel b_emty_tkluong6_4 = new JLabel();
		JLabel b_emty_tkluong6_3 = new JLabel();
		p_button_thongKeluong_6.add(b_emty_tkluong6_1);
		p_button_thongKeluong_6.add(b_emty_tkluong6_2);
		p_button_thongKeluong_6.add(b_pieChart_6);
		p_button_thongKeluong_6.add(b_thoat_tk_luong_6);
		p_button_thongKeluong_6.add(b_emty_tkluong6_4);
		p_button_thongKeluong_6.add(b_emty_tkluong6_3);
		p_chua_button_thongKeluong_6.add(space_luong_6);
		p_chua_button_thongKeluong_6.add(p_button_thongKeluong_6);
		JLabel luongCaoNhat6 = new JLabel("Lương cao nhất: ", 0);
		r_maxLuong6 = new JLabel();
		luongCaoNhat6.setFont(f);
		r_maxLuong6.setFont(f);
		JLabel luongThapNhat6 = new JLabel("Lương thấp nhất: ", 0);
		r_minLuong6 = new JLabel();
		luongThapNhat6.setFont(f);
		r_minLuong6.setFont(f);
		JLabel luongBacCao6 = new JLabel("Lương bậc cao: ", 0);
		r_luongBacCao6 = new JLabel();
		luongBacCao6.setFont(f);
		r_luongBacCao6.setFont(f);
		JLabel luongBacThap6 = new JLabel("Lương bậc thấp: ", 0);
		r_luongBacThap6 = new JLabel();
		luongBacThap6.setFont(f);
		r_luongBacThap6.setFont(f);
		JLabel tongLuong6 = new JLabel("Tổng lương nhân sự: ", 0);
		r_sumLuong6 = new JLabel();
		tongLuong6.setFont(f);
		r_sumLuong6.setFont(f);
		JLabel luongTrungBinh6 = new JLabel("Lương trung bình: ", 0);
		r_avgLuong6 = new JLabel();
		luongTrungBinh6.setFont(f);
		r_avgLuong6.setFont(f);

		p_content_thongKeluong_6.add(luongCaoNhat6);
		p_content_thongKeluong_6.add(r_maxLuong6);
		p_content_thongKeluong_6.add(luongThapNhat6);
		p_content_thongKeluong_6.add(r_minLuong6);
		p_content_thongKeluong_6.add(luongBacCao6);
		p_content_thongKeluong_6.add(r_luongBacCao6);
		p_content_thongKeluong_6.add(luongBacThap6);
		p_content_thongKeluong_6.add(r_luongBacThap6);
		p_content_thongKeluong_6.add(luongTrungBinh6);
		p_content_thongKeluong_6.add(r_avgLuong6);
		p_content_thongKeluong_6.add(tongLuong6);
		p_content_thongKeluong_6.add(r_sumLuong6);

		p_chua_content_thongKeluong_6.add(p_content_thongKeluong_6, BorderLayout.CENTER);
		p_chua_content_thongKeluong_6.add(p_chua_button_thongKeluong_6, BorderLayout.SOUTH);
		p_all_tk_luong_6.add(thongKeluong_top_6, BorderLayout.NORTH);
		p_all_tk_luong_6.add(thongKeluong_bottom_6, BorderLayout.SOUTH);
		p_all_tk_luong_6.add(p_chua_content_thongKeluong_6, BorderLayout.CENTER);
		p_all_tk_luong_6.add(thongKeluong_left_6, BorderLayout.WEST);
		p_all_tk_luong_6.add(thongKeluong_right_6, BorderLayout.EAST);
		// -----------------------------------------------------------------------------
		// --------------------------THỐNG KÊ LƯƠNG THÁNG
		// 7--------------------------------
		JPanel p_all_tk_luong_7 = new JPanel();
		p_all_tk_luong_7.setLayout(new BorderLayout());
		p_all_tk_luong_7.setBackground(Color.WHITE);
		JLabel thongKeluong_top_7 = new JLabel();
		thongKeluong_top_7.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/t7.png")));
		JLabel thongKeluong_bottom_7 = new JLabel();
		thongKeluong_bottom_7.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_bottom.png")));
		JLabel thongKeluong_left_7 = new JLabel();
		thongKeluong_left_7.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JLabel thongKeluong_right_7 = new JLabel();
		thongKeluong_right_7.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JPanel p_content_thongKeluong_7 = new JPanel();
		p_content_thongKeluong_7.setBackground(Color.WHITE);
		p_content_thongKeluong_7.setLayout(new GridLayout(3, 4));
		JPanel p_chua_content_thongKeluong_7 = new JPanel();
		p_chua_content_thongKeluong_7.setLayout(new BorderLayout());
		p_chua_content_thongKeluong_7.setBackground(Color.WHITE);
		JPanel p_chua_button_thongKeluong_7 = new JPanel();
		p_chua_button_thongKeluong_7.setLayout(new GridLayout(2, 0));
		p_chua_button_thongKeluong_7.setBackground(Color.WHITE);
		JLabel space_luong_7 = new JLabel();
		JPanel p_button_thongKeluong_7 = new JPanel();
		p_button_thongKeluong_7.setLayout(new GridLayout(0, 6));
		p_button_thongKeluong_7.setBackground(Color.WHITE);
		b_pieChart_7 = new JButton("Biểu đồ");
		b_pieChart_7.setBackground(Color.CYAN);
		b_pieChart_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String avgluong = cn.AvgLuong(7, 2021);
				Double luongBacCao = Double.parseDouble(avgluong) + 1500000;
				Double luongBacThap = Double.parseDouble(avgluong) - 1500000;
				double LuongThap = cn.LuongThap(7, 2021, luongBacThap);
				double LuongTB = cn.LuongTrungBinh(7, 2021, luongBacThap, luongBacCao);
				double LuongCao = cn.LuongCao(7, 2021, luongBacCao);
				cn.BieuDo(LuongThap, LuongTB, LuongCao);
			}

		});
		b_thoat_tk_luong_7 = new JButton("Thoát");
		b_thoat_tk_luong_7.setBackground(Color.CYAN);
		b_thoat_tk_luong_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "3");
			}

		});
		b_thoat_tk_luong_7.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_exit.png")));
		JLabel b_emty_tkluong7_1 = new JLabel();
		JLabel b_emty_tkluong7_2 = new JLabel();
		JLabel b_emty_tkluong7_4 = new JLabel();
		JLabel b_emty_tkluong7_3 = new JLabel();
		p_button_thongKeluong_7.add(b_emty_tkluong7_1);
		p_button_thongKeluong_7.add(b_emty_tkluong7_2);
		p_button_thongKeluong_7.add(b_pieChart_7);
		p_button_thongKeluong_7.add(b_thoat_tk_luong_7);
		p_button_thongKeluong_7.add(b_emty_tkluong7_4);
		p_button_thongKeluong_7.add(b_emty_tkluong7_3);
		p_chua_button_thongKeluong_7.add(space_luong_7);
		p_chua_button_thongKeluong_7.add(p_button_thongKeluong_7);
		JLabel luongCaoNhat7 = new JLabel("Lương cao nhất: ", 0);
		r_maxLuong7 = new JLabel();
		luongCaoNhat7.setFont(f);
		r_maxLuong7.setFont(f);
		JLabel luongThapNhat7 = new JLabel("Lương thấp nhất: ", 0);
		r_minLuong7 = new JLabel();
		luongThapNhat7.setFont(f);
		r_minLuong7.setFont(f);
		JLabel luongBacCao7 = new JLabel("Lương bậc cao: ", 0);
		r_luongBacCao7 = new JLabel();
		luongBacCao7.setFont(f);
		r_luongBacCao7.setFont(f);
		JLabel luongBacThap7 = new JLabel("Lương bậc thấp: ", 0);
		r_luongBacThap7 = new JLabel();
		luongBacThap7.setFont(f);
		r_luongBacThap7.setFont(f);
		JLabel tongLuong7 = new JLabel("Tổng lương nhân sự: ", 0);
		r_sumLuong7 = new JLabel();
		tongLuong7.setFont(f);
		r_sumLuong7.setFont(f);
		JLabel luongTrungBinh7 = new JLabel("Lương trung bình: ", 0);
		r_avgLuong7 = new JLabel();
		luongTrungBinh7.setFont(f);
		r_avgLuong7.setFont(f);

		p_content_thongKeluong_7.add(luongCaoNhat7);
		p_content_thongKeluong_7.add(r_maxLuong7);
		p_content_thongKeluong_7.add(luongThapNhat7);
		p_content_thongKeluong_7.add(r_minLuong7);
		p_content_thongKeluong_7.add(luongBacCao7);
		p_content_thongKeluong_7.add(r_luongBacCao7);
		p_content_thongKeluong_7.add(luongBacThap7);
		p_content_thongKeluong_7.add(r_luongBacThap7);
		p_content_thongKeluong_7.add(luongTrungBinh7);
		p_content_thongKeluong_7.add(r_avgLuong7);
		p_content_thongKeluong_7.add(tongLuong7);
		p_content_thongKeluong_7.add(r_sumLuong7);

		p_chua_content_thongKeluong_7.add(p_content_thongKeluong_7, BorderLayout.CENTER);
		p_chua_content_thongKeluong_7.add(p_chua_button_thongKeluong_7, BorderLayout.SOUTH);
		p_all_tk_luong_7.add(thongKeluong_top_7, BorderLayout.NORTH);
		p_all_tk_luong_7.add(thongKeluong_bottom_7, BorderLayout.SOUTH);
		p_all_tk_luong_7.add(p_chua_content_thongKeluong_7, BorderLayout.CENTER);
		p_all_tk_luong_7.add(thongKeluong_left_7, BorderLayout.WEST);
		p_all_tk_luong_7.add(thongKeluong_right_7, BorderLayout.EAST);
		// -----------------------------------------------------------------------------
		// --------------------------THỐNG KÊ LƯƠNG THÁNG
		// 8--------------------------------
		JPanel p_all_tk_luong_8 = new JPanel();
		p_all_tk_luong_8.setLayout(new BorderLayout());
		p_all_tk_luong_8.setBackground(Color.WHITE);
		JLabel thongKeluong_top_8 = new JLabel();
		thongKeluong_top_8.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/t8.png")));
		JLabel thongKeluong_bottom_8 = new JLabel();
		thongKeluong_bottom_8.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_bottom.png")));
		JLabel thongKeluong_left_8 = new JLabel();
		thongKeluong_left_8.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JLabel thongKeluong_right_8 = new JLabel();
		thongKeluong_right_8.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JPanel p_content_thongKeluong_8 = new JPanel();
		p_content_thongKeluong_8.setBackground(Color.WHITE);
		p_content_thongKeluong_8.setLayout(new GridLayout(3, 4));
		JPanel p_chua_content_thongKeluong_8 = new JPanel();
		p_chua_content_thongKeluong_8.setLayout(new BorderLayout());
		p_chua_content_thongKeluong_8.setBackground(Color.WHITE);
		JPanel p_chua_button_thongKeluong_8 = new JPanel();
		p_chua_button_thongKeluong_8.setLayout(new GridLayout(2, 0));
		p_chua_button_thongKeluong_8.setBackground(Color.WHITE);
		JLabel space_luong_8 = new JLabel();
		JPanel p_button_thongKeluong_8 = new JPanel();
		p_button_thongKeluong_8.setLayout(new GridLayout(0, 6));
		p_button_thongKeluong_8.setBackground(Color.WHITE);
		b_pieChart_8 = new JButton("Biểu đồ");
		b_pieChart_8.setBackground(Color.CYAN);
		b_pieChart_8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String avgluong = cn.AvgLuong(8, 2021);
				Double luongBacCao = Double.parseDouble(avgluong) + 1500000;
				Double luongBacThap = Double.parseDouble(avgluong) - 1500000;
				double luongThap = cn.LuongThap(8, 2021, luongBacThap);
				double luongTB = cn.LuongTrungBinh(8, 2021, luongBacThap, luongBacCao);
				double luongCao = cn.LuongCao(8, 2021, luongBacCao);
				cn.BieuDo(luongThap, luongTB, luongCao);
			}

		});
		b_thoat_tk_luong_8 = new JButton("Thoát");
		b_thoat_tk_luong_8.setBackground(Color.CYAN);
		b_thoat_tk_luong_8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "3");
			}

		});
		b_thoat_tk_luong_8.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_exit.png")));
		JLabel b_emty_tkluong8_1 = new JLabel();
		JLabel b_emty_tkluong8_2 = new JLabel();
		JLabel b_emty_tkluong8_4 = new JLabel();
		JLabel b_emty_tkluong8_3 = new JLabel();
		p_button_thongKeluong_8.add(b_emty_tkluong8_1);
		p_button_thongKeluong_8.add(b_emty_tkluong8_2);
		p_button_thongKeluong_8.add(b_pieChart_8);
		p_button_thongKeluong_8.add(b_thoat_tk_luong_8);
		p_button_thongKeluong_8.add(b_emty_tkluong8_4);
		p_button_thongKeluong_8.add(b_emty_tkluong8_3);
		p_chua_button_thongKeluong_8.add(space_luong_8);
		p_chua_button_thongKeluong_8.add(p_button_thongKeluong_8);
		JLabel luongCaoNhat8 = new JLabel("Lương cao nhất: ", 0);
		r_maxLuong8 = new JLabel();
		luongCaoNhat8.setFont(f);
		r_maxLuong8.setFont(f);
		JLabel luongThapNhat8 = new JLabel("Lương thấp nhất: ", 0);
		r_minLuong8 = new JLabel();
		luongThapNhat8.setFont(f);
		r_minLuong8.setFont(f);
		JLabel luongBacCao8 = new JLabel("Lương bậc cao: ", 0);
		r_luongBacCao8 = new JLabel();
		luongBacCao8.setFont(f);
		r_luongBacCao8.setFont(f);
		JLabel luongBacThap8 = new JLabel("Lương bậc thấp: ", 0);
		r_luongBacThap8 = new JLabel();
		luongBacThap8.setFont(f);
		r_luongBacThap8.setFont(f);
		JLabel tongLuong8 = new JLabel("Tổng lương nhân sự: ", 0);
		r_sumLuong8 = new JLabel();
		tongLuong8.setFont(f);
		r_sumLuong8.setFont(f);
		JLabel luongTrungBinh8 = new JLabel("Lương trung bình: ", 0);
		r_avgLuong8 = new JLabel();
		luongTrungBinh8.setFont(f);
		r_avgLuong8.setFont(f);

		p_content_thongKeluong_8.add(luongCaoNhat8);
		p_content_thongKeluong_8.add(r_maxLuong8);
		p_content_thongKeluong_8.add(luongThapNhat8);
		p_content_thongKeluong_8.add(r_minLuong8);
		p_content_thongKeluong_8.add(luongBacCao8);
		p_content_thongKeluong_8.add(r_luongBacCao8);
		p_content_thongKeluong_8.add(luongBacThap8);
		p_content_thongKeluong_8.add(r_luongBacThap8);
		p_content_thongKeluong_8.add(luongTrungBinh8);
		p_content_thongKeluong_8.add(r_avgLuong8);
		p_content_thongKeluong_8.add(tongLuong8);
		p_content_thongKeluong_8.add(r_sumLuong8);

		p_chua_content_thongKeluong_8.add(p_content_thongKeluong_8, BorderLayout.CENTER);
		p_chua_content_thongKeluong_8.add(p_chua_button_thongKeluong_8, BorderLayout.SOUTH);
		p_all_tk_luong_8.add(thongKeluong_top_8, BorderLayout.NORTH);
		p_all_tk_luong_8.add(thongKeluong_bottom_8, BorderLayout.SOUTH);
		p_all_tk_luong_8.add(p_chua_content_thongKeluong_8, BorderLayout.CENTER);
		p_all_tk_luong_8.add(thongKeluong_left_8, BorderLayout.WEST);
		p_all_tk_luong_8.add(thongKeluong_right_8, BorderLayout.EAST);
		// -----------------------------------------------------------------------------
		// --------------------------THỐNG KÊ LƯƠNG THÁNG
		// 9--------------------------------
		JPanel p_all_tk_luong_9 = new JPanel();
		p_all_tk_luong_9.setLayout(new BorderLayout());
		p_all_tk_luong_9.setBackground(Color.WHITE);
		JLabel thongKeluong_top_9 = new JLabel();
		thongKeluong_top_9.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/t9.png")));
		JLabel thongKeluong_bottom_9 = new JLabel();
		thongKeluong_bottom_9.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_bottom.png")));
		JLabel thongKeluong_left_9 = new JLabel();
		thongKeluong_left_9.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JLabel thongKeluong_right_9 = new JLabel();
		thongKeluong_right_9.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JPanel p_content_thongKeluong_9 = new JPanel();
		p_content_thongKeluong_9.setBackground(Color.WHITE);
		p_content_thongKeluong_9.setLayout(new GridLayout(3, 4));
		JPanel p_chua_content_thongKeluong_9 = new JPanel();
		p_chua_content_thongKeluong_9.setLayout(new BorderLayout());
		p_chua_content_thongKeluong_9.setBackground(Color.WHITE);
		JPanel p_chua_button_thongKeluong_9 = new JPanel();
		p_chua_button_thongKeluong_9.setLayout(new GridLayout(2, 0));
		p_chua_button_thongKeluong_9.setBackground(Color.WHITE);
		JLabel space_luong_9 = new JLabel();
		JPanel p_button_thongKeluong_9 = new JPanel();
		p_button_thongKeluong_9.setLayout(new GridLayout(0, 6));
		p_button_thongKeluong_9.setBackground(Color.WHITE);
		b_pieChart_9 = new JButton("Biểu đồ");
		b_pieChart_9.setBackground(Color.CYAN);
		b_pieChart_9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String avgluong = cn.AvgLuong(9, 2021);
				Double luongBacCao = Double.parseDouble(avgluong) + 1500000;
				Double luongBacThap = Double.parseDouble(avgluong) - 1500000;
				double luongThap = cn.LuongThap(9, 2021, luongBacThap);
				double luongTB = cn.LuongTrungBinh(9, 2021, luongBacThap, luongBacCao);
				double luongCao = cn.LuongCao(9, 2021, luongBacCao);
				cn.BieuDo(luongThap, luongTB, luongCao);
			}

		});
		b_thoat_tk_luong_9 = new JButton("Thoát");
		b_thoat_tk_luong_9.setBackground(Color.CYAN);
		b_thoat_tk_luong_9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "3");
			}

		});
		b_thoat_tk_luong_9.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_exit.png")));
		JLabel b_emty_tkluong9_1 = new JLabel();
		JLabel b_emty_tkluong9_2 = new JLabel();
		JLabel b_emty_tkluong9_4 = new JLabel();
		JLabel b_emty_tkluong9_3 = new JLabel();
		p_button_thongKeluong_9.add(b_emty_tkluong9_1);
		p_button_thongKeluong_9.add(b_emty_tkluong9_2);
		p_button_thongKeluong_9.add(b_pieChart_9);
		p_button_thongKeluong_9.add(b_thoat_tk_luong_9);
		p_button_thongKeluong_9.add(b_emty_tkluong9_4);
		p_button_thongKeluong_9.add(b_emty_tkluong9_3);
		p_chua_button_thongKeluong_9.add(space_luong_9);
		p_chua_button_thongKeluong_9.add(p_button_thongKeluong_9);
		JLabel luongCaoNhat9 = new JLabel("Lương cao nhất: ", 0);
		r_maxLuong9 = new JLabel();
		luongCaoNhat9.setFont(f);
		r_maxLuong9.setFont(f);
		JLabel luongThapNhat9 = new JLabel("Lương thấp nhất: ", 0);
		r_minLuong9 = new JLabel();
		luongThapNhat9.setFont(f);
		r_minLuong9.setFont(f);
		JLabel luongBacCao9 = new JLabel("Lương bậc cao: ", 0);
		r_luongBacCao9 = new JLabel();
		luongBacCao9.setFont(f);
		r_luongBacCao9.setFont(f);
		JLabel luongBacThap9 = new JLabel("Lương bậc thấp: ", 0);
		r_luongBacThap9 = new JLabel();
		luongBacThap9.setFont(f);
		r_luongBacThap9.setFont(f);
		JLabel tongLuong9 = new JLabel("Tổng lương nhân sự: ", 0);
		r_sumLuong9 = new JLabel();
		tongLuong9.setFont(f);
		r_sumLuong9.setFont(f);
		JLabel luongTrungBinh9 = new JLabel("Lương trung bình: ", 0);
		r_avgLuong9 = new JLabel();
		luongTrungBinh9.setFont(f);
		r_avgLuong9.setFont(f);

		p_content_thongKeluong_9.add(luongCaoNhat9);
		p_content_thongKeluong_9.add(r_maxLuong9);
		p_content_thongKeluong_9.add(luongThapNhat9);
		p_content_thongKeluong_9.add(r_minLuong9);
		p_content_thongKeluong_9.add(luongBacCao9);
		p_content_thongKeluong_9.add(r_luongBacCao9);
		p_content_thongKeluong_9.add(luongBacThap9);
		p_content_thongKeluong_9.add(r_luongBacThap9);
		p_content_thongKeluong_9.add(luongTrungBinh9);
		p_content_thongKeluong_9.add(r_avgLuong9);
		p_content_thongKeluong_9.add(tongLuong9);
		p_content_thongKeluong_9.add(r_sumLuong9);

		p_chua_content_thongKeluong_9.add(p_content_thongKeluong_9, BorderLayout.CENTER);
		p_chua_content_thongKeluong_9.add(p_chua_button_thongKeluong_9, BorderLayout.SOUTH);
		p_all_tk_luong_9.add(thongKeluong_top_9, BorderLayout.NORTH);
		p_all_tk_luong_9.add(thongKeluong_bottom_9, BorderLayout.SOUTH);
		p_all_tk_luong_9.add(p_chua_content_thongKeluong_9, BorderLayout.CENTER);
		p_all_tk_luong_9.add(thongKeluong_left_9, BorderLayout.WEST);
		p_all_tk_luong_9.add(thongKeluong_right_9, BorderLayout.EAST);
		// -----------------------------------------------------------------------------
		// --------------------------THỐNG KÊ LƯƠNG THÁNG
		// 10--------------------------------
		JPanel p_all_tk_luong_10 = new JPanel();
		p_all_tk_luong_10.setLayout(new BorderLayout());
		p_all_tk_luong_10.setBackground(Color.WHITE);
		JLabel thongKeluong_top_10 = new JLabel();
		thongKeluong_top_10.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/t10.png")));
		JLabel thongKeluong_bottom_10 = new JLabel();
		thongKeluong_bottom_10.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_bottom.png")));
		JLabel thongKeluong_left_10 = new JLabel();
		thongKeluong_left_10.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JLabel thongKeluong_right_10 = new JLabel();
		thongKeluong_right_10.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JPanel p_content_thongKeluong_10 = new JPanel();
		p_content_thongKeluong_10.setBackground(Color.WHITE);
		p_content_thongKeluong_10.setLayout(new GridLayout(3, 4));
		JPanel p_chua_content_thongKeluong_10 = new JPanel();
		p_chua_content_thongKeluong_10.setLayout(new BorderLayout());
		p_chua_content_thongKeluong_10.setBackground(Color.WHITE);
		JPanel p_chua_button_thongKeluong_10 = new JPanel();
		p_chua_button_thongKeluong_10.setLayout(new GridLayout(2, 0));
		p_chua_button_thongKeluong_10.setBackground(Color.WHITE);
		JLabel space_luong_10 = new JLabel();
		JPanel p_button_thongKeluong_10 = new JPanel();
		p_button_thongKeluong_10.setLayout(new GridLayout(0, 6));
		p_button_thongKeluong_10.setBackground(Color.WHITE);
		b_pieChart_10 = new JButton("Biểu đồ");
		b_pieChart_10.setBackground(Color.CYAN);
		b_pieChart_10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String avgluong = cn.AvgLuong(10, 2021);
				Double luongBacCao = Double.parseDouble(avgluong) + 1500000;
				Double luongBacThap = Double.parseDouble(avgluong) - 1500000;
				double LuongThap = cn.LuongThap(10, 2021, luongBacThap);
				double LuongTB = cn.LuongTrungBinh(10, 2021, luongBacThap, luongBacCao);
				double LuongCao = cn.LuongCao(10, 2021, luongBacCao);
				cn.BieuDo(LuongThap, LuongTB, LuongCao);
			}

		});
		b_thoat_tk_luong_10 = new JButton("Thoát");
		b_thoat_tk_luong_10.setBackground(Color.CYAN);
		b_thoat_tk_luong_10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "3");
			}

		});
		b_thoat_tk_luong_10.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_exit.png")));
		JLabel b_emty_tkluong10_1 = new JLabel();
		JLabel b_emty_tkluong10_2 = new JLabel();
		JLabel b_emty_tkluong10_4 = new JLabel();
		JLabel b_emty_tkluong10_3 = new JLabel();
		p_button_thongKeluong_10.add(b_emty_tkluong10_1);
		p_button_thongKeluong_10.add(b_emty_tkluong10_2);
		p_button_thongKeluong_10.add(b_pieChart_10);
		p_button_thongKeluong_10.add(b_thoat_tk_luong_10);
		p_button_thongKeluong_10.add(b_emty_tkluong10_4);
		p_button_thongKeluong_10.add(b_emty_tkluong10_3);
		p_chua_button_thongKeluong_10.add(space_luong_10);
		p_chua_button_thongKeluong_10.add(p_button_thongKeluong_10);
		JLabel luongCaoNhat10 = new JLabel("Lương cao nhất: ", 0);
		r_maxLuong10 = new JLabel();
		luongCaoNhat10.setFont(f);
		r_maxLuong10.setFont(f);
		JLabel luongThapNhat10 = new JLabel("Lương thấp nhất: ", 0);
		r_minLuong10 = new JLabel();
		luongThapNhat10.setFont(f);
		r_minLuong10.setFont(f);
		JLabel luongBacCao10 = new JLabel("Lương bậc cao: ", 0);
		r_luongBacCao10 = new JLabel();
		luongBacCao10.setFont(f);
		r_luongBacCao10.setFont(f);
		JLabel luongBacThap10 = new JLabel("Lương bậc thấp: ", 0);
		r_luongBacThap10 = new JLabel();
		luongBacThap10.setFont(f);
		r_luongBacThap10.setFont(f);
		JLabel tongLuong10 = new JLabel("Tổng lương nhân sự: ", 0);
		r_sumLuong10 = new JLabel();
		tongLuong10.setFont(f);
		r_sumLuong10.setFont(f);
		JLabel luongTrungBinh10 = new JLabel("Lương trung bình: ", 0);
		r_avgLuong10 = new JLabel();
		luongTrungBinh10.setFont(f);
		r_avgLuong10.setFont(f);

		p_content_thongKeluong_10.add(luongCaoNhat10);
		p_content_thongKeluong_10.add(r_maxLuong10);
		p_content_thongKeluong_10.add(luongThapNhat10);
		p_content_thongKeluong_10.add(r_minLuong10);
		p_content_thongKeluong_10.add(luongBacCao10);
		p_content_thongKeluong_10.add(r_luongBacCao10);
		p_content_thongKeluong_10.add(luongBacThap10);
		p_content_thongKeluong_10.add(r_luongBacThap10);
		p_content_thongKeluong_10.add(luongTrungBinh10);
		p_content_thongKeluong_10.add(r_avgLuong10);
		p_content_thongKeluong_10.add(tongLuong10);
		p_content_thongKeluong_10.add(r_sumLuong10);

		p_chua_content_thongKeluong_10.add(p_content_thongKeluong_10, BorderLayout.CENTER);
		p_chua_content_thongKeluong_10.add(p_chua_button_thongKeluong_10, BorderLayout.SOUTH);
		p_all_tk_luong_10.add(thongKeluong_top_10, BorderLayout.NORTH);
		p_all_tk_luong_10.add(thongKeluong_bottom_10, BorderLayout.SOUTH);
		p_all_tk_luong_10.add(p_chua_content_thongKeluong_10, BorderLayout.CENTER);
		p_all_tk_luong_10.add(thongKeluong_left_10, BorderLayout.WEST);
		p_all_tk_luong_10.add(thongKeluong_right_10, BorderLayout.EAST);
		// -----------------------------------------------------------------------------
		// --------------------------THỐNG KÊ LƯƠNG THÁNG
		// 11--------------------------------
		JPanel p_all_tk_luong_11 = new JPanel();
		p_all_tk_luong_11.setLayout(new BorderLayout());
		p_all_tk_luong_11.setBackground(Color.WHITE);
		JLabel thongKeluong_top_11 = new JLabel();
		thongKeluong_top_11.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/t11.png")));
		JLabel thongKeluong_bottom_11 = new JLabel();
		thongKeluong_bottom_11.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_bottom.png")));
		JLabel thongKeluong_left_11 = new JLabel();
		thongKeluong_left_11.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JLabel thongKeluong_right_11 = new JLabel();
		thongKeluong_right_11.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JPanel p_content_thongKeluong_11 = new JPanel();
		p_content_thongKeluong_11.setBackground(Color.WHITE);
		p_content_thongKeluong_11.setLayout(new GridLayout(3, 4));
		JPanel p_chua_content_thongKeluong_11 = new JPanel();
		p_chua_content_thongKeluong_11.setLayout(new BorderLayout());
		p_chua_content_thongKeluong_11.setBackground(Color.WHITE);
		JPanel p_chua_button_thongKeluong_11 = new JPanel();
		p_chua_button_thongKeluong_11.setLayout(new GridLayout(2, 0));
		p_chua_button_thongKeluong_11.setBackground(Color.WHITE);
		JLabel space_luong_11 = new JLabel();
		JPanel p_button_thongKeluong_11 = new JPanel();
		p_button_thongKeluong_11.setLayout(new GridLayout(0, 6));
		p_button_thongKeluong_11.setBackground(Color.WHITE);
		b_pieChart_11 = new JButton("Biểu đồ");
		b_pieChart_11.setBackground(Color.CYAN);
		b_pieChart_11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String avgluong = cn.AvgLuong(11, 2021);
				Double luongBacCao = Double.parseDouble(avgluong) + 1500000;
				Double luongBacThap = Double.parseDouble(avgluong) - 1500000;
				double LuongThap = cn.LuongThap(11, 2021, luongBacThap);
				double LuongTB = cn.LuongTrungBinh(11, 2021, luongBacThap, luongBacCao);
				double LuongCao = cn.LuongCao(11, 2021, luongBacCao);
				cn.BieuDo(LuongThap, LuongTB, LuongCao);
			}

		});
		b_thoat_tk_luong_11 = new JButton("Thoát");
		b_thoat_tk_luong_11.setBackground(Color.CYAN);
		b_thoat_tk_luong_11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "3");
			}

		});
		b_thoat_tk_luong_11.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_exit.png")));
		JLabel b_emty_tkluong11_1 = new JLabel();
		JLabel b_emty_tkluong11_2 = new JLabel();
		JLabel b_emty_tkluong11_4 = new JLabel();
		JLabel b_emty_tkluong11_3 = new JLabel();
		p_button_thongKeluong_11.add(b_emty_tkluong11_1);
		p_button_thongKeluong_11.add(b_emty_tkluong11_2);
		p_button_thongKeluong_11.add(b_pieChart_11);
		p_button_thongKeluong_11.add(b_thoat_tk_luong_11);
		p_button_thongKeluong_11.add(b_emty_tkluong11_4);
		p_button_thongKeluong_11.add(b_emty_tkluong11_3);
		p_chua_button_thongKeluong_11.add(space_luong_11);
		p_chua_button_thongKeluong_11.add(p_button_thongKeluong_11);
		JLabel luongCaoNhat11 = new JLabel("Lương cao nhất: ", 0);
		r_maxLuong11 = new JLabel();
		luongCaoNhat11.setFont(f);
		r_maxLuong11.setFont(f);
		JLabel luongThapNhat11 = new JLabel("Lương thấp nhất: ", 0);
		r_minLuong11 = new JLabel();
		luongThapNhat11.setFont(f);
		r_minLuong11.setFont(f);
		JLabel luongBacCao11 = new JLabel("Lương bậc cao: ", 0);
		r_luongBacCao11 = new JLabel();
		luongBacCao11.setFont(f);
		r_luongBacCao11.setFont(f);
		JLabel luongBacThap11 = new JLabel("Lương bậc thấp: ", 0);
		r_luongBacThap11 = new JLabel();
		luongBacThap11.setFont(f);
		r_luongBacThap11.setFont(f);
		JLabel tongLuong11 = new JLabel("Tổng lương nhân sự: ", 0);
		r_sumLuong11 = new JLabel();
		tongLuong11.setFont(f);
		r_sumLuong11.setFont(f);
		JLabel luongTrungBinh11 = new JLabel("Lương trung bình: ", 0);
		r_avgLuong11 = new JLabel();
		luongTrungBinh11.setFont(f);
		r_avgLuong11.setFont(f);

		p_content_thongKeluong_11.add(luongCaoNhat11);
		p_content_thongKeluong_11.add(r_maxLuong11);
		p_content_thongKeluong_11.add(luongThapNhat11);
		p_content_thongKeluong_11.add(r_minLuong11);
		p_content_thongKeluong_11.add(luongBacCao11);
		p_content_thongKeluong_11.add(r_luongBacCao11);
		p_content_thongKeluong_11.add(luongBacThap11);
		p_content_thongKeluong_11.add(r_luongBacThap11);
		p_content_thongKeluong_11.add(luongTrungBinh11);
		p_content_thongKeluong_11.add(r_avgLuong11);
		p_content_thongKeluong_11.add(tongLuong11);
		p_content_thongKeluong_11.add(r_sumLuong11);

		p_chua_content_thongKeluong_11.add(p_content_thongKeluong_11, BorderLayout.CENTER);
		p_chua_content_thongKeluong_11.add(p_chua_button_thongKeluong_11, BorderLayout.SOUTH);
		p_all_tk_luong_11.add(thongKeluong_top_11, BorderLayout.NORTH);
		p_all_tk_luong_11.add(thongKeluong_bottom_11, BorderLayout.SOUTH);
		p_all_tk_luong_11.add(p_chua_content_thongKeluong_11, BorderLayout.CENTER);
		p_all_tk_luong_11.add(thongKeluong_left_11, BorderLayout.WEST);
		p_all_tk_luong_11.add(thongKeluong_right_11, BorderLayout.EAST);
		// -----------------------------------------------------------------------------
		// --------------------------THỐNG KÊ LƯƠNG THÁNG
		// 12--------------------------------
		JPanel p_all_tk_luong_12 = new JPanel();
		p_all_tk_luong_12.setLayout(new BorderLayout());
		p_all_tk_luong_12.setBackground(Color.WHITE);
		JLabel thongKeluong_top_12 = new JLabel();
		thongKeluong_top_12.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/t12.png")));
		JLabel thongKeluong_bottom_12 = new JLabel();
		thongKeluong_bottom_12.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_bottom.png")));
		JLabel thongKeluong_left_12 = new JLabel();
		thongKeluong_left_12.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JLabel thongKeluong_right_12 = new JLabel();
		thongKeluong_right_12.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/tk_nv_left.png")));
		JPanel p_content_thongKeluong_12 = new JPanel();
		p_content_thongKeluong_12.setBackground(Color.WHITE);
		p_content_thongKeluong_12.setLayout(new GridLayout(3, 4));
		JPanel p_chua_content_thongKeluong_12 = new JPanel();
		p_chua_content_thongKeluong_12.setLayout(new BorderLayout());
		p_chua_content_thongKeluong_12.setBackground(Color.WHITE);
		JPanel p_chua_button_thongKeluong_12 = new JPanel();
		p_chua_button_thongKeluong_12.setLayout(new GridLayout(2, 0));
		p_chua_button_thongKeluong_12.setBackground(Color.WHITE);
		JLabel space_luong_12 = new JLabel();
		JPanel p_button_thongKeluong_12 = new JPanel();
		p_button_thongKeluong_12.setLayout(new GridLayout(0, 6));
		p_button_thongKeluong_12.setBackground(Color.WHITE);
		b_pieChart_12 = new JButton("Biểu đồ");
		b_pieChart_12.setBackground(Color.CYAN);
		b_pieChart_12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String avgluong = cn.AvgLuong(12, 2021);
				Double luongBacCao = Double.parseDouble(avgluong) + 1500000;
				Double luongBacThap = Double.parseDouble(avgluong) - 1500000;
				double luongThap = cn.LuongThap(12, 2021, luongBacThap);
				double luongTB = cn.LuongTrungBinh(12, 2021, luongBacThap, luongBacCao);
				double luongCao = cn.LuongCao(12, 2021, luongBacCao);
				cn.BieuDo(luongThap, luongTB, luongCao);
			}

		});
		b_thoat_tk_luong_12 = new JButton("Thoát");
		b_thoat_tk_luong_12.setBackground(Color.CYAN);
		b_thoat_tk_luong_12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "3");
			}

		});
		b_thoat_tk_luong_12.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_exit.png")));
		JLabel b_emty_tkluong12_1 = new JLabel();
		JLabel b_emty_tkluong12_2 = new JLabel();
		JLabel b_emty_tkluong12_4 = new JLabel();
		JLabel b_emty_tkluong12_3 = new JLabel();
		p_button_thongKeluong_12.add(b_emty_tkluong12_1);
		p_button_thongKeluong_12.add(b_emty_tkluong12_2);
		p_button_thongKeluong_12.add(b_pieChart_12);
		p_button_thongKeluong_12.add(b_thoat_tk_luong_12);
		p_button_thongKeluong_12.add(b_emty_tkluong12_4);
		p_button_thongKeluong_12.add(b_emty_tkluong12_3);
		p_chua_button_thongKeluong_12.add(space_luong_12);
		p_chua_button_thongKeluong_12.add(p_button_thongKeluong_12);
		JLabel luongCaoNhat12 = new JLabel("Lương cao nhất: ", 0);
		r_maxLuong12 = new JLabel();
		luongCaoNhat12.setFont(f);
		r_maxLuong12.setFont(f);
		JLabel luongThapNhat12 = new JLabel("Lương thấp nhất: ", 0);
		r_minLuong12 = new JLabel();
		luongThapNhat12.setFont(f);
		r_minLuong12.setFont(f);
		JLabel luongBacCao12 = new JLabel("Lương bậc cao: ", 0);
		r_luongBacCao12 = new JLabel();
		luongBacCao12.setFont(f);
		r_luongBacCao12.setFont(f);
		JLabel luongBacThap12 = new JLabel("Lương bậc thấp: ", 0);
		r_luongBacThap12 = new JLabel();
		luongBacThap12.setFont(f);
		r_luongBacThap12.setFont(f);
		JLabel tongLuong12 = new JLabel("Tổng lương nhân sự: ", 0);
		r_sumLuong12 = new JLabel();
		tongLuong12.setFont(f);
		r_sumLuong12.setFont(f);
		JLabel luongTrungBinh12 = new JLabel("Lương trung bình: ", 0);
		r_avgLuong12 = new JLabel();
		luongTrungBinh12.setFont(f);
		r_avgLuong12.setFont(f);

		p_content_thongKeluong_12.add(luongCaoNhat12);
		p_content_thongKeluong_12.add(r_maxLuong12);
		p_content_thongKeluong_12.add(luongThapNhat12);
		p_content_thongKeluong_12.add(r_minLuong12);
		p_content_thongKeluong_12.add(luongBacCao12);
		p_content_thongKeluong_12.add(r_luongBacCao12);
		p_content_thongKeluong_12.add(luongBacThap12);
		p_content_thongKeluong_12.add(r_luongBacThap12);
		p_content_thongKeluong_12.add(luongTrungBinh12);
		p_content_thongKeluong_12.add(r_avgLuong12);
		p_content_thongKeluong_12.add(tongLuong12);
		p_content_thongKeluong_12.add(r_sumLuong12);

		p_chua_content_thongKeluong_12.add(p_content_thongKeluong_12, BorderLayout.CENTER);
		p_chua_content_thongKeluong_12.add(p_chua_button_thongKeluong_12, BorderLayout.SOUTH);
		p_all_tk_luong_12.add(thongKeluong_top_12, BorderLayout.NORTH);
		p_all_tk_luong_12.add(thongKeluong_bottom_12, BorderLayout.SOUTH);
		p_all_tk_luong_12.add(p_chua_content_thongKeluong_12, BorderLayout.CENTER);
		p_all_tk_luong_12.add(thongKeluong_left_12, BorderLayout.WEST);
		p_all_tk_luong_12.add(thongKeluong_right_12, BorderLayout.EAST);
		// -----------------------------------------------------------------------------

		JPanel p_all = new JPanel();
		p_all.setLayout(new BorderLayout());
		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/img_anh_bia.png")));
		p_all.add(baoquat, BorderLayout.CENTER);
		p_card.add(p_all, "ttns");
		p_card.add(p_all_phongBan, "pb");
		p_card.add(img, "3");
		p_card.add(p_all_tangCa, "tc");
		p_card.add(p_all_luong, "luong");
		p_card.add(p_all_bonus, "bonus");
		p_card.add(p_all_phucap, "phucap");
		p_card.add(p_all_nghi_phep, "nghiphep");
		p_card.add(p_all_taikhoan, "qltk");
		p_card.add(p_all_taikhoan_chinhsua, "chinhsua");
		p_card.add(p_all_cv, "chucvu");
		p_card.add(p_all_tk_nv, "tknv");
		p_card.add(p_all_tk_luong_1, "tklt1");
		p_card.add(p_all_tk_luong_2, "tklt2");
		p_card.add(p_all_tk_luong_3, "tklt3");
		p_card.add(p_all_tk_luong_4, "tklt4");
		p_card.add(p_all_tk_luong_5, "tklt5");
		p_card.add(p_all_tk_luong_6, "tklt6");
		p_card.add(p_all_tk_luong_7, "tklt7");
		p_card.add(p_all_tk_luong_8, "tklt8");
		p_card.add(p_all_tk_luong_9, "tklt9");
		p_card.add(p_all_tk_luong_10, "tklt10");
		p_card.add(p_all_tk_luong_11, "tklt11");
		p_card.add(p_all_tk_luong_12, "tklt12");

		card.show(p_card, "3");

		JMenuBar menu_bar = new JMenuBar();
		// --------------------------------------------------------------------------------
		JMenu m_acc = new JMenu("Tài Khoản");
		JMenuItem m_ql_tk = new JMenuItem("Quản lí tài khoản", KeyEvent.VK_Q);
		m_ql_tk.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
		m_ql_tk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "qltk");

			}

		});
		JMenuItem m_dangXuat = new JMenuItem("Đăng Xuất", KeyEvent.VK_D);
		m_dangXuat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
		m_dangXuat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					DangXuat();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
		m_acc.add(m_ql_tk);
		m_acc.add(m_dangXuat);

		// --------------------------------------------------------------------------------
		JMenu m_in4 = new JMenu("Danh mục");
		JMenuItem m_input = new JMenuItem("Thông tin nhân sự", KeyEvent.VK_T);
		m_input.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
		m_input.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "ttns");
			}

		});

		m_in4.add(m_input);

		// --------------------------------------------------------------------------------
		JMenu m_thong_ke = new JMenu("Thống kê");
		JMenuItem m_nhanvien = new JMenuItem("Nhân viên");
		m_nhanvien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cn.ThongKeNhanVien();
				card.show(p_card, "tknv");

			}

		});
		JMenu m_luong = new JMenu("Lương");
		JMenuItem month1 = new JMenuItem("Tháng 1");
		month1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maxluong = cn.MaxLuong(1, 2021);
				String minluong = cn.MinLuong(1, 2021);
				String avgluong = cn.AvgLuong(1, 2021);
				String sumluong = cn.SumLuong(1, 2021);
				Double luongBacCao = Double.parseDouble(avgluong) + 1500000;
				Double luongBacThap = Double.parseDouble(avgluong) - 1500000;
				cn.ThongKeLuong(r_maxLuong, r_minLuong, r_avgLuong, r_sumLuong, maxluong, minluong, avgluong, sumluong);
				if (maxluong.equals("0") && minluong.equals("0") && avgluong.equals("0") && sumluong.equals("0")) {
					r_luongBacCao.setText("0");
					r_luongBacThap.setText("0");
				} else {
					r_luongBacCao.setText(luongBacCao + "");
					r_luongBacThap.setText(luongBacThap + "");
				}
				card.show(p_card, "tklt1");
			}

		});
		JMenuItem month2 = new JMenuItem("Tháng 2");
		month2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maxluong = cn.MaxLuong(2, 2021);
				String minluong = cn.MinLuong(2, 2021);
				String avgluong = cn.AvgLuong(2, 2021);
				String sumluong = cn.SumLuong(2, 2021);
				Double luongBacCao = Double.parseDouble(avgluong) + 1500000;
				Double luongBacThap = Double.parseDouble(avgluong) - 1500000;
				cn.ThongKeLuong(r_maxLuong2, r_minLuong2, r_avgLuong2, r_sumLuong2, maxluong, minluong, avgluong,
						sumluong);
				if (maxluong.equals("0") && minluong.equals("0") && avgluong.equals("0") && sumluong.equals("0")) {
					r_luongBacCao2.setText("0");
					r_luongBacThap2.setText("0");
				} else {
					r_luongBacCao2.setText(luongBacCao + "");
					r_luongBacThap2.setText(luongBacThap + "");
				}
				card.show(p_card, "tklt2");
			}

		});
		JMenuItem month3 = new JMenuItem("Tháng 3");
		month3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maxluong = cn.MaxLuong(3, 2021);
				String minluong = cn.MinLuong(3, 2021);
				String avgluong = cn.AvgLuong(3, 2021);
				String sumluong = cn.SumLuong(3, 2021);
				Double luongBacCao = Double.parseDouble(avgluong) + 1500000;
				Double luongBacThap = Double.parseDouble(avgluong) - 1500000;
				cn.ThongKeLuong(r_maxLuong3, r_minLuong3, r_avgLuong3, r_sumLuong3, maxluong, minluong, avgluong,
						sumluong);
				if (maxluong.equals("0") && minluong.equals("0") && avgluong.equals("0") && sumluong.equals("0")) {
					r_luongBacCao3.setText("0");
					r_luongBacThap3.setText("0");
				} else {
					r_luongBacCao3.setText(luongBacCao + "");
					r_luongBacThap3.setText(luongBacThap + "");
				}
				card.show(p_card, "tklt3");
			}

		});
		JMenuItem month4 = new JMenuItem("Tháng 4");
		month4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maxluong = cn.MaxLuong(4, 2021);
				String minluong = cn.MinLuong(4, 2021);
				String avgluong = cn.AvgLuong(4, 2021);
				String sumluong = cn.SumLuong(4, 2021);
				Double luongBacCao = Double.parseDouble(avgluong) + 1500000;
				Double luongBacThap = Double.parseDouble(avgluong) - 1500000;
				cn.ThongKeLuong(r_maxLuong4, r_minLuong4, r_avgLuong4, r_sumLuong4, maxluong, minluong, avgluong,
						sumluong);
				if (maxluong.equals("0") && minluong.equals("0") && avgluong.equals("0") && sumluong.equals("0")) {
					r_luongBacCao4.setText("0");
					r_luongBacThap4.setText("0");
				} else {
					r_luongBacCao4.setText(luongBacCao + "");
					r_luongBacThap4.setText(luongBacThap + "");
				}
				card.show(p_card, "tklt4");
			}

		});
		JMenuItem month5 = new JMenuItem("Tháng 5");
		month5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maxluong = cn.MaxLuong(5, 2021);
				String minluong = cn.MinLuong(5, 2021);
				String avgluong = cn.AvgLuong(5, 2021);
				String sumluong = cn.SumLuong(5, 2021);
				Double luongBacCao = Double.parseDouble(avgluong) + 1500000;
				Double luongBacThap = Double.parseDouble(avgluong) - 1500000;
				cn.ThongKeLuong(r_maxLuong5, r_minLuong5, r_avgLuong5, r_sumLuong5, maxluong, minluong, avgluong,
						sumluong);
				if (maxluong.equals("0") && minluong.equals("0") && avgluong.equals("0") && sumluong.equals("0")) {
					r_luongBacCao5.setText("0");
					r_luongBacThap5.setText("0");
				} else {
					r_luongBacCao5.setText(luongBacCao + "");
					r_luongBacThap5.setText(luongBacThap + "");
				}
				card.show(p_card, "tklt5");
			}

		});
		JMenuItem month6 = new JMenuItem("Tháng 6");
		month6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maxluong = cn.MaxLuong(6, 2021);
				String minluong = cn.MinLuong(6, 2021);
				String avgluong = cn.AvgLuong(6, 2021);
				String sumluong = cn.SumLuong(6, 2021);
				Double luongBacCao = Double.parseDouble(avgluong) + 1500000;
				Double luongBacThap = Double.parseDouble(avgluong) - 1500000;
				cn.ThongKeLuong(r_maxLuong6, r_minLuong6, r_avgLuong6, r_sumLuong6, maxluong, minluong, avgluong,
						sumluong);
				if (maxluong.equals("0") && minluong.equals("0") && avgluong.equals("0") && sumluong.equals("0")) {
					r_luongBacCao6.setText("0");
					r_luongBacThap6.setText("0");
				} else {
					r_luongBacCao6.setText(luongBacCao + "");
					r_luongBacThap6.setText(luongBacThap + "");
				}
				card.show(p_card, "tklt6");
			}

		});
		JMenuItem month7 = new JMenuItem("Tháng 7");
		month7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maxluong = cn.MaxLuong(7, 2021);
				String minluong = cn.MinLuong(7, 2021);
				String avgluong = cn.AvgLuong(7, 2021);
				String sumluong = cn.SumLuong(7, 2021);
				Double luongBacCao = Double.parseDouble(avgluong) + 1500000;
				Double luongBacThap = Double.parseDouble(avgluong) - 1500000;
				cn.ThongKeLuong(r_maxLuong7, r_minLuong7, r_avgLuong7, r_sumLuong7, maxluong, minluong, avgluong,
						sumluong);
				if (maxluong.equals("0") && minluong.equals("0") && avgluong.equals("0") && sumluong.equals("0")) {
					r_luongBacCao7.setText("0");
					r_luongBacThap7.setText("0");
				} else {
					r_luongBacCao7.setText(luongBacCao + "");
					r_luongBacThap7.setText(luongBacThap + "");
				}
				card.show(p_card, "tklt7");
			}

		});
		JMenuItem month8 = new JMenuItem("Tháng 8");
		month8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maxluong = cn.MaxLuong(8, 2021);
				String minluong = cn.MinLuong(8, 2021);
				String avgluong = cn.AvgLuong(8, 2021);
				String sumluong = cn.SumLuong(8, 2021);
				Double luongBacCao = Double.parseDouble(avgluong) + 1500000;
				Double luongBacThap = Double.parseDouble(avgluong) - 1500000;
				cn.ThongKeLuong(r_maxLuong8, r_minLuong8, r_avgLuong8, r_sumLuong8, maxluong, minluong, avgluong,
						sumluong);
				if (maxluong.equals("0") && minluong.equals("0") && avgluong.equals("0") && sumluong.equals("0")) {
					r_luongBacCao8.setText("0");
					r_luongBacThap8.setText("0");
				} else {
					r_luongBacCao8.setText(luongBacCao + "");
					r_luongBacThap8.setText(luongBacThap + "");
				}
				card.show(p_card, "tklt8");
			}

		});
		JMenuItem month9 = new JMenuItem("Tháng 9");
		month9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maxluong = cn.MaxLuong(9, 2021);
				String minluong = cn.MinLuong(9, 2021);
				String avgluong = cn.AvgLuong(9, 2021);
				String sumluong = cn.SumLuong(9, 2021);
				Double luongBacCao = Double.parseDouble(avgluong) + 1500000;
				Double luongBacThap = Double.parseDouble(avgluong) - 1500000;
				cn.ThongKeLuong(r_maxLuong9, r_minLuong9, r_avgLuong9, r_sumLuong9, maxluong, minluong, avgluong,
						sumluong);
				if (maxluong.equals("0") && minluong.equals("0") && avgluong.equals("0") && sumluong.equals("0")) {
					r_luongBacCao9.setText("0");
					r_luongBacThap9.setText("0");
				} else {
					r_luongBacCao9.setText(luongBacCao + "");
					r_luongBacThap9.setText(luongBacThap + "");
				}
				card.show(p_card, "tklt9");
			}

		});
		JMenuItem month10 = new JMenuItem("Tháng 10");
		month10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maxluong = cn.MaxLuong(10, 2021);
				String minluong = cn.MinLuong(10, 2021);
				String avgluong = cn.AvgLuong(10, 2021);
				String sumluong = cn.SumLuong(10, 2021);
				Double luongBacCao = Double.parseDouble(avgluong) + 1500000;
				Double luongBacThap = Double.parseDouble(avgluong) - 1500000;
				cn.ThongKeLuong(r_maxLuong10, r_minLuong10, r_avgLuong10, r_sumLuong10, maxluong, minluong, avgluong,
						sumluong);
				if (maxluong.equals("0") && minluong.equals("0") && avgluong.equals("0") && sumluong.equals("0")) {
					r_luongBacCao10.setText("0");
					r_luongBacThap10.setText("0");
				} else {
					r_luongBacCao10.setText(luongBacCao + "");
					r_luongBacThap10.setText(luongBacThap + "");
				}
				card.show(p_card, "tklt10");
			}

		});
		JMenuItem month11 = new JMenuItem("Tháng 11");
		month11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maxluong = cn.MaxLuong(11, 2021);
				String minluong = cn.MinLuong(11, 2021);
				String avgluong = cn.AvgLuong(11, 2021);
				String sumluong = cn.SumLuong(11, 2021);
				Double luongBacCao = Double.parseDouble(avgluong) + 1500000;
				Double luongBacThap = Double.parseDouble(avgluong) - 1500000;
				cn.ThongKeLuong(r_maxLuong11, r_minLuong11, r_avgLuong11, r_sumLuong11, maxluong, minluong, avgluong,
						sumluong);
				if (maxluong.equals("0") && minluong.equals("0") && avgluong.equals("0") && sumluong.equals("0")) {
					r_luongBacCao11.setText("0");
					r_luongBacThap11.setText("0");
				} else {
					r_luongBacCao11.setText(luongBacCao + "");
					r_luongBacThap11.setText(luongBacThap + "");
				}
				card.show(p_card, "tklt11");
			}

		});
		JMenuItem month12 = new JMenuItem("Tháng 12");
		month12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maxluong = cn.MaxLuong(12, 2021);
				String minluong = cn.MinLuong(12, 2021);
				String avgluong = cn.AvgLuong(12, 2021);
				String sumluong = cn.SumLuong(12, 2021);
				Double luongBacCao = Double.parseDouble(avgluong) + 1500000;
				Double luongBacThap = Double.parseDouble(avgluong) - 1500000;
				cn.ThongKeLuong(r_maxLuong12, r_minLuong12, r_avgLuong12, r_sumLuong12, maxluong, minluong, avgluong,
						sumluong);
				if (maxluong.equals("0") && minluong.equals("0") && avgluong.equals("0") && sumluong.equals("0")) {
					r_luongBacCao12.setText("0");
					r_luongBacThap12.setText("0");
				} else {
					r_luongBacCao12.setText(luongBacCao + "");
					r_luongBacThap12.setText(luongBacThap + "");
				}
				card.show(p_card, "tklt12");
			}

		});

		m_luong.add(month1);
		m_luong.add(month2);
		m_luong.add(month3);
		m_luong.add(month4);
		m_luong.add(month5);
		m_luong.add(month6);
		m_luong.add(month7);
		m_luong.add(month8);
		m_luong.add(month9);
		m_luong.add(month10);
		m_luong.add(month11);
		m_luong.add(month12);
		m_thong_ke.add(m_nhanvien);
		m_thong_ke.add(m_luong);
		// --------------------------------------------------------------------------------
		JMenu m_quan_li = new JMenu("Quản lí");
		JMenuItem m_phong_ban = new JMenuItem("Phòng ban", KeyEvent.VK_P);
		m_phong_ban.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
		m_phong_ban.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "pb");
			}

		});
		JMenuItem m_phu_cap = new JMenuItem("Phụ cấp", KeyEvent.VK_C);
		m_phu_cap.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
		m_phu_cap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "phucap");
			}

		});
		JMenuItem m_chucvu = new JMenuItem("Chức vụ", KeyEvent.VK_V);
		m_chucvu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
		m_chucvu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "chucvu");
			}

		});
		JMenuItem m_thuong = new JMenuItem("Thưởng", KeyEvent.VK_B);
		m_thuong.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_DOWN_MASK));
		m_thuong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "bonus");
			}

		});
		JMenuItem m_tangCa = new JMenuItem("Tăng ca", KeyEvent.VK_O);
		m_tangCa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
		m_tangCa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "tc");
			}

		});
		JMenuItem m_nghiPhep = new JMenuItem("Nghỉ phép", KeyEvent.VK_N);
		m_nghiPhep.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
		m_nghiPhep.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "nghiphep");
			}

		});
		JMenuItem m_bang_luong = new JMenuItem("Bảng lương", KeyEvent.VK_S);
		m_bang_luong.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
		m_bang_luong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(p_card, "luong");
			}

		});

		m_quan_li.add(m_phong_ban);
		m_quan_li.add(m_phu_cap);
		m_quan_li.add(m_thuong);
		m_quan_li.add(m_tangCa);
		m_quan_li.add(m_nghiPhep);
		m_quan_li.add(m_bang_luong);
		m_quan_li.add(m_chucvu);
		// --------------------------------------------------------------------------------
		menu_bar.add(m_acc);
		menu_bar.add(m_in4);
		menu_bar.add(m_thong_ke);
		menu_bar.add(m_quan_li);
		// --------------------------------THỐNG
		// KÊ------------------------------------------
		this.setLayout(new BorderLayout());
		this.add(menu_bar, BorderLayout.NORTH);
		this.add(p_card, BorderLayout.CENTER);
	}

	public void Exit() {
		this.setVisible(false);
	}

	public void DangXuat() throws ClassNotFoundException {
		TaiKhoanDangNhapGanDay dn = new TaiKhoanDangNhapGanDay();
		Exit();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ArrayList<QuanLiTaiKhoan> list = new ArrayList<QuanLiTaiKhoan>();
		new ViewQuanLi(list);
	}

}
