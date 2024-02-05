package db.guestBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DBConnection;

public class GuestBook {
	private Connection conn;		// sql과 java를 이어주는 클래스
	private PreparedStatement pr;	// sql를 쿼리문을 통해 내가 원하는 방식으로 사용할 수 있게 해주는 클래스
	private ResultSet rs;			// 쿼리문 결과값을 담는 바구니같은 클래스
	
	public void listView() {
		try {
			// 1. db와 연결한다.			       순서대로 url, userid, userpw
			conn = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
			// 2. 쿼리를 짜서 java를 통해 sql 쿼리를 실행한다.
			pr = conn.prepareStatement("SELECT id"
										  + ", score"
										  + ", DATE_FORMAT(in_date, '%Y-%m-%d') AS \"in_date\" "
									  + "FROM `rank` "
									  + "ORDER BY score DESC");
			rs = pr.executeQuery();	// rs(결과를 담는 바구니)
			
			// 3. 나는 어떠한 모습으로 유저에게 내용을 보여줄 것인가?
			// rs가 가지고 있는 결과값이 있을 땐 true, 없을 땐 false
			int num = 1;
			System.out.println("순위\t아이디\t점수\t등록일");
			while (rs.next()) {
				System.out.println((num++) + "\t" + rs.getString("id") + "\t"  + rs.getString("score") + "\t" + rs.getString("in_date"));
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pr.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		};
	}
}
