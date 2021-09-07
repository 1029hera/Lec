package com.lec.java.variables04;

public class Variable04Main {

	public static void main(String[] args) {
		System.out.println("실수 데이터 타입");
		
		// 실수형 자료 타입: float(4바이트), double(8바이트)
		// 정수형 자료 타입의 기본형은 int
		// 실수형 자료 타입의 기본형은 double
		
		System.out.println(1);
		System.out.println(1.0);
		System.out.println(1.); // 1.0
		System.out.println(.1); // 0.1
		
		double number1 = 3.141592;
		//float number2 = 3.14;
		float number3 = 3.14f; // float 리터럴은 숫자 뒤에 f 를 붙이면 된다.
		
		// 실수타입의 최소, 최대값
		System.out.println("float: " + Float.MIN_VALUE + " ~ " + Float.MAX_VALUE);
		System.out.println("double: " + Double.MIN_VALUE + " ~ " + Double.MAX_VALUE);
		
		float number4 = 1.23456789f;
		double number5 = 1.23456789;
		
		System.out.println("number4 = " + number4);
		System.out.println("number5 = " + number5);
		
		// 실수 표기법
		double number6 = 123;
		double number7 = 1.23e2; // 지수표기법 (exponential notation)
		// 1.23e2 = 1.23 X 10^2 = 123
		
		System.out.println("number6 = " + number6);
		System.out.println("number7 = " + number7);
		
		

	}

}
