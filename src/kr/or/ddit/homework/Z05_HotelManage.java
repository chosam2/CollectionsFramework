package kr.or.ddit.homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Z05_HotelManage {
	Scanner sc;
	Hotel hotel;
	Map<Integer, Hotel> map;

	public Z05_HotelManage() {
		sc = new Scanner(System.in);
		map = new HashMap<>();
	}

	public static void main(String[] args) {
		Z05_HotelManage manage = new Z05_HotelManage();

		manage.start();

	}

	void start() {
		System.out.println("***************************");
		System.out.println("호텔문을 열었습니다.");
		System.out.println("***************************");
		System.out.println();
		while (true) {
			System.out.println("***************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1. 체크인 2.체크아웃 3.객실상태 4.업무종료");
			System.out.println("***************************");
			System.out.print("메뉴선택=> ");
			int input = Integer.parseInt(sc.nextLine().trim());
			switch (input) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				roomStatus();
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("잘못 눌렀습니다.");
			}

		}
	}

	private void roomStatus() {

		Set<Map.Entry<Integer, Hotel>> mapSet = map.entrySet();

		Iterator<Map.Entry<Integer, Hotel>> entryIt = mapSet.iterator();

		while (entryIt.hasNext()) {
			Map.Entry<Integer, Hotel> entry = entryIt.next();

			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

	private void checkOut() {
		System.out.println("어느방을 체크하웃 하시겠습니까?");
		System.out.print("방번호 입력 >> ");
		int roomNum = Integer.parseInt(sc.nextLine().trim());

		if (map.get(roomNum) != null) {
			map.remove(roomNum);
			System.out.println("체크아웃 되었습니다.");
		} else {
			System.out.println(roomNum + "방에는 체크인한 사람이 없습니다.");
		}

	}

	private void checkIn() {
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력=> ");
		int roomNum = Integer.parseInt(sc.nextLine().trim());
		System.out.println();
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 => ");
		String guest = sc.nextLine();

		if (map.get(roomNum) != null) {
			System.out.println(map.get(roomNum).getRoomNum() + "방에는 이미 사람이 있습니다.");
		} else {
			map.put(roomNum, new Hotel(roomNum, guest));
		}
	}
}

class Hotel {

	private int roomNum;
	private String guest;

	public Hotel(int roomNum, String guest) {
		super();
		this.roomNum = roomNum;
		this.guest = guest;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getGuest() {
		return guest;
	}

	public void setGuest(String guest) {
		this.guest = guest;
	}

	@Override
	public String toString() {
		return "방번호 : " + roomNum + ", 투숙객 : " + guest;
	}

}