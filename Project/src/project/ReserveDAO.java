package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;

public class ReserveDAO {

	public static void main(String[] args) {
		ReserveDAO();
	}

	static Connection con = null;
	static PreparedStatement ps = null;
//	ResultSet rs = null;
	static String url = "jdbc:mysql://127.0.0.1:3306/sqldb?useUnicode=true&serverTimezone=Asia/Seoul";
	static String user = "root";
	static String pwd = "my1234";

	// == DB 연결 ========================================================
	public static Connection ReserveDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 6.0 버전 이후
			System.out.println("드라이버 연결 성공 ");
			Connection con = DriverManager.getConnection(url, user, pwd);
			System.out.println("데이터베이스 연결 성공 ");
			return con;

		} catch (Exception e) {
			System.out.println("데이터베이스 연결오류 " + e.getMessage());
		}
		return null;
	} // ==DB 연결 끝 ====================================================

	// === ReservePage 정보 삽입====================================================
	public static void insertReserve(String reserveNum, String usertel, String departure, String destination,
			String date, String people) {
		try {
			Connection con = ReserveDAO();

			PreparedStatement ps = con.prepareStatement("" + "INSERT INTO ReserveTBL"
					+ "(reserveNum, usertel, departure, destination, date,people)" + "VALUE" + "('" + reserveNum + "','"
					+ usertel + "','" + departure + "','" + destination + "','" + date + "','" + people + "')");
			ps.executeUpdate();
			System.out.println("Save");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	// === ReservePage 정보 삽입끝====================================================

	// === 항공편 전체 불러오기 =========================================================

	public static String[][] getTicket() {
		ReserveDTO dto = new ReserveDTO();
		try {
			con = ReserveDAO();
			PreparedStatement statement = con.prepareStatement("Select " + "ticketNum, " + "departure," + "destination,"
					+ "date," + "depT," + "arrT," + "price FROM ticketTBL");

			ResultSet results = statement.executeQuery();

			ArrayList<String[]> list = new ArrayList<String[]>();
			while (results.next()) {
				list.add(new String[] { results.getString("ticketNum"), results.getString("departure"),
						results.getString("destination"), results.getString("date"), results.getString("depT"),
						results.getString("arrT"), results.getString("price") });
			}
			String[][] arr = new String[list.size()][7];
			return list.toArray(arr);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}// === 항공편 전체 불러오기 끝
		// =======================================================================

	// == flight 업데이트
	// ===============================================================
	public boolean updateReserve(ReserveDTO dto) {
		boolean check = false;
		Save_tel tel = new Save_tel();
		try {
			con = ReserveDAO();
			String sqlUpdate = "UPDATE ReserveTBL SET depT = ?, arrT = ?, price = ? WHERE usertel = ?";
			String usetel = tel.tel;
			ps = con.prepareStatement(sqlUpdate);
			ps.setString(1, dto.getDepT());
			ps.setString(2, dto.getArrT());
			ps.setString(3, dto.getPrice());
			ps.setString(4, usetel);
			int rs = ps.executeUpdate();

			if (rs > 0) {
				System.out.println("save");
				check = true;
			} else
				System.out.println("실패");
		} catch (Exception e) {
			System.out.println("실패사유 :" + e.getMessage());
		}
		return check;

	} // == flight업데이트
		// 끝===============================================================

	// == seat업데이트 ===============================================================
	public boolean updateReserve2(ReserveDTO dto) {
		boolean check = false;
		Save_tel tel = new Save_tel();
		try {
			con = ReserveDAO();
			String sqlUpdate = "UPDATE ReserveTBL SET seat = ? WHERE usertel = ?";

			String usetel = tel.tel;
			ps = con.prepareStatement(sqlUpdate);
			ps.setString(1, dto.getSeat());
			ps.setString(2, usetel);
			int rs = ps.executeUpdate();

			if (rs > 0) {
				System.out.println("save");
				check = true;
			} else
				System.out.println("실패");
		} catch (Exception e) {
			System.out.println("실패사유 :" + e.getMessage());
		}
		return check;

	} // == 업데이트 끝 ===============================================================

}