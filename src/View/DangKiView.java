package View;

import javax.swing.*;

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

public class DangKiView extends JFrame {
	private JTextField t_user_name;
	private JPasswordField t_pass;
	private JButton button_dangNhap;
	private JButton button_dangKi;
	private JPasswordField t_re_pass;
	private JTextField t_hoTen;
	private JRadioButton radio_nam;
	private JRadioButton radio_nu;
	private JButton b_exit;
	private JTextField t_mail;
	private ArrayList<QuanLiTaiKhoan> list;
	Connection con;
	Statement stmt;
	ResultSet rs;
	private JCheckBox show_pass;
	public DangKiView(ArrayList<QuanLiTaiKhoan> list) throws ClassNotFoundException {
		this.list = list;
		connect_java();
		this.setting();
		this.setVisible(true);
	}
	
	public void setting() {
		this.setTitle("Đăng Kí Tài Khoản");
		this.setSize(850, 540);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	
		JPanel p_dangKi = new JPanel();
		p_dangKi.setLayout(new GridLayout(0, 2));
		JLabel banner_dangNhap = new JLabel("");
		banner_dangNhap.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/bia_dangki_2.png")));
		//------------------------SAP XEP CAC THANH PHAN VA TRANG TRI-------------------------------------------------------
		JPanel form_dangKi = new JPanel();
		form_dangKi.setLayout(new BorderLayout());
		JLabel title_form = new JLabel("ĐĂNG KÍ TÀI KHOẢN");
		title_form.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/banner_3.png")));
		form_dangKi.add(title_form, BorderLayout.NORTH);
		JPanel center = new JPanel();
		center.setLayout(new BorderLayout());
		JPanel vuong = new JPanel();
		vuong.setLayout(new BorderLayout());
		JLabel trai = new JLabel();
		JLabel phai = new JLabel();
		vuong.add(trai, BorderLayout.WEST);
		trai.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/vuong.png")));
		vuong.add(title_form, BorderLayout.CENTER);
		vuong.add(phai, BorderLayout.EAST);
		phai.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/vuong.png")));
		JLabel top = new JLabel();
		top.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/top_dk.png")));
		JLabel bottom = new JLabel();
		bottom.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/top_dk.png")));
		JLabel left = new JLabel();
		left.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/left_dk.png")));
		JLabel right = new JLabel();
		right.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/left_dk.png")));
		form_dangKi.add(top, BorderLayout.NORTH);
		center.add(vuong, BorderLayout.NORTH);
		center.add(bottom, BorderLayout.SOUTH);
		center.add(left, BorderLayout.WEST);		
		center.add(right, BorderLayout.EAST);
		button_dangKi = new JButton("ĐĂNG KÍ");
		button_dangKi.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_signup_1.png")));
		button_dangKi.setBackground(Color.YELLOW);
		button_dangKi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (t_hoTen.getText().equals("") || t_pass.getText().equals("") || t_re_pass.getText().equals("")
					|| t_mail.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Các thông tin không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
				}
				else if (t_pass.getText().equals(t_re_pass.getText())) {
					ThemTaiKhoan();
				}
				else {
					JOptionPane.showMessageDialog(null, "Mật khẩu không khớp!");
				}
				
				
			}
			
		});
		b_exit = new JButton("TRỞ VỀ");
		b_exit.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_back.png")));
		b_exit.setBackground(Color.YELLOW);
		b_exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Back();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		JPanel content_c = new JPanel();
		content_c.setLayout(new BorderLayout());
		JPanel trangTri = new JPanel();
		trangTri.setLayout(new BorderLayout());
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(14, 0));
		JLabel hoTen = new JLabel("HỌ VÀ TÊN");
		hoTen.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_name.png")));
		JLabel gioiTinh = new JLabel("GIỚI TÍNH");
		t_hoTen = new JTextField(50);
		radio_nam = new JRadioButton("NAM");
		radio_nu = new JRadioButton("NỮ");
		ButtonGroup bg=new ButtonGroup();    
		bg.add(radio_nam);bg.add(radio_nu);  
		JPanel button_gender = new JPanel();
		button_gender.setLayout(new GridLayout(1, 3));
		button_gender.add(gioiTinh);button_gender.add(radio_nam); button_gender.add(radio_nu);
		
		JLabel e = new JLabel();
		JLabel e1 = new JLabel();
		JLabel email = new JLabel("EMAIL");
		t_mail = new JTextField(50);
		email.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_mail.png")));
		JLabel user_name = new JLabel("TÊN ĐĂNG NHẬP");
		user_name.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_user.png")));
		JLabel password = new JLabel("MẬT KHẨU MỚI");
		password.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_key.png")));
		JLabel re_password = new JLabel("NHẬP LẠI MẬT KHẨU");
		re_password.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/icon_key.png")));
		t_user_name = new JTextField(50);
		t_pass = new JPasswordField(50);
		t_re_pass = new JPasswordField(50);
		show_pass = new JCheckBox("Hiển thị mật khẩu");
		show_pass.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				hienThi_MatKhau();
			}
			
		});
		JPanel p_button = new JPanel();
		p_button.setLayout(new GridLayout(1, 2));
		p_button.add(button_dangKi); p_button.add(b_exit);
		content.add(hoTen); content.add(t_hoTen); 
		content.add(email); content.add(t_mail); 
		content.add(user_name); content.add(t_user_name); 
		content.add(button_gender);content.add(password); content.add(t_pass); 
		content.add(re_password); content.add(t_re_pass);content.add(show_pass); content.add(p_button);content.add(e1);

		content_c.add(content, BorderLayout.NORTH);
		JLabel top_1 = new JLabel();
		top_1.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/top_2.png")));
		JLabel bottom_1 = new JLabel();
		bottom_1.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/top_2.png")));
		JLabel left_1 = new JLabel();
		left_1.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/left_2.png")));
		JLabel right_1 = new JLabel();
		right_1.setIcon(new ImageIcon(ViewQuanLi.class.getResource("/img/left_2.png")));
				
		//------------------------THEM CAC THANH PHAN VAO CUA SO-------------------------------------------------
		trangTri.add(top_1, BorderLayout.NORTH);
		trangTri.add(bottom_1, BorderLayout.SOUTH);
		trangTri.add(left_1, BorderLayout.WEST);		
		trangTri.add(right_1, BorderLayout.EAST);
		trangTri.add(content, BorderLayout.CENTER);
		center.add(trangTri, BorderLayout.CENTER);
		form_dangKi.add(center, BorderLayout.CENTER);
		p_dangKi.add(banner_dangNhap);
		p_dangKi.add(form_dangKi);
		
		this.add(p_dangKi);
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
	public void hienThi_MatKhau() {
		if (show_pass.isSelected()) {
			t_pass.setEchoChar((char)0);
			t_re_pass.setEchoChar((char)0);
		}
		else {
			t_pass.setEchoChar('•');
			t_re_pass.setEchoChar('•');
		}
	}
	public void ThemTaiKhoan() {
		try {
			String GioiTinh ="";
			if(radio_nam.isSelected()) {
				GioiTinh = "Nam";
			}
			else if (radio_nu.isSelected()) {
				GioiTinh = "Nữ";
			}
			else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính.");
			}
			
			
				String sql = "EXEC DKI_TAIKHOAN "+"N'"+t_hoTen.getText()+"'"+","
						+"'"+t_mail.getText()+"'"+","+"N'"+GioiTinh+"'"+","+
						"'"+t_user_name.getText()+"'"+","+"'"+t_pass.getText()+"'";
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(this, "Đăng kí thành công");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Đăng kí không thành công", "Thông báo", JOptionPane.WARNING_MESSAGE);
		}
	}
	public void Back() throws ClassNotFoundException {
		TaiKhoanDangNhapGanDay dn;
			dn = new TaiKhoanDangNhapGanDay();
			Exit();
		
	}
	
	public void Exit() {
		this.setVisible(false);
	}

}