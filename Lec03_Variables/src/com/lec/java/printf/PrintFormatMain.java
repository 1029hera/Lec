package com.lec.java.printf;
/* 서식화된 문자열 (formatted string)
 *  ● 화면에 출력할때는 -> printf()
 *    
 *    printf("서식문자열", 값1, 값2....)
 *    
 *  ● 문자열(String)으로 만들때는 -> String.format()
 *       	
 *    String.format("서식문자열", 값1, 값2....)
 *    
 *  ● format specifier (서식 지정자)
 *  	%d  :  십진수 정수로 출력
 *  	%f  :  실수 출력
 *  	%s  :  문자열 출력
 *  	%c  :  '문자하나' 출력
 *  	%x  :  16진수 정수로 출력
 *  	%%  :  % 출력
*/
public class PrintFormatMain {

	public static void main(String[] args) {
		double pi = Math.PI; // 원주율 값
		System.out.println(pi);
		
		System.out.printf("원주율 %f 입니다\n", pi);
		System.out.printf("원주율 %.2f 입니다\n", pi);
		
		int age = 10;
		short grade = 3;
		
		System.out.printf("제 나이는 %d 살입니다. 학년은 %d 입니다.", age, grade);
		
		double height = 182.3;
		System.out.printf("제 키는 " + height + "입니다.\n");
		System.out.printf("제 키는 %f입니다.\n", height);
		System.out.printf("제 키는 %.1f입니다.\n", height);
		
		// 출력폭 지정, 좌우정렬
		System.out.printf("|%d|%d|%d|\n", 100, 200, 300);
		System.out.printf("|%5d|%5d|%5d|\n", 100, 200, 300); // 우측정렬(기본)
		System.out.printf("|%-5d|%-5d|%-5d|\n", 100, 200, 300); // 좌측정렬
		System.out.printf("|%6.1f|\n", height);
		
		System.out.printf("제 이름은 [%s]입니다. 혈액형은 %c입니다.\n", "김만두", 'B');
		System.out.printf("제 이름은 [%10s]입니다. 혈액형은 %c입니다.\n", "김만두", 'B');
		
		// % 출력
		double rate = 134423.0 / 345678.0;
		System.out.printf("합격률은 %.1f%% 입니다.\n", rate * 100);
		
		System.out.println();
		
		// String.format()
		// 기본적으로 printf() 와 사용법은 동일함
		// 단, 화면에 출력하는게 아니라, 결과를 문자열(String) 으로 만들어서 리턴

		String.format("합격률은 %.1f%% 입니다.\n", rate * 100);
		String result = String.format("합격률은 %.1f%% 입니다.\n", rate * 100);
		System.out.println(result);
		
		

	}

}
