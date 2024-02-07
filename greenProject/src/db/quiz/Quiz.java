package db.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import common.style.Font;

public class Quiz {
	QuizDB qdb = new QuizDB();

	Scanner sc = new Scanner(System.in);
	int score;
	
	public void game(String subject, String mem_id,String mem_name) {
		List<String> word = new ArrayList<String>();
		List<String> hint = new ArrayList<String>();
		String answer;
		int index = 0;

		word.addAll(qdb.wordList(subject));
		
		System.out.println("총 다섯번의 퀴즈가 진행됩니다!");
		aa: for (int i = 0; i < 5; i++) {
			hint = qdb.hintList(word.get(i));
			
			System.out.println( Font.FONT_GREEN + (i + 1) + "번째 문제" + Font.RESET);
			for (int j = 0; j < hint.size(); j++) {
				System.out.print(">> ");
				System.out.println(+ (j + 1) + "번째 힌트 [ " + hint.get(j) + " ]");
				
				System.out.print(">> 정답 : ");
				
				answer = sc.next();
				index = qdb.wordGame(answer, hint.get(j), j);
				
				if (index == 1) {
					score(j);
					continue aa;
				}
			}
			System.out.println();
		}
		System.out.println(Font.FONT_GREEN + mem_name + "님의 점수는 " + score + "점 입니다." + Font.RESET);
		if(score <= 0){
			System.err.println("0점은 랭킹에 등록되지 않습니다.");
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