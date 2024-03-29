package common.main;

import java.util.Scanner;

import common.input.InfoInput;
import common.menuPrint.MenuPrint;
import common.style.Font;
import db.guestBook.GuestBook;
import db.quiz.Quiz;
import db.rank.Rank;
import db.user.User;
import db.user.UserVO;

public class Main {
	public static void main(String[] args) {
		InfoInput input = new InfoInput(); // 회원가입 또는 로그인할 때 입력받는 값을 UserVO로 이동하는 클래스
		MenuPrint menu = new MenuPrint(); // 메뉴가 지저분해서 클래스를 따로 생성함
		User user = new User(); // 로그인, 회원가입, 탈퇴 등
		Quiz quiz = new Quiz(); // 단어맞추기 게임
		Rank rank = new Rank(); // 게임 순위
		GuestBook book = new GuestBook();
		Scanner sc = new Scanner(System.in);
		
		menu.wellcome();
		loop: while (true) {
			int mainMenu = menu.mainMenu();
			switch (mainMenu) {
			case 0:
				System.out.println(Font.BACKGROUND_WHITE + Font.FONT_RED
						+ "=================[ 프로그램을 종료합니다. ]=================" + Font.RESET);
				break loop;
			case 1: // 로그인 (●eunae)
				System.out
						.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN + "         [ LOGIN ]         " + Font.RESET);
				UserVO mem = input.loginInput();

				String login_result = user.login(mem.getId(), mem.getPw());

				switch (login_result) {
					case "SIGNOUT_USER": // 회원탈퇴
						System.out.println(Font.BACKGROUND_BLACK + Font.FONT_RED + "탈퇴한 아이디입니다. 다시 확인 바랍니다." + Font.RESET);
						break;
					case "SUCCESS": // 로그인성공
						menu.loginSucceeAndStart(mem.getName());
						mLoop: while (true) {
							int middleMenu = menu.middleMenu();
							switch (middleMenu) {
							case 1:
								int gameMenu = menu.gameMenu();
								switch (gameMenu) { 		 // 입력받은 값으로 기능 굴리기
								case 1: // 색상 (●hyoungjin)
									quiz.game("색상",mem.getId(),mem.getName());
									break;
								case 2: // 동물 (●hyoungjin)
									quiz.game("동물",mem.getId(),mem.getName());
									break;
								case 3: // 음식 (●hyoungjin)
									quiz.game("음식",mem.getId(),mem.getName());
									break;
								case 8: // 로그아웃
									System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN + "      [ 로그아웃 완료! ]     "
											+ Font.RESET);
									mem = null;
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
									System.out.println(Font.BACKGROUND_BLACK + Font.FONT_RED
											+ "메뉴 외의 번호를 입력하셨습니다. 다시 입력해주세요!" + Font.RESET);
								};
							break;
						case 2: // 랭킹 기능
							int rankMenu = menu.rankMenu();
							switch (rankMenu) {
							case 1: // 목록조회 (●eunae)
								rank.rankRead(mem.getId());
								break;
							case 9:
								System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN
										+ "=================[ 이전메뉴로 돌아갑니다. ]=================" + Font.RESET);
								break;
							default:
								System.out.println(Font.BACKGROUND_BLACK + Font.FONT_RED
										+ "메뉴 외의 번호를 입력하셨습니다. 다시 입력해주세요!" + Font.RESET);
							}
							break;
						case 3:
							int guestBookMenu = menu.guestBookMenu();
							switch (guestBookMenu) {
							case 1: // 목록조회 (●eunhee)
								book.listView();
								break;
							case 2: // 글 등록 (●jihun)
								System.out.println(mem.getName() + "님, 게시글 등록이 시작됩니다.");
								System.out.println("제목을 입력해주세요.");
								String title = sc.next();
								System.out.println("내용을 입력해주세요.");
								String content = sc.next();
								
								int result = book.guestBookInsert(mem.getId(), title, content);
								if(result > 0) {
									System.out.println(Font.FONT_GREEN + "방명록 등록이 완료되었습니다!" + Font.RESET);
								} else {
									System.err.println("방명록 등록이 정상적으로 진행되지 않았습니다!");
								}
								break;
							case 3: // 글 삭제 (●jihun)
								book.deleteGuestBookList(mem.getId());
								System.out.println("어떤 글을 삭제하겠습니까?");
								int guestNo = sc.nextInt();
								int deleteResult = book.guestBookDelete(mem.getId(), guestNo);
								if(deleteResult > 0) {
									System.out.println(Font.FONT_GREEN + "=============[ 정상적으로 글이 삭제되었습니다. ]=============" + Font.RESET);
								} else {
									System.err.println("글번호가 올바르지 않습니다!");
								}
								
								break;
							case 8: // 로그아웃 (●eunae)
								System.out.println(Font.BACKGROUND_WHITE + Font.FONT_BLUE
										+ "           [ 로그아웃 완료! ]          " + Font.RESET);
								mem = null;
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
								System.out.println(Font.BACKGROUND_BLACK + Font.FONT_RED
										+ "메뉴 외의 번호를 입력하셨습니다. 다시 입력해주세요!" + Font.RESET);
							};
							break;
						case 8:
							System.out.println(Font.BACKGROUND_WHITE + Font.FONT_BLUE
									+ "           [ 로그아웃 완료! ]          " + Font.RESET);
							mem = null;
							break mLoop;
						case 9: // 회원탈퇴 (●eunae)
							int userMenu = menu.signOutMenu();
							switch (userMenu) {
							case 1:
								String signOut_result = user.login(mem.getId(), input.pwCheck());

								switch (signOut_result) {
								case "WRONG_PASSWORD":
									System.out.println(
											Font.BACKGROUND_BLACK + Font.FONT_RED + "비밀번호가 일치하지 않습니다." + Font.RESET);
									break;
								case "SUCCESS":
									boolean randomIntCheck = input.randomIntCheck();
									if (randomIntCheck) {
										boolean randomIntDoubleCheck = input.randomIntDoubleCheck();
										if (randomIntDoubleCheck) {
											System.out.println(Font.BACKGROUND_BLACK + Font.FONT_RED
													+ "틀렸습니다! 메뉴로 돌아갑니다" + Font.RESET);
											break;
										} else {
											int result = user.signOut(mem.getId());

											if (result > 0) {
												System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN
														+ "                탈퇴완료! 처음으로 돌아갑니다.                "
														+ Font.RESET);
											} else {
												System.out.println(Font.BACKGROUND_BLACK + Font.FONT_RED
														+ "             탈퇴가 정상적으로 진행되지 않았습니다!             "
														+ Font.RESET);
											}
											break mLoop;
										}
									} else {
										// 모든 값이 정상적으로 들어오면 탈퇴 진행 및 대분류 카테고리 이동
										int result = user.signOut(mem.getId());

										if (result > 0) {
											System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN
													+ "                탈퇴완료! 처음으로 돌아갑니다.                " + Font.RESET);
										} else {
											System.out.println(Font.BACKGROUND_BLACK + Font.FONT_RED
													+ "             탈퇴가 정상적으로 진행되지 않았습니다!             " + Font.RESET);
										}
										break mLoop;
									}
								}
								break;
							case 2:
								System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN
										+ "=================[ 이전메뉴로 돌아갑니다. ]=================" + Font.RESET);
								break;
							default:
								System.out.println(Font.BACKGROUND_BLACK + Font.FONT_RED
										+ "메뉴 외의 번호를 입력하셨습니다. 다시 입력해주세요!" + Font.RESET);
							}
							break;
						case 0:
							System.out.println(Font.BACKGROUND_WHITE + Font.FONT_RED
									+ "=================[ 프로그램을 종료합니다. ]=================" + Font.RESET);
							break loop;
						default:
							System.out.println(Font.BACKGROUND_BLACK + Font.FONT_RED + "메뉴 외의 번호를 입력하셨습니다. 다시 입력해주세요!"
									+ Font.RESET);
						}
					} // mLoop end
					break;
				case "WRONG_PASSWORD": // 비밀번호 불일치
					System.out.println(Font.BACKGROUND_BLACK + Font.FONT_RED + "비밀번호가 일치하지 않습니다." + Font.RESET);
					break;
				case "USER_NOT_FOUND": // 사용자 존재하지 않음
					System.out.println(Font.BACKGROUND_BLACK + Font.FONT_RED + "존재하지않는 아이디입니다." + Font.RESET);
					break;
				case "ERROR": // 저 위의 상황을 다 빗나간 것
					System.out
							.println(Font.BACKGROUND_BLACK + Font.FONT_RED + "오류가 발생하였습니다. 관리자에게 문의하세요." + Font.RESET);
					break;
				}
				break;
			case 2: // 회원가입 (●sdqwe12)
				input.signUpInput();
				break;
			default:
				System.out
						.println(Font.BACKGROUND_BLACK + Font.FONT_RED + "메뉴 외의 번호를 입력하셨습니다. 다시 입력해주세요!" + Font.RESET);
			} // main menu switch end
		} // loop while end
	} // main method end
}
