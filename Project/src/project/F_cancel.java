package project;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class F_cancel extends JFrame implements ActionListener {

	private JFrame f;
	private JPanel p;
	private JLabel lb_departure, lb_destination, lb_depDate, lb_arrDate, lb_seat, lb_people, lb_price;
	private JButton btn_cancel, btn_cReserve;
	private static final String URL = "jdbc:mysql://localhost:3306/sqldb?useUnicode=true&serverTimezone=Asia/Seoul";
	private static final String USER = "root";
	private static final String PW = "my1234";
	Connection con = null;
	ResultSet rs = null;

	public F_cancel() {
		f = new JFrame();
		f.setTitle("예약취소");
		f.getContentPane().setBackground(Color.WHITE);
		f.getContentPane().setLayout(null);
		f.setBounds(100, 100, 800, 600);

		JPanel p = new JPanel();
		p.setBounds(0, 0, 794, 571);
		f.getContentPane().add(p);
		p.setLayout(null);

		JLabel check = new JLabel("내 항공권 관리");
		check.setBounds(35, 24, 129, 15);
		check.setFont(new Font("굴림", Font.BOLD, 16));
		p.add(check);

		JLabel lb1 = new JLabel("출발지");
		lb1.setFont(new Font("굴림", Font.BOLD, 14));
		lb1.setBounds(45, 55, 85, 15);
		p.add(lb1);

		JLabel lb2 = new JLabel("도착지");
		lb2.setFont(new Font("굴림", Font.BOLD, 14));
		lb2.setBounds(326, 55, 85, 15);
		p.add(lb2);

		lb_departure = new JLabel();
		lb_departure.setFont(new Font("굴림", Font.BOLD, 14));
		lb_departure.setText(Confirm_reserve.s[1]);
		lb_departure.setBounds(45, 77, 182, 36);
		lb_departure.setToolTipText("");
		p.add(lb_departure);

		JLabel lb3 = new JLabel("→");
		lb3.setBounds(233, 77, 19, 27);
		lb3.setFont(new Font("굴림", Font.BOLD, 18));
		p.add(lb3);

		lb_destination = new JLabel();
		lb_destination.setFont(new Font("굴림", Font.BOLD, 14));
		lb_destination.setText(Confirm_reserve.s[2]);
		lb_destination.setBounds(326, 77, 182, 36);
		p.add(lb_destination);

		JLabel lb5 = new JLabel("출발시간");
		lb5.setFont(new Font("굴림", Font.BOLD, 14));
		lb5.setBounds(45, 137, 85, 15);
		p.add(lb5);

		JLabel lb6 = new JLabel("도착시간");
		lb6.setFont(new Font("굴림", Font.BOLD, 14));
		lb6.setBounds(326, 137, 85, 15);
		p.add(lb6);

		lb_depDate = new JLabel();
		lb_depDate.setFont(new Font("굴림", Font.BOLD, 14));
		lb_depDate.setText(Confirm_reserve.s[4]);
		lb_depDate.setBounds(45, 158, 182, 36);
		p.add(lb_depDate);

		lb_arrDate = new JLabel();
		lb_arrDate.setFont(new Font("굴림", Font.BOLD, 14));
		lb_arrDate.setText(Confirm_reserve.s[5]);
		lb_arrDate.setBounds(326, 158, 182, 36);
		p.add(lb_arrDate);

		JLabel lb7 = new JLabel("좌석");
		lb7.setFont(new Font("굴림", Font.BOLD, 14));
		lb7.setBounds(67, 229, 62, 15);
		p.add(lb7);

		lb_seat = new JLabel();
		lb_seat.setFont(new Font("굴림", Font.BOLD, 14));
		lb_seat.setText(Confirm_reserve.s[6]);
		lb_seat.setBounds(108, 219, 90, 36);
		p.add(lb_seat);

		JLabel lb8 = new JLabel("인원수");
		lb8.setFont(new Font("굴림", Font.BOLD, 14));
		lb8.setBounds(210, 229, 62, 15);
		p.add(lb8);

		lb_people = new JLabel();
		lb_people.setFont(new Font("굴림", Font.BOLD, 14));
		lb_people.setText(Confirm_reserve.s[7]);
		lb_people.setBounds(263, 219, 90, 36);
		p.add(lb_people);

		JLabel lb9 = new JLabel("가격");
		lb9.setFont(new Font("굴림", Font.BOLD, 14));
		lb9.setBounds(366, 229, 62, 15);
		p.add(lb9);

		lb_price = new JLabel();
		lb_price.setFont(new Font("굴림", Font.BOLD, 14));
		lb_price.setText(Confirm_reserve.s[8]);
		lb_price.setBounds(398, 219, 90, 36);
		p.add(lb_price);

		btn_cancel = new JButton("취소");
		btn_cancel.setBounds(289, 308, 90, 36);
		p.add(btn_cancel);

		btn_cReserve = new JButton("예약 취소");
		btn_cReserve.setBounds(162, 308, 90, 36);
		p.add(btn_cReserve);

		f.setBackground(Color.WHITE);
		f.setBounds(100, 100, 600, 405);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.getContentPane().setLayout(null);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setVisible(true);

		btn_cancel.addActionListener(this);
		btn_cReserve.addActionListener(this);
	}

	public void Delete() throws SQLException {

		String sqlDEL = "delete from reservetbl where usertel = ? and reservenum = ?";
//      String sqlDEL = "DELETE FROM reserveTbl where reserveNum = 1 ";

		MemberDAO dao = new MemberDAO();
		con = dao.DBConnection();
		PreparedStatement ps = con.prepareStatement(sqlDEL);
		ps.setString(1, Save_tel.tel);
		ps.setString(2, Confirm_reserve.s[0]);
		ps.executeUpdate();
		System.out.println(sqlDEL);

		ps.close();
		con.close();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_cReserve) {
			JOptionPane.showMessageDialog(null, "예약을 취소하시겠습니까?");
			try {
				Delete();
				new Confirm_reserve();
				f.dispose();
			} catch (SQLException e1) {
				System.out.println(e1);
			}

		} else if (e.getSource() == btn_cancel) {
			new Confirm_reserve();
			f.dispose();
		}

	}
}