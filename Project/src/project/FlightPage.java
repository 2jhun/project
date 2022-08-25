package project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class FlightPage extends JFrame implements MouseListener, ActionListener {

   private JFrame frame;
   private JTable table;
   private JTable departureTable,departureData;
   private JButton confirmBtn;
   private JButton cancelBtn;
   JLabel dtField, atField, priceField, destinationField;
   private LineBorder line = new LineBorder(Color.black, 1, true); 
   public FlightPage() {
      
      
      
      frame = new JFrame();
      JPanel panel = new JPanel();
      String[] headings = new String[] { "티켓넘버", "출발지", "도착지 ", "날짜", "출발시간", "도착시간", "가격" };
      String[][] data = ReserveDAO.getTicket();
      DefaultTableModel model = new DefaultTableModel(data, headings) {
         @Override
         public boolean isCellEditable(int row, int column) { // 내용 변경 불가
            return false;
         };
      };
      
      model.fireTableDataChanged();
      frame.getContentPane().add(panel);
      panel.setLayout(null);
      frame.setVisible(true);
      frame.setSize(800, 640);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JPanel flightPanel = new JPanel();
      flightPanel.setLayout(null);

      departureData = new JTable(model);
      departureData.setFillsViewportHeight(true);
      departureData.setBounds(103, 37, 540, 457);
      JScrollPane scrollPane_1 = new JScrollPane(departureData);
      scrollPane_1.setBounds(69, 37, 622, 253);
      flightPanel.add(scrollPane_1);
      frame.getContentPane().add(flightPanel);

      confirmBtn = new JButton("확인");
      confirmBtn.setBounds(527, 517, 70, 23);
      flightPanel.add(confirmBtn);

      cancelBtn = new JButton("<");
      cancelBtn.setBounds(609, 517, 70, 23);
      flightPanel.add(cancelBtn);

      destinationField = new JLabel("");
      destinationField.setBounds(272, 385, 64, 15);
      flightPanel.add(destinationField);

      dtField = new JLabel("");
      dtField.setBounds(142, 428, 70, 15);
      flightPanel.add(dtField);

      atField = new JLabel("");
      atField.setBounds(279, 428, 70, 15);
      flightPanel.add(atField);

      priceField = new JLabel("");
      priceField.setBounds(142, 469, 70, 15);
      flightPanel.add(priceField);
      

      JLabel destination_1 = new JLabel("티켓 넘버 :");
      destination_1.setBounds(69, 349, 64, 15);
      flightPanel.add(destination_1);

      JLabel destination_1_1 = new JLabel("출발지 : ");
      destination_1_1.setBounds(69, 385, 64, 15);
      flightPanel.add(destination_1_1);

      JLabel destination_1_2 = new JLabel("도착지 :");
      destination_1_2.setBounds(218, 385, 64, 15);
      flightPanel.add(destination_1_2);

      JLabel destination_1_2_1 = new JLabel("날짜 :");
      destination_1_2_1.setBounds(218, 349, 64, 15);
      flightPanel.add(destination_1_2_1);

      JLabel destination_1_2_1_1 = new JLabel("출발시간 :");
      destination_1_2_1_1.setBounds(69, 428, 64, 15);
      flightPanel.add(destination_1_2_1_1);

      JLabel destination_1_2_1_1_1 = new JLabel("도착시간 :");
      destination_1_2_1_1_1.setBounds(218, 428, 64, 15);
      flightPanel.add(destination_1_2_1_1_1);

      JLabel destination_1_2_1_1_1_1 = new JLabel("가격 :");
      destination_1_2_1_1_1_1.setBounds(69, 469, 64, 15);
      flightPanel.add(destination_1_2_1_1_1_1);

      JLabel departureField = new JLabel("");
      departureField.setBounds(142, 385, 64, 15);
      flightPanel.add(departureField);

      JLabel dateField = new JLabel("");
      dateField.setBounds(272, 349, 64, 15);
      flightPanel.add(dateField);

      JLabel ticketNumField = new JLabel(" ");
      ticketNumField.setBounds(142, 349, 64, 15);
      flightPanel.add(ticketNumField);
      
      JLabel lblNewLabel = new JLabel("항공편 선택");
      lblNewLabel.setBounds(69, 12, 126, 15);
      flightPanel.add(lblNewLabel);
      
      JLabel lblNewLabel_1 = new JLabel("");
      lblNewLabel_1.setBounds(39, 318, 361, 205);
      lblNewLabel_1.setBorder(line);
      flightPanel.add(lblNewLabel_1);

      // ======항공편 클릭시 하단 에 정보기입 =================================================
      departureData.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            int idx = departureData.getSelectedRow();
            ticketNumField.setText((String) departureData.getValueAt(idx, 0));
            departureField.setText((String) departureData.getValueAt(idx, 1));
            destinationField.setText((String) departureData.getValueAt(idx, 2));
            dateField.setText((String) departureData.getValueAt(idx, 3));
            dtField.setText((String) departureData.getValueAt(idx, 4));
            atField.setText((String) departureData.getValueAt(idx, 5));
            priceField.setText((String) departureData.getValueAt(idx, 6));

            System.out.println((String) departureData.getValueAt(idx, 0)); // 넘어가는지 확인용
         }
      }); // ==================================================================================

      confirmBtn.addActionListener(this);
      cancelBtn.addActionListener(this);
      frame.setVisible(true);
   }

   // ================================================================================
   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == confirmBtn) {
         updateReserve();
         new SeatPage();
         frame.dispose();

      } else if (e.getSource() == cancelBtn) {
         new ReservePage();
         frame.dispose();

      }
   }

   // ================================================================================
   private void updateReserve() {
      ReserveDTO dto = ReserveData();
      ReserveDAO db = new ReserveDAO();
      boolean check = db.updateReserve(dto);
      if (check) {
         JOptionPane.showMessageDialog(null, "저장완료");
      } else
         JOptionPane.showMessageDialog(null, "저장실패");
   }

   // ================================================================================
   public ReserveDTO ReserveData() {
      ReserveDTO dto = new ReserveDTO();
      String dtFd = dtField.getText();
      String atFd = atField.getText();
      String prFd = priceField.getText();
      dto.setDepT(dtFd);
      dto.setArrT(atFd);
      dto.setPrice(prFd);
      return dto;
   }

   // ================================================================================

   @Override
   public void mouseClicked(MouseEvent e) {
   }

   @Override
   public void mousePressed(MouseEvent e) {
   }

   @Override
   public void mouseReleased(MouseEvent e) {
   }

   @Override
   public void mouseEntered(MouseEvent e) {
   }

   @Override
   public void mouseExited(MouseEvent e) {
   }
} // -- 끝