package db.quiz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import db.user.UserVO;

public class Quiz {
	private Connection conn; // data base connection
	private Statement stmt; // sql query 실행
	private ResultSet rs; // query result
	private String sql; // query를 담을 String타입 변수
	
	QuizDB qdb = new QuizDB();

	Scanner sc = new Scanner(System.in);
	String answer = "";
	int score;
	
	public void game(String subject, String mem_id,String mem_name) {
		List<String> word = new ArrayList<String>();
		List<String> hint = new ArrayList<String>();
		String answer;
		int index = 0;

		word.addAll(qdb.wordList(subject));

		Collections.shuffle(word);

		aa: for (int i = 0; i < word.size(); i++) {
			hint = qdb.hintList(word.get(i));
			System.out.println(i + 1 + "번째 문제");
			
			for (int j = 0; j < hint.size(); j++) {
				System.out.println(j + 1 + "번째 힌트 " + hint.get(j));
				System.out.print("정답 : ");
				
				answer = sc.next();
				index = qdb.wordGame(answer, hint.get(j), j);
				
				if (index == 1) {
					score(j);
					continue aa;
				}
			}
		}
		System.out.println(mem_name+"님의 점수는 " + score + "점 입니다.");
		if(score <= 0){
			System.out.println("0점은 랭킹에 등록되지 않습니다.");
		}
		else {
			qdb.rankInsert(score, subject, mem_id);
		}
		score = 0;
	}
	
	public void score(int j) {
		int score1 = 5;
		int score2 = 3;
		int score3 = 1;
		
		switch(j) {
		case 0:
			score += score1;
			break;
		case 1:
			score += score2;
			break;
		case 2:
			score += score3;
			break;
		}
	}
}