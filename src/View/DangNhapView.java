package View;

import javax.swing.*;

import Controller.ChucNang;
import Model.QuanLiTaiKhoan;
import Model.TaiKhoanDangNhapGanDay;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DangNhapView extends JFrame {
	private JTextField t_user_name;
	private JPasswordField t_pass;
	private JButton button_dangNhap;
	private JButton button_dangKi;
	private JCheckBox check;
	private JButton b_forget_password;
	private ArrayList<QuanLiTaiKhoan> list;
	private QuanLiTaiKhoan tk;
	Connection con;
	ResultSet rs;
	Statement stmt;

	public DangNhapView(ArrayList<QuanLiTaiKhoan> list) throws ClassNotFoundException {
		this.list = list;
		tk = new QuanLiTaiKhoan();
		connect_java();
		this.setting();
		this.setVisible(true);
	}

	public void setting() {
		this.setTitle("Đăng Nhập Tài Khoản");
		this.setSize(850, 540);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JPanel p_dangNhap = new JPanel();
		p_dangNhap.setLayout(new GridLayout(0, 2));
		JLabel banner_dangNhap = new JLabel("");
		banner_dangNhap.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/sign_up_1.png")));

		// ------------------------SAP XEP CAC THANH PHAN VA TRANG
		// TRI-------------------------------------------------------

		JPanel form_dangNhap = new JPanel();
		form_dangNhap.setLayout(new BorderLayout());
		JLabel title_form = new JLabel("ĐĂNG NHẬP TÀI KHOẢN");
		title_form.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/dangnhap.png")));
		form_dangNhap.add(title_form, BorderLayout.NORTH);
		JPanel center = new JPanel();
		center.setLayout(new BorderLayout());
		JLabel top = new JLabel();
		top.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/top.png")));
		JLabel bottom = new JLabel();
		bottom.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/top.png")));
		JLabel left = new JLabel();
		left.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/left.png")));
		JLabel right = new JLabel();
		right.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/left.png")));
		form_dangNhap.add(top, BorderLayout.NORTH);
		center.add(title_form, BorderLayout.NORTH);
		center.add(bottom, BorderLayout.SOUTH);
		center.add(left, BorderLayout.WEST);
		center.add(right, BorderLayout.EAST);
		JPanel button = new JPanel();
		button.setLayout(new GridLayout(1, 2));
		button_dangNhap = new JButton("ĐĂNG NHẬP");
		button_dangNhap.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_login_1.png")));
		button_dangNhap.setBackground(Color.YELLOW);
		button_dangNhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					addTaiKhoan();
					DangNhap();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		button_dangKi = new JButton("ĐĂNG KÍ");
		button_dangKi.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_signup_1.png")));
		button_dangKi.setBackground(Color.YELLOW);
		button_dangKi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				DangKiTaiKhoan();

			}

		});
		button.add(button_dangNhap);
		button.add(button_dangKi);
		JPanel content_c = new JPanel();
		content_c.setLayout(new BorderLayout());
		JPanel trangTri = new JPanel();
		trangTri.setLayout(new BorderLayout());
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(9, 0));
		JLabel e = new JLabel();
		JLabel e1 = new JLabel();
		JLabel user_name = new JLabel("TÊN ĐĂNG NHẬP");
		user_name.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_user.png")));
		JLabel password = new JLabel("MẬT KHẨU");
		password.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_key.png")));
		t_user_name = new JTextField(50);
		t_pass = new JPasswordField();
		JPanel p_show_pass = new JPanel();
		p_show_pass.setLayout(new GridLayout(3, 1));
		JLabel e2 = new JLabel();
		JLabel e3 = new JLabel();
		JPanel show = new JPanel();
		show.setLayout(new BorderLayout());
		b_forget_password = new JButton("Quên mật khẩu?");
		b_forget_password.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				QuenMatKhauView quen_matKhau;
				try {
					quen_matKhau = new QuenMatKhauView();
					quen_matKhau.setVisible(true);
					ExitMain();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Sự cố! Vui lòng thử lại", "Thông báo", JOptionPane.WARNING_MESSAGE);
				}
				
			}

		});
		JLabel show_password = new JLabel("Hiển thị mật khẩu");
		check = new JCheckBox();
		check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				hienThi_MatKhau();
			}

		});
		show.add(check, BorderLayout.WEST);
		show.add(show_password, BorderLayout.CENTER);
		content.add(user_name);
		content.add(t_user_name);
		content.add(password);
		content.add(t_pass);
		content.add(show);
		content.add(e3);
		content.add(b_forget_password);
		content.add(e3);
		content.add(button);
		content.add(e1);

		content_c.add(content, BorderLayout.NORTH);
		JLabel top_1 = new JLabel();
		top_1.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/top_2.png")));
		JLabel bottom_1 = new JLabel();
		bottom_1.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/top_2.png")));
		JLabel left_1 = new JLabel();
		left_1.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/left_2.png")));
		JLabel right_1 = new JLabel();
		right_1.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/left_2.png")));

		// ------------------------THEM CAC THANH PHAN VAO CUA
		// SO-------------------------------------------------

		trangTri.add(top_1, BorderLayout.NORTH);
		trangTri.add(bottom_1, BorderLayout.SOUTH);
		trangTri.add(left_1, BorderLayout.WEST);
		trangTri.add(right_1, BorderLayout.EAST);
		trangTri.add(content, BorderLayout.CENTER);
		center.add(trangTri, BorderLayout.CENTER);
		form_dangNhap.add(center, BorderLayout.CENTER);
		p_dangNhap.add(banner_dangNhap);
		p_dangNhap.add(form_dangNhap);

		this.add(p_dangNhap);
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

	public void DangNhap() throws SQLException, ClassNotFoundException {
		String bit = "0";
		String sql_user = "SELECT dbo.KIEMTRA ('" + t_user_name.getText() + "'" + "," + "'" + t_pass.getText() + "')";
		ResultSet rs = stmt.executeQuery(sql_user);
		while (rs.next()) {
			try {
				bit = rs.getString(1);
				if(bit.equals("1")) {
					JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
					ViewQuanLi v = new ViewQuanLi(this.list);
					v.setVisible(true);
					this.setVisible(false);
				}
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu không đúng, vui lòng thử lại", "Thông báo", JOptionPane.WARNING_MESSAGE);
			}
		}

	}
	public void addTaiKhoan() {
		String sql = "EXEC SHOW_TAIKHOAN '" + t_user_name.getText() + "'";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				tk.setHoTen(rs.getString(1));
				tk.setEmail(rs.getString(2));
				tk.setGioiTinh(rs.getString(3));
				tk.setTenDangNhap(rs.getString(4));
				tk.setMatKhau(rs.getString(5));
			}
			list.add(tk);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}

	public void hienThi_MatKhau() {
		if (check.isSelected()) {
			t_pass.setEchoChar((char) 0);
		} else {
			t_pass.setEchoChar('•');
		}
	}
	public void DangKiTaiKhoan() {
		DangKiView view;
		try {
			view = new DangKiView(this.list);
			view.setVisible(true);
			ExitMain();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
		}
	}

	public void ExitMain() {
		this.setVisible(false);
	}
	public static void main(String[] args) throws ClassNotFoundException {
		new TaiKhoanDangNhapGanDay();
	}
}