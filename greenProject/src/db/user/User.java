package db.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DBConnection;

public class User {
	private Connection conn;	// data base connection
	private Statement stmt;		// sql query 실행
	private ResultSet rs;		// query result
	private String sql;			// query를 담을 String타입 변수
	
	
	
	
	
	
	
	
	
	
	
	
	// 로그인 ( 은애 )
	public String login(String id, String pw) {
		try {
			conn = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
			sql = "SELECT * FROM test WHERE id = ?";
			PreparedStatement pre = conn.prepareStatement(sql);
			// 파라미터 설정
			pre.setString(1, id);
            
            // 쿼리 실행
            try (ResultSet resultSet = pre.executeQuery()) {
            	if (resultSet.next()) {
                    // 사용자가 존재하는 경우 비밀번호 확인
                    String storedPassword = resultSet.getString("pw");
                    if (pw.equals(storedPassword)) {
                        // 비밀번호가 일치하는 경우 로그인 성공
                        return "SUCCESS";
                    } else {
                        // 비밀번호가 일치하지 않는 경우
                        return "WRONG_PASSWORD";
                    }
                } else {
                    // 사용자가 존재하지 않는 경우
                    return "USER_NOT_FOUND";
                }
            }
            
		} catch (SQLException e) {
			e.printStackTrace();
		};
		
		return "ERROR";
	};
	
	
	
	
	// 회원탈퇴 ( 미정 )
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
