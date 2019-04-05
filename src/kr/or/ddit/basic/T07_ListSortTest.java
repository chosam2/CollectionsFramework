package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T07_ListSortTest {
	public static void main(String[] args) {
		List<Member> list = new ArrayList<>();

		list.add(new Member(1, "홍길동", "010-1111-2222"));
		list.add(new Member(5, "변학도", "010-2222-2222"));
		list.add(new Member(9, "성춘향", "010-3333-2222"));
		list.add(new Member(3, "이순신", "010-4444-2222"));
		list.add(new Member(6, "강감찬", "010-5555-2222"));
		list.add(new Member(2, "일지매", "010-6666-2222"));

		System.out.println("정렬 전 : ");
		for (Member mem : list) {
			System.out.println(mem);
		}
		System.out.println("==============================================");

		Collections.sort(list);	// 내부정렬

		System.out.println("이름의 오름차순으로 정렬 후");
		for (Member mem : list) {
			System.out.println(mem);
		}
		System.out.println("==============================================");

		// 외부정렬 기준을 이용한 정렬하기
		Collections.sort(list, new SortNumDesc());

		System.out.println("Member의 번호(num)의 내림차순으로 정렬하기 정렬 후");
		for (Member mem : list) {
			System.out.println(mem);
		}
	}
}

/**
 * 회원의 정보를 저장할 클래스
 * 회원의 이름을 기준으로 오름차순 정렬이 될 수 있는 클래스
 * @author Hyungwook
 *
 */

class Member implements Comparable<Member> { // 내부적으로 비교할때는 Comparable 이고 따로 선언할떄는 Comparator를 implements해줘야함
	private int num; // 번호
	private String name; // 이름
	private String tel; // 전화번호

	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num = " + num + ", name = " + name + ", tel = " + tel + "]";
	}

	@Override
	public int compareTo(Member mem) {

		return this.getName().compareTo(mem.name);
	}
}

/**
 * 정렬기준의 외부선언을 위해서는 Comparator인터페이스를 구현하면 된다.
 * Member의 번호(num)의 내림차순으로 정렬하기 구현
 * @author Hyungwook
 *
 */
class SortNumDesc implements Comparator<Member> {

	@Override
	public int compare(Member mem1, Member mem2) {
		/*
			if (mem1.getNum() > mem2.getNum()) { // 기본적으로 compare에서는 앞에꺼가 뒤어꺼보다 크면 양수임(오름차순이기때문에) mem1 - mem2 가 양수가 나옴(mem1이 클 때)
				return -1;
			} else if (mem1.getNum() == mem2.getNum()) {
				return 0;
			} else {
				return 1;
			}
		*/

		// Wrapper클래스에서 제공하는 메서드를 이용하는 방법1
		// 내림차순일 경우에는 -1을 곱해준다
		 return Integer.compare(mem1.getNum(), mem2.getNum()) * -1; // static 메서드 => Integer에서 제공하는 util 기능을 이용한 방법

		//  Wrapper클래스에서 제공하는 메서드를 이용하는 방법2
//		return new Integer(mem1.getNum()).compareTo(mem2.getNum()) * -1;

	}

}
