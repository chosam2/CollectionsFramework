package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T14_PhoneTest {
	Scanner sc = new Scanner(System.in);
	Phone phone;
	Map<String, Phone> map = new HashMap<>();

	public static void main(String[] args) {
		T14_PhoneTest phoneTest = new T14_PhoneTest();

		phoneTest.programMain();

	}

	void programMain() {

		System.out.println("==================================");
		System.out.println("전화번호 관리 프로그램(파일로 저장되지 않음");
		System.out.println("==================================");
		while (true) {
			System.out.println("메뉴를 선택하세요.");
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 수정");
			System.out.println("3. 전화번호 삭제");
			System.out.println("4. 전화번호 검색");
			System.out.println("5. 전화번호 전체 출력");
			System.out.println("0. 프로그램 종료");

			System.out.print("번호입력 >> ");
			int input = Integer.parseInt(sc.nextLine().trim());

			switch (input) {
			case 1:
				phoneAdd();
				break;
			case 2:
				phoneModify();
				break;
			case 3:
				phoneDelete();
				break;
			case 4:
				phoneSearch();
				break;
			case 5:
				phoneSearch();
				break;
			case 0:
				System.exit(0);
			}
		}
	}

	private void phoneSearch() {
		// TODO Auto-generated method stub

	}

	private void phoneDelete() {
		System.out.println("삭제할 이름을 입력하세요.");
		String name = sc.nextLine();
		System.out.println(map);
	}

	private void phoneModify() {
		// TODO Auto-generated method stub

	}

	private void phoneAdd() {
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");

		System.out.print("이름 >> ");
		String name = sc.nextLine().trim();
		System.out.print("전화번호 >> ");
		String tel = sc.nextLine().trim();
		System.out.print("주소 >> ");
		String addr = sc.nextLine().trim();

		map.put(name, new Phone(name, tel, addr));
		System.out.println(map);

	}
}

class Phone {

	private int num = 0;
	private String name;
	private String tel;
	private String addr;

	public Phone(String name, String tel, String addr) {
		super();
		this.num++;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Phone [번호=" + num + ", 이름=" + name + ", 연락처=" + tel + ", 주소=" + addr + "]";
	}

}
