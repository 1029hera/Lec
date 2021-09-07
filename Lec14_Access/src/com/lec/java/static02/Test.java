package com.lec.java.static02;

public class Test {
	int num; // 인스턴스 변수
	static int sNum; // 클래스 변수 (static 변수)
	
	// 인스턴스 메소드
	public void show() {
		System.out.println("num = " + num);
		System.out.println("sNum = " + sNum);
	}
	
	// 클래스 메소드 (static 메소드)
	public static void show2() {
//		System.out.println("num = " + num);
		System.out.println("sNum = " + sNum);
	}
}
