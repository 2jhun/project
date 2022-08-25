package project;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CusManage extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton deleteBtn, cancelBtn;
	private JTable table;
	private JScrollPane scrollPane;
	private JFrame f;
	private JPanel p;

	private String colNames[] = { "아이디", "비밀번호", "이름", "생일", "이메일", "전화번호", "주소" };
	private DefaultTableModel model = new DefaultTableModel(colNames, 0);
	private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/sqldb?useUnicode=true&serverTimezone=Asia/Seoul";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "my1234";

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public CusManage() {
		// 프레임
		f = new JFrame();
		f.setTitle("항공권 예약 시스템 - 관리자 메뉴(회원 관리)");
		f.setBounds(100, 100, 800, 600);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		f.setResizable(false);
		f.setLocationRelativeTo(null);

		// 패널
		p = new JPanel();
		f.add(p);
		p.setBounds(0, 0, 794, 571);
		p.setLayout(null);

		// 테이블
		setLayout(null);
		table = new JTable(model);
		table.addMouseListener(new JTableMouseListener());
		scrollPane = new JScrollPane(table);
		scrollPane.setSize(786, 500);
		p.add(scrollPane);

		// 버튼
		deleteBtn = new JButton();
		deleteBtn.setBounds(224, 510, 142, 39);
		deleteBtn.setText("회원 삭제");
		p.add(deleteBtn);

		cancelBtn = new JButton("취소");
		cancelBtn.setBounds(424, 510, 142, 39);
		p.add(cancelBtn);

		// 리스너
		deleteBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		select();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == deleteBtn) {
			deleteMember();
			JOptionPane.showMessageDialog(null, "회원삭제가 완료되었습니다.");
		} else if (e.getSource() == cancelBtn) {
			new Admin();
			f.dispose();
		}
	}

	private void select() {
		String sqlSelect = "SELECT * FROM MemberTBL ORDER BY userName ASC";

		try {
			MemberDAO dao = new MemberDAO();
			dao.DBConnection();
			con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			ps = con.prepareStatement(sqlSelect);
			rs = ps.executeQuery();

			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("userId"), rs.getString("userPw"), rs.getString("userName"),
						rs.getString("userBirth"), rs.getString("userEmail"), rs.getString("userTel"),
						rs.getString("userAddr") });
			}
		} catch (Exception e) {
			System.out.println("가져오기 실패");
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (Exception e) {
				System.out.println("종료 실패");
			}
		}
	}

	public boolean deleteMember() {
		boolean check = false;

		DefaultTableModel model2 = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();

		try {
			MemberDAO dao = new MemberDAO();
			con = dao.DBConnection();

			String sqlDelete = "DELETE FROM memberTBL WHERE userTel = ?";

			ps = con.prepareStatement(sqlDelete);
			ps.setString(1, (String) model2.getValueAt(row, 5));
			int rs1 = ps.executeUpdate();

			if (rs1 > 0) {
				System.out.println("삭제 성공");
				check = true;
			} else
				System.out.println("삭제 실패");
		} catch (Exception ee) {
			System.out.println("삭제 진짜 실패");
		}
		model2.setRowCount(0);
		select();
		return check;
	}

	private class JTableMouseListener implements MouseListener {
		public void mouseClicked(java.awt.event.MouseEvent e) {
			JTable jtable = (JTable) e.getSource();
			int row = jtable.getSelectedRow();
			int col = jtable.getSelectedColumn();

			System.out.println(model.getValueAt(row, col));
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
	}
}