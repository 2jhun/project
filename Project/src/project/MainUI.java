package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainUI extends JFrame implements ActionListener {
	JFrame f;
	JPanel p;
	JButton startBtn;
	ImagePanel imgP;

	public MainUI() {
		// 프레임
		f = new JFrame();
		f.setTitle("항공권 예약 시스템 - 메인 화면");
		f.getContentPane().setLayout(null);
		f.setResizable(false);

		// 배경화면
		imgP = new ImagePanel(new ImageIcon("./image/flight1.jpg").getImage());
		f.add(imgP);
		f.pack();

		// 패널
		p = new JPanel();
		p.setBounds(0, 0, 794, 571);
		f.getContentPane().add(p);
		p.setLayout(null);

		// 버튼
		startBtn = new JButton("Start");
		startBtn.setBounds(550, 400, 142, 39);
		p.add(startBtn);

		// 프레임
		f.setBounds(100, 100, 800, 600);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

		// 리스너
		startBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startBtn) {
			new Login();
			f.dispose();
		}
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

	public static void main(String[] args) {
		new MainUI();
	}
}