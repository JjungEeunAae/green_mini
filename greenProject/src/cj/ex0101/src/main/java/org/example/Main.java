package org.example;


import org.example.member.Member;
import org.example.member.MemberCLI;
import org.example.member.MemberDB;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        MemberDB md = new MemberDB();
        MemberCLI mc = new MemberCLI();

        MenuPrint menu = new MenuPrint();
        menu.wellcome();
            while (true) {
                int select = 0;
            int menuNumber = menu.mainMenu();
            switch (menuNumber) {
                case 1: //로그인
                    mc.loginInput();
                    if (!Login.login) {
                        Member dbMember = md.loginInput();
                        System.out.println("dbMember = " + dbMember);
                        if (dbMember != null) {
                            Login.login = true;
                            Login.member = dbMember;
                        }
                    } else {
                        System.out.println("이미 로그인하셨습니다.");
                    }
                        break;
                case 2: //회원가입
                    mc.signupInput();
                    break;
                case 0: //종료
                    System.out.println("종료되었습니다.");
                    System.exit(0);
                default:
                    System.out.println("메뉴 외의 번호를 입력하셨습니다. 다시 입력해주세요!");
            }
             }

    }
}