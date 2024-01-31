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
	int tscore;
	
	public void score(int j) {
		int score1 = 5;
		int score2 = 3;
		int score3 = 1;
		
		switch(j) {
		case 0:
			tscore += score1;
			break;
		case 1:
			tscore += score2;
			break;
		case 2:
			tscore += score3;
			break;
		}
	}

	public void color(String mem_name) {
		
		String name = mem_name;
		
		List<String> word = new ArrayList<String>();
		List<String> hint1 = new ArrayList<String>();
		List<String> hint2 = new ArrayList<String>();
		List<String> hint3 = new ArrayList<String>();
		List<String> hint4 = new ArrayList<String>();
		List<String> hint5 = new ArrayList<String>();
		List<String> hint6 = new ArrayList<String>();
		List<String> hint7 = new ArrayList<String>();
		List<String> hint8 = new ArrayList<String>();
		List<String> hint9 = new ArrayList<String>();
		List<String> hint10 = new ArrayList<String>();
		
		word = qdb.wordSelect("색상");
		hint1 = qdb.hintSelect("빨간색");
		hint2 = qdb.hintSelect("주황색");
		hint3 = qdb.hintSelect("노란색");
		hint4 = qdb.hintSelect("초록색");
		hint5 = qdb.hintSelect("분홍색");
		hint6 = qdb.hintSelect("갈색");
		hint7 = qdb.hintSelect("보라색");
		hint8 = qdb.hintSelect("흰색");
		hint9 = qdb.hintSelect("검은색");
		hint10 = qdb.hintSelect("회색");
		
		Collections.shuffle(word);
		Collections.shuffle(hint1);
		Collections.shuffle(hint2);
		Collections.shuffle(hint3);
		Collections.shuffle(hint4);
		Collections.shuffle(hint5);
		Collections.shuffle(hint6);
		Collections.shuffle(hint7);
		Collections.shuffle(hint8);
		Collections.shuffle(hint9);
		Collections.shuffle(hint10);
		
		aa:for(int i = 0; i < word.size();i++) {
			System.out.println((i+1) + "번 문제");
			for(int j = 0;j<3;j++) {
				if(word.get(i).equals("빨간색")) {
					System.out.println((j+1) + "번 힌트 " + hint1.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
					
				}
				else if(word.get(i).equals("주황색")) {
					System.out.println((j+1) + "번 힌트 " + hint2.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				else if(word.get(i).equals("노란색")) {
					System.out.println((j+1) + "번 힌트 " + hint3.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				else if(word.get(i).equals("초록색")) {
					System.out.println((j+1) + "번 힌트 " + hint4.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				else if(word.get(i).equals("분홍색")) {
					System.out.println((j+1) + "번 힌트 " + hint5.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				else if(word.get(i).equals("갈색")) {
					System.out.println((j+1) + "번 힌트 " + hint6.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				else if(word.get(i).equals("보라색")) {
					System.out.println((j+1) + "번 힌트 " + hint7.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				else if(word.get(i).equals("흰색")) {
					System.out.println((j+1) + "번 힌트 " + hint8.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				else if(word.get(i).equals("검은색")) {
					System.out.println((j+1) + "번 힌트 " + hint9.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				else if(word.get(i).equals("회색")) {
					System.out.println((j+1) + "번 힌트 " + hint10.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				
			}
		}
		System.out.println(tscore);
		qdb.rankInsert(tscore, name);
		tscore = 0;
		
	}
	

	public void animal(String mem_name) {
		
		String name = mem_name;
		
		List<String> word = new ArrayList<String>();
		List<String> hint1 = new ArrayList<String>();
		List<String> hint2 = new ArrayList<String>();
		List<String> hint3 = new ArrayList<String>();
		List<String> hint4 = new ArrayList<String>();
		List<String> hint5 = new ArrayList<String>();
		List<String> hint6 = new ArrayList<String>();
		List<String> hint7 = new ArrayList<String>();
		List<String> hint8 = new ArrayList<String>();
		List<String> hint9 = new ArrayList<String>();
		List<String> hint10 = new ArrayList<String>();
		
		word = qdb.wordSelect("동물");
		hint1 = qdb.hintSelect("강아지");
		hint2 = qdb.hintSelect("고양이");
		hint3 = qdb.hintSelect("말");
		hint4 = qdb.hintSelect("사자");
		hint5 = qdb.hintSelect("코끼리");
		hint6 = qdb.hintSelect("원숭이");
		hint7 = qdb.hintSelect("곰");
		hint8 = qdb.hintSelect("사슴");
		hint9 = qdb.hintSelect("고래");
		hint10 = qdb.hintSelect("새");
		
		Collections.shuffle(word);
		Collections.shuffle(hint1);
		Collections.shuffle(hint2);
		Collections.shuffle(hint3);
		Collections.shuffle(hint4);
		Collections.shuffle(hint5);
		Collections.shuffle(hint6);
		Collections.shuffle(hint7);
		Collections.shuffle(hint8);
		Collections.shuffle(hint9);
		Collections.shuffle(hint10);
		
		aa:for(int i = 0; i < word.size();i++) {
			System.out.println((i+1) + "번 문제");
			for(int j = 0;j<3;j++) {
				if(word.get(i).equals("강아지")) {
					System.out.println((j+1) + "번 힌트 " + hint1.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
					
				}
				else if(word.get(i).equals("고양이")) {
					System.out.println((j+1) + "번 힌트 " + hint2.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				else if(word.get(i).equals("말")) {
					System.out.println((j+1) + "번 힌트 " + hint3.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				else if(word.get(i).equals("사자")) {
					System.out.println((j+1) + "번 힌트 " + hint4.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				else if(word.get(i).equals("코끼리")) {
					System.out.println((j+1) + "번 힌트 " + hint5.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				else if(word.get(i).equals("원숭이")) {
					System.out.println((j+1) + "번 힌트 " + hint6.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				else if(word.get(i).equals("곰")) {
					System.out.println((j+1) + "번 힌트 " + hint7.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				else if(word.get(i).equals("사슴")) {
					System.out.println((j+1) + "번 힌트 " + hint8.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				else if(word.get(i).equals("고래")) {
					System.out.println((j+1) + "번 힌트 " + hint9.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				else if(word.get(i).equals("새")) {
					System.out.println((j+1) + "번 힌트 " + hint10.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				
			}
		}
		System.out.println(tscore);
		qdb.rankInsert(tscore,name);
		tscore = 0;
	}

	public void food(String mem_name) {
		
		String name = mem_name;
		
		List<String> word = new ArrayList<String>();
		List<String> hint1 = new ArrayList<String>();
		List<String> hint2 = new ArrayList<String>();
		List<String> hint3 = new ArrayList<String>();
		List<String> hint4 = new ArrayList<String>();
		List<String> hint5 = new ArrayList<String>();
		List<String> hint6 = new ArrayList<String>();
		List<String> hint7 = new ArrayList<String>();
		List<String> hint8 = new ArrayList<String>();
		List<String> hint9 = new ArrayList<String>();
		List<String> hint10 = new ArrayList<String>();
		
		word = qdb.wordSelect("음식");
		hint1 = qdb.hintSelect("피자");
		hint2 = qdb.hintSelect("파스타");
		hint3 = qdb.hintSelect("치킨");
		hint4 = qdb.hintSelect("초밥");
		hint5 = qdb.hintSelect("햄버거");
		hint6 = qdb.hintSelect("라면");
		hint7 = qdb.hintSelect("스테이크");
		hint8 = qdb.hintSelect("떡볶이");
		hint9 = qdb.hintSelect("샐러드");
		hint10 = qdb.hintSelect("아이스크림");
		
		Collections.shuffle(word);
		Collections.shuffle(hint1);
		Collections.shuffle(hint2);
		Collections.shuffle(hint3);
		Collections.shuffle(hint4);
		Collections.shuffle(hint5);
		Collections.shuffle(hint6);
		Collections.shuffle(hint7);
		Collections.shuffle(hint8);
		Collections.shuffle(hint9);
		Collections.shuffle(hint10);
		
		aa:for(int i = 0; i < word.size();i++) {
			System.out.println((i+1) + "번 문제");
			for(int j = 0;j<3;j++) {
				if(word.get(i).equals("피자")) {
					System.out.println((j+1) + "번 힌트 " + hint1.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
					
				}
				else if(word.get(i).equals("파스타")) {
					System.out.println((j+1) + "번 힌트 " + hint2.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				else if(word.get(i).equals("치킨")) {
					System.out.println((j+1) + "번 힌트 " + hint3.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				else if(word.get(i).equals("초밥")) {
					System.out.println((j+1) + "번 힌트 " + hint4.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				else if(word.get(i).equals("햄버거")) {
					System.out.println((j+1) + "번 힌트 " + hint5.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				else if(word.get(i).equals("라면")) {
					System.out.println((j+1) + "번 힌트 " + hint6.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				else if(word.get(i).equals("스테이크")) {
					System.out.println((j+1) + "번 힌트 " + hint7.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				else if(word.get(i).equals("떡볶이")) {
					System.out.println((j+1) + "번 힌트 " + hint8.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				else if(word.get(i).equals("샐러드")) {
					System.out.println((j+1) + "번 힌트 " + hint9.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				else if(word.get(i).equals("아이스크림")) {
					System.out.println((j+1) + "번 힌트 " + hint10.get(j));
					System.err.println("정답을 입력해주세요.");
					answer = sc.next();
					if(word.get(i).equals(answer)){
						System.out.println("정답입니다.");
						score(j);
						continue aa;
					}
					else {
						System.out.println("오답입니다.");
						continue;
					}
				}
				
			}
		}
		System.out.println(tscore);
		qdb.rankInsert(tscore, name);
		tscore = 0;
	}

}
