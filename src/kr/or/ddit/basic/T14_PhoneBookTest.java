package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

public class T14_PhoneBookTest {
	Scanner sc;
	Phone phone;
	Map<String, Phone> map;

	public T14_PhoneBookTest() {
		sc = new Scanner(System.in);
		map = new HashMap<>();
	}

	public static void main(String[] args) {
		T14_PhoneBookTest phoneTest = new T14_PhoneBookTest();

		phoneTest.phoneBookStart();

	}

	void phoneBookStart() {

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
				phoneInsert();
				break;
			case 2:
				phoneUpdate();
				break;
			case 3:
				phoneDelete();
				break;
			case 4:
				phoneSearch();
				break;
			case 5:
				phoneShowAll();
				break;
			case 0:
				System.exit(0);
			}
		}
	}

	private void phoneInsert() {
		System.out.println();
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = sc.nextLine().trim();

		if (map.get(name) != null) {
			System.out.println(name + "씨는 이미 등록된 사람입니다.");
			return;
		}

		System.out.print("전화번호 >> ");
		//		String tel = sc.next();	 // 엔터키 포함해서 전달
		//		sc.hasNextLine();	// 버퍼에 있는 엔터키 받아서 제거시켜줌.

		String tel = sc.nextLine().trim();
		System.out.print("주소 >> ");
		String addr = sc.nextLine();

		map.put(name, new Phone(name, tel, addr));
		System.out.println(name + "씨 등록 완료!");

	}

	private void phoneDelete() {
		System.out.println("삭제할 이름을 입력하세요.");
		String name = sc.nextLine();

		if (map.remove(name) == null) {
			System.out.println(name + "씨는 등록되지 않은 사람입니다.");
		} else {
			System.out.println(name + "씨가 삭제되었습니다.");
		}

		//		Set<String> keySet = map.keySet();
		//		for (String key : keySet) {
		//			if (name.equals(key)) {
		//				map.remove(key);
		//			}
		//		}
	}

	private void phoneUpdate() {
		System.out.println("수정할 이름을 입력하세요.");
		String name = sc.nextLine();

		System.out.print("번호 >> ");
		String tel = sc.nextLine().trim();
		System.out.print("주소 >> ");
		String addr = sc.nextLine();
		map.put(name, new Phone(name, tel, addr));

	}

	/**
	 * Iterator을 이용한 리스트 조회
	 */
	private void phoneSearch() {
		System.out.println("검색할 이름을 입력하세요.");
		String name = sc.nextLine().trim();

		if (map.get(name) == null) {
			System.out.println(name + "씨는 등록되지 않은 사람입니다.");
			return;
		}

		Set<String> keySet = map.keySet();

		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			if (key.equals(name)) {
				System.out.println(key + " : " + map.get(name));
			}
		}

	}

	private void phoneShowAll() {
		Set<Map.Entry<String, Phone>> mapSet = map.entrySet();

		Iterator<Map.Entry<String, Phone>> entryIt = mapSet.iterator();

		while (entryIt.hasNext()) {
			Map.Entry<String, Phone> entry = entryIt.next();

			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

}

class Phone {

	private static int count = 0;
	private int num;
	private String name;
	private String tel;
	private String addr;

	{
		++count;
		num = count;
	}

	public Phone(String name, String tel, String addr) {
		super();
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
		return "번호=" + num + ", 이름=" + name + ", 연락처=" + tel + ", 주소=" + addr;
	}

}
