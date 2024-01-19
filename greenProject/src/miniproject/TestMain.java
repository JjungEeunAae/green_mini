package miniproject;

import java.util.Scanner;

import db.test.Test;

public class TestMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// test
		String test_id = sc.nextLine();
		String test_pw = sc.nextLine();
		Test te = new Test();
		te.test(test_id, test_pw);
	}
}
