package project;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Confirm_reserve extends JFrame implements ActionListener, MouseListener {

	private JFrame f;
	private JPanel p;
	private JButton btn_rManage, btn_cancel;
	private JTable table;
	private JScrollPane scroll;
	private JLabel lb;
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/sqldb?useUnicode=true&serverTimezone=Asia/Seoul";
	private static final String USER = "root";
	private static final String PW = "my1234";
	static String[] s = new String[9];
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

//   String flight; 

	String[] f_Col = { "예약번호", "출발지", "도착지", "날짜", "출발시간", "도착시간", "좌석", "인원", "가격" };
	DefaultTableModel model = new DefaultTableModel(f_Col, 0) {
		@Override
		public boolean isCellEditable(int row, int column) { // 내용 변경 불가
			return false;
		};
	};

	public Confirm_reserve() {

		f = new JFrame();
		f.setTitle("예약확인");
		f.getContentPane().setBackground(Color.WHITE);
		f.getContentPane().setLayout(null);
		f.setBackground(Color.WHITE);
		f.setBounds(100, 100, 800, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setVisible(true);

		p = new JPanel();
		p.setBounds(0, 0, 794, 571);
		f.getContentPane().add(p);
		p.setLayout(null);

		JLabel check = new JLabel("예약된 항공권");
		check.setBounds(35, 24, 129, 15);
		check.setFont(new Font("굴림", Font.BOLD, 16));
		p.add(check);

		table = new JTable(model);
		table.setBackground(SystemColor.window);
		scroll = new JScrollPane(table);
		scroll.setBounds(35, 59, 725, 300);
		p.add(scroll);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 한 줄만 선택가능

		btn_rManage = new JButton("예약관리");
		btn_rManage.setBounds(272, 436, 90, 36);
		p.add(btn_rManage);

		btn_cancel = new JButton("취소");
		btn_cancel.setBounds(399, 438, 90, 36);
		p.add(btn_cancel);

		btn_rManage.addActionListener(this);
		btn_cancel.addActionListener(this);
		table.addMouseListener(this);
		select();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_rManage) {
			new F_cancel();
			f.dispose();
		} else if (e.getSource() == btn_cancel) {
			f.dispose();
			new ReserveMainP();
		}
	}

	private void select() {
		String sqlSelect = "SELECT * FROM ReserveTBL where userTel = ? ORDER BY date ASC";
//      String sqlSelect = "SELECT * FROM ReserveTBL ORDER BY date ASC";

		try {
			MemberDAO dao = new MemberDAO();
			dao.DBConnection();
			con = DriverManager.getConnection(URL, USER, PW);
			ps = con.prepareStatement(sqlSelect);
			ps.setString(1, Save_tel.tel);
			System.out.println(ps);
			rs = ps.executeQuery();
			System.out.println(model);
			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("reserveNum"), rs.getString("departure"),
						rs.getString("destination"), rs.getString("date"), rs.getString("depT"), rs.getString("arrT"),
						rs.getString("seat"), rs.getString("people"), rs.getString("price") });
			}
//         rs.beforeFirst();
//         while (rs.next()) {
//            flight = rs.getString("departure");
//         }
		} catch (Exception e) {
			e.printStackTrace();
//         System.out.println(e);
			System.out.println("가져오기 실패");
		} finally {
			try { // 역순으로 반드시 닫기
				rs.close();
				ps.close();
				con.close();
			} catch (Exception e) {
				System.out.println("종료 실패");
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		int col = table.getSelectedColumn();
		for (int i = 0; i < table.getColumnCount(); i++) {
//         String[] s = new String[7];
//         System.out.print(table.getModel().getValueAt(row, i) + "\t");
			s[i] = table.getModel().getValueAt(row, i) + "";
		}
//      System.out.println();
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	public static void main(String[] args) {
		new Confirm_reserve();
	}

}