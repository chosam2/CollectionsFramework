package kr.or.ddit.homework;

import java.util.HashSet;
import java.util.Set;


public class T12_Equals_hashCodeTest {
	/*
	HashSet, HashMap, Hashtable과 같은 객체들을 사용할 경우
	객체가 서로 같은지를 비교하기 위해 equals()메서드와 hashCode()메서드를 호출한다.
	그래서 객체가 서로 같은지 여부를 결정하려면 두 메서드를 재정의 해야 한다.
	HashSet, HashMap, Hashtable에서는 객체가 같은지 여부는 데이터를 추가할 때 검사한다.
	
	- equals()메서드는 두 객체의 내용(값)이 같은지 비교하는 메서드 이고
	- hashCode()메서드는 두 객체가 같은 객체인지를 비교하는 메서드 이다.
	*/
	/*
		- equals()메서드와 hashCode()메서드에 관련된 규칙
		1. 두 객체가 같으면 반드시 같은 hashcode를 가져야 한다.
		2. 두 객체가 같으면 equals()메서드를 호출했을 때 true를 반환해야 한다.
		   즉, 객체 a, b가 같다면 a.equals(b)와 b.equals(a) 둘 다 true이여야 한다.
		3. 두 객체의 hashcode가 같다고 해서 두 객체가 반드시 같은 객체는 아니다.
		   하지만 두 객체가 같으면 반드시 hashcode가 같아야 한다.
		4. equals()메서드를 override하면 반드시 hashCode()메서드도 override해야 한다.
		5. hashCode()는 기본적으로 Heap에 있는 각 객체에 대한 메모리 주소 매핑 정보를 
		   기반으로 한 정수값을 반환한다.
		   그러므로, 클래스에서 hashCode()메서드를 override하지 않으면 절대로 두 객체가 같은 것으로
		   간주될 수 없다.
		
		-  hashCode()메서드에서 사용하는 '해싱 알고리즘'에서 서도 다른 객체에 대하여 같은 hashcode값을
		   만들어 낼 수 있다. 그래서 객체가 같지 않더라도 hashcode가 같을 수 있다.
	*/

	public static void main(String[] args) {
		Person p1 = new Person(1, "홍길동");
//		System.out.println(p1.getClass());
		Person p2 = new Person(1, "홍길동");
//		System.out.println(p2.getClass());

		System.out.println("p1.equals(p2) : " + p1.equals(p2));
		System.out.println("p1 == p2 : " + (p1 == p2));
		System.out.println();

		Set<Person> set = new HashSet<Person>();
		System.out.println("= p1추가 전 =");
		set.add(p1);	// add할때 hashCode값이 같으면 오버라이딩된 hashCode() 함수 실행.
		System.out.println("= p1추가 후 =");
		System.out.println();
		System.out.println("= p2추가 전 =");
		set.add(p2);	// add할때 hashCode값이 같으면 equals 확인해서 다른것도 비교함.
		System.out.println("= p2추가 후 =");

		System.out.println("변경전 데이터");
		for (Person p : set) {
			System.out.println(p.getId() + " : " + p.getName());
		}

		p1.setName("일지매"); // 추가된 후에 데이터가 변경되어도 Set의 데이터는 변하지 않는다.
							// (이름이 변경되기 전후의 hashCode()값이 서로 상이하기때문에)

		System.out.println("변경후 데이터");
		for (Person p : set) {
			System.out.println(p.getId() + " : " + p.getName());
		}

		System.out.println("= p1추가 전 =");
		System.out.println("add(p1) 성공여부 : " + set.add(p1));	// add할때 hashCode값이 같으면 equals 확인.
		System.out.println("= p1추가 후 =");
		System.out.println("set.add(p1) 후 데이터");

		for (Person p : set) {
			System.out.println(p.getId() + " : " + p.getName());
		}

		System.out.println("= p2삭제 전 =");
		System.out.println("remove(p2) 성공여부 : " + set.remove(p2));
		System.out.println("= p2삭제 후 =");
		System.out.println("set.remove(p2) 후 데이터");

		for (Person p : set) {
			System.out.println(p.getId() + " : " + p.getName());
		}
	}

}

class Person {
	private int id;
	private String name;

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {	// 나랑 나를 비교하는 것
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		if (this == obj) {
			return true;
		}

		Person test = (Person) obj;

		System.out.println("현재객체이름 : " + this.getName());
		System.out.println("비교대상객체이름 : " + test.getName());

		if (this.name == null && test.name != null) {
			return false;
		}

		if (this.id == test.id && this.name.equals(test.name)) {
			return true;
		}

		return false;
	}
	
	
	// hashCode의 판단요건은 중복이 없어야한다.
	@Override
	public int hashCode() {
		/*
		final int prime = 31;
		int result = 1;
		
		result = prime * result + (name==null ? 0 : name.hashCode());
		result = prime * result + id;
		
		return result;
		*/

		System.out.println(name + "의 hashCode() 결과값 : " + (name + id).hashCode());	// name + id 하면 String형(홍길동1)이 되기때문에 String에서 제공하는 hashCode가 실행
		return (name + id).hashCode();
	}
}
