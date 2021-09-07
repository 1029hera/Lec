package com.lec.java.if01;

/* if, if ~ else 조건문
 * 
 * 구문1:
 * 	if (조건식) {
 *  	조건식이 true 일때 실행되는 문장(들) 
 *  	...
 * 	}
 * 
 * 구문2:
 *  if (조건식) {
 *		조건식이 true 일때 실행되는 문장(들)
 *		...
 *  } else {
 *		조건식이 false 일때 실행되는 문장(들)
 *		...
 *  }
 */
public class If01Main {

	public static void main(String[] args) {
		System.out.println("if 조건문");

		int num = -10;
		if(num > 0) {
			// if() 조건식이 true 일 때 실행되는 블럭
			System.out.println("양수입니다.");
		} else {
			// if() 조건식이 false 일 때 실행되는 블럭
			System.out.println("0 혹은 음수입니다.");
		} // end if
		
		System.out.println();
		
		
		int num2 = 123;
		if(num2 % 2 == 0) {
			System.out.println("짝수입니다.");
		} else {
			System.out.println("홀수입니다.");
		}
		
		System.out.println();
		
		int num3 = 40;
		
		if(0 <= num3 && num3 <= 100) {
			System.out.println("0 <= num4 <= 100");
		}
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
