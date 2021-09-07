package com.lec.java.while02;

public class While02Main {

	public static void main(String[] args) {
		System.out.println("while 연습");
		
		// 1 ~ 100 수 중에서 2와 7의 공배수만 출력
		int i = 1;
		while(i <= 100) {
			
			if(i % 2 == 0 && i % 7 == 0) {
				System.out.println(i);
			}
			
			i++;
		}

	} // end main()

} // end class While02Main









