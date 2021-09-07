package practice.game369;

import java.util.Scanner;

public class Game369 {

	public static void main(String[] args) {
		
// ppt p.2 과제 시작
		// /*
		int num = 100;
		int a, b;
		
		for(int i = 1; i < num + 1; i++) {
			a = i / 10; // 10의 자리 숫자 
			b = i % 10; // 1의 자리 숫자
			
			if(a == 3 || a == 6 || a == 9 || b == 3 || b == 6 || b == 9) {
				// 3 6 9 가 포함될 경우
				System.out.print(" * "); // 열을 맞추기 위해 공백을 포함했습니다.
			} else {
				System.out.printf("%3d", i); // 열 맞출려고 %3d로 해놨습니다.
			}
			
			if(i % 10 == 0) { // 10개마다 줄바꿈
				System.out.println();
			} else { // 숫자간의 여백
				System.out.print(" ");
			}
			
		} // end for
		// */
		
// ppt p.2 과제 끝
		
		
// ppt p.3 과제 시작 (위 코드 주석처리 후 아래코드 주석 삭제하고 실행 부탁드립니다.)	
		
		/*
		int a, b, n = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		int num = sc.nextInt(); // 사용자에게서 숫자 입력 받음
		
		while(n <= num) {
			b = n % 10; // 1의 자리 숫자
			a = n;
			while(true) { // 10의 자리, 100의 자리, 1000의 자리 확인
				a = a / 10;
				if(a == 3 || a == 6 || a == 9 || a / 10 == 0) break;
				// 3 6 9가 나오면 더이상 진행할 필요X, 10으로 나눈 몫이 0이라면 더이상 나눌 필요X
			}
			if(a == 3 || a == 6 || a == 9 || b == 3 || b == 6 || b == 9) {
				// 3 6 9 가 포함될 경우
				System.out.print("  * "); // 열을 맞추기 위해 공백을 포함했습니다.
			} else {
				System.out.printf("%4d", n); // 열을 맞추기 위해 %4d로 해놨습니다.
			}
			if(n % 10 == 0) { // 10개마다 줄바꿈
				System.out.println();
			} else { // 숫자간의 여백
				System.out.print(" ");
			}
			n++;
		} // end while
		sc.close();
		*/
		
// ppt p.3 과제 끝
		
		
	} // end main

}
