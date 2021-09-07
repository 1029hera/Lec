package com.lec.java.loop03;

public class Loop03Main {

	public static void main(String[] args) {
		System.out.println("중첩 for 문 nested for");

		// 구구단 출력 : 중첩 for 사용
		for(int i = 1; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				System.out.println(i + " X " + j + " = " + (i * j));
			}
			System.out.println("------------");
		}
		
		System.out.println();
		// 구구단 출력 : 중첩 while 문 사용
		int dan = 1, mul;
		while(dan < 10) {
			mul = 1;
			while(mul < 10) {
				System.out.println(dan + " X " + mul + " = " + (dan * mul));
				mul++;
			}
			System.out.println("------------");
			dan++;
		}
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


















