package kr.or.ddit.homework;

import java.util.Comparator;

//학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는
//Student클래스를 만든다.
//생성자는 학번, 이름, 국어, 영어, 수학 점수만 매개변수로 받아서 처리한다.
//
//이 Student객체들은 List에 저장하여 관리한다.
//List에 저장된 데이터들을 학번의 오름차순으로 정렬하여 출력하는 부분과
//총점의 역순으로 정렬하는 부분을 프로그램 하시오.
//(총점이 같으면 학번의 내림차순으로 정렬되도록 한다.)
//(학번 정렬기준은 Student클래스 자체에서 제공하도록 하고,
// 총점 정렬기준은 외부클래스에서 제공하도록 한다.)

public class T01_ListSortTest {
	public static void main(String[] args) {

	}

}

class Student implements Comparable<Student> {

	private int number;
	private String name;
	private int kor;
	private int eng;
	private int math;

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
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

class SortNumDesc implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
