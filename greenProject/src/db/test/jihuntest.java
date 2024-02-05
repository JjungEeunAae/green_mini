package db.test;

package db.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import db.DBConnection;
import db.user.UserVO;
import style.Font;

public class jihuntest {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private String sql;
	private PreparedStatement pre;
	
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
	public void guestBookRead(String id) {
		 String sql = "SELECT CASE "
	                + "WHEN state = 1 THEN '탈퇴회원' "
	                + "ELSE g.id "
	                + "END AS \"id\", title, content, DATE_FORMAT(write_date, '%Y-%m-%d') AS \"write_date\" "
	                + "FROM guest_book g "
	                + "JOIN member m ON g.id = m.id "
	                + "ORDER BY write_date";

	        try (Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {

	            System.out.println("[아이디]\t[제목]\t[내용]\t  [등록일]");
	            while (rs.next()) {
	                System.out.println(rs.getString("id") + "\t" + rs.getString("title") + "\t" + rs.getString("content") + "\t" + rs.getString("write_date"));
	            }
	            System.out.println();

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
				+ "		END AS \"id\" "
				+ "	    , score "
				+ "     , DATE_FORMAT(in_date, '%Y-%m-%d') AS \"in_date\" "
				+ "  FROM `rank` r "
				+ "  JOIN member m "
				+ "    ON r.id = m.id "
				+ " ORDER BY score DESC "
				+ " LIMIT 0,10";
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				System.out.println("❤️랭크는 10등까지만 보입니다❤️");
				System.out.println("[id]\t[점수] \t  [등록일]");
				while(rs.next()) {
					System.out.println(rs.getString("id") + "\t " + rs.getString("score") + "점\t " + rs.getString("in_date"));
				}
				System.out.println();
			} catch (Exception e) {
				e.printStackTrace();
			};
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 방명록 등록
	public int guestBookInsert(String id, String title, String content) {
		   String sql = "INSERT INTO guest_book(id, title, content, write_date) VALUES (?,?,?,NOW())";

	        try (PreparedStatement pre = conn.prepareStatement(sql)) {
	            pre.setString(1, id);
	            pre.setString(2, title);
	            pre.setString(3, content);

	            int rowsAffected = pre.executeUpdate();

	            // 성공적으로 실행되었을 때
	            if (rowsAffected > 0) {
	                System.out.println("방명록이 성공적으로 등록되었습니다.");
	                return rowsAffected;
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return 0;
	    }

	// 삭제할 목록 보여주기
	public void deleteGuestBookList(String id) {
		 String sql = "SELECT guest_no, title, content, DATE_FORMAT(write_date, '%Y-%m-%d') AS \"write_date\" FROM guest_book WHERE id = ?";

	        try (PreparedStatement pre = conn.prepareStatement(sql)) {
	            pre.setString(1, id);
	            try (ResultSet rs = pre.executeQuery()) {
	                if (rs.next()) {
	                    System.out.println("[글번호]\t[제목]\t[내용]\t  [등록일]");
	                    do {
	                        System.out.println(rs.getString("guest_no") + "\t"
	                                + rs.getString("title") + "\t"
	                                + rs.getString("content") + "\t"
	                                + rs.getString("write_date"));
	                    } while (rs.next());
	                } else {
	                    System.out.println("작성한 글이 없습니다.");
	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	// 글 삭제
	public int guestBookDelete(String id, int guestNo) {
		 String sql = "DELETE FROM guest_book WHERE guest_no = ? AND id = ?";

	        try (PreparedStatement pre = conn.prepareStatement(sql)) {
	            pre.setInt(1, guestNo);
	            pre.setString(2, id);

	            return pre.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return 0;
	    }
	
	// 회원가입전에 아이디 중복체크하기
	public boolean findById(String id) {
		try {
			conn = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
			sql = "SELECT * FROM member WHERE id = ?";
			pre = conn.prepareStatement(sql);
			pre.setString(1, id);
			
			rs = pre.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	// 회원가입
	public void signUp(UserVO member) {
		int result = 0;
		
		boolean findByid = findById(member.getId());
		
		if(!findByid) {	// 중복된 아이디가 없으면 회원가입 진행
			try {
				conn = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
				sql = "INSERT INTO member (id, pw, name, state, sign_date) "
					+ "VALUES (?,?,?,0,NOW())";
				pre = conn.prepareStatement(sql);
				pre.setString(1, member.getId());
				pre.setString(2, member.getPw());
				pre.setString(3, member.getName());
				
				result = pre.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(result > 0) {
				System.out.println("회원등록이 완료되었습니다.");
			} else {
				System.out.println("등록실패");
			}
		} else {
			System.err.println("중복된 아이디가 있어 회원가입이 불가합니다.");
		}
	}
	
	// 퀴즈
	public Map<String, List<String>> quiz(String subject) {
		Map<String,List<String>> quiz = new HashMap<>();
		try {
			conn = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
			sql = "SELECT h.word "
				+ "     , `subject` "
				+ "     , GROUP_CONCAT(hint SEPARATOR  ',') AS \"hint\" "
				+ "  FROM word w "
				+ "  JOIN word_hint h "
				+ "    ON h.word = w.word "
				+ " WHERE `subject` = ? "
				+ " GROUP BY h.word "
				+ " ORDER BY 2 ASC";
			pre = conn.prepareStatement(sql);
			pre.setString(1, subject);
			
			rs = pre.executeQuery();
			if(rs.next()) {
				while(rs.next()) {
					// 쉼표로 구분된 힌트 문자열을 리스트로 변환
					List<String> hint = Arrays.asList(rs.getString("hint").split(","));
					quiz.put(rs.getString("word"), hint);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quiz;
	}
	
	// 퀴즈 풀면 DB에도 저장해야지!
	public int score(int score, String id) {
		int result = 0;
		if(score > 0) {
			try {
				conn = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
				sql = "INSERT INTO `rank` (score, id, in_date) "
						+ "VALUES (?, ?,NOW())";
				
				pre = conn.prepareStatement(sql);
				pre.setInt(1, score);
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
		return 0;
	}
	
	// 퀴즈 돌려돌려 돌림판~!
	public void quizPrint(String subject, String id) {
		Scanner sc = new Scanner(System.in);
		String answer = "";
		
		Map<String, List<String>> quiz = quiz(subject);
		Set<String> key = quiz.keySet();// 모든 키를 포함하는 Set 가져오기
		String[] keyArr = key.toArray(new String[key.size()]);// Set을 String 배열로 만들기
		
		quiz:while(true) {
			int random = (int)(Math.random() * (quiz.size()-1)) + 1;
			String word = keyArr[random];
			List<String> hint = quiz.get(word);
			
			System.out.println(word + ": " + hint);
			
			int score = 30;
			for(int i = 0 ; i < hint.size() ; i++) {
				System.out.println("힌트 " + "( " + (i+1) +"회 ): " + hint.get(i));
				System.out.println("정답을 입력해주세요!(종료:0)");
				answer = sc.next();
				
				// 힌트를 모두 받았지만 정답을 맞추지 못했을 때
				if(i + 1 == hint.size()) {
					score = score - 10;
					System.out.println(Font.BACKGROUND_BLACK + Font.FONT_RED+"아쉽지만 정답을 맞추지 못했습니다!"+Font.RESET);
					System.out.println("정답은 [" + word + "] 였습니다!");
					System.out.println();
					System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN+"다른 문제가 출제됩니다. 바로 힌트 들어갑니다 >_<!"+Font.RESET);
					continue quiz;	// 바로 다른 문제 나감
				};
				
				// 퀴즈를 한 번에 맞추면 가산점 주기
				if( i == 0) {
					if(word.equals(answer)) {
						System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN+"    와우! 바로 맞추셨네요! 가산점 들어갑니다~!    "+Font.RESET);
						score += 20;
						score(score,id);	// 랭크 목록에 저장
						System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN+"      당신의 점수는 " + score + "점 입니다. 축하합니다!     "+Font.RESET);
						break quiz;
					}
				}
				
				if(word.equals(answer)) {
					System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN+"                 정답입니다!                 "+Font.RESET);
					score(score,id);	// 랭크 목록에 저장
					System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN+"      당신의 점수는 " + score + "점 입니다. 축하합니다!     "+Font.RESET);
					break quiz;
				} else if(answer.equals("0")){
					System.out.println(Font.BACKGROUND_BLACK + Font.FONT_RED+"게임을 종료합니다 :)"+Font.RESET);
					break quiz;
				} else {
					System.out.println(Font.BACKGROUND_BLACK + Font.FONT_RED+"틀렸습니다!"+Font.RESET);
					score = score - 10;
				}
			}
		}
		
	}
	
}
