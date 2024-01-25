package db.input;

import java.util.Scanner;

import db.user.UserVO;

public class InfoInput {
	private Scanner sc = new Scanner(System.in);

	// 로그인 시 입력받을 값
	public UserVO loginInput() {
		System.out.println("아이디를 입력해주세요.");
		String id = sc.next();
		System.out.println("비밀번호를 입력해주세요.");
		String pw = sc.next();
		
		return new UserVO(id, pw);
	}
	
	// 회원가입 시 입력받을 값
	public UserVO signUpInput() {
		System.out.println("회원가입 진행");
		System.out.println("아이디 입력>");
		String sign_id = sc.next();
		System.out.println("비번 입력>");
		String sign_pw = sc.next();
		System.out.println("이름 입력>");
		String sign_name = sc.next();
		
		return new UserVO(sign_id, sign_pw, sign_name);
	}
	
}
