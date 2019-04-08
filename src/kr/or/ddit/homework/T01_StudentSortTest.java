package kr.or.ddit.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는
//Student클래스를 만든다.
//생성자는 학번, 이름, 국어, 영어, 수학 점수만 매개변수로 받아서 처리한다.
//
//이 Student객체들은 List에 저장하여 관리한다.
//List에 저장된 데이터들을 학번의 오름차순으로 정렬하여 출력하는 부분과
//총점의 역순으로 정렬하는 부분을 프로그램 하시오. -> 내림차순

//(총점이 같으면 학번의 내림차순으로 정렬되도록 한다.)
//(학번 정렬기준은 Student클래스 자체에서 제공하도록 하고,
// 총점 정렬기준은 외부클래스에서 제공하도록 한다.)

public class T01_StudentSortTest {
	public static void main(String[] args) {

		List<Student> list = new ArrayList<>();

		list.add(new Student(13, "유형욱", 90, 80, 100));
		list.add(new Student(26, "김민현", 90, 90, 90));
		list.add(new Student(2, "권준수", 80, 85, 90));
		list.add(new Student(70, "장혁준", 90, 70, 85));
		list.add(new Student(1, "김승태", 70, 100, 70));

		int sum = 0;

		for (Student std : list) {
			sum = std.getKor() + std.getEng() + std.getMath();
			std.setSum(sum);
		}

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (list.get(i).getSum() < list.get(j).getSum()) {
					list.get(i).setRank(list.get(i).getRank() + 1);
				}
			}
		}

		System.out.println("=== 정렬 전 ===");
		for (Student std : list) {
			System.out.println(std);
		}

		Collections.sort(list);
		System.out.println("=== 내부 정렬 후(학번 오름차순) ===");
		for (Student std : list) {
			System.out.println(std);
		}

		Collections.sort(list, new SortNumDesc()); // 외부 정렬

		System.out.println("=== 외부 정렬 후 ===");
		for (Student std : list) {
			System.out.println(std);
		}

	}

}

class Student implements Comparable<Student> {

	private int number;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private int rank = 1;

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public Student(int number, String name, int kor, int eng, int math) {
		super();
		this.number = number;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public int compareTo(Student std) {
		return Integer.compare(this.getNumber(), std.getNumber());
	}

	@Override
	public String toString() {
		return "Student [학번=" + number + ", 이름=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum=" + sum + ", rank=" + rank + "]";
	}

}

class SortNumDesc implements Comparator<Student> {

	@Override
	public int compare(Student std1, Student std2) {
		if (std1.getSum() > std2.getSum()) {
			return -1;
		} else if (std1.getSum() == std2.getSum()) {
			return Integer.compare(std1.getNumber(), std2.getNumber()) * -1;
		} else {
			return 1;
		}
	}

}
