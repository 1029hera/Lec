package com.lec.java.variables03;

public class Variable03Main {

	public static void main(String[] args) {
		System.out.println("변수의 타입");
		
		// 자바의 기본 자료형(primitive data type)
		// 정수 타입: byte(1바이트), short(2바이트), int(4바이트), long(8바이트)
		// 실수 타입: float, double
		// 문자 타입: char
		// 논리 타입: boolean

		System.out.println("정수 타입 변수들");
		
		// byte : -128 ~ + 127 (256개)
		System.out.println("byte: " + Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
		byte num1 = -128;
		byte num2 = 0;
		byte num3 = 123;
		
		// 리터럴 (literal) : 코드 상에서 직접 입력하는 값
		// 리터럴도 타입이다.
		// 기본적으로
		//  정수 --> int 타입으로 변환
		//  실수 --> double 타입으로 변환
		
		System.out.println("short: " + Short.MIN_VALUE + " ~ " + Short.MAX_VALUE);
		System.out.println("int: " + Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
		System.out.println("long: " + Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);
		
		short num5 = -1234;
		short num6 = 32767;
		
		//int num9 = 9876543210;
		//long num10 = 9876543210;
		long num10 = 9876543210L; // 정수 뒤에 L을 붙이면 long 타입 리터럴로 인식.
		
		long num12 = 12; // 4bytes
		long num13 = 12L; // 8bytes
		int num14 = 12;
		//int num15 = 12L;
		
		// 정수값의 경계선
		byte num15 = Byte.MAX_VALUE; // +127
		byte num16 = (byte)(num15 + 1);
		System.out.println("num15 = " + num15);
		System.out.println("num16 = " + num16);
		
		int number1 = 11; // 10진수
		int number2 = 0xB; // 16진수 0x 로 시작
		int number3 = 013; // 8진수 0 으로 시작
		int number4 = 0b1011; // 2진수 0b 로 시작
		
		System.out.println("number1 = " + number1);
		System.out.println("number2 = " + number2);
		System.out.println("number3 = " + number3);
		System.out.println("number4 = " + number4);
		
	}

}
