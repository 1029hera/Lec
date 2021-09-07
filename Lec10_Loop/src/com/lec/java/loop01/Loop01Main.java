package com.lec.java.loop01;

/* break;
 * 순환문(for, while, do~while) 안에서 break를 만나면
 * break를 감싸는 가장 가까운 순환문 종료
 */
public class Loop01Main {

	public static void main(String[] args) {
		System.out.println("Break");
		
		int num = 1;
		while(num <= 10) {
			System.out.println(num);
			
			// num 값 3을 출력하면 순환문 종료
			if(num == 3) {
				break;
			}
			
			num++;
		}
		System.out.println("while 끝난 후 num = " + num);
		
		
		System.out.println();
		// 2와 7의 최소공배수를 출력
		// 최소공배수: 공배수 중에서 가장 작은 수

		num = 1;
		while(true) {
			if(num % 2 == 0 && num % 7 == 0) {
				System.out.println(num);
				break;
			}
			num++;
		}
		

		System.out.println();
		System.out.println("무한 루프와 break;");

		for(num = 1;;num++) {
			System.out.println(num);
			if(num == 5) break;
		}
		
		
		
		System.out.println();
		// 2단은 x 2 까지 출력
		// 3단은 x 3 까지 출력
		
		// TODO

		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


















