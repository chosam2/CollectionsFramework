package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T03_ArrayListTest {

	/*
	 * 문제) 5명의 사람 이름을 입력하여 ArrayList에 저장하고
	 * 		이 중에서 '김'씨 성의 이름을 출력하시오.
	 * 		(단, 입력은 Scanner를 이용하여 입력받는다..)
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<>();

		System.out.println("=== 5명의 이름을 입력하세요 ===");
		for (int i = 0; i < 5; i++) {
			System.out.print(i + 1 + "번째 이름을 입력하세요 : ");
			list.add(i, sc.nextLine());
		}

		//		for (String s : list) {
		//			if (s.contains("김")) {
		//
		//				System.out.println(s);
		//			}
		//		}
		char c;

		for (String s : list) {
			if (s.charAt(0) == '김') {
				System.out.println(s);
			}

			if (s.substring(0, 1).equals("김")) {
				System.out.println(s);
			}

			if (s.indexOf("김") == 0) {
				System.out.println(s);
			}
			
			if(s.startsWith("김")) {
				System.out.println(s);
			}
		}
	}
}
