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
import java.sql.SQLException;
import java.util.Base64;

import javax.swing.*;

import project.MainUI.ImagePanel;

public class Login extends JFrame implements ActionListener {
	private JFrame f;
	private JPanel p;
	private JLabel mainLgL;
	private JButton loginBtn, backBtn, joinBtn, noMemJoinBtn, noMemLgBtn, homeBtn;
	private JTextField idF;
	private JPasswordField pwF;
	private JLabel idL;
	private JLabel pwL;
	private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/sqldb?useUnicode=true&serverTimezone=Asia/Seoul";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "my1234";
	private final static String adminId = "Admin";
	private final static String adminPw = "admin1q2w3e4r@";

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public Login() {
		// 프레임
		f = new JFrame();
		f.setTitle("항공권 예약 시스템 - 로그인");
		f.setBounds(100, 100, 800, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setVisible(true);

		// 패널
		p = new JPanel();
		p.setBounds(0, 0, 794, 571);
		f.getContentPane().add(p);
		p.setLayout(null);

		// 제목
		mainLgL = new JLabel("MEMBER LOGIN");
		mainLgL.setFont(new Font("굴림", Font.BOLD, 42));
		mainLgL.setBounds(187, 111, 336, 67);
		p.add(mainLgL);

		// 아이디
		idL = new JLabel("ID : ");
		idL.setFont(new Font("함초롬돋움", Font.BOLD, 18));
		idL.setBounds(204, 211, 75, 48);
		idL.setHorizontalAlignment(SwingConstants.CENTER);
		p.add(idL);
		idF = new JTextField();
		idF.setBounds(291, 211, 195, 48);
		idF.setColumns(10);
		p.add(idF);

		// 비밀번호
		pwL = new JLabel("PW : ");
		pwL.setFont(new Font("함초롬돋움", Font.PLAIN, 18));
		pwL.setBounds(204, 281, 75, 48);
		pwL.setHorizontalAlignment(SwingConstants.CENTER);
		p.add(pwL);
		pwF = new JPasswordField();
		pwF.setColumns(12);
		pwF.setBounds(291, 282, 195, 48);
		p.add(pwF);

		// 버튼
		loginBtn = new JButton("로그인");
		loginBtn.setBounds(511, 211, 122, 118);
		loginBtn.setFont(new Font("안상수2006가는", Font.BOLD, 25));
		p.add(loginBtn);

		joinBtn = new JButton("회원가입");
		joinBtn.setBounds(204, 358, 122, 35);
		p.add(joinBtn);

		noMemJoinBtn = new JButton("비회원 가입");
		noMemJoinBtn.setBounds(360, 358, 122, 35);
		p.add(noMemJoinBtn);

		noMemLgBtn = new JButton("비회원 로그인");
		noMemLgBtn.setBounds(511, 358, 122, 35);
		p.add(noMemLgBtn);

		backBtn = new JButton("<");
		backBtn.setBounds(26, 500, 41, 39);
		p.add(backBtn);

		homeBtn = new JButton("");
		homeBtn.setSelectedIcon(new ImageIcon("./image/homeBtn.png"));
		homeBtn.setIcon(new ImageIcon("./image/homeBtn.png"));
		homeBtn.setBounds(729, 20, 41, 39);
		p.add(homeBtn);

		// 리스너
		loginBtn.addActionListener(this);
		joinBtn.addActionListener(this);
		noMemJoinBtn.addActionListener(this);
		noMemLgBtn.addActionListener(this);
		homeBtn.addActionListener(this);
		backBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginBtn) {
			login();
		} else if (e.getSource() == joinBtn) {
			new Join();
			f.dispose();
		} else if (e.getSource() == noMemJoinBtn) {
			new Non_MemberJoin();
			f.dispose();
		} else if (e.getSource() == noMemLgBtn) {
			new Non_MemberLogin();
			f.dispose();
		} else if (e.getSource() == backBtn) {
			new MainUI();
			f.dispose();
		} else if (e.getSource() == homeBtn) {
			new MainUI();
			f.dispose();
		}
	}

	// 로그인
	public void login() {
		String sqlLogin = "SELECT userPw FROM memberTBL WHERE userId = ?";

		if (idF.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
			return;
		} else if (pwF.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요");
			return;
		} else if (idF.getText().equals(adminId) && pwF.getText().equals(adminPw)) {
			JOptionPane.showMessageDialog(null, "관리자 로그인 성공");
			new Admin();
			f.dispose();
			return;
		} else if (idF.getText().equals("123") && pwF.getText().equals("123")) {
			JOptionPane.showMessageDialog(null, "�ҽ����Ͻÿ�.Ȧ���ڸ� �Է� �޾Ƽ� ��ڰ� 2�� ����̰ų� �Ǵ�5�� ���", "error",
					JOptionPane.ERROR_MESSAGE);
			JOptionPane.showMessageDialog(null, "???????????????????????", "error", JOptionPane.ERROR_MESSAGE);
			JOptionPane.showMessageDialog(null, "어떻게 찾았지ㅎㅎ", "error", JOptionPane.ERROR_MESSAGE);

			JFrame eggF = new JFrame();
			eggF.setTitle("ERROR");
			eggF.getContentPane().setLayout(null);
			eggF.setResizable(false);

			ImagePanel imgP = new ImagePanel(new ImageIcon("./image/egg.JPG").getImage());
			eggF.add(imgP);
			eggF.pack();

			JPanel eggP = new JPanel();
			eggP.setBounds(0, 0, 794, 571);
			eggF.getContentPane().add(eggP);
			eggP.setLayout(null);

			JLabel lblNewLabel = new JLabel("개발자 : 이자훈");
			lblNewLabel.setBounds(630, 10, 150, 40);
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
			eggP.add(lblNewLabel);

			eggF.setBounds(100, 100, 800, 600);
			eggF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			eggF.setLocationRelativeTo(null);
			eggF.setVisible(true);
		} else {

			try {
				MemberDAO dao = new MemberDAO();
				if (dao.checkId(idF.getText())) {
					dao.DBConnection();
					con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
					ps = con.prepareStatement(sqlLogin);
					ps.setString(1, idF.getText());
					rs = ps.executeQuery();

					if (rs.next()) {
						if (rs.getString(1).contentEquals(SHA512(pwF.getText()))) {
							selectTel();
							JOptionPane.showMessageDialog(null, "로그인 완료");
							new ReserveMainP();
							f.dispose();
						} else
							JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다");
					}
				} else
					JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다");
			} catch (Exception e) {
				System.out.println("로그인 실패");
			}
		}
	}

	// 전화번호 추출
	public void selectTel() {
		String sqlTel = "SELECT userTel FROM memberTBL WHERE userId = ?";

		try {
			MemberDAO dao = new MemberDAO();
			dao.DBConnection();
			con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			ps = con.prepareStatement(sqlTel);
			ps.setString(1, idF.getText());
			rs = ps.executeQuery();

			if (rs.next()) {
				Save_tel stl = new Save_tel();
				String save_tel = rs.getString(1);
				stl.s_tel(save_tel);
			}
		} catch (SQLException e) {
			System.out.println("번호 추출 실패");
		}
	}

	// SHA512 암호화
	public static String SHA512(String userPw) {
		String encPw = null;
		try {
			for (int i = 0; i < 2; i++) {
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

	class ImagePanel extends JPanel {
		private Image img;

		public ImagePanel(Image img) {
			this.img = img;
			setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
			setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
			setLayout(null);
		}

		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}
}