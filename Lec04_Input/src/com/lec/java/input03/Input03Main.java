package com.lec.java.input03;

import java.util.Scanner;

public class Input03Main {

	public static void main(String[] args) {
		
		System.out.println("nextLine() vs next()");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("여러 단어로 이루어진 문장을 입력하세요>");
		String in = sc.nextLine();
		System.out.println("in: " + in);
		
		// next()
		// 다음 단어(token) 을 받아서 String 으로 돌려준다
		System.out.print("여러 단어로 이루어진 문장을 입력하세요>");
		String in1 = sc.next();
		System.out.println("in1: " + in1);
		
		String in2 = sc.next();
		System.out.println("in2: " + in2);
		String in3 = sc.next();
		System.out.println("in3: " + in3);
		
		System.out.println("숫자 3개 입력 (int, double, int)>");
		int i1 = sc.nextInt();
		double d1 = sc.nextDouble();
		int i2 = sc.nextInt();
		
		System.out.printf("i1=%d d1=%f i2=%d\n", i1, d1, i2);
		
		
		
		sc.close(); // close() <-- 사용한 시스템 자원 (키보드, hw, 파일, 네트워크 등...) 을 시스템에 반납
		
	}

}
