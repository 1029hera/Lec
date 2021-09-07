package com.lec.java.fristjava;
/*
모든 자바 프로그램은 main() 메소드로부터 '시작'한다
프로그램 실행순서는 '시작' 부터 한 문장(Statement) 씩 실행되는 것이 원칙
문장의 끝은 반드시 세미콜론 ';' 으로 마무리 해야 한다
*/
public class FristJava {

	public static void main(String[] args) {
		
		System.out.println(123);
		System.out.println("123"); // 문자열(String) dms " ~ "로 감쌓여짐
		
		System.out.println();
		
		System.out.println(10 + 20); // 숫자 + 숫자 => 숫자
		System.out.println("10 + 20");
		System.out.println(10 + 20 + 30);
		
		
		System.out.println("결과:" + 10); // 문자열 + 숫자 => 문자열
		System.out.println(2000 + 21 + "년");
		System.out.println("올해는" + 2000 + 21); // 문자열(문자열+숫자) + 숫자
		System.out.println("올해는" + (2000 + 21));
		
		// 사칙연산 결과 보여주기 ( +, -, *, / )
		System.out.println("10 + 20 = " + (10 + 20));
		System.out.println("10 - 20 = " + (10 - 20));
		System.out.println("10 * 20 = " + (10 * 20));
		System.out.println("10 / 20 = " + (10 / 20)); // 정수와 정수의 연산결과는 정수
		System.out.println("10 / 20 = " + (10.0 / 20.0)); // 실수와의 연산은 실수
		
		// 이스케이프 문자 (escape character)
		// She says "Hi" <-- 출력할려면?
		System.out.println("She says \"Hi\"");
		
		// \", \n, \t, \\
		System.out.println("\t123\t456");
		System.out.println("\t10\t4");
		System.out.println("Avengers\n\\Endgame\\");
		
		
	} // end main()

} // end class
