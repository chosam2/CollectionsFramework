package kr.or.ddit.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Z13_LottoProgram {
	int[] lottoNum = new int[6];
	int[][] userNum;
	int attempt;

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Z13_LottoProgram lotto = new Z13_LottoProgram();
		lotto.lottoStart();
	}

	/**
	 * 게임 스타트
	 */
	private void lottoStart() {

		while (true) {
			System.out.println("==============================");
			System.out.println("Lotto 프로그램");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("==============================");
			System.out.print("메뉴선택 : ");
			int input = Integer.parseInt(sc.nextLine().trim());
			switch (input) {
			case 1:
				getRndNum();
				break;
			case 2:
				System.exit(0);
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}

	}

	/**
	 * 난수 1 ~ 45 생성
	 */
	private void getRndNum() {
		insertCoin();

		Set<Integer> ltNumSet = new HashSet<Integer>();

		while (ltNumSet.size() < 6) { // 중복되지 않는 6개의 숫자를 ltNumSet에 추가.
			ltNumSet.add((int) (Math.random() * 45 + 1)); // 1 ~ 45까지 난수 생성해서 집어넣기.
		}
		//		System.out.println(ltNumSet);

		//		Iterator<Integer> it = ltNumSet.iterator();
		//		
		//		int i = 0;
		//		while(it.hasNext()) {
		//			lottoNum[i++] = it.next().intValue();	 // 난수로 생성된 로또번호 6개 배열에 추가.
		//		}
		//
		List<Integer> ltNumList = new ArrayList<>(ltNumSet);
		Collections.shuffle(ltNumList);
		int i = 0;
		for (int ltNum : ltNumList) {
			lottoNum[i++] = ltNum;
		}
		

		selectNum();
	}

	/**
	 * 로또번호 1 ~ 45 입력받기
	 */
	private void selectNum() {
		userNum = new int[attempt][6];
		System.out.println("중복되지 않는 정수 6개 고르세요");
		for (int k = 0; k < userNum.length; k++) {
			System.out.println(k + 1 + " 회차 입력 가즈아!");
			for (int i = 0; i < userNum[k].length; i++) {
				System.out.print(k + 1 + "회차" + (i + 1) + " 번째 숫자 : ");
				userNum[k][i] = Integer.parseInt(sc.nextLine().trim());
				if (userNum[k][i] > 45 || userNum[k][i] < 1) {
					System.out.println("1 ~ 45 사이의 숫자만 입력하세요");
					i--;
					continue;
				}
				for (int j = 0; j < i; j++) {
					if (userNum[k][i] == userNum[k][j]) {
						System.out.println("중복되는 숫자입니다. 다시 입력하세요.");
						i--;
						continue;
					}
				}
			}
			System.out.println(Arrays.toString(userNum[k]));
		}
	}

	/**
	 * 입금 메서드
	 */
	private void insertCoin() {
		int price = 0;
		attempt = 0;
		int remainder = 0;
		System.out.println("Lotto 구입 시작");
		System.out.println("(1000원에 로또번호 하나입니다.)");
		System.out.print("금액 입력 : ");
		price = Integer.parseInt(sc.nextLine().trim());
		attempt = price / 1000;
		remainder = price - (attempt * 1000);
		System.out.println(price + "원을 넣으셨군요, " + "거스름돈은 " + remainder + "입니다.");
		System.out.println(attempt + "세트 번호를 고르실 수 있습니다!");
		System.out.println("==============================");
	}

}
