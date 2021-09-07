package com.lec.java.operator03;

/* 부호연산자(+, -) sign operator
 * 	+: 부호 연산자(수의 부호(양,음)가 바뀌지 않음)
 * 	-: 부호 연산자(수의 부호(양,음)가 바뀜)
 */
public class Operator03Main {

	public static void main(String[] args) {
		System.out.println("연산자 3 - 부호연산자(+, -) sign operator");
		
		int num1 = -10;
		int num2 = +num1;
		int num3 = -num1;
		
		System.out.println("num2 = " + num2);
		System.out.println("num3 = " + num3);
		
		int num4 = num1 + -num2;
		System.out.println("num4 = " + num4);
		
		int num5 = num1 - -num2;
		System.out.println("num5 = " + num5);
		
		// ↑ 이항연산자 띄어쓰기 꼭!
		

		System.out.println("\n프로그램 종료");
	} // end main

} // end class













