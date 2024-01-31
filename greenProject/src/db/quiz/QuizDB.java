package db.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;

public class QuizDB {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public List<String> wordSelect(String subject) {
		List<String> word = new ArrayList<String>();
		try {
			con = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
			pstmt = con.prepareStatement("select * from word where subject='" + subject+"'");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				word.add(rs.getString("word"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return word;
	}
	
	public List<String> hintSelect(String word) {
		List<String> hint = new ArrayList<String>();
		try {
			con = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
			pstmt = con.prepareStatement("select * from word_hint where word='" + word+"'");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				hint.add(rs.getString("hint"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hint;
	}
	
	public void rankInsert(int score,String id) {
		try{
			con = DriverManager.getConnection(DBConnection.JDBC_URL, DBConnection.USERNAME, DBConnection.PASSWORD);
			pstmt = con.prepareStatement("insert into `rank` (score,id,in_date) values (?,?,now())");
			
			pstmt.setInt(1, score);
			pstmt.setString(2, id);
			
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
