package project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

public class AddTicket extends JFrame implements ActionListener {
	JFrame f;
	JPanel p;
	JLabel addL, ticketL, depL, desL, dateL, yL, mL, depTL, depTL1, arrTL, arrTL1, priceL;
	JTextField ticketF, depF, desF, yField, mField, dField, depTF1, depTF2, arrTF1, arrTF2;
	JPasswordField pwF;
	JButton addBtn, cancelBtn;
	JFormattedTextField priceF = new JFormattedTextField(new NumberFormatter());

	public AddTicket() {
		// 프레임
		f = new JFrame();
		f.setTitle("항공권 예약 시스템 - 항공권 추가");
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
		addL = new JLabel("항공권 추가");
		addL.setFont(new Font("굴림", Font.BOLD, 37));
		addL.setHorizontalAlignment(SwingConstants.CENTER);
		addL.setBounds(242, 22, 300, 47);
		p.add(addL);

		// 티켓번호
		ticketL = new JLabel("티켓번호 :");
		ticketL.setHorizontalAlignment(SwingConstants.CENTER);
		ticketL.setBounds(259, 113, 63, 29);
		p.add(ticketL);
		ticketF = new JTextField();
		ticketF.setBounds(355, 113, 229, 29);
		p.add(ticketF);
		ticketF.setColumns(10);

		// 출발지
		depL = new JLabel("출발지 :");
		depL.setHorizontalAlignment(SwingConstants.CENTER);
		depL.setBounds(270, 162, 52, 29);
		p.add(depL);
		depF = new JTextField();
		depF.setBounds(355, 162, 229, 29);
		p.add(depF);
		depF.setColumns(12);

		// 도착지
		desL = new JLabel("도착지 :");
		desL.setHorizontalAlignment(SwingConstants.CENTER);
		desL.setBounds(270, 215, 52, 29);
		p.add(desL);
		desF = new JTextField();
		desF.setColumns(10);
		desF.setBounds(355, 215, 229, 29);
		p.add(desF);

		// 날짜
		dateL = new JLabel("날짜 :");
		dateL.setHorizontalAlignment(SwingConstants.CENTER);
		dateL.setBounds(279, 272, 43, 29);
		p.add(dateL);

		yField = new JTextField();
		yField.setColumns(10);
		yField.setBounds(355, 272, 63, 29);
		p.add(yField);
		yL = new JLabel("년");
		yL.setBounds(423, 282, 17, 15);
		p.add(yL);

		mField = new JTextField();
		mField.setColumns(10);
		mField.setBounds(438, 272, 63, 29);
		p.add(mField);
		mL = new JLabel("월");
		mL.setBounds(505, 282, 17, 15);
		p.add(mL);

		dField = new JTextField();
		dField.setColumns(10);
		dField.setBounds(521, 272, 63, 29);
		p.add(dField);

		// 출발시간
		depTL = new JLabel("출발시간 :");
		depTL.setHorizontalAlignment(SwingConstants.CENTER);
		depTL.setBounds(259, 325, 63, 29);
		p.add(depTL);

		depTF1 = new JTextField();
		depTF1.setColumns(10);
		depTF1.setBounds(355, 325, 103, 29);
		p.add(depTF1);

		depTL1 = new JLabel(":");
		depTL1.setBounds(465, 332, 10, 15);
		p.add(depTL1);

		depTF2 = new JTextField();
		depTF2.setColumns(10);
		depTF2.setBounds(481, 325, 103, 29);
		p.add(depTF2);

		// 도착시간
		arrTL = new JLabel("도착시간 :");
		arrTL.setHorizontalAlignment(SwingConstants.CENTER);
		arrTL.setBounds(259, 378, 63, 29);
		p.add(arrTL);

		arrTF1 = new JTextField();
		arrTF1.setColumns(10);
		arrTF1.setBounds(355, 378, 103, 29);
		p.add(arrTF1);

		arrTL1 = new JLabel(":");
		arrTL1.setBounds(465, 385, 10, 15);
		p.add(arrTL1);

		arrTF2 = new JTextField();
		arrTF2.setColumns(10);
		arrTF2.setBounds(481, 378, 103, 29);
		p.add(arrTF2);

		// 가격
		priceL = new JLabel("가격 :");
		priceL.setHorizontalAlignment(SwingConstants.CENTER);
		priceL.setBounds(279, 427, 43, 29);
		p.add(priceL);

		priceF.setColumns(10);
		priceF.setBounds(355, 427, 229, 29);
		p.add(priceF);

		// 버튼
		addBtn = new JButton("추가");
		addBtn.setBounds(259, 484, 103, 38);
		p.add(addBtn);

		cancelBtn = new JButton("취소");
		cancelBtn.setBounds(439, 484, 103, 38);
		p.add(cancelBtn);

		addBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addBtn) {
			insertTicket();
		} else if (e.getSource() == cancelBtn) {
			new TicketManage();
			f.dispose();
		}
	}

	private void insertTicket() {
		MemberDTO dto = getViewData();
		MemberDAO dao = new MemberDAO();
		boolean check = dao.insertTicket(dto);

		if (check) {
			JOptionPane.showMessageDialog(null, "항공권 추가가 완료되었습니다.");
			new TicketManage();
			f.dispose();
		} else
			JOptionPane.showMessageDialog(null, "항공권 추가에 실패하였습니다.");
	}

	public MemberDTO getViewData() {
		MemberDTO dto = new MemberDTO();
		String ticketNum = ticketF.getText();
		String departure = depF.getText();
		String destination = desF.getText();
		String yDate = yField.getText();
		String mDate = mField.getText();
		String dDate = dField.getText();
		String date = yDate + mDate + dDate;
		String dhTime = depTF1.getText();
		String dmTime = depTF2.getText();
		String depT = dhTime + dmTime;
		String ahTime = arrTF1.getText();
		String amTime = arrTF2.getText();
		String arrT = ahTime + amTime;
		String price = priceF.getText();

		dto.setTicketNum(ticketNum);
		dto.setDeparture(departure);
		dto.setDestination(destination);
		dto.setDate(date);
		dto.setDepT(depT);
		dto.setArrT(arrT);
		dto.setPrice(price);

		return dto;
	}
}