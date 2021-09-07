package com.lec.java.for04;

public class For04Main {

	public static void main(String[] args) {
		System.out.println("for문 연습");
		
		// 1 ~ 10 까지의 합을 계산
		// 1 + 2 + ... + 9 + 10 => 55
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println("sum = " + sum);
		
		// 1 ~ 10 까지의 수 중에서 짝수들의 합 구하기
		sum = 0;
		for(int i = 1; i <= 10; i++) {
			if(i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("sum = " + sum);
		
		
	} // end main ()

} // end class For04Main










