package test.sjh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class GuestBookSystem {
	



	    public static final String JDBC_URL = "jdbc:mysql://192.168.0.38/word_quiz?serverTimezone=UTC";
	    public static final String USERNAME = "root";
	    public static final String PASSWORD = "1234";

	    private Scanner scanner;

	    public GuestBookSystem() {
	        this.scanner = new Scanner(System.in);
	    }

	    private void addEntry() { // 방명록 글 등록
	        System.out.print("이름을 입력하세요 : ");
	        String name = scanner.nextLine();
	        System.out.print("작성할 글을 입력해주세요 : ");
	        String message = scanner.nextLine();

	        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
	            String query = "INSERT INTO guestbook (name, message) VALUES (?, ?)";
	            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	                preparedStatement.setString(1, name);
	                preparedStatement.setString(2, message);
	                preparedStatement.executeUpdate();
	            }
	            System.out.println("방명록이 등록되었습니다.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    private void deleteEntry() { // 밤명록 글 삭제
	        System.out.print("삭제할 방명록의 ID를 입력하세요 : ");
	        int entryId = scanner.nextInt();
	        scanner.nextLine();

	        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
	            String query = "DELETE FROM guestbook WHERE id = ?";
	            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	                preparedStatement.setInt(1, entryId);
	                preparedStatement.executeUpdate();
	            }
	            System.out.println("방명록이 삭제되었습니다.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void main(String[] args) {
	    	GuestBookSystem main = new GuestBookSystem();

	        while (true) {
	            // 이미 구현된 부분이므로 필요 없지 않을까,,
	            // System.out.println("1. 방명록 글 등록");
	            // System.out.println("2. 방명록 글 삭제");
	            // System.out.println("0. 종료");

	            int choice = main.scanner.nextInt();
	            main.scanner.nextLine();

	            switch (choice) {
	                case 1:
	                    main.addEntry();
	                    break;
	                case 2:
	                    main.deleteEntry();
	                    break;
	                case 0:
	                    System.out.println("프로그램을 종료합니다.");
	                    System.exit(0);
	                default:
	                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
	            }
	        }
	    }
	}

	// case 2 : GuestBookHandler.addEntry();
	// case 3 : GuestBookHandler.deleteEntry();
	// main 프로젝트에 이렇게만 작성해도 될지 잘 모르겠습니다..

