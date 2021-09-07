package com.lec.java.class06;

public class Class06Main {

	public static void main(String[] args) {
		System.out.println("클래스 연습 : 성적처리");
		
		Score score1 = new Score();
		
		score1.setName("김성중");
		
		Score score2 = new Score("박재현", 90, 80, 70);
		score2.displayInfo();

		System.out.println("프로그램 종료");
	} // end main()

} // end class Clas06Main










