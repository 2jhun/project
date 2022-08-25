package project;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Admin implements ActionListener {
	private JFrame f;
	private JPanel p;
	private JButton cusMBtn, tketMBtn, homeBtn;

	public Admin() {
		// 프레임
		f = new JFrame();
		f.setTitle("항공권 예약 시스템 - 관리자 메뉴");
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

		// 버튼
		cusMBtn = new JButton("회원 관리");
		cusMBtn.setFont(new Font("안상수2006가는", Font.BOLD, 35));
		cusMBtn.setBounds(138, 138, 200, 250);
		p.add(cusMBtn);

		tketMBtn = new JButton("항공권 관리");
		tketMBtn.setFont(new Font("안상수2006가는", Font.BOLD, 30));
		tketMBtn.setBounds(454, 138, 200, 250);
		p.add(tketMBtn);

		homeBtn = new JButton("");
		homeBtn.setSelectedIcon(new ImageIcon("./image/homeBtn.png"));
		homeBtn.setIcon(new ImageIcon("./image/homeBtn.png"));
		homeBtn.setBounds(729, 20, 40, 40);
		p.add(homeBtn);

		// 리스너
		cusMBtn.addActionListener(this);
		tketMBtn.addActionListener(this);
		homeBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cusMBtn) {
			new CusManage();
			f.dispose();
		} else if (e.getSource() == tketMBtn) {
			new TicketManage();
			f.dispose();
		} else if (e.getSource() == homeBtn) {
			new MainUI();
			f.dispose();
		}
	}
}