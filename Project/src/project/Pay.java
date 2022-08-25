package project;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Pay extends JFrame implements ActionListener {

	private JFrame frame;
	private JButton cancelBtn, deposit, creditCard, cancelBtn_1;

	public Pay() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("결제수단 선택 - 3");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 800, 600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 796, 548);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		deposit = new JButton("무통장 입금");
		deposit.setBounds(151, 31, 420, 177);
		panel.add(deposit);

		creditCard = new JButton("카드");
		creditCard.setBounds(151, 252, 420, 177);
		panel.add(creditCard);

		cancelBtn = new JButton("<");
		cancelBtn.setBounds(630, 445, 72, 66);
		panel.add(cancelBtn);

		cancelBtn_1 = new JButton("취소");
		cancelBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cancelBtn_1.setBounds(31, 445, 72, 66);
		panel.add(cancelBtn_1);

		cancelBtn_1.addActionListener(this);
		cancelBtn.addActionListener(this);
		deposit.addActionListener(this);
		creditCard.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelBtn) {
			new SeatPage();
			frame.dispose();
		} else if (e.getSource() == deposit) {
			JOptionPane.showMessageDialog(null, "예약이 완료 되었습니다.");
			new ReserveMainP();
			frame.dispose();
		} else if (e.getSource() == creditCard) {
			JOptionPane.showMessageDialog(null, "예약이 완료 되었습니다.");
			new ReserveMainP();
			frame.dispose();
		} else if (e.getSource() == cancelBtn_1) {
			new ReserveMainP();
			frame.dispose();
		}
	}
}