package com.lec.java.operator04;

/* 증감 연산자(++, --) Increment / Decrement Operator
 *  	++변수: 변수의 값을 1 증가시켜서 저장
 *   	--변수: 변수의 값을 1 감소시켜서 저장
 *  
 *   증감연산자: prefix(접두사), postfix(접미사)
 *   	접두사(prefix)인 경우에는, 증감(++, --)이 먼저 된 후 다른 연산자가 동작
 *   	접미사(postfix)인 경우에는, 다른 연산자 먼저 실행된 후 증감(++, --)가 동작
 */
public class Operator04Main {

	public static void main(String[] args) {
		System.out.println("연산자 4 - 증감 연산자(++, --) Increment / Decrement Operator");
		
		int num1 = 100;
		
		++num1;
		// num1 = num1 + 1
		// num1 += 1
		System.out.println("num1 = " + num1);
		
		int num2 = 100;
		--num2;
		System.out.println("num2 = " + num2);
		
		
		System.out.println("\n\n======================");
		System.out.println("증감연산자: prefix(접두사), postfix(접미사)");
		
		int num3 = 100;
		++num3;
		num3++;
		System.out.println("num3 = " + num3);
		
		int num4 = 100;
		int num5 = ++num4;
		// 접두사(prefix)인 경우에는 증감(++, --)이 먼저 된 후 다른 연산자 동작
		// (1) num4의 값이 1 증가
		// (2) 증가된 num4의 값이 num5에 저장
		System.out.println("num4 = " + num4);
		System.out.println("num5 = " + num5);
		
		int num6 = 100;
		int num7 = num6++;
		System.out.println("num6 = " + num6);
		System.out.println("num7 = " + num7);
		
	
		// ★증감연산자는 다른 연산과 섞지 말고 단독문장으로 수행하는 것을 극 추천★
		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class












