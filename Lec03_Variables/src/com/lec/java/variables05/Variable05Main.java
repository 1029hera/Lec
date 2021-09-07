package com.lec.java.variables05;

public class Variable05Main {

	public static void main(String[] args) {
		System.out.println("char, boolean, String");
		
		// char : 문자 하나를 저장하기 위한 데이터 타입 (2 bytes)
		char ch1 = 'A';
		
		// 문자열(String)은 큰따옴표("")로 묶어 줌.   (String literal)
		// 문자 하나(char)는 작은따옴표('')로 묶어 줌.   (char literal)
		//char ch2 = "A"; // 컴파일 에러: 자바는 "A"를 문자열로 인식하기 때문
		
		
		System.out.println("ch1: " + ch1);
		
		char ch2 = '한';
		char ch3 = '글';
		System.out.println(ch2);
		System.out.println(ch3);
		
		char ch4 = 1234;
		System.out.println("ch4 = " + ch4);
		char ch5 = 0xAE01;
		System.out.println("ch5 = " + ch5);
		
		/*
		 * 1. 까마귀
		 * 2. 가마우지
		 * 3. 가마솥
		 * 4. 까까머리 
		 * ? -> 2 3 4 1
		 */
		
		/*
		 * 1. cable
		 * 2. able
		 * 3. maple
		 * 4. bible
		 * 
		 *  ? -> 2 4 1 3
		 */
		
		/*
		 * 1. aaAA
		 * 2. AaAa
		 * 3. AAaa
		 * 4. aAaA
		 * 
		 * ? -> 1 4 2 3
		 */
		
		// 알파벳 대문자 코드값보다 소문자 코드값이 크다!!
		char ch8 = 'A', ch9 = 'a';
		System.out.println("'A' = " + ch8 + " " + (int)ch8);
		System.out.println("'a' = " + ch9 + " " + (int)ch9);
		
		// boolean (논리형): 참(true), 거짓(false)
		boolean b1 = true;
		boolean b2 = false;
		System.out.println("b1 = " + b1);
		System.out.println("b2 = " + b2);
		
		System.out.println(10 < 20);
		System.out.println(10 > 20);
		
		// String : 문자열 객체 (primitive type 아님)
		String name = "Hong"; // String literal
		String nick = "Thunder";
		
		System.out.println("이름은: " + name + "\n별명은: " + nick);
		
		
	}

}
