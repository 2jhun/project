package project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import javax.swing.SwingConstants;

public class ReservePage extends JFrame implements ActionListener{

   private JFrame frame;
   private JButton confirmBtn, cancelBtn;
   private JLabel startingPointField, destinationField, peopleField, departureField;
   private static   JComboBox destinationCombo;
   static String  destination,reserveNum;
   private LineBorder line = new LineBorder(Color.black, 1, true); 
   public ReservePage() {

      frame = new JFrame();
      frame.setBounds(100, 100, 450, 300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("항공권 예약하기 - 1");
      frame.setBounds(100, 100, 800, 600);
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);
      frame.getContentPane().setLayout(null);
      frame.setVisible(true);
      
      JPanel reservePanel = new JPanel();
      reservePanel.setBounds(12, 10, 796, 572);
      frame.getContentPane().add(reservePanel);
      reservePanel.setLayout(null);

      JLabel lblNewLabel = new JLabel("출발지");
      lblNewLabel.setBounds(38, 76, 50, 15);
      reservePanel.add(lblNewLabel);

      JLabel lblNewLabel_1 = new JLabel("목적지");
      lblNewLabel_1.setBounds(428, 76, 50, 15);
      reservePanel.add(lblNewLabel_1);

       destinationCombo = new JComboBox();
      destinationCombo.setModel(new DefaultComboBoxModel(new String[] {"la", "paris", "london", "bern"}));
      destinationCombo.setBounds(490, 72, 213, 23);
      reservePanel.add(destinationCombo);

      JComboBox startingPointCombo = new JComboBox();
      startingPointCombo.setModel(new DefaultComboBoxModel(new String[] { "인천공항" }));
      startingPointCombo.setBounds(88, 72, 213, 23);
      reservePanel.add(startingPointCombo);

      JLabel lblNewLabel_2 = new JLabel("출발날짜");
      lblNewLabel_2.setBounds(38, 148, 50, 15);
      reservePanel.add(lblNewLabel_2);

      JLabel lblNewLabel_3 = new JLabel("인원선택");
      lblNewLabel_3.setBounds(88, 207, 50, 15);
      reservePanel.add(lblNewLabel_3);

      JRadioButton people1 = new JRadioButton("1");
      people1.setBounds(88, 241, 50, 23);
      reservePanel.add(people1);

      JRadioButton people2 = new JRadioButton("2");
      people2.setBounds(155, 241, 50, 23);
      reservePanel.add(people2);

      JRadioButton people3 = new JRadioButton("3");
      people3.setBounds(236, 241, 50, 23);
      reservePanel.add(people3);

      JRadioButton people4 = new JRadioButton("4");
      people4.setBounds(313, 241, 50, 23);
      reservePanel.add(people4);

      ButtonGroup peopleGroup = new ButtonGroup();
      peopleGroup.add(people1);
      peopleGroup.add(people2);
      peopleGroup.add(people3);
      peopleGroup.add(people4);

      reservePanel.add(people1);
      reservePanel.add(people2);
      reservePanel.add(people3);
      reservePanel.add(people4);

      
      // =======================
      UtilDateModel model = new UtilDateModel();
      JDatePanelImpl datePanel = new JDatePanelImpl(model);
      JDatePickerImpl departureDate = new JDatePickerImpl(datePanel);
      // ========================
      
      reservePanel.add(departureDate);
      departureDate.setBounds(88, 142, 213, 21);
      departureDate.setVisible(true);

      System.out.println(model.getYear() + "-" + (model.getMonth() + 1) + "-" + model.getDay());

      JLabel lblNewLabel_4 = new JLabel("목적지 : ");
      lblNewLabel_4.setBounds(88, 355, 50, 15);
      reservePanel.add(lblNewLabel_4);

      JLabel lblNewLabel_4_1 = new JLabel("출발하는날  :");
      lblNewLabel_4_1.setBounds(88, 380, 81, 15);
      reservePanel.add(lblNewLabel_4_1);

      JLabel lblNewLabel_4_1_1_1 = new JLabel("인원수 :");
      lblNewLabel_4_1_1_1.setBounds(88, 414, 67, 15);
      reservePanel.add(lblNewLabel_4_1_1_1);

      JLabel destinationField = new JLabel("");
      destinationField.setBounds(181, 355, 146, 15);
      reservePanel.add(destinationField);

       departureField = new JLabel("");
      departureField.setBounds(181, 380, 157, 15);
      reservePanel.add(departureField);

      JLabel peopleField = new JLabel("");
      peopleField.setBounds(179, 414, 146, 15);
      reservePanel.add(peopleField);

      // String[] country = {"미국","영국","프랑스","이탈리아"};
      ImageIcon[] images = { new ImageIcon("./image/usa.jpg"), new ImageIcon("./image/uk.jpg"),
            new ImageIcon("./image/france.jpg"), new ImageIcon("./image/italy.jpg") };

      JLabel imgLabel = new JLabel(images[0]);
      reservePanel.add(imgLabel);
      imgLabel.setBounds(428, 155, 275, 240);
      imgLabel.setBorder(line);

      confirmBtn = new JButton("확인"); //

      // === DB 전송 ===================================================================
      confirmBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Save_tel tel = new Save_tel();
            
            String front = tel.tel.substring(4, 8);
            String back = tel.tel.substring(9, 13);
            int frontNum = Integer.parseInt(front);   
            int backNum = Integer.parseInt(back);
            int num = (int)(Math.random()*100)+1;
            int reN = (frontNum *num)*(backNum *num) ;
            String reserveNumber= String.valueOf(reN);
            
            reserveNum = reserveNumber;
            String usertel = tel.tel;
            String departure = startingPointCombo.getSelectedItem().toString();
            destination = destinationField.getText();
            String date = departureField.getText();
            String people = peopleField.getText();
            
            ReserveDAO.insertReserve(reserveNum, usertel, departure, destination, date, people);
            JOptionPane.showMessageDialog(null, "저장 완료");
            frame.dispose();
         }
      });
      // ==============================================================================
      confirmBtn.setBounds(464, 473, 91, 23);
      reservePanel.add(confirmBtn);

      cancelBtn = new JButton("<");

      cancelBtn.setBounds(567, 473, 91, 23);
      reservePanel.add(cancelBtn);

      JLabel lblNewLabel_4_2 = new JLabel("출발지 : ");
      lblNewLabel_4_2.setBounds(88, 316, 81, 23);
      reservePanel.add(lblNewLabel_4_2);

      JLabel startingPointField = new JLabel("");
      startingPointField.setBounds(180, 316, 145, 30);
      reservePanel.add(startingPointField);
      
      JLabel lblNewLabel_5 = new JLabel("");
      lblNewLabel_5.setBounds(38, 298, 325, 178);
      lblNewLabel_5.setBorder(line); 
      reservePanel.add(lblNewLabel_5);

      startingPointCombo.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            startingPointField.setText(startingPointCombo.getSelectedItem().toString());
         }
      });

      destinationCombo.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource(); // 콤보박스 알아내기
            int index = cb.getSelectedIndex();// 선택된 아이템의 인덱스
            imgLabel.setIcon(images[index]); // 인덱스의 이미지를 이미지 레이블에 출력

            destinationField.setText(destinationCombo.getSelectedItem().toString());

         }
      });

      departureDate.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            departureField.setText(model.getYear() + "-" + (model.getMonth() + 1) + "-" + model.getDay());

         }
      });

      people1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            peopleField.setText(people1.getText());
         }
      });
      people2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            peopleField.setText(people2.getText());
         }
      });   
      people3.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            peopleField.setText(people3.getText());
         }
      });
      people4.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            peopleField.setText(people4.getText());
         }
      });

      confirmBtn.addActionListener(this);
      cancelBtn.addActionListener(this);

   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == confirmBtn) {
         new FlightPage();
         frame.dispose();
      } else if (e.getSource() == cancelBtn) {
         new ReserveMainP();
         frame.dispose();
      }
   }
}

   
   