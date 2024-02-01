package db.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DBConnection;
import db.input.InfoInput;
import style.Font;

public class User {
	private Connection conn; // data base connection
	private Statement stmt; // sql query 실행
	private ResultSet rs; // query result
	private String sql; // query를 담을 String타입 변수
	private InfoInput input = new InfoInput();

	// 아이디 중복 체크 sdqwe12
	public boolean idCheck(String id) {
		try {
			conn = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement("select id from member where id='" + id + "'");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("중복된 아이디입니다. 다시 입력해주세요");
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("사용 가능한 아이디입니다.");
		return false;

	}

	// 회원가입 sdqwe12
	public void signUp(String id, String pw, String name) {
		try {
			conn = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
			sql = "insert into member (id,pw,name,state,sign_date) values (?,?,?,0,now())";
			PreparedStatement pre = conn.prepareStatement(sql);

			pre.setString(1, id);
			pre.setString(2, pw);
			pre.setString(3, name);
			pre.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 로그인 후 유저 정보 가져오기
	public UserVO userInfo(String id, String pw) {
		UserVO nvo = new UserVO();
		try {
			conn = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
			sql = "SELECT * FROM member WHERE id = ?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, id);

			rs = pre.executeQuery();

			if (rs.next()) {
				nvo.setId(rs.getString("id"));
				nvo.setPw(pw);
				nvo.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
<<<<<<< HEAD

=======
>>>>>>> 28c6800d9cea51788995fdbf460510f615a174a0
		return nvo;
	}

	// 로그인 ( 은애 )
	public String login(String id, String pw) {
		try {
			conn = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
			sql = "SELECT * FROM member WHERE id = ?";
			PreparedStatement pre = conn.prepareStatement(sql);
			// 파라미터 설정
			pre.setString(1, id);

			// 쿼리 실행
			try (ResultSet resultSet = pre.executeQuery()) {
				if (resultSet.next()) {
					// 탈퇴유저 확인(1:탈퇴회원, 0:탈퇴안한회원)
					String userState = resultSet.getString("state");
					// 사용자가 존재하는 경우 비밀번호 확인
					String storedPassword = resultSet.getString("pw");

					if (userState.equals("1")) { // 탈퇴 회원일 경우
						return "SIGNOUT_USER";
					} else if (userState.equals("0")) { // 탈퇴 안한 회원일 경우
						if (pw.equals(storedPassword)) {
							// 비밀번호가 일치하는 경우 로그인 성공
							return "SUCCESS";
						} else {
							// 비밀번호가 일치하지 않는 경우
							return "WRONG_PASSWORD";
						}
					}
				} else {
					// 사용자가 존재하지 않는 경우
					return "USER_NOT_FOUND";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
			}
		}
		;

		return "ERROR";
	};

	// 회원탈퇴 ( 은애 )
	public int signOut(String id) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
			sql = "UPDATE member " + "   SET state = 1 " + " WHERE id = ?";
			PreparedStatement pre = conn.prepareStatement(sql);
			// 파라미터 설정
			pre.setString(1, id);

			result = pre.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
			}
		}

		if (result > 0) {
			return 1;
		} else {
			return 0;
		}
	}

}
