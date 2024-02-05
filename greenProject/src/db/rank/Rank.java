package db.rank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DBConnection;

public class Rank {
	private Connection conn;
	private PreparedStatement pr;
	private ResultSet rs;
	private String sql;
	
	public void rankRead() {
		try {
			conn = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
			sql = "SELECT CASE "
				+ "			WHEN state = 1 THEN '탈퇴회원' "
				+ "			ELSE r.id "
				+ "		  END AS \"id\" "
				+ "	    , score "
				+ "     , DATE_FORMAT(in_date, '%Y-%m-%d') AS \"in_date\" "
				+ "  FROM `rank` r "
				+ "  JOIN member m "
				+ "    ON r.id = m.id "
				+ " ORDER BY score DESC "
				+ " LIMIT 0,10";
			pr = conn.prepareStatement(sql);
			rs = pr.executeQuery();
			
			System.out.println("❤️랭크는 10등까지만 보입니다❤️");
			System.out.println("[id]\t[점수] \t  [등록일]");
			while(rs.next()) {
				System.out.println(rs.getString("id") + "\t " + rs.getString("score") + "점\t " + rs.getString("in_date"));
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
			};
		};
	}
}
