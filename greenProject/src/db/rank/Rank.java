package db.rank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.style.Font;
import db.DBConnection;

public class Rank {
	private Connection conn;
	private PreparedStatement pr;
	private ResultSet rs;
	private String sql;
	
	public void rankRead(String id) {
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
			System.out.println("[순위]\t[id]\t[]\t[점수] \t  [등록일]");
			int rank = 0;
			while(rs.next()) {
				String myId = Font.FONT_GREEN + rs.getString("id") + Font.RESET + "\t\t ";
				rank++;
				if(rs.getString("id").equals(id)) {
					System.out.println(rank + "\t" + myId +
										rs.getString("score") + "점\t " + rs.getString("in_date"));
				} else {					
					System.out.println(rank + "\t" + rs.getString("id") + "\t " +
										rs.getString("score") + "점\t " + rs.getString("in_date"));
				}
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
