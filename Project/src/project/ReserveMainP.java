package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ReserveMainP extends JFrame implements ActionListener {
	private JFrame frame;
	private JPanel reserveMainPanel;
	private JButton reserveBtn;
	private JButton checkBtn;
	private JButton homeBtn;

	public ReserveMainP() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("항공권 예약 및 조회");
		frame.setBounds(100, 100, 800, 600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JPanel reserveMainPanel = new JPanel();
		reserveMainPanel.setBounds(0, 0, 796, 572);
		frame.getContentPane().add(reserveMainPanel);
		reserveMainPanel.setLayout(null);

		reserveBtn = new JButton("항공권 예약 하기");
		reserveBtn.setBounds(109, 114, 535, 141);
		reserveMainPanel.add(reserveBtn);

		checkBtn = new JButton("항공권 예약 확인");
		checkBtn.setBounds(109, 333, 535, 141);
		reserveMainPanel.add(checkBtn);

//		homeBtn = new JButton("home");
//		homeBtn.setBounds(684, 27, 76, 50);
//		reserveMainPanel.add(homeBtn);

		homeBtn = new JButton("");
		homeBtn.setSelectedIcon(new ImageIcon("./image/homeBtn.png"));
		homeBtn.setIcon(new ImageIcon("./image/homeBtn.png"));
		homeBtn.setBounds(729, 20, 41, 39);
		reserveMainPanel.add(homeBtn);

		homeBtn.addActionListener(this);
		reserveBtn.addActionListener(this);
		checkBtn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == reserveBtn) {
			new ReservePage();
			frame.dispose();

		} else if (e.getSource() == checkBtn) {
			new Confirm_reserve();
			frame.dispose();
		} else if (e.getSource() == homeBtn) {
			new MainUI();
			frame.dispose();
		}

	}

}
