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

	public void color() {
		Scanner sc = new Scanner(System.in);
		String answer;
		int tscore = 0;

		String[] color = { "빨간색", "주황색", "노란색", "초록색", "분홍색", "갈색", "보라색", "흰색", "검은색", "회색" };

		List<String> colors = Arrays.asList(color);
		Collections.shuffle(colors);

		String[][] colorHint = { { "딸기", "사과", "장미" }, { "오렌지", "감", "당근"}, { "레몬", "개나리","바나나" }, { "잔디","에메랄드","대나무" },
				{ "벚꽃", "플라밍고", "딸기우유" }, { "낙옆", "벽돌", "나뭇가지" }, { "가지", "포도", "라일락", }, { "우유", "국화", "북극곰" }, { "아스팔트", "밤하늘", "검" },
				{ "회", "회", "회" } };

		for (int i = 0; i < color.length; i++) {
			for (int j = 0; j < color[i].length(); j++) {
				
				List<String> colorsHint = Arrays.asList(colorHint[i]);
				Collections.shuffle(colorsHint);
			}
		}

		aa: for (int i = 0; i < color.length; i++) {

			int score = 3;

			for (int j = 0; j < colorHint[i].length; j++) {

				if (color[i].equals("빨간색")) {
					System.out.println("힌트 : " + colorHint[0][j]);
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
						} else if (j + 1 == colorHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}

				} else if (color[i].equals("주황색")) {
					System.out.println("힌트 : " + colorHint[1][j]);
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
						} else if (j + 1 == colorHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (color[i].equals("노란색")) {
					System.out.println("힌트 : " + colorHint[2][j]);
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

						if (j + 1 == colorHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (color[i].equals("초록색")) {
					System.out.println("힌트 : " + colorHint[3][j]);
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

						if (j + 1 == colorHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (color[i].equals("파란색")) {
					System.out.println("힌트 : " + colorHint[4][j]);
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

						if (j + 1 == colorHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (color[i].equals("남색")) {
					System.out.println("힌트 : " + colorHint[5][j]);
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

						if (j + 1 == colorHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (color[i].equals("보라색")) {
					System.out.println("힌트 : " + colorHint[6][j]);
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

						if (j + 1 == colorHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (color[i].equals("흰색")) {
					System.out.println("힌트 : " + colorHint[7][j]);
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

						if (j + 1 == colorHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (color[i].equals("검은색")) {
					System.out.println("힌트 : " + colorHint[8][j]);
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

						if (j + 1 == colorHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (color[i].equals("회색")) {
					System.out.println("힌트 : " + colorHint[9][j]);
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

						if (j + 1 == colorHint[i].length) {
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

	public void animal() {
		Scanner sc = new Scanner(System.in);
		String answer;
		int tscore = 0;

		String[] animal = { "강아지", "고양이", "말", "사자", "코끼리", "원숭이", "곰", "사슴", "돌고래", "기린" };

		List<String> animals = Arrays.asList(animal);
		Collections.shuffle(animals);

		String[][] animalHint = { { "개", "개", "개" }, { "고양이", "고양이", "고양이" }, { "말", "말", "말" }, { "사자", "사자", "사자" },
				{ "코끼리", "코끼리", "코끼리" }, { "원숭이", "원숭이", "원숭이" }, { "곰", "곰", "곰" }, { "사슴", "사슴", "사슴" },
				{ "돌고래", "돌고래", "돌고래" }, { "기린", "기린", "기린" } };
		
		for (int i = 0; i < animal.length; i++) {
			for (int j = 0; j < animal[i].length(); j++) {
				
				List<String> animalsHint = Arrays.asList(animalHint[i]);
				Collections.shuffle(animalsHint);
			}
		}

		aa: for (int i = 0; i < animal.length; i++) {

			int score = 3;

			for (int j = 0; j < animalHint[i].length; j++) {

				if (animal[i].equals("강아지")) {
					System.out.println("힌트 : " + animalHint[0][j]);
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
						} else if (j + 1 == animalHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}

				} else if (animal[i].equals("고양이")) {
					System.out.println("힌트 : " + animalHint[1][j]);
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
						} else if (j + 1 == animalHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (animal[i].equals("말")) {
					System.out.println("힌트 : " + animalHint[2][j]);
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
						} else if (j + 1 == animalHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (animal[i].equals("사자")) {
					System.out.println("힌트 : " + animalHint[3][j]);
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
						} else if (j + 1 == animalHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (animal[i].equals("코끼리")) {
					System.out.println("힌트 : " + animalHint[4][j]);
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
						} else if (j + 1 == animalHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (animal[i].equals("원숭이")) {
					System.out.println("힌트 : " + animalHint[5][j]);
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
						} else if (j + 1 == animalHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (animal[i].equals("곰")) {
					System.out.println("힌트 : " + animalHint[6][j]);
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
						} else if (j + 1 == animalHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (animal[i].equals("사슴")) {
					System.out.println("힌트 : " + animalHint[7][j]);
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
						} else if (j + 1 == animalHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (animal[i].equals("돌고래")) {
					System.out.println("힌트 : " + animalHint[8][j]);
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
						} else if (j + 1 == animalHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (animal[i].equals("기린")) {
					System.out.println("힌트 : " + animalHint[9][j]);
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
						} else if (j + 1 == animalHint[i].length) {
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

		String[] food = { "피자", "파스타", "삼겹살", "초밥", "햄버거", "간짜장", "스테이크", "떡볶이", "샐러드", "아이스크림" };

		List<String> foods = Arrays.asList(food);
		Collections.shuffle(foods);

		String[][] foodHint = { { "피자", "피자", "피자" }, { "햄버거스타", "햄버거스타", "햄버거스타" }, { "삼겹살", "삼겹살", "삼겹살" },
				{ "초밥", "초밥", "초밥" }, { "햄버거", "햄버거", "햄버거" }, { "간짜장", "간짜장", "간짜장" }, { "스테이크", "스테이크", "스테이크" },
				{ "떡볶이", "떡볶이", "떡볶이" }, { "샐러드", "샐러드", "샐러드" }, { "아이스크림", "아이스크림", "아이스크림" } };
		
		for (int i = 0; i < food.length; i++) {
			for (int j = 0; j < food[i].length(); j++) {
				
				List<String> foodsHint = Arrays.asList(foodHint[i]);
				Collections.shuffle(foodsHint);
			}
		}

		aa: for (int i = 0; i < food.length; i++) {

			int score = 3;

			for (int j = 0; j < foodHint[i].length; j++) {

				if (food[i].equals("피자")) {
					System.out.println("힌트 : " + foodHint[0][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(food[i]) == food[i].equals(food[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(food[i]) != food[i].equals(food[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == foodHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}

				} else if (food[i].equals("파스타")) {
					System.out.println("힌트 : " + foodHint[1][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(food[i]) == food[i].equals(food[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(food[i]) != food[i].equals(food[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == foodHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (food[i].equals("삼겹살")) {
					System.out.println("힌트 : " + foodHint[2][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(food[i]) == food[i].equals(food[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(food[i]) != food[i].equals(food[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == foodHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (food[i].equals("초밥")) {
					System.out.println("힌트 : " + foodHint[3][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(food[i]) == food[i].equals(food[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(food[i]) != food[i].equals(food[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == foodHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (food[i].equals("햄버거")) {
					System.out.println("힌트 : " + foodHint[4][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(food[i]) == food[i].equals(food[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(food[i]) != food[i].equals(food[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == foodHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (food[i].equals("간짜장")) {
					System.out.println("힌트 : " + foodHint[5][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(food[i]) == food[i].equals(food[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(food[i]) != food[i].equals(food[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == foodHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (food[i].equals("스테이크")) {
					System.out.println("힌트 : " + foodHint[6][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(food[i]) == food[i].equals(food[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(food[i]) != food[i].equals(food[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == foodHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (food[i].equals("떡볶이")) {
					System.out.println("힌트 : " + foodHint[7][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(food[i]) == food[i].equals(food[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(food[i]) != food[i].equals(food[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == foodHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (food[i].equals("샐러드")) {
					System.out.println("힌트 : " + foodHint[8][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(food[i]) == food[i].equals(food[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(food[i]) != food[i].equals(food[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == foodHint[i].length) {
							System.out.println("다음문제");
							System.out.println("현재 점수 : " + tscore);
						} else {
							System.out.println("다음힌트");
						}
						continue;
					}
				} else if (food[i].equals("아이스크림")) {
					System.out.println("힌트 : " + foodHint[9][j]);
					System.out.println("정답입력");

					answer = sc.next();

					if (answer.equals(food[i]) == food[i].equals(food[i])) {
						System.out.println("정답");
						tscore += score;
						System.out.println("현재점수 : " + tscore);
						System.out.println("다음 문제");
						continue aa;
					} else if (answer.equals(food[i]) != food[i].equals(food[i])) {
						System.out.println("오답");
						score--;

						if (j + 1 == foodHint[i].length) {
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
