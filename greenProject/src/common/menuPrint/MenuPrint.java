package common.menuPrint;

import java.util.Scanner;

import common.input.InfoInput;
import common.style.Font;

public class MenuPrint {
	Scanner sc = new Scanner(System.in);
	private InfoInput input = new InfoInput();
	
	// 시스템 실행되면 바로 나오는 안내 내용
	public void wellcome() {
		System.out.println("  _   _   U _____ u    _         _         U  ___ u \r\n"
				+ " |'| |'|  \\| ___\"|/   |\"|       |\"|         \\/\"_ \\/ \r\n"
				+ "/| |_| |\\  |  _|\"   U | | u   U | | u       | | | | \r\n"
				+ "U|  _  |u  | |___    \\| |/__   \\| |/__  .-,_| |_| | \r\n"
				+ " |_| |_|   |_____|    |_____|   |_____|  \\_)-\\___/  \r\n"
				+ " //   \\\\   <<   >>    //  \\\\    //  \\\\        \\\\    \r\n"
				+ "(_\") (\"_) (__) (__)  (_\")(\"_)  (_\")(\"_)      (__)   ");
		System.out.println();
	}
	
	// 대분류 메뉴
	public int mainMenu() {
		System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN + "    [ 메뉴를 선택해주세요 ]    " + Font.RESET);
		System.out.println(" 1.로그인 | 2.회원가입 | 0.종료");
		int mainCategory = sc.nextInt();
		return mainCategory;
	}
	
	// 로그인 성공 시 나오는 내용
	public void loginSucceeAndStart(String name) {
		System.out.println("  ____       _____       _         ____       _____   \r\n"
				+ " / __\"| u   |_ \" _|  U  /\"\\  u  U |  _\"\\ u   |_ \" _|  \r\n"
				+ "<\\___ \\/      | |     \\/ _ \\/    \\| |_) |/     | |    \r\n"
				+ " u___) |     /| |\\    / ___ \\     |  _ <      /| |\\   \r\n"
				+ " |____/>>   u |_|U   /_/   \\_\\    |_| \\_\\    u |_|U   \r\n"
				+ "  )(  (__)  _// \\\\_   \\\\    >>    //   \\\\_   _// \\\\_  \r\n"
				+ " (__)      (__) (__) (__)  (__)  (__)  (__) (__) (__) ");
		System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN
				+ "                      로그인 성공!                       " + Font.RESET);
		System.out.println(Font.BACKGROUND_WHITE + Font.FONT_BLUE + "==================[ " + name
				+ "님 환영합니다. ]===================" + Font.RESET);
	}
	
	// 로그인 성공 시 나오는 중분류 메뉴
	public int middleMenu() {
		System.out.println(" ------------------[ 메뉴를 선택해주세요 ]------------------ ");
		System.out.println(" 1.단어맞추기 | 2.랭킹 | 3.방명록 | 8.로그아웃 | 9.탈퇴 | 0.종료");
		System.out.println(" ------------------------------------------------------ ");
		int middleMenu = sc.nextInt();
		return middleMenu;
	}
	
	// 단어맞추기 중분류 메뉴
	public int gameMenu() {
		System.out.println(Font.BACKGROUND_WHITE + Font.FONT_BLUE
				+ "                       단어맞추기                      " + Font.RESET);
		System.out.println(" -----------------[ 메뉴를 선택해주세요 ]--------------- ");
		System.out.println("1.색상 | 2.동물 | 3.음식 | 8.로그아웃 | 9.이전메뉴 | 0.종료");
		System.out.println(" --------------------------------------------------- ");
		int gameMenu = sc.nextInt(); // 메뉴 번호 입력받기
		return gameMenu;
	}
	
	// 랭킹 중분류 메뉴
	public int rankMenu() {
		System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN
				+ "               랭킹             " + Font.RESET);
		System.out.println(" -----[ 메뉴를 선택해주세요 ]-----");
		System.out.println("    1.목록조회   |   9.이전메뉴   ");
		System.out.println(" ----------------------------");
		int rankMenu = sc.nextInt();
		return rankMenu;
	}
	
	// 방명록 중분류 메뉴
	public int guestBookMenu() {
		System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN
				+ "                        방 명 록                        " + Font.RESET);
		System.out.println(" -----------------[ 메뉴를 선택해주세요 ]------------------");
		System.out.println("1.목록조회 | 2.등록 | 3.삭제 | 8.로그아웃 | 9.이전메뉴 | 0.종료");
		System.out.println(" ------------------------------------------------------");
		int guestBookMenu = sc.nextInt();
		return guestBookMenu;
	}
	
	// 회원탈퇴 중분류 메뉴
	public int signOutMenu() {
		System.out.println(Font.BACKGROUND_WHITE + Font.FONT_GREEN
				+ "               이대로 탈퇴를 이어가시겠습니까?                " + Font.RESET);
		System.out.println("                     1.YES | 2.NO                      ");
		int userCategory = sc.nextInt();
		
		return userCategory;
	}
}
