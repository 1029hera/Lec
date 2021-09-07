package com.lec.java.wrapper01;

/* Wrapper 클래스: 기본 자료형(primitive type)의 데이터를 감싸는 클래스
 * 기본 자료형: boolean, char, byte, short, int, long, float, double
 * Wrapper: Boolean, Character, Byte, Short, Integer, Long, Float, Double
 */

public class Wrapper01Main {

	public static void main(String[] args) {
		System.out.println("Wrapper 클래스");
		System.out.println("wrapper 클래스에 값을 저장하는 방법");
		System.out.println();
		
		Integer i1 = 100; // reference <= primitive?
		i1 = i1 + 200; // reference가 산술연산?
		System.out.println("i1 = " + i1);
		

		// 1. 생성자 이용
		Integer num1 = new Integer(123);
		System.out.println("num1 = " + num1);
		
		
		// 2. wrapper 클래스의 static 메소드인 valueOf() 메소드를 사용
		Integer num2 = Integer.valueOf(123);
		System.out.println("num2 + " + num2);
		
		
		// 3. new Integer() VS Integer.valueOf()
		System.out.println(num1 == num2); // 주소 비교
		System.out.println(num1.equals(num2));
		
		Integer num3 = new Integer(123); // new 는 새로운 instance 생성
		Integer num4 = Integer.valueOf(123); // num2 와 같은 리터럴 로 생성
		// valueOf() 는 Object를 cache 해둔다.  같은 literal로 생성하면 같은 Object.
        // 메모리 절약 차원/
		
		System.out.println(num1 == num3); // 다르다
		System.out.println(num1 == num4); // 같다	
		
		
		// 4. literal 상수로 생성
		System.out.println();
		Integer num5 = 123;
		// 123 Literal(상수)를 가지고 Integer 클래스의 인스턴스를 생성
		// Integer.valuOf(123)과 동일한 코드가 동작됨 (Auto-Boxing)
		System.out.println(num4 == num5);
		
		// 5. valueOf(문자열) 가능!
		System.out.println();
		Integer num6 = Integer.valueOf("123"); // 문자열 가능
		System.out.println(num6 * 2);
		
		
		// 6. 산술 연산 가능
		num6 /= 4;
		System.out.println(num6);

		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
















