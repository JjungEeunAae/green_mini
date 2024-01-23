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
				{ "벚꽃", "플라밍고", "딸기우유" }, { "낙옆", "벽돌", "나뭇가지" }, { "가지", "포도", "라일락", }, { "우유", "국화", "북극곰" }, { "아스팔트", "밤하늘", "까마귀" },
				{ "시멘트", "비둘기", "쥐" } };

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
				} else if (color[i].equals("분홍색")) {
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
				} else if (color[i].equals("갈색")) {
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

		String[] animal = { "강아지", "고양이", "말", "사자", "코끼리", "원숭이", "곰", "사슴", "고래", "새" };

		List<String> animals = Arrays.asList(animal);
		Collections.shuffle(animals);

		String[][] animalHint = { { "리트리버", "푸들", "허스키" }, { "페르시안", "샴", "러시안블루" }, { "토로버드", "아라비안", "쿼터마일" }, { "코드바", "아스티커", "커버트" },
				{ "인도", "아프리카", "뱀베" }, { "침팬지", "고릴라", "오랑우탄" }, { "북극", "불", "반달가슴" }, { "엘크", "수프", "시카" },
				{ "흰수염", "범", "청수염" }, { "비둘기", "까마귀", "부엉이" } };
		
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
				} else if (animal[i].equals("고래")) {
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
				} else if (animal[i].equals("새")) {
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

		String[] food = { "피자", "파스타", "치킨", "초밥", "햄버거", "라면", "스테이크", "떡볶이", "샐러드", "아이스크림" };

		List<String> foods = Arrays.asList(food);
		Collections.shuffle(foods);

		String[][] foodHint = { { "콤비네이션", "포테이토", "고구마" }, { "봉골레", "알리오올리오", "까르보나라" }, { "후라이드", "양념", "간장" },
				{ "장어", "연어", "새우" }, { "불고기", "치즈", "빅맥" }, { "안성탕면", "신라면", "불닭볶음면" }, { "웰던", "미디움", "레어" },
				{ "로제", "짜장", "라볶이" }, { "야채", "다이어트", "드레싱" }, { "엔초", "월드콘", "투게더" } };
		
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
				} else if (food[i].equals("치킨")) {
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
				} else if (food[i].equals("라면")) {
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
