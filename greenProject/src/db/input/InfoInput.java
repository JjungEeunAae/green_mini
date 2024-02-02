package db.input;

import java.util.Scanner;

import db.user.User;
import db.user.UserVO;
import style.Font;

public class InfoInput {
	Scanner sc = new Scanner(System.in);

	// 로그인 시 입력받을 값
	public UserVO loginInput() {
		User user = new User();

		System.out.println(">> 아 이 디 입력 <<");
		String id = sc.next();
		System.out.println(">> 비밀번호 입력 <<");
		String pw = sc.next();

		return user.userInfo(id, pw);
	}

	// 회원가입 시 입력받을 값
	public void signUpInput() {
		User user = new User();
		String sign_id="";
		boolean dupl = true;
		while (dupl) {
			System.out.println("회원가입 진행");
			System.out.println(">> 아이디 입력 <<");
			sign_id = sc.nextLine();
			dupl = user.idCheck(sign_id);
		}
		System.out.println(">> 비밀번호 입력 <<");
		String sign_pw = sc.nextLine();
		System.out.println(">> 이름 입력 <<");
		String sign_name = sc.nextLine();
		user.signUp(sign_id, sign_pw, sign_name);

	}

	// 회원탈퇴 시 유저의 비번을 입력받음
	public String pwCheck() {
		System.out.println("비밀번호를 입력해주세요.");
		String pwCheck = sc.next();
		return pwCheck;
	}

	// 회원탈퇴 시 랜덤숫자를 받아 정상 탈퇴를 진행함
	// 랜덤 1차 입력
	public boolean randomIntCheck() {
		boolean result = false;
		int random = (int) (Math.random() * 555) + 1;

		System.out.println("탈퇴 진행을 위해 번호를 입력해주세요.");
		System.out.println("입력하기 >> [  " + random + "  ]");
		int randomNumberCheck = sc.nextInt();

		if (randomNumberCheck != random) {
			result = true;
		}

		return result;
	}

	// 랜덤 숫자 2차 입력
	public boolean randomIntDoubleCheck() {
		boolean result = false;
		int randomDouble = (int) (Math.random() * 555) + 1;
		System.out.println(Font.BACKGROUND_BLACK + Font.FONT_RED + "틀렸습니다! 번호를 재입력해주세요." + Font.RESET);
		System.out.println("입력하기 >> [  " + randomDouble + "  ]");
		int randomNumberDoubleCheck = sc.nextInt();

		if (randomNumberDoubleCheck != randomDouble) {
			result = true;
		}
		return result;
	}

}
