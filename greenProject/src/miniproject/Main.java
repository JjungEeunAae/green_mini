package miniproject;

import java.util.Scanner;

import db.quiz.Quiz;
import db.user.User;
import style.Font;

public class Main {
	public static void main(String[] args) {
		Quiz quiz = new Quiz();

		Scanner sc = new Scanner(System.in);

		System.out.println("  _   _   U _____ u    _         _         U  ___ u \r\n"
				+ " |'| |'|  \\| ___\"|/   |\"|       |\"|         \\/\"_ \\/ \r\n"
				+ "/| |_| |\\  |  _|\"   U | | u   U | | u       | | | | \r\n"
				+ "U|  _  |u  | |___    \\| |/__   \\| |/__  .-,_| |_| | \r\n"
				+ " |_| |_|   |_____|    |_____|   |_____|  \\_)-\\___/  \r\n"
				+ " //   \\\\   <<   >>    //  \\\\    //  \\\\        \\\\    \r\n"
				+ "(_\") (\"_) (__) (__)  (_\")(\"_)  (_\")(\"_)      (__)   ");
		System.out.println();
		loop: while (true) {
			// 대분류
			System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN + "    [ 메뉴를 선택해주세요 ]    " + Font.RESET);
			System.out.println(" 1.로그인 | 2.회원가입 | 0.종료");
			int mainCategory = sc.nextInt();
			switch (mainCategory) {
			case 0:
				System.out.println(Font.BACKGROUND_WHITE + Font.FONT_RED
						+ "=================[ 프로그램을 종료합니다. ]=================" + Font.RESET);
				break loop;
			case 1:
				// 로그인
				System.out
						.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN + "         [ LOGIN ]         " + Font.RESET);
				System.out.println("아이디를 입력해주세요.");
				String id = sc.next();
				System.out.println("비밀번호를 입력해주세요.");
				String pw = sc.next();
				

				// DB에 id가 존재하지 않을 시 "존재하지않는 아이디" 출력
				// user.setId(id) user.serPw(pw)

				// 1.DB에 id가 존재할 시 여기로
				// 1-1.pw가 틀렸을 때 로그인으로 리턴

				// 1-2.성공적으로 로그인 되었을 때
				System.out.println("  ____       _____       _         ____       _____   \r\n"
						+ " / __\"| u   |_ \" _|  U  /\"\\  u  U |  _\"\\ u   |_ \" _|  \r\n"
						+ "<\\___ \\/      | |     \\/ _ \\/    \\| |_) |/     | |    \r\n"
						+ " u___) |     /| |\\    / ___ \\     |  _ <      /| |\\   \r\n"
						+ " |____/>>   u |_|U   /_/   \\_\\    |_| \\_\\    u |_|U   \r\n"
						+ "  )(  (__)  _// \\\\_   \\\\    >>    //   \\\\_   _// \\\\_  \r\n"
						+ " (__)      (__) (__) (__)  (__)  (__)  (__) (__) (__) ");
				System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN
						+ "                      로그인 성공!                       " + Font.RESET);
				System.out.println(Font.BACKGROUND_WHITE + Font.FONT_BLUE
						+ "==================[ OO님 환영합니다. ]===================" + Font.RESET);
				mLoop: while (true) {
					// 단어맞추기 랭킹 방명록 로그아웃 회원탈퇴 종료
					System.out.println(" ------------------[ 메뉴를 선택해주세요 ]------------------ ");
					System.out.println("1.단어맞추기 | 2.랭킹 | 3.방명록 | 8.로그아웃 | 9.탈퇴 |  0.종료");
					System.out.println(" ------------------------------------------------------ ");
					int middleCategory = sc.nextInt();
					switch (middleCategory) {
					case 1:
						// 단어맞추기 기능(소분류 넣어야 함)
						System.out.println(Font.BACKGROUND_WHITE + Font.FONT_BLUE
								+ "                       단어맞추기                      " + Font.RESET);
						System.out.println(" -----------------[ 메뉴를 선택해주세요 ]--------------- ");
						System.out.println("1.색상 | 2.동물 | 3.음식 | 8.로그아웃 | 9.이전메뉴 | 0.종료");
						System.out.println(" --------------------------------------------------- ");

						int gameCategory = sc.nextInt(); // 메뉴 번호 입력받기
						switch (gameCategory) { // 입력받은 값으로 기능 굴리기
						case 1: // 색상
							quiz.color();
							break;
						case 2: // 동물
							quiz.animal();
							break;
						case 3: // 음식
							quiz.food();
							break;
						case 8: // 로그아웃
							System.out.println(
									Font.BACKGROUND_WHITE + Font.FONT_GREEN + "      [ 로그아웃 완료! ]     " + Font.RESET);
							break mLoop;
						case 9:
							// 이전메뉴
							System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN
									+ "=================[ 이전메뉴로 돌아갑니다. ]=================" + Font.RESET);
							break;
						case 0:
							// 종료
							System.out.println(Font.BACKGROUND_WHITE + Font.FONT_RED
									+ "=================[ 프로그램을 종료합니다. ]=================" + Font.RESET);
							break loop;
						default:
							System.out.println(Font.BACKGROUND_BLACK + Font.FONT_RED + "메뉴 외의 번호를 입력하셨습니다. 다시 입력해주세요!"
									+ Font.RESET);
						}
						;

						break;
					case 2:
						// 랭킹 기능
						System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN + "               랭킹             "
								+ Font.RESET);
						System.out.println(" -----[ 메뉴를 선택해주세요 ]-----");
						System.out.println("    1.목록조회   |   9.이전메뉴   ");
						System.out.println(" ----------------------------");
						int rankCategory = sc.nextInt();
						switch (rankCategory) {
						case 1: // 목록조회

						case 9:
							System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN
									+ "=================[ 이전메뉴로 돌아갑니다. ]=================" + Font.RESET);
							break;
						default:
							System.out.println(Font.BACKGROUND_BLACK + Font.FONT_RED + "메뉴 외의 번호를 입력하셨습니다. 다시 입력해주세요!"
									+ Font.RESET);
						}
						break;
					case 3:
						// 방명록 기능(소분류 넣어야 함)
						System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN
								+ "                        방 명 록                        " + Font.RESET);
						System.out.println(" -----------------[ 메뉴를 선택해주세요 ]------------------");
						System.out.println("1.목록조회 | 2.등록 | 3.삭제 | 8.로그아웃 | 9.이전메뉴 | 0.종료");
						System.out.println(" ------------------------------------------------------");
						int boardCategory = sc.nextInt();
						switch (boardCategory) {
						case 1: // 목록조회

							break;
						case 2: // 글 등록

							break;
						case 3: // 글 삭제

							break;
						case 8: // 로그아웃
							System.out.println(Font.BACKGROUND_WHITE + Font.FONT_BLUE
									+ "           [ 로그아웃 완료! ]          " + Font.RESET);
							break mLoop;
						case 9: // 이전메뉴
							System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN
									+ "=================[ 이전메뉴로 돌아갑니다. ]=================" + Font.RESET);
							break;
						case 0: // 종료
							System.out.println(Font.BACKGROUND_WHITE + Font.FONT_RED
									+ "=================[ 프로그램을 종료합니다. ]=================" + Font.RESET);
							break loop;
						default:
							System.out.println(Font.BACKGROUND_BLACK + Font.FONT_RED + "메뉴 외의 번호를 입력하셨습니다. 다시 입력해주세요!"
									+ Font.RESET);
						}
						;

						break;
					case 8:
						System.out.println(Font.BACKGROUND_WHITE + Font.FONT_BLUE + "           [ 로그아웃 완료! ]          "
								+ Font.RESET);
						break mLoop;
					case 9: // 탈퇴 시스템
						System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN
								+ "               이대로 탈퇴를 이어가시겠습니까?                " + Font.RESET);
						System.out.println("                     1.YES | 2.NO                      ");
						int userCategory = sc.nextInt();
						switch (userCategory) {
						case 1:
							int random = (int) (Math.random() * 555) + 1;

							System.out.println("비밀번호를 입력해주세요.");
							String pwCheck = sc.next();
							// 현재 유저의 비밀번호와 입력한 비밀번호가 다를 경우 리턴시키기

							System.out.println("탈퇴 진행을 위해 번호를 입력해주세요.");
							System.out.println("입력하기 >> [  " + random + "  ]");
							int randomNumberCheck = sc.nextInt();

							if (randomNumberCheck != random) {
								int randomDouble = (int) (Math.random() * 555) + 1;
								System.out.println("틀렸습니다! 번호를 재입력 해주세요.");
								System.out.println("입력하기 >> [  " + randomDouble + "  ]");
								int randomNumberDoubleCheck = sc.nextInt();

								if (randomNumberDoubleCheck != randomDouble) {
									System.out.println(Font.BACKGROUND_BLACK + Font.FONT_RED
											+ "입력값이 올바르지 않습니다. 메뉴로 돌아갑니다" + Font.RESET);
									break;
								} else {
									System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN
											+ "                탈퇴완료! 처음으로 돌아갑니다.                " + Font.RESET);
									break mLoop;
								}
								// 여기에 뭘 넣어야 바로 random 쪽으로 갈까?
							} else {
								// 모든 값이 정상적으로 들어오면 탈퇴 진행 및 대분류 카테고리 이동
								System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN
										+ "                탈퇴완료! 처음으로 돌아갑니다.                " + Font.RESET);
								break mLoop;
							}
						case 2:
							System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN
									+ "=================[ 이전메뉴로 돌아갑니다. ]=================" + Font.RESET);
							break;
						default:
							System.out.println(Font.BACKGROUND_BLACK + Font.FONT_RED + "메뉴 외의 번호를 입력하셨습니다. 다시 입력해주세요!"
									+ Font.RESET);
						}
						break;
					case 0:
						System.out.println(Font.BACKGROUND_WHITE + Font.FONT_RED
								+ "=================[ 프로그램을 종료합니다. ]=================" + Font.RESET);
						break loop;
					default:
						System.out.println(
								Font.BACKGROUND_BLACK + Font.FONT_RED + "메뉴 외의 번호를 입력하셨습니다. 다시 입력해주세요!" + Font.RESET);
					}

				}
				break;
			case 2: // 회원가입

				break;
			default:
				System.out
						.println(Font.BACKGROUND_BLACK + Font.FONT_RED + "메뉴 외의 번호를 입력하셨습니다. 다시 입력해주세요!" + Font.RESET);
			}

		}
		;
	}
}
