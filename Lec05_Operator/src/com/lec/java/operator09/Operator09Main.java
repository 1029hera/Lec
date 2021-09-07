package com.lec.java.operator09;
/* 산술 연산의 결과 타입
 * 
 * 일단 피연산자가 reference type 이면, unbox 후 형변환 수행됨. 그리고 나서
 * 피연산자중 하나라도 double 이면 다른쪽이 double 이 된다.  
 * 그렇지 않으면 피연산자중 하나라도 float 이면 다른 쪽이 float 가 된다.  
 * 그도 아니면 피연산자중 하나라도 long 이면 다른 쪽을 long 으로 바꾼다.  
 * 그도 아니면 양쪽 피연산자 모~ 두 int 로 바꾼다.
 * 
 * https://docs.oracle.com/javase/specs/#5.6.2
 * 	When an operator applies binary numeric promotion to a pair of operands, each of which must denote a value that is convertible to a numeric type, the following rules apply, in order, using widening conversion (§5.1.2) to convert operands as necessary: 
 * 	If any of the operands is of a reference type, unboxing conversion (§5.1.8) is performed. Then: 
 * 	If either operand is of type double, the other is converted to double. 
 * 	Otherwise, if either operand is of type float, the other is converted to float. 
 * 	Otherwise, if either operand is of type long, the other is converted to long. 
 * 	Otherwise, both operands are converted to type int.
 */
public class Operator09Main {

	public static void main(String[] args) {
		System.out.println("산술연산의 결과 타입");

		int n1 = 10, n2 = 20;
		int n3 = n1 + n2;
		System.out.println("n3: " + n3);
		
		byte b1 = 10, b2 = 20;
		byte b3 = 10 + 20;
		//b3 = b1 + b2; // byte + byte => int
		
		long l1 = 10L;
		//int n4 = n1 + l1; // int + long => long
		
		short s1 = 100;
		//short s2 = s1 + b1; // short + byte => int
		
		float f1 = 1.0f, f2 = 2.0f; // float + float => float
		float f3 = f1 + f2;
		
		double d1 = 1.0, d2 = 2.0;
		//float f4 = f1 + d1; // float + double => double
		
		long l2 = 27000000000L;
		System.out.println("l2: " + l2);
		
		l2 = 3000 * 3000 * 3000;
		System.out.println("l2: " + l2);
		
		// 복합대입 연산자의 경우 형변환 주의
		int sum = 0;
		double d3 = 1.2;
		//sum = sum + d3; // int + double => double
		sum += d3;
		System.out.println(sum);
		
		// sum += d3
		// sum = sum + d3 로 작동하는 게 아니라
		// sum = (int)(dum + d3) 로 동작함
		
		
		System.out.println("\n 프로그램 종료");
	} // end main ()

} // end class

//Debug
//step1 : breakpoint 설정
//step2 : debug 시작
//step3 : 
//     step over
//     resume

//    1) 프로그램의 흐름
//    2) 변수값의 변화
//    3) 호출관계 흐름

//step4 : debug 종료 (terminate)
//




