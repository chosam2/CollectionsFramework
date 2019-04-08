package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
 *  문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
 *  	컴퓨터의 숫자는 난수를 이용하여 구한다.
 *  		(스트라이크는 'S', 볼은 'B'로 출력한다.)
 *  
 *  	컴퓨터의 난수가 9 5 7 일때 실행 예시)
 *  	숫자입력 => 3 5 6
 *  	3 5 6 => 1S 0B
 *  	숫자입력 => 7 8 9
 *  	7 8 9 => 0S 2B
 *  	...
 * 		숫자입력 => 9 5 7
 * 		9 5 7 => 3S 0B
 * 
 *  	5번째 만에 맞췄군요.
 */
public class T11_BaseBallTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1 ~ 9 사이의 중복되지 않는 정수 3개 만들기
		Set<Integer> intRnd = new HashSet<>();

		while (intRnd.size() < 3) {
			int num = (int) (Math.random() * 9 + 1);
			intRnd.add(num);
		}

		System.out.println("만들어진 난수들 : " + intRnd);
		System.out.println();

		List<Integer> intRndList = new ArrayList<>(intRnd);

		Collections.shuffle(intRndList);
		System.out.println("List형태로 변환 + Shuffle");
		System.out.println();
		for (Integer num : intRndList) {
			System.out.print(num + " ");
		}

		System.out.println("==============================");
		System.out.print("숫자 3개 입력해라.");
		List<Integer> number = new ArrayList<>();
		number.add(Integer.parseInt(sc.nextLine().trim()));
		number.add(Integer.parseInt(sc.nextLine().trim()));
		number.add(Integer.parseInt(sc.nextLine().trim()));
		System.out.println(number);

		boolean flag = true;
		int strike = 0;
		for (int i = 0; i < intRndList.size(); i++) {
			if (intRndList.get(i).equals(number.get(i))) {
				strike++;
			}
			for (int j = 0; j < intRndList.size(); j++) {
				
			}
		}

	}

}
