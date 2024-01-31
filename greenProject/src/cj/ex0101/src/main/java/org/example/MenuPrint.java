package org.example;

import java.util.Scanner;

public class MenuPrint {
Scanner scan = new Scanner(System.in);
    public void wellcome() {
        System.out.println("  __                  ___       ___               __\n" +
                " /\\ \\                /\\_ \\     /\\_ \\             /\\ \\\n" +
                " \\ \\ \\___       __   \\//\\ \\    \\//\\ \\      ___   \\ \\ \\\n" +
                "  \\ \\  _ `\\   /'__`\\   \\ \\ \\     \\ \\ \\    / __`\\  \\ \\ \\\n" +
                "   \\ \\ \\ \\ \\ /\\  __/    \\_\\ \\_    \\_\\ \\_ /\\ \\L\\ \\  \\ \\_\\\n" +
                "    \\ \\_\\ \\_\\\\ \\____\\   /\\____\\   /\\____\\\\ \\____/   \\/\\_\\\n" +
                "     \\/_/\\/_/ \\/____/   \\/____/   \\/____/ \\/___/     \\/_/"
        );
    }

    public int mainMenu() {
        System.out.println("[ 메뉴를 선택해주세요 ]");
        System.out.println(" 1.로그인 | 2.회원가입 | 0.종료");
        int mainCategory = scan.nextInt();
        return mainCategory;

    }
}
