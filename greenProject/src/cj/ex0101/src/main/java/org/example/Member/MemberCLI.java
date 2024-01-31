package org.example.member;

import java.util.Scanner;

public class MemberCLI {
    Scanner scan = new Scanner(System.in);
//    org.example.Member.MemberDB md = new org.example.Member.MemberDB(); 이거 키면 재귀함수 오버플로우 뜨면서 오류남
        public Member signupInput() {
        System.out.println("이메일을 입력 하세요.");
        String email = scan.next();
        System.out.println("패스워드를 입력 하세요.");
        String password = scan.next();
        System.out.println("이름을 입력 하세요.");
        String name = scan.next();

//      return new Member(email, password, name, null,null);
        return Member.builder()
                .email(email)
                .password(password)
                .name(name)
                .build();
    }
    public Member loginInput() {
        System.out.println("이메일을 입력 하세요.");
        String email = scan.next();
        System.out.println("패스워드를 입력 하세요.");
        String password = scan.next();

        return Member.builder()
                .email(email)
                .password(password)
                .build();
    }
}
