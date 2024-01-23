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
	
	//564165465465454
	
	
	public void test(String a, String b) {
		try {
			conn = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
			sql = "INSERT INTO test (`id`,`pw`) VALUES (?,?)";
			// ProparedStatement : SQL 문에 매개변수를 전달하는 데 사용
			PreparedStatement pre = conn.prepareStatement(sql);
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
	
	
	
}
