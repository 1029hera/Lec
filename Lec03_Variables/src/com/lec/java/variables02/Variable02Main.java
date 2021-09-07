package com.lec.java.variables02;

public class Variable02Main {

	public static void main(String[] args) {
		
		// 국어, 영어, 수학점수를 담은 변수 선언하고
		// 총점, 평균을 계산해서 출력
		
		int korean = 50; // 선언과 동시에 초기화
		int english = 50;
		int math = 33;
		
		System.out.println("총점 : " + (korean + english + math));
		
		int total = korean + english + math;
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + total / 3);
		System.out.println("평균 : " + total / 3.0);
		
		System.out.println("평균 : " + (double)total / 3);
		
	}

}
