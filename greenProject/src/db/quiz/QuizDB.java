package db.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import db.DBConnection;

public class QuizDB {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// 프로젝트 DB에 맞게 컬럼명 변경하기
	
	public List<String> wordList(String subject) {
		List<String> word = new ArrayList<String>();
		try {
			con = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
			pstmt = con.prepareStatement("select * from word where `subject`='" + subject + "' order by floor(rand()*10)");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				word.add(rs.getString("word"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return word;
	}
	
	public List<String> hintList(String word) {
		List<String> hint = new ArrayList<String>();
		List<String> hints = new ArrayList<String>();
		try {
			con = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
			pstmt =  con.prepareStatement("select word,group_concat(hint) from word_hint where word ='"+ word+"'");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				hint = Arrays.asList(rs.getString("group_concat(hint)").split(","));
				hints = hint;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Collections.shuffle(hints);
		
		return hints;
	}
	
	public int wordGame(String answer,String hint,int j) {
		try {
			con = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
			pstmt = con.prepareStatement("select * from word_hint where word='"+answer+"' and hint='"+hint+"'");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("정답");
				return 1;
			}
			else if(j < 2){
				System.out.println("다음힌트");
			}
			else {
				System.out.println("맞추지 못했습니다 다음문제");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public void rankInsert(int score, String subject,String mem_id) {
		try {
			con = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
			pstmt = con.prepareStatement
					("insert into `rank` (score,id,in_date) values ("+score+",'"+mem_id+"',now())");
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
