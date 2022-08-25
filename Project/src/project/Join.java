package project;

import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.Base64;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

public class Join extends JFrame implements ActionListener {
	JFrame f;
	JPanel p;
	JLabel joinL, idL, pwL, nameL, birthL, emailL, telL, addrL;
	JLabel yearL, monthL, telL1, telL2, exBirth;
	JTextField idF, nameF, telF1, telF2, telF3, emailF, addrF;
	JPasswordField pwF;
	JButton checkIdBtn, joinBtn, cancelBtn;
	JFormattedTextField yField = new JFormattedTextField(new NumberFormatter());
	JFormattedTextField mField = new JFormattedTextField(new NumberFormatter());
	JFormattedTextField dField = new JFormattedTextField(new NumberFormatter());
//	String salt = Salt();

	public Join() {
		joinUI();
	}

	private void joinUI() {
		// 프레임
		f = new JFrame();
		f.setTitle("항공권 예약 시스템 - 회원가입");
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
		joinL = new JLabel("회원가입");
		joinL.setFont(new Font("굴림", Font.BOLD, 37));
		joinL.setHorizontalAlignment(SwingConstants.CENTER);
		joinL.setBounds(242, 22, 300, 47);
		p.add(joinL);

		// 아이디
		idL = new JLabel("아이디 : ");
		idL.setHorizontalAlignment(SwingConstants.CENTER);
		idL.setBounds(259, 113, 63, 29);
		p.add(idL);
		idF = new JTextField();
		idF.setBounds(355, 113, 229, 29);
		p.add(idF);
		idF.setColumns(10);

		checkIdBtn = new JButton("중복확인");
		checkIdBtn.setBounds(596, 113, 100, 29);
		p.add(checkIdBtn);

		// 비밀번호
		pwL = new JLabel("비밀번호 : ");
		pwL.setHorizontalAlignment(SwingConstants.CENTER);
		pwL.setBounds(247, 162, 75, 29);
		p.add(pwL);
		pwF = new JPasswordField();
		pwF.setBounds(355, 162, 229, 29);
		p.add(pwF);
		pwF.setColumns(12);

		// 이름
		nameL = new JLabel("이름 : ");
		nameL.setHorizontalAlignment(SwingConstants.CENTER);
		nameL.setBounds(270, 215, 52, 29);
		p.add(nameL);
		nameF = new JTextField();
		nameF.setColumns(10);
		nameF.setBounds(355, 215, 229, 29);
		p.add(nameF);

		// 생년월일
		birthL = new JLabel("생년월일 : ");
		birthL.setHorizontalAlignment(SwingConstants.CENTER);
		birthL.setBounds(247, 272, 75, 29);
		p.add(birthL);
		yField.setColumns(10);
		yField.setBounds(355, 272, 63, 29);
		p.add(yField);
		yearL = new JLabel("년");
		yearL.setBounds(423, 282, 17, 15);
		p.add(yearL);

		mField.setColumns(10);
		mField.setBounds(438, 272, 63, 29);
		p.add(mField);
		monthL = new JLabel("월");
		monthL.setBounds(505, 282, 17, 15);
		p.add(monthL);

		dField.setColumns(10);
		dField.setBounds(521, 272, 63, 29);
		p.add(dField);

		exBirth = new JLabel("ex)890302");
		exBirth.setBounds(596, 272, 80, 29);
		p.add(exBirth);

		// 이메일
		emailL = new JLabel("이메일 : ");
		emailL.setHorizontalAlignment(SwingConstants.CENTER);
		emailL.setBounds(259, 321, 63, 29);
		p.add(emailL);
		emailF = new JTextField();
		emailF.setColumns(10);
		emailF.setBounds(355, 321, 229, 29);
		p.add(emailF);

		// 전화번호
		telL = new JLabel("연락처 : ");
		telL.setHorizontalAlignment(SwingConstants.CENTER);
		telL.setBounds(259, 378, 63, 29);
		p.add(telL);

		telF1 = new JTextField();
		telF1.setColumns(10);
		telF1.setBounds(355, 378, 63, 29);
		p.add(telF1);
		telL1 = new JLabel("-");
		telL1.setBounds(425, 385, 17, 15);
		p.add(telL1);

		telF2 = new JTextField();
		telF2.setColumns(10);
		telF2.setBounds(441, 378, 63, 29);
		p.add(telF2);
		telL2 = new JLabel("-");
		telL2.setBounds(508, 385, 17, 15);
		p.add(telL2);

		telF3 = new JTextField();
		telF3.setColumns(10);
		telF3.setBounds(521, 378, 63, 29);
		p.add(telF3);

		// 주소
		addrL = new JLabel("주소 : ");
		addrL.setHorizontalAlignment(SwingConstants.CENTER);
		addrL.setBounds(270, 427, 52, 29);
		p.add(addrL);

		addrF = new JTextField();
		addrF.setColumns(10);
		addrF.setBounds(355, 427, 229, 29);
		p.add(addrF);

		// 버튼
		joinBtn = new JButton("회원가입");
		joinBtn.setBounds(259, 484, 103, 38);
		p.add(joinBtn);

		cancelBtn = new JButton("취소");
		cancelBtn.setBounds(439, 484, 103, 38);
		p.add(cancelBtn);

		joinBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		checkIdBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == checkIdBtn) {
			if (idF.getText().trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "아이디를 입력해 주세요.", "아이디 입력", JOptionPane.WARNING_MESSAGE);
				idF.grabFocus();
				return;
			} else if (idF.getText().length() < 4 || idF.getText().length() > 20) {
				JOptionPane.showMessageDialog(null, "아이디는 4글자 이상, 20글자 이하만 가능합니다.", "아이디 입력",
						JOptionPane.WARNING_MESSAGE);
				idF.grabFocus();
				return;
			} else if (checkIDMethod(idF.getText()) == 1) {
				JOptionPane.showMessageDialog(null, "아이디는 특수문자 포함이 불가능합니다.", "아이디 입력", JOptionPane.WARNING_MESSAGE);
				idF.grabFocus();
				return;
			} else {
				MemberDAO dao = new MemberDAO();
				try {
					if (dao.checkId(idF.getText())) {
						JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.", "아이디 입력", JOptionPane.WARNING_MESSAGE);
						idF.setText("");
					} else
						JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.");
				} catch (SQLException e1) {
				}
			}
		} else if (e.getSource() == joinBtn) {
			if (idF.getText().trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "아이디를 입력해 주세요.", "아이디 입력", JOptionPane.WARNING_MESSAGE);
				idF.grabFocus();
				return;
			} else if (idF.getText().length() < 4 || idF.getText().length() > 20) {
				JOptionPane.showMessageDialog(null, "아이디는 4글자 이상, 20글자 이하만 가능합니다.", "아이디 입력",
						JOptionPane.WARNING_MESSAGE);
				idF.grabFocus();
				return;
			} else if (pwF.getText().trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "비밀번호를 입력해 주세요.", "비밀번호 입력", JOptionPane.WARNING_MESSAGE);
				pwF.grabFocus();
				return;
			} else if (pwF.getText().length() < 6 || pwF.getText().length() > 20) {
				JOptionPane.showMessageDialog(null, "비밀번호는 6글자 이상, 20글자 이하만 가능합니다.", "비밀번호 입력",
						JOptionPane.WARNING_MESSAGE);
				pwF.grabFocus();
				return;
			} else if (nameF.getText().trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "이름을 입력해 주세요.", "이름 입력", JOptionPane.WARNING_MESSAGE);
				nameF.grabFocus();
				return;
			} else if (nameF.getText().length() < 2 || nameF.getText().length() > 20) {
				JOptionPane.showMessageDialog(null, "이름은 2글자 이상, 20글자 이하만 가능합니다.", "이름 입력",
						JOptionPane.WARNING_MESSAGE);
				nameF.grabFocus();
				return;
			} else if (yField.getText().length() < 2 || yField.getText().length() > 2) {
				JOptionPane.showMessageDialog(null, "생년은 2글자만 가능합니다.", "생년 입력", JOptionPane.WARNING_MESSAGE);
				yField.grabFocus();
				return;
			} else if (mField.getText().length() < 2 || mField.getText().length() > 2) {
				JOptionPane.showMessageDialog(null, "생월은 2글자만 가능합니다.", "생년 입력", JOptionPane.WARNING_MESSAGE);
				mField.grabFocus();
				return;
			} else if (dField.getText().length() < 2 || dField.getText().length() > 2) {
				JOptionPane.showMessageDialog(null, "생일은 2글자만 가능합니다.", "생년 입력", JOptionPane.WARNING_MESSAGE);
				dField.grabFocus();
				return;
			} else if (telF1.getText().trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "번호를 입력해 주세요.", "번호1 입력", JOptionPane.WARNING_MESSAGE);
				telF1.grabFocus();
				return;
			} else if (telF1.getText().length() < 3 || telF1.getText().length() > 4) {
				JOptionPane.showMessageDialog(null, "앞번호는 3자리 이상, 4자리 이하만 가능합니다.", "번호1 입력",
						JOptionPane.WARNING_MESSAGE);
				telF1.grabFocus();
				return;
			} else if (getInt(telF1.getText()) == 1) {
				JOptionPane.showMessageDialog(null, "핸드폰 번호는 숫자만 가능합니다", "숫자 입력", JOptionPane.WARNING_MESSAGE);
				telF1.grabFocus();
				return;
			} else if (telF2.getText().trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "번호를 입력해 주세요.", "번호2 입력", JOptionPane.WARNING_MESSAGE);
				telF2.grabFocus();
				return;
			} else if (telF2.getText().length() < 3 || telF2.getText().length() > 4) {
				JOptionPane.showMessageDialog(null, "중간 번호는 3자리 이상, 4자리 이하만 가능합니다.", "번호2 입력",
						JOptionPane.WARNING_MESSAGE);
				telF2.grabFocus();
				return;
			} else if (getInt(telF2.getText()) == 1) {
				JOptionPane.showMessageDialog(null, "핸드폰 번호는 숫자만 가능합니다", "숫자 입력", JOptionPane.WARNING_MESSAGE);
				telF2.grabFocus();
				return;
			} else if (telF3.getText().trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "번호를 입력해 주세요.", "번호3 입력", JOptionPane.WARNING_MESSAGE);
				telF3.grabFocus();
				return;
			} else if (telF3.getText().length() < 4 || telF3.getText().length() > 4) {
				JOptionPane.showMessageDialog(null, "끝번호는 4자리만 가능합니다.", "번호3 입력", JOptionPane.WARNING_MESSAGE);
				telF3.grabFocus();
				return;
			} else if (getInt(telF3.getText()) == 1) {
				JOptionPane.showMessageDialog(null, "핸드폰 번호는 숫자만 가능합니다", "숫자 입력", JOptionPane.WARNING_MESSAGE);
				telF3.grabFocus();
				return;
			} else if (emailF.getText().length() > 0) {
				if (checkGolbang(emailF.getText()) == 0) {
					JOptionPane.showMessageDialog(null, "이메일 형식을 확인해주세요", "생년 입력", JOptionPane.WARNING_MESSAGE);
					emailF.grabFocus();
					return;
				}
			}
			insertMember();
		} else if (e.getSource() == cancelBtn) {
			new Login();
			f.dispose();
		}
	}

	// 회원가입
	private void insertMember() {
		MemberDTO dto = getViewData();
		MemberDAO dao = new MemberDAO();
		boolean check = dao.insertMember(dto);

		if (check) {
			JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
			new Login();
			f.dispose();
		} else
			JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
	}

	// 받은 데이터 DTO에 삽입
	public MemberDTO getViewData() {
		// 비밀번호 암호화
		String pw_encrypt = SHA512(pwF.getText());

		MemberDTO dto = new MemberDTO();
		String userId = idF.getText();
		String userPw = pw_encrypt;
		String userName = nameF.getText();
		String userBirth1 = yField.getText();
		String userBirth2 = mField.getText();
		String userBirth3 = dField.getText();
		String userBirth = userBirth1 + userBirth2 + userBirth3;
		String userEmail = emailF.getText();
		String userTel1 = telF1.getText();
		String userTel2 = telF2.getText();
		String userTel3 = telF3.getText();
		String userTel = userTel1 + "-" + userTel2 + "-" + userTel3;
		String userAddr = addrF.getText();

		dto.setUserId(userId);
		dto.setUserPw(userPw);
		dto.setUserName(userName);
		dto.setUserBirth(userBirth);
		dto.setUserEmail(userEmail);
		dto.setUserTel(userTel);
		dto.setUserAddr(userAddr);

		return dto;
	}

	// 아이디 중복확인 특수문자 체크
	public int checkIDMethod(String id) {
		int check = 0, code;
		char alpha;
		for (int i = 0; i < id.length(); i++) {
			alpha = id.charAt(i);
			code = (int) alpha;
			if (code >= 0 && code <= 47 || code >= 58 && code <= 64 || code >= 91 && code <= 96
					|| code >= 123 && code <= 127)
				check = 1;
		}
		return check;
	}

	// 입력값이 숫자인지 체크
	public int getInt(String num) {
		int check = 0, code;
		char alpha;
		for (int i = 0; i < num.length(); i++) {
			alpha = num.charAt(i);
			code = (int) alpha;
			if (0 <= code && code <= 47 || 58 <= code && code <= 127)
				check = 1;
		}
		return check;
	}

	// 이메일 @ 입력여부 확인
	public int checkGolbang(String email) {
		int check = 0, code;
		char alpha;
		for (int i = 0; i < email.length(); i++) {
			alpha = email.charAt(i);
			code = (int) alpha;
			if (code == 64)
				check = 1;
		}
		return check;
	}

	// salt(난수값) 생성
//	public static String Salt() {
//		String salt = "";
//		try {
//			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
//			byte[] bytes = new byte[5];
//			random.nextBytes(bytes);
//			salt = new String(Base64.getEncoder().encode(bytes));
//		} catch (NoSuchAlgorithmException e) {
//			System.out.println("난수값 생성 실패");
//		}
//		return salt;
//	}

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
}