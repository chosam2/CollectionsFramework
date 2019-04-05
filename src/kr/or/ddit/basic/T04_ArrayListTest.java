package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T04_ArrayListTest {

	/*
	 * 문제1) 5명의 별명을 입력하여 ArrayList에 저장하고 
	 * 		  별명의 길이가 제일 긴 별명을 출력하시오.
	 * 		 (단, 각 별명의 길이는 모두 다르게 입력한다.)
	 * 
	 * 문제2 ) 문제1에서 별명의 길이가 같은 것을 여러개 입력했을 때도 처리하시오.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		int temp = 0;

		System.out.println("5명의 별명을 입력하세요.");
		for (int i = 0; i < 5; i++) {
			System.out.print(i+1 + "번째 별명 : ");
			list.add(i, sc.nextLine());
		}

		for (String s : list) {
			temp = s.length();
			list2.add(temp);
		}

		for (int i = 0; i < list2.size(); i++) {
			if (list2.get(i) > temp) {
				temp = list2.get(i);
			}
		}

		for (int length : list2) {
			if(length == temp) {
				int index = list2.lastIndexOf(length);
				System.out.println(list.get(index));
			}
		}
		
		
		
		
		/*
		 * 선생님 풀이
		 * 
		 * 
		 */

	}
}
