package project;

import java.awt.*;
import java.awt.event.*;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;

import javax.swing.*;

public class Non_MemberLogin extends JFrame implements ActionListener {
	private JFrame f;
	private JPanel p;
	private JLabel noMemLgL, telL1, telL2;
	private JButton loginBtn, backBtn, homeBtn;
	private JTextField telF1, telF2, telF3;
	private JPasswordField pwF;
	private JLabel telL;
	private JLabel pwL;
	private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/sqldb?useUnicode=true&serverTimezone=Asia/Seoul";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "my1234";

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public Non_MemberLogin() {
		// 프레임
		f = new JFrame();
		f.setTitle("항공권 예약 시스템 - 비회원 로그인");
		f.setBounds(100, 100, 800, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		f.setResizable(false);
		f.setLocationRelativeTo(null);

		// 패널
		p = new JPanel();
		p.setBounds(0, 0, 794, 571);
		f.getContentPane().add(p);
		p.setLayout(null);

		// 제목
		noMemLgL = new JLabel("NON_MEMBER LOGIN");
		noMemLgL.setFont(new Font("굴림", Font.BOLD, 42));
		noMemLgL.setBounds(113, 125, 446, 67);
		p.add(noMemLgL);

		// 핸드폰 번호
		telL = new JLabel("핸드폰 번호 : ");
		telL.setFont(new Font("함초롬돋움", Font.BOLD, 18));
		telL.setBounds(124, 243, 122, 48);
		telL.setHorizontalAlignment(SwingConstants.CENTER);
		p.add(telL);

		telF1 = new JTextField();
		telF1.setColumns(10);
		telF1.setBounds(258, 243, 63, 48);
		p.add(telF1);
		telL1 = new JLabel("-");
		telL1.setBounds(328, 259, 17, 15);
		p.add(telL1);

		telF2 = new JTextField();
		telF2.setColumns(10);
		telF2.setBounds(341, 243, 63, 48);
		p.add(telF2);
		telL2 = new JLabel("-");
		telL2.setBounds(410, 259, 17, 15);
		p.add(telL2);

		telF3 = new JTextField();
		telF3.setColumns(10);
		telF3.setBounds(423, 243, 63, 48);
		p.add(telF3);

		// 비밀번호
		pwL = new JLabel("PW : ");
		pwL.setFont(new Font("함초롬돋움", Font.BOLD, 18));
		pwL.setBounds(183, 308, 63, 48);
		pwL.setHorizontalAlignment(SwingConstants.CENTER);
		p.add(pwL);
		pwF = new JPasswordField();
		pwF.setColumns(12);
		pwF.setBounds(258, 313, 228, 48);
		p.add(pwF);

		// 버튼
		loginBtn = new JButton("로그인");
		loginBtn.setBounds(511, 243, 122, 118);
		loginBtn.setFont(new Font("안상수2006가는", Font.BOLD, 30));
		p.add(loginBtn);

		homeBtn = new JButton("");
		homeBtn.setSelectedIcon(new ImageIcon("./image/homeBtn.png"));
		homeBtn.setIcon(new ImageIcon("./image/homeBtn.png"));
		homeBtn.setBounds(729, 20, 41, 39);
		p.add(homeBtn);

		backBtn = new JButton("<");
		backBtn.setBounds(26, 500, 41, 39);
		p.add(backBtn);

		f.setVisible(true);

		// 리스너
		loginBtn.addActionListener(this);
		homeBtn.addActionListener(this);
		backBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginBtn) {
			non_MemLogin();
		} else if (e.getSource() == backBtn) {
			new Login();
			f.dispose();
		} else if (e.getSource() == homeBtn) {
			new MainUI();
			f.dispose();
		}
	}

	// 비회원 로그인
	public void non_MemLogin() {
		String sqlLogin = "SELECT userPw FROM memberTBL WHERE userTel = ?";

		if (telF1.getText().equals("") || telF2.getText().equals("") || telF3.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "핸드폰 번호를 입력하세요");
			return;
		} else if (pwF.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요");
			return;
		}

		try {
			String userTel = telF1.getText() + "-" + telF2.getText() + "-" + telF3.getText();
			MemberDAO dao = new MemberDAO();
			dao.DBConnection();
			con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			ps = con.prepareStatement(sqlLogin);
			ps.setString(1, userTel);
			rs = ps.executeQuery();

			if (rs.next()) {
				if (rs.getString(1).contentEquals(SHA512(pwF.getText()))) {
					JOptionPane.showMessageDialog(null, "로그인 완료");
					new ReserveMainP();
					f.dispose();
				} else
					JOptionPane.showMessageDialog(null, "핸드폰 번호/비밀번호가 틀렸습니다");
			}
		} catch (Exception e) {
			System.out.println("로그인 실패");
		}
	}

	// SHA512 암호화
	public static String SHA512(String userPw) {
		String encPw = null;
		try {
			for (int i = 0; i < 3; i++) {
				// SHA-512 내장 메소드 사용 어떤식으로 암호화 처리 되는지는 알 수 없음
				MessageDigest md = MessageDigest.getInstance("SHA-512");
				byte[] bytes = userPw.getBytes(Charset.forName("UTF-8"));
				md.update(bytes); // 암호화 처리된 게 bytes안에 있음

				// 암호화 처리된 게 문자열로 바뀜
				encPw = Base64.getEncoder().encodeToString(md.digest());
			}
		} catch (NoSuchAlgorithmException e) {
			System.out.println("암호화 실패");
		}
		return encPw;
	}
}