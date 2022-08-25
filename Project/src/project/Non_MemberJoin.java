package project;

import java.awt.*;
import java.awt.event.*;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.swing.*;

public class Non_MemberJoin extends JFrame implements ActionListener {
	JFrame f;
	JPanel p;
	JLabel noMemL, noMemNameL, noMemPwL;
	JLabel noMemTelL, noMemTelL1, noMemTelL2;
	JTextField noMemNameF;
	JTextField noMemTelF1, noMemTelF2, noMemTelF3;
	JPasswordField noMemPwF;
	JButton noMemLgBtn, noMemCancelBtn;

	public Non_MemberJoin() {
		// 프레임
		f = new JFrame();
		f.setTitle("항공권 예약 시스템 - 비회원 가입");
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
		noMemL = new JLabel("비회원가입");
		noMemL.setHorizontalAlignment(SwingConstants.CENTER);
		noMemL.setFont(new Font("굴림", Font.BOLD, 37));
		noMemL.setBounds(242, 69, 300, 47);
		p.add(noMemL);

		// 이름
		noMemNameL = new JLabel("이름 : ");
		noMemNameL.setHorizontalAlignment(SwingConstants.CENTER);
		noMemNameL.setBounds(230, 173, 52, 29);
		p.add(noMemNameL);
		noMemNameF = new JTextField();
		noMemNameF.setBounds(306, 173, 229, 29);
		p.add(noMemNameF);

		// 비밀번호
		noMemPwL = new JLabel("비밀번호 : ");
		noMemPwL.setHorizontalAlignment(SwingConstants.CENTER);
		noMemPwL.setBounds(207, 252, 75, 29);
		p.add(noMemPwL);
		noMemPwF = new JPasswordField();
		noMemPwF.setBounds(306, 252, 229, 29);
		p.add(noMemPwF);
		noMemPwF.setColumns(12);

		// 연락처
		noMemTelL = new JLabel("연락처 : ");
		noMemTelL.setHorizontalAlignment(SwingConstants.CENTER);
		noMemTelL.setBounds(219, 337, 63, 29);
		p.add(noMemTelL);

		noMemTelF1 = new JTextField();
		noMemTelF1.setBounds(306, 337, 65, 29);
		p.add(noMemTelF1);
		noMemTelL1 = new JLabel("-");
		noMemTelL1.setBounds(376, 344, 12, 15);
		p.add(noMemTelL1);

		noMemTelF2 = new JTextField();
		noMemTelF2.setBounds(389, 337, 65, 29);
		p.add(noMemTelF2);
		noMemTelL2 = new JLabel("-");
		noMemTelL2.setBounds(459, 344, 12, 15);
		p.add(noMemTelL2);

		noMemTelF3 = new JTextField();
		noMemTelF3.setBounds(470, 337, 65, 29);
		p.add(noMemTelF3);

		// 버튼
		noMemLgBtn = new JButton("비회원가입");
		noMemLgBtn.setBounds(268, 424, 103, 38);
		p.add(noMemLgBtn);

		noMemCancelBtn = new JButton("취소");
		noMemCancelBtn.setBounds(398, 424, 103, 38);
		p.add(noMemCancelBtn);

		// 리스너
		noMemLgBtn.addActionListener(this);
		noMemCancelBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == noMemLgBtn) {
			if (noMemNameF.getText().trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "이름을 입력해 주세요.", "이름 입력", JOptionPane.WARNING_MESSAGE);
				noMemNameF.grabFocus();
				return;
			} else if (noMemNameF.getText().length() < 2 || noMemNameF.getText().length() > 20) {
				JOptionPane.showMessageDialog(null, "이름은 2글자 이상, 20글자 이하만 가능합니다.", "이름 입력",
						JOptionPane.WARNING_MESSAGE);
				noMemNameF.grabFocus();
				return;
			} else if (noMemPwF.getText().trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "비밀번호를 입력해 주세요.", "비밀번호 입력", JOptionPane.WARNING_MESSAGE);
				noMemPwF.grabFocus();
				return;
			} else if (noMemPwF.getText().length() < 6 || noMemPwF.getText().length() > 20) {
				JOptionPane.showMessageDialog(null, "비밀번호는 6글자 이상, 20글자 이하만 가능합니다.", "비밀번호 입력",
						JOptionPane.WARNING_MESSAGE);
				noMemPwF.grabFocus();
				return;
			} else if (noMemTelF1.getText().trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "번호를 입력해 주세요.", "번호1 입력", JOptionPane.WARNING_MESSAGE);
				noMemTelF1.grabFocus();
				return;
			} else if (noMemTelF1.getText().length() < 3 || noMemTelF1.getText().length() > 4) {
				JOptionPane.showMessageDialog(null, "앞번호는 3자리 이상, 4자리 이하만 가능합니다.", "번호1 입력",
						JOptionPane.WARNING_MESSAGE);
				noMemTelF1.grabFocus();
				return;
			} else if (getInt(noMemTelF1.getText()) == 1) {
				JOptionPane.showMessageDialog(null, "핸드폰 번호는 숫자만 가능합니다", "숫자 입력", JOptionPane.WARNING_MESSAGE);
				noMemTelF1.grabFocus();
				return;
			} else if (noMemTelF2.getText().trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "번호를 입력해 주세요.", "번호2 입력", JOptionPane.WARNING_MESSAGE);
				noMemTelF2.grabFocus();
				return;
			} else if (noMemTelF2.getText().length() < 3 || noMemTelF2.getText().length() > 4) {
				JOptionPane.showMessageDialog(null, "중간 번호는 3자리 이상, 4자리 이하만 가능합니다.", "번호2 입력",
						JOptionPane.WARNING_MESSAGE);
				noMemTelF2.grabFocus();
				return;
			} else if (getInt(noMemTelF2.getText()) == 1) {
				JOptionPane.showMessageDialog(null, "핸드폰 번호는 숫자만 가능합니다", "숫자 입력", JOptionPane.WARNING_MESSAGE);
				noMemTelF2.grabFocus();
				return;
			} else if (noMemTelF3.getText().trim().length() == 0) {
				JOptionPane.showMessageDialog(null, "번호를 입력해 주세요.", "번호3 입력", JOptionPane.WARNING_MESSAGE);
				noMemTelF3.grabFocus();
				return;
			} else if (noMemTelF3.getText().length() < 4 || noMemTelF3.getText().length() > 4) {
				JOptionPane.showMessageDialog(null, "끝번호는 4자리만 가능합니다.", "번호3 입력", JOptionPane.WARNING_MESSAGE);
				noMemTelF3.grabFocus();
				return;
			} else if (getInt(noMemTelF3.getText()) == 1) {
				JOptionPane.showMessageDialog(null, "핸드폰 번호는 숫자만 가능합니다", "숫자 입력", JOptionPane.WARNING_MESSAGE);
				noMemTelF3.grabFocus();
				return;
			}
			noMemInsertMember();
		} else if (e.getSource() == noMemCancelBtn) {
			new Login();
			f.dispose();
		}
	}

	private void noMemInsertMember() {
		MemberDTO dto = getViewData();
		MemberDAO dao = new MemberDAO();
		boolean check = dao.noMemInsertMember(dto);

		if (check) {
			JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
			new Non_MemberLogin();
			f.dispose();
		} else
			JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
	}

	private MemberDTO getViewData() {
		String pw_encrypt = SHA512(noMemPwF.getText());

		MemberDTO dto = new MemberDTO();
		String userName = noMemNameF.getText();
		String userPw = pw_encrypt;
		String userTel1 = noMemTelF1.getText();
		String userTel2 = noMemTelF2.getText();
		String userTel3 = noMemTelF3.getText();
		String userTel = userTel1 + "-" + userTel2 + "-" + userTel3;

		dto.setUserPw(userPw);
		dto.setUserName(userName);
		dto.setUserTel(userTel);

		return dto;
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