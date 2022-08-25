package project;

import java.sql.*;
import java.util.*;

public class MemberDAO {
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/sqldb?useUnicode=true&serverTimezone=Asia/Seoul";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "my1234";
	private boolean idCheck = false;

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public MemberDAO() {
	}

	// DB 연결
	public Connection DBConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("jdbc 드라이버 연결 완료");
			con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			System.out.println("DB 접속 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc 드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 접속실패" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unknown error");
		}
		return con;
	}

	// 회원 가입
	public boolean insertMember(MemberDTO dto) {
		boolean check = false;

		try {
			con = DBConnection();

			String sqlInsert = "INSERT INTO memberTBL"
					+ "(userid, userpw, username, userbirth, useremail, usertel, useraddr) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?)";

			ps = con.prepareStatement(sqlInsert);
			ps.setString(1, dto.getUserId());
			ps.setString(2, dto.getUserPw());
			ps.setString(3, dto.getUserName());
			ps.setString(4, dto.getUserBirth());
			ps.setString(5, dto.getUserEmail());
			ps.setString(6, dto.getUserTel());
			ps.setString(7, dto.getUserAddr());
			int rs = ps.executeUpdate(); // 실행 -> 저장

			if (rs > 0) {
				System.out.println("가입 성공");
				check = true;
			} else
				System.out.println("가입 실패");
		} catch (Exception e) {
			System.out.println("회원 등록 실패");
		}
		return check;
	}

	// 비회원 가입
	public boolean noMemInsertMember(MemberDTO dto) {
		boolean check = false;

		try {
			con = DBConnection();

			String sqlInsert = "INSERT INTO memberTBL" + "(userpw, username, usertel) " + "VALUES(?, ?, ?)";

			ps = con.prepareStatement(sqlInsert);
			ps.setString(1, dto.getUserPw());
			ps.setString(2, dto.getUserName());
			ps.setString(3, dto.getUserTel());
			int rs = ps.executeUpdate(); // 실행 -> 저장

			if (rs > 0) {
				System.out.println("가입 성공");
				check = true;
			} else
				System.out.println("가입 실패");
		} catch (Exception e) {
			System.out.println("회원 등록 실패");
		}
		return check;
	}

	// 멤버 가져오기
	public MemberDTO getMemberDTO(String userId) {
		MemberDTO dto = new MemberDTO();

		try {
			con = DBConnection();
			String sqlSelect = "SELECT * FROM memberTBL where id = ?";
			ps = con.prepareStatement(sqlSelect);
			ps.setString(1, userId);

			rs = ps.executeQuery();

			if (rs.next()) {
				dto.setUserId(rs.getString("userId"));
				dto.setUserPw(rs.getString("userPw"));
				dto.setUserName(rs.getString("userName"));
				dto.setUserBirth(rs.getString("userBirth"));
				dto.setUserEmail(rs.getString("userEmail"));
				dto.setUserTel(rs.getString("userTel"));
				dto.setUserAddr(rs.getString("userAddr"));
			}
		} catch (Exception e) {
			System.out.println("정보 가져오기 실패");
		}
		return dto;
	}

	// 아이디 중복확인
	public boolean checkId(String id) throws SQLException {
		con = DBConnection();
		String sqlCheck = "SELECT userId FROM memberTBL";
		ps = this.con.prepareStatement(sqlCheck);

		rs = ps.executeQuery();

		while (rs.next()) {
			if (rs.getString("userId").equals(id))
				idCheck = true;
		}
		if (rs != null)
			rs.close();
		if (ps != null)
			ps.close();
		if (con != null)
			con.close();
		return idCheck;
	}

	// 항공권 추가
	public boolean insertTicket(MemberDTO dto) {
		boolean check = false;

		try {
			con = DBConnection();

			String sqlInsert = "INSERT INTO ticketTBL" + "(ticketNum, departure, destination, date, depT, arrT, price) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?)";

			ps = con.prepareStatement(sqlInsert);
			ps.setString(1, dto.getTicketNum());
			ps.setString(2, dto.getDeparture());
			ps.setString(3, dto.getDestination());
			ps.setString(4, dto.getDate());
			ps.setString(5, dto.getDepT());
			ps.setString(6, dto.getArrT());
			ps.setString(7, dto.getPrice());
			int rs = ps.executeUpdate(); // 실행 -> 저장

			if (rs > 0) {
				System.out.println("추가 성공");
				check = true;
			} else
				System.out.println("추가 실패");
		} catch (Exception e) {
			System.out.println("추가 등록 실패");
		}
		return check;
	}
}