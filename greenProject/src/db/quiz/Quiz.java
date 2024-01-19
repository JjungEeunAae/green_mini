package db.quiz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Quiz {
	private Connection conn; // data base connection
	private Statement stmt; // sql query 실행
	private ResultSet rs; // query result
	private String sql; // query를 담을 String타입 변수

	Scanner sc = new Scanner(System.in);

	public void animal() {
		Scanner sc = new Scanner(System.in);
		String answer;
		int tscore = 0;

		String[] animal = { "강아지", "고양이", "말", "사자", "코끼리", "원숭이", "곰", "사슴", "돌고래", "기린" };

		List<String> animals = Arrays.asList(animal);
		Collections.shuffle(animals);

		String[][] animalEx = { { "개", "개", "개" }, { "고양이", "고양이", "고양이" }, { "말", "말", "말" }, { "사자", "사자", "사자" },
				{ "코끼리", "코끼리", "코끼리" }, { "원숭이", "원숭이", "원숭이" }, { "곰", "곰", "곰" }, { "사슴", "사슴", "사슴" },
				{ "돌고래", "돌고래", "돌고래" }, { "기린", "기린", "기린" } };

		aa: for (int i = 0; i < animal.length; i++) {

			int score = 3;

			for (int j = 0; j < animalEx[i].length; j++) {

				if (animal[i].equals("강아지")) {
					System.out.println("힌트 : " + animalEx[0][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(animal[i]) == animal[i].equals(animal[i])) {
						System.out.println("정답");
						tscore += score;

						if (i + 1 == animal.length) {
							System.out.println("게임종료");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("현재점수 : " + tscore);
							System.out.println("다음 문제");
						}
						continue aa;
					} else if (answer.equals(animal[i]) != animal[i].equals(animal[i])) {
						System.out.println("오답");
						score--;

						if (i + 1 == animal.length) {
							System.out.println("게임종료");
							System.out.println("현재 점수 : " + tscore);
						} else if (j + 1 == animalEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}

				} else if (animal[i].equals("고양이")) {
					System.out.println("힌트 : " + animalEx[1][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(animal[i]) == animal[i].equals(animal[i])) {
						System.out.println("정답");
						tscore += score;

						if (i + 1 == animal.length) {
							System.out.println("게임종료");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("현재점수 : " + tscore);
							System.out.println("다음 문제");
						}
						continue aa;
					} else if (answer.equals(animal[i]) != animal[i].equals(animal[i])) {
						System.out.println("오답");
						score--;

						if (i + 1 == animal.length) {
							System.out.println("게임종료");
							System.out.println("현재 점수 : " + tscore);
						} else if (j + 1 == animalEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (animal[i].equals("말")) {
					System.out.println("힌트 : " + animalEx[2][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(animal[i]) == animal[i].equals(animal[i])) {
						System.out.println("정답");
						tscore += score;

						if (i + 1 == animal.length) {
							System.out.println("게임종료");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("현재점수 : " + tscore);
							System.out.println("다음 문제");
						}
						continue aa;
					} else if (answer.equals(animal[i]) != animal[i].equals(animal[i])) {
						System.out.println("오답");
						score--;

						if (i + 1 == animal.length) {
							System.out.println("게임종료");
							System.out.println("현재 점수 : " + tscore);
						} else if (j + 1 == animalEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (animal[i].equals("사자")) {
					System.out.println("힌트 : " + animalEx[3][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(animal[i]) == animal[i].equals(animal[i])) {
						System.out.println("정답");
						tscore += score;

						if (i + 1 == animal.length) {
							System.out.println("게임종료");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("현재점수 : " + tscore);
							System.out.println("다음 문제");
						}
						continue aa;
					} else if (answer.equals(animal[i]) != animal[i].equals(animal[i])) {
						System.out.println("오답");
						score--;

						if (i + 1 == animal.length) {
							System.out.println("게임종료");
							System.out.println("현재 점수 : " + tscore);
						} else if (j + 1 == animalEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (animal[i].equals("코끼리")) {
					System.out.println("힌트 : " + animalEx[4][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(animal[i]) == animal[i].equals(animal[i])) {
						System.out.println("정답");
						tscore += score;

						if (i + 1 == animal.length) {
							System.out.println("게임종료");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("현재점수 : " + tscore);
							System.out.println("다음 문제");
						}
						continue aa;
					} else if (answer.equals(animal[i]) != animal[i].equals(animal[i])) {
						System.out.println("오답");
						score--;

						if (i + 1 == animal.length) {
							System.out.println("게임종료");
							System.out.println("현재 점수 : " + tscore);
						} else if (j + 1 == animalEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (animal[i].equals("원숭이")) {
					System.out.println("힌트 : " + animalEx[5][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(animal[i]) == animal[i].equals(animal[i])) {
						System.out.println("정답");
						tscore += score;

						if (i + 1 == animal.length) {
							System.out.println("게임종료");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("현재점수 : " + tscore);
							System.out.println("다음 문제");
						}
						continue aa;
					} else if (answer.equals(animal[i]) != animal[i].equals(animal[i])) {
						System.out.println("오답");
						score--;

						if (i + 1 == animal.length) {
							System.out.println("게임종료");
							System.out.println("현재 점수 : " + tscore);
						} else if (j + 1 == animalEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (animal[i].equals("곰")) {
					System.out.println("힌트 : " + animalEx[6][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(animal[i]) == animal[i].equals(animal[i])) {
						System.out.println("정답");
						tscore += score;

						if (i + 1 == animal.length) {
							System.out.println("게임종료");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("현재점수 : " + tscore);
							System.out.println("다음 문제");
						}
						continue aa;
					} else if (answer.equals(animal[i]) != animal[i].equals(animal[i])) {
						System.out.println("오답");
						score--;

						if (i + 1 == animal.length) {
							System.out.println("게임종료");
							System.out.println("현재 점수 : " + tscore);
						} else if (j + 1 == animalEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (animal[i].equals("사슴")) {
					System.out.println("힌트 : " + animalEx[7][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(animal[i]) == animal[i].equals(animal[i])) {
						System.out.println("정답");
						tscore += score;

						if (i + 1 == animal.length) {
							System.out.println("게임종료");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("현재점수 : " + tscore);
							System.out.println("다음 문제");
						}
						continue aa;
					} else if (answer.equals(animal[i]) != animal[i].equals(animal[i])) {
						System.out.println("오답");
						score--;

						if (i + 1 == animal.length) {
							System.out.println("게임종료");
							System.out.println("현재 점수 : " + tscore);
						} else if (j + 1 == animalEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (animal[i].equals("돌고래")) {
					System.out.println("힌트 : " + animalEx[8][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(animal[i]) == animal[i].equals(animal[i])) {
						System.out.println("정답");
						tscore += score;

						if (i + 1 == animal.length) {
							System.out.println("게임종료");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("현재점수 : " + tscore);
							System.out.println("다음 문제");
						}
						continue aa;
					} else if (answer.equals(animal[i]) != animal[i].equals(animal[i])) {
						System.out.println("오답");
						score--;

						if (i + 1 == animal.length) {
							System.out.println("게임종료");
							System.out.println("현재 점수 : " + tscore);
						} else if (j + 1 == animalEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (animal[i].equals("기린")) {
					System.out.println("힌트 : " + animalEx[9][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(animal[i]) == animal[i].equals(animal[i])) {
						System.out.println("정답");
						tscore += score;

						if (i + 1 == animal.length) {
							System.out.println("게임종료");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("현재점수 : " + tscore);
							System.out.println("다음 문제");
						}
						continue aa;
					} else if (answer.equals(animal[i]) != animal[i].equals(animal[i])) {
						System.out.println("오답");
						score--;

						if (i + 1 == animal.length) {
							System.out.println("게임종료");
							System.out.println("현재 점수 : " + tscore);
						} else if (j + 1 == animalEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				}
			}
		}
	}

	public void color() {
		Scanner sc = new Scanner(System.in);
		String answer;
		int tscore = 0;

		String[] color = { "빨간색", "주황색", "노란색", "초록색", "파란색", "남색", "보라색", "흰색", "검은색", "회색" };

		List<String> colors = Arrays.asList(color);
		Collections.shuffle(colors);

		String[][] colorEx = { { "빨", "빨", "빨" }, { "주", "주", "주" }, { "노", "노", "노" }, { "초", "초", "초" },
				{ "파", "파", "파" }, { "남", "남", "남" }, { "보", "보", "보" }, { "흰", "흰", "흰" }, { "검", "검", "검" },
				{ "회", "회", "회" } };

		aa: for (int i = 0; i < color.length; i++) {

			int score = 3;

			for (int j = 0; j < colorEx[i].length; j++) {

				if (color[i].equals("빨간색")) {
					System.out.println("힌트 : " + colorEx[0][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(color[i]) == color[i].equals(color[i])) {
						System.out.println("정답");
						tscore += score;

						if (i + 1 == color.length) {
							System.out.println("게임종료");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("현재점수 : " + tscore);
							System.out.println("다음 문제");
						}
						continue aa;
					} else if (answer.equals(color[i]) != color[i].equals(color[i])) {
						System.out.println("오답");
						score--;

						if (i + 1 == color.length) {
							System.out.println("게임종료");
							System.out.println("현재 점수 : " + tscore);
						} else if (j + 1 == colorEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}

				} else if (color[i].equals("주황색")) {
					System.out.println("힌트 : " + colorEx[1][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(color[i]) == color[i].equals(color[i])) {
						System.out.println("정답");
						tscore += score;

						if (i + 1 == color.length) {
							System.out.println("게임종료");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("현재점수 : " + tscore);
							System.out.println("다음 문제");
						}
						continue aa;
					} else if (answer.equals(color[i]) != color[i].equals(color[i])) {
						System.out.println("오답");
						score--;

						if (i + 1 == color.length) {
							System.out.println("게임종료");
							System.out.println("현재 점수 : " + tscore);
						} else if (j + 1 == colorEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (color[i].equals("노란색")) {
					System.out.println("힌트 : " + colorEx[2][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(color[i]) == color[i].equals(color[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(color[i]) != color[i].equals(color[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == colorEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (color[i].equals("초록색")) {
					System.out.println("힌트 : " + colorEx[3][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(color[i]) == color[i].equals(color[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(color[i]) != color[i].equals(color[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == colorEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (color[i].equals("파란색")) {
					System.out.println("힌트 : " + colorEx[4][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(color[i]) == color[i].equals(color[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(color[i]) != color[i].equals(color[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == colorEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (color[i].equals("남색")) {
					System.out.println("힌트 : " + colorEx[5][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(color[i]) == color[i].equals(color[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(color[i]) != color[i].equals(color[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == colorEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (color[i].equals("보라색")) {
					System.out.println("힌트 : " + colorEx[6][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(color[i]) == color[i].equals(color[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(color[i]) != color[i].equals(color[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == colorEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (color[i].equals("흰색")) {
					System.out.println("힌트 : " + colorEx[7][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(color[i]) == color[i].equals(color[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(color[i]) != color[i].equals(color[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == colorEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (color[i].equals("검은색")) {
					System.out.println("힌트 : " + colorEx[8][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(color[i]) == color[i].equals(color[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(color[i]) != color[i].equals(color[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == colorEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (color[i].equals("회색")) {
					System.out.println("힌트 : " + colorEx[9][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(color[i]) == color[i].equals(color[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(color[i]) != color[i].equals(color[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == colorEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				}
			}
		}
	}

	public void food() {
		Scanner sc = new Scanner(System.in);
		String answer;
		int tscore = 0;

		String[] color = { "피자", "파스타", "삼겹살", "초밥", "햄버거", "간짜장", "스테이크", "떡볶이", "샐러드", "아이스크림" };

		List<String> colors = Arrays.asList(color);
		Collections.shuffle(colors);

		String[][] colorEx = { { "피자", "피자", "피자" }, { "햄버거스타", "햄버거스타", "햄버거스타" }, { "삼겹살", "삼겹살", "삼겹살" },
				{ "초밥", "초밥", "초밥" }, { "햄버거", "햄버거", "햄버거" }, { "간짜장", "간짜장", "간짜장" }, { "스테이크", "스테이크", "스테이크" },
				{ "떡볶이", "떡볶이", "떡볶이" }, { "샐러드", "샐러드", "샐러드" }, { "아이스크림", "아이스크림", "아이스크림" } };

		aa: for (int i = 0; i < color.length; i++) {

			int score = 3;

			for (int j = 0; j < colorEx[i].length; j++) {

				if (color[i].equals("피자")) {
					System.out.println("힌트 : " + colorEx[0][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(color[i]) == color[i].equals(color[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(color[i]) != color[i].equals(color[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == colorEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}

				} else if (color[i].equals("파스타")) {
					System.out.println("힌트 : " + colorEx[1][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(color[i]) == color[i].equals(color[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(color[i]) != color[i].equals(color[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == colorEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (color[i].equals("삼겹살")) {
					System.out.println("힌트 : " + colorEx[2][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(color[i]) == color[i].equals(color[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(color[i]) != color[i].equals(color[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == colorEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (color[i].equals("초밥")) {
					System.out.println("힌트 : " + colorEx[3][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(color[i]) == color[i].equals(color[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(color[i]) != color[i].equals(color[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == colorEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (color[i].equals("햄버거")) {
					System.out.println("힌트 : " + colorEx[4][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(color[i]) == color[i].equals(color[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(color[i]) != color[i].equals(color[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == colorEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (color[i].equals("간짜장")) {
					System.out.println("힌트 : " + colorEx[5][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(color[i]) == color[i].equals(color[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(color[i]) != color[i].equals(color[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == colorEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (color[i].equals("스테이크")) {
					System.out.println("힌트 : " + colorEx[6][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(color[i]) == color[i].equals(color[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(color[i]) != color[i].equals(color[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == colorEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (color[i].equals("떡볶이")) {
					System.out.println("힌트 : " + colorEx[7][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(color[i]) == color[i].equals(color[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(color[i]) != color[i].equals(color[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == colorEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (color[i].equals("샐러드")) {
					System.out.println("힌트 : " + colorEx[8][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(color[i]) == color[i].equals(color[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(color[i]) != color[i].equals(color[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == colorEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (color[i].equals("아이스크림")) {
					System.out.println("힌트 : " + colorEx[9][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(color[i]) == color[i].equals(color[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(color[i]) != color[i].equals(color[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == colorEx[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				}
			}
		}
	}

}
