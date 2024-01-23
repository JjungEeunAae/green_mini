package db.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DBConnection;

public class Test {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private String sql;
	private PreparedStatement pre;
	
	//564165465465454
	
	
	public void test(String a, String b) {
		try {
			conn = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
			sql = "INSERT INTO test (`id`,`pw`) VALUES (?,?)";
			// ProparedStatement : SQL 문에 매개변수를 전달하는 데 사용
			pre = conn.prepareStatement(sql);
			 // 파라미터 설정
			pre.setString(1, a);
            pre.setString(2, b);

            // 쿼리 실행
            int rowsAffected = pre.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("데이터가 성공적으로 삽입되었습니다.");
            } else {
                System.out.println("데이터 삽입 실패");
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 방명록 목록
	public void guestBookRead() {
		try {
			conn = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
			sql = "SELECT CASE "
				+ "			WHEN state = 1 THEN '탈퇴회원' "
				+ "			ELSE g.id "
				+ "		   END AS \"id\""
				+ "     , title "
				+ "     , content "
				+ "	    , DATE_FORMAT(write_date, '%Y-%m-%d') AS \"write_date\" "
				+ "  FROM guest_book g"
				+ "  JOIN member m "
				+ "    ON g.id = m.id "
				+ " ORDER BY write_date";
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					System.out.println("[아이디]\t[제목]\t[내용]\t  [등록일]");
					while (rs.next()) {
						System.out.println(rs.getString("id") + "\t" + rs.getString("title") + "\t" + rs.getString("content") + "\t" + rs.getString("write_date"));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 랭크 목록
	public void rankRead() {
		try {
			conn = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
			sql = "SELECT CASE "
				+ "			WHEN state = 1 THEN '탈퇴회원' "
				+ "			ELSE r.id "
				+ "		END AS \"id\""
				+ "	    , score "
				+ "     , DATE_FORMAT(in_date, '%Y-%m-%d') AS \"in_date\" "
				+ "  FROM `rank` r"
				+ "  JOIN member m"
				+ "    ON r.id = m.id"
				+ " ORDER BY score DESC "
				+ " LIMIT 0,10";
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					System.out.println("❤️랭크는 10등까지만 보입니다❤️");
					System.out.println("[id]\t[점수] \t  [등록일]");
					while(rs.next()) {
						System.out.println(rs.getString("id") + "\t " + rs.getString("score") + "점\t " + rs.getString("in_date"));
					}
				} else {
					System.out.println("결과가 없습니다.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			};
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 방명록 등록
	public int guestBookInsert(String id, String title, String content) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
			sql = "INSERT INTO guest_book(id, title, content, write_date) "
					+ "VALUES (?,?,?,NOW())";
			pre = conn.prepareStatement(sql);
			pre.setString(1, id);
			pre.setString(2, title);
			pre.setString(3, content);
			
			result = pre.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(result > 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	// 삭제할 목록 보여주기
	public void deleteGuestBookList(String id) {
		try {
			conn = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
			sql = "SELECT guest_no, title, content, DATE_FORMAT(write_date, '%Y-%m-%d') AS \"write_date\" FROM guest_book WHERE id = ?";
			pre = conn.prepareStatement(sql);
			pre.setString(1, id);
			
			rs = pre.executeQuery();
			if(rs.next()) {
				System.out.println("[글번호]\t[제목]\t[내용]\t  [등록일]");
				while(rs.next()) {
					System.out.println(rs.getString("guest_no") + "\t"
										+ rs.getString("title") + "\t"
										+ rs.getString("content") + "\t"
										+ rs.getString("write_date"));
				}
			} else {
				System.out.println("작성한 글이 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 글 삭제
	public int guestBookDelete(String id, int guestNo) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
			sql = "DELETE FROM guest_book WHERE guest_no = ? AND id = ?";
			
			pre = conn.prepareStatement(sql);
			pre.setInt(1, guestNo);
			pre.setString(2, id);
			
			result = pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(result > 0) {
			return 1;
		} else {
			return 0;
		}
	}
}
