package View;

import javax.swing.*;

import Model.TaiKhoanDangNhapGanDay;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class QuenMatKhauView extends JFrame {

	private JTextField t_email;
	private JButton b_timKiem;
	private JButton b_huy;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public QuenMatKhauView() throws ClassNotFoundException {
		connect_java();
		this.setting();
		this.setVisible(true);
	}

	public void setting() {
		// -------------Thiết lập Cửa sổ-------------------------------------
		this.setTitle("TÌM TÀI KHOẢN");
		this.setSize(500, 278);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		Font font = new Font("Arial", Font.BOLD, 18);

		// -------------Sắp xếp các thành phần-------------------------------
		JPanel p_all = new JPanel();
		p_all.setLayout(new BorderLayout());
		JPanel p_center = new JPanel();
		p_center.setLayout(new GridLayout(6, 0));
		JPanel p_button = new JPanel();
		p_button.setLayout(new GridLayout(1, 4));

		// -----------------Tiêu đề------------------------------------------
		JLabel e = new JLabel();
		JLabel e1 = new JLabel();
		JLabel e2 = new JLabel();
		JLabel e3 = new JLabel();
		JLabel e4 = new JLabel();
		JLabel e5 = new JLabel();
		JLabel left = new JLabel();
		left.setIcon(new ImageIcon(QuenMatKhauView.class.getResource("/img/left_qmk.png")));
		JLabel right = new JLabel();
		right.setIcon(new ImageIcon(QuenMatKhauView.class.getResource("/img/left_qmk.png")));

		JLabel title = new JLabel();
		title.setIcon(new ImageIcon(QuenMatKhauView.class.getResource("/img/title_qmk.png")));
		JLabel chu_thich = new JLabel("Vui lòng nhập email để tìm kiếm tài khoản.", 0);
		chu_thich.setFont(font);
		// -----------------TextField----------------------------------------
		t_email = new JTextField(50);

		// --------------------BUTTON----------------------------------------

		b_timKiem = new JButton("TÌM");
		b_timKiem.setBackground(Color.CYAN);
		b_timKiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					SearchAccount();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
				}
			}

		});
		b_timKiem.setIcon(new ImageIcon(QuenMatKhauView.class.getResource("/img/icon_search.png")));
		b_huy = new JButton("TRỞ VỀ");
		b_huy.setBackground(Color.CYAN);
		b_huy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					try {
						TaiKhoanDangNhapGanDay dn = new TaiKhoanDangNhapGanDay();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Exit();
			}
			
		});
		b_huy.setIcon(new ImageIcon(QuenMatKhauView.class.getResource("/img/icon_exit.png")));
		p_button.add(e1);
		p_button.add(b_huy);
		p_button.add(b_timKiem);
		p_button.add(e);
		p_center.add(e3);
		p_center.add(chu_thich);
		p_center.add(t_email);
		p_center.add(e2);
		p_center.add(e4);
		p_center.add(p_button);

		p_all.add(title, BorderLayout.NORTH);
		p_all.add(p_center, BorderLayout.CENTER);
		p_all.add(e4, BorderLayout.SOUTH);
		p_all.add(left, BorderLayout.WEST);
		p_all.add(right, BorderLayout.EAST);
		this.add(p_all);

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

	public void SearchAccount() throws SQLException {
		String sql = "SELECT dbo.SEARCH('" + t_email.getText() + "')";
		
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String user = rs.getString(1) + " có phải tài khoản của bạn không?";
				if (rs.getString(1) != null) {
					int a = JOptionPane.showConfirmDialog(this, user);
					if (a == JOptionPane.YES_OPTION) {
						MK();
					}
				}
				else {
					JOptionPane.showMessageDialog(this, "Email không tồn tại", "Thông báo", JOptionPane.WARNING_MESSAGE);
				}
			}
		
	}

	public void MK() throws SQLException {
		String sql = "SELECT dbo.MK('" + t_email.getText() + "')";
	
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				String pass = "Đây là mật khẩu của bạn: " + rs.getString(1);
				JOptionPane.showMessageDialog(this, pass);

			}
	}
	public void Exit() {
		this.setVisible(false);
	}

}
