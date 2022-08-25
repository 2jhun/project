package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SeatPage extends JFrame implements ActionListener {

	private JFrame frame;
	private JButton confirmBtn, cancelBtn;
	JLabel seatNum;

	public SeatPage() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("항공권 예약하기 - 3");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 800, 600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JPanel seatPanel = new JPanel();
		seatPanel.setBounds(36, 0, 796, 572);
		frame.getContentPane().add(seatPanel);
		seatPanel.setLayout(null);

		JButton a1 = new JButton("A1");
		a1.setBounds(58, 35, 52, 23);
		seatPanel.add(a1);

		JButton b1 = new JButton("B1");
		b1.setBounds(117, 34, 52, 23);
		seatPanel.add(b1);

		JButton b2 = new JButton("B2");
		b2.setBounds(117, 67, 52, 23);
		seatPanel.add(b2);

		JButton a2 = new JButton("A2");
		a2.setBounds(58, 67, 52, 23);
		seatPanel.add(a2);

		JButton a3 = new JButton("A3");
		a3.setBounds(58, 100, 52, 23);
		seatPanel.add(a3);

		JButton b3 = new JButton("B3");
		b3.setBounds(117, 100, 52, 23);
		seatPanel.add(b3);

		JButton a4 = new JButton("A4");
		a4.setBounds(58, 128, 52, 23);
		seatPanel.add(a4);

		JButton b4 = new JButton("B4");
		b4.setBounds(117, 128, 52, 23);
		seatPanel.add(b4);

		JButton a5 = new JButton("A5");
		a5.setBounds(58, 161, 52, 23);
		seatPanel.add(a5);

		JButton b5 = new JButton("B5");
		b5.setBounds(117, 161, 52, 23);
		seatPanel.add(b5);

		JButton a6 = new JButton("A6");
		a6.setBounds(58, 194, 52, 23);
		seatPanel.add(a6);

		JButton b6 = new JButton("B6");
		b6.setBounds(117, 194, 52, 23);
		seatPanel.add(b6);

		JButton c1 = new JButton("C1");
		c1.setBounds(203, 35, 52, 23);
		seatPanel.add(c1);

		JButton d1 = new JButton("D1");
		d1.setBounds(267, 35, 52, 23);
		seatPanel.add(d1);

		JButton c2 = new JButton("C2");
		c2.setBounds(203, 67, 52, 23);
		seatPanel.add(c2);

		JButton d2 = new JButton("D2");
		d2.setBounds(267, 67, 52, 23);
		seatPanel.add(d2);

		JButton c3 = new JButton("C3");
		c3.setBounds(203, 100, 52, 23);
		seatPanel.add(c3);

		JButton d3 = new JButton("D3");
		d3.setBounds(267, 100, 52, 23);
		seatPanel.add(d3);

		JButton c4 = new JButton("C4");
		c4.setBounds(203, 128, 52, 23);
		seatPanel.add(c4);

		JButton c5 = new JButton("C5");
		c5.setBounds(203, 161, 52, 23);
		seatPanel.add(c5);

		JButton c6 = new JButton("C6");
		c6.setBounds(203, 194, 52, 23);
		seatPanel.add(c6);

		JButton d4 = new JButton("D4");
		d4.setBounds(267, 128, 52, 23);
		seatPanel.add(d4);

		JButton d5 = new JButton("D5");
		d5.setBounds(267, 161, 52, 23);
		seatPanel.add(d5);

		JButton d6 = new JButton("D6");
		d6.setBounds(267, 194, 52, 23);
		seatPanel.add(d6);

		ButtonGroup bd = new ButtonGroup();
		bd.add(a1);
		bd.add(a2);
		bd.add(a3);
		bd.add(a4);
		bd.add(a5);
		bd.add(a6);
		bd.add(b1);
		bd.add(b2);
		bd.add(b3);
		bd.add(b4);
		bd.add(b5);
		bd.add(b6);
		bd.add(c1);
		bd.add(c2);
		bd.add(c3);
		bd.add(c4);
		bd.add(c5);
		bd.add(c6);
		bd.add(d1);
		bd.add(d2);
		bd.add(d3);
		bd.add(d4);
		bd.add(d5);
		bd.add(d6);

		JButton btnA[] = { a1, a2, a3, a4, a5, a6, b1, b2, b3, b4, b5, b6, c1, c2, c3, c4, c5, c6, d1, d2, d3, d4, d5,
				d6 };

		seatNum = new JLabel("좌석을 선택해주세요");
		seatNum.setBounds(165, 377, 155, 15);
		seatPanel.add(seatNum);

		JLabel seatpo_1 = new JLabel("좌석선택 : ");
		seatpo_1.setBounds(100, 377, 103, 15);
		seatPanel.add(seatpo_1);

		JLabel seatpo_1_1_1 = new JLabel("좌석을 선택해주세요");
		seatpo_1_1_1.setBounds(58, 10, 133, 15);
		seatPanel.add(seatpo_1_1_1);

		JButton e1 = new JButton("E1");
		e1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(e1.getText());
			}
		});
		e1.setBounds(419, 35, 52, 23);
		seatPanel.add(e1);

		JButton h6 = new JButton("H6");
		h6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(h6.getText());
			}
		});
		h6.setBounds(628, 194, 52, 23);
		seatPanel.add(h6);

		JButton e2 = new JButton("E2");
		e2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(e2.getText());
			}
		});
		e2.setBounds(419, 67, 52, 23);
		seatPanel.add(e2);

		JButton f1 = new JButton("F1");
		f1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(f1.getText());
			}
		});
		f1.setBounds(478, 34, 52, 23);
		seatPanel.add(f1);

		JButton f2 = new JButton("F2");
		f2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(f2.getText());
			}
		});
		f2.setBounds(478, 67, 52, 23);
		seatPanel.add(f2);

		JButton e3 = new JButton("E3");
		e3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(e3.getText());
			}
		});
		e3.setBounds(419, 100, 52, 23);
		seatPanel.add(e3);

		JButton f3 = new JButton("F3");
		f3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(f3.getText());
			}
		});
		f3.setBounds(478, 100, 52, 23);
		seatPanel.add(f3);

		JButton f4 = new JButton("F4");
		f4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(f4.getText());
			}
		});
		f4.setBounds(478, 128, 52, 23);
		seatPanel.add(f4);

		JButton e4 = new JButton("E4");
		e4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(e4.getText());
			}
		});
		e4.setBounds(419, 128, 52, 23);
		seatPanel.add(e4);

		JButton e5 = new JButton("E5");
		e5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(e5.getText());
			}
		});
		e5.setBounds(419, 161, 52, 23);
		seatPanel.add(e5);

		JButton f5 = new JButton("F5");
		f5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(f5.getText());
			}
		});
		f5.setBounds(478, 161, 52, 23);
		seatPanel.add(f5);

		JButton f6 = new JButton("F6");
		f6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(f6.getText());
			}
		});
		f6.setBounds(478, 194, 52, 23);
		seatPanel.add(f6);

		JButton e6 = new JButton("E6");
		e6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(e6.getText());
			}
		});
		e6.setBounds(419, 194, 52, 23);
		seatPanel.add(e6);

		JButton g6 = new JButton("G6");
		g6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(g6.getText());
			}
		});
		g6.setBounds(564, 194, 52, 23);
		seatPanel.add(g6);

		JButton g5 = new JButton("G5");
		g5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(g5.getText());
			}
		});
		g5.setBounds(564, 161, 52, 23);
		seatPanel.add(g5);

		JButton h5 = new JButton("H5");
		h5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(h5.getText());
			}
		});
		h5.setBounds(628, 161, 52, 23);
		seatPanel.add(h5);

		JButton h4 = new JButton("H4");
		h4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(h4.getText());
			}
		});
		h4.setBounds(628, 128, 52, 23);
		seatPanel.add(h4);

		JButton g4 = new JButton("G4");
		g4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(g4.getText());
			}
		});
		g4.setBounds(564, 128, 52, 23);
		seatPanel.add(g4);

		JButton g3 = new JButton("G3");
		g3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(g3.getText());
			}
		});
		g3.setBounds(564, 100, 52, 23);
		seatPanel.add(g3);

		JButton h3 = new JButton("H3");
		h3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(h3.getText());
			}
		});
		h3.setBounds(628, 100, 52, 23);
		seatPanel.add(h3);

		JButton h2 = new JButton("H2");
		h2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(h2.getText());
			}
		});
		h2.setBounds(628, 67, 52, 23);
		seatPanel.add(h2);

		JButton g2 = new JButton("G2");
		g2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(g2.getText());
			}
		});
		g2.setBounds(564, 67, 52, 23);
		seatPanel.add(g2);

		JButton g1 = new JButton("G1");
		g1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(g1.getText());
			}
		});
		g1.setBounds(564, 35, 52, 23);
		seatPanel.add(g1);

		JButton h1 = new JButton("H1");
		h1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(h1.getText());
			}
		});
		h1.setBounds(628, 35, 52, 23);
		seatPanel.add(h1);

		confirmBtn = new JButton("확인");
		confirmBtn.setBounds(419, 426, 133, 23);
		seatPanel.add(confirmBtn);

		cancelBtn = new JButton("취소");
		cancelBtn.setBounds(564, 426, 91, 23);
		seatPanel.add(cancelBtn);
		frame.setVisible(true);

		a1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(a1.getText());

			}
		});
		a2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(a2.getText());

			}
		});
		a3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(a3.getText());

			}
		});
		a4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(a4.getText());

			}
		});
		a5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(a5.getText());

			}
		});
		a6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(a6.getText());

			}
		});
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(b1.getText());

			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(b2.getText());

			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(b3.getText());

			}
		});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(d4.getText());

			}
		});
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(b5.getText());

			}
		});
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(b6.getText());

			}
		});

		c1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(c1.getText());

			}
		});

		c2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(c3.getText());

			}
		});

		c4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(c4.getText());

			}
		});

		c5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(c5.getText());

			}
		});

		c6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(c6.getText());

			}
		});

		d1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(d1.getText());

			}
		});

		d2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(d2.getText());

			}
		});

		d3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(d3.getText());

			}
		});

		d4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(d5.getText());

			}
		});

		d6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seatNum.setText(d6.getText());

			}
		});

		confirmBtn.addActionListener(this);
		cancelBtn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == confirmBtn) {
			updatetReserve2();
			new Pay();
			frame.dispose();

		} else if (e.getSource() == cancelBtn) {
			new FlightPage();
			frame.dispose();
		}
	}

	private void updatetReserve2() {
		ReserveDTO dto = seatData();
		ReserveDAO db = new ReserveDAO();
		boolean check = db.updateReserve2(dto);
		if (check) {
			JOptionPane.showMessageDialog(null, "저장완료");
		} else
			JOptionPane.showMessageDialog(null, "저장실패");
	}

	public ReserveDTO seatData() {
		ReserveDTO dto = new ReserveDTO();
		String seat = seatNum.getText();
		dto.setSeat(seat);
		return dto;
	}

}
