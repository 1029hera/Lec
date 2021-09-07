package com.lec.java.input02;

import java.util.Scanner;

// 문자열 (String) 입력
// char 입력
public class Input02Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// String 입력
		System.out.print("이름을 입력하세요: ");
		String name = sc.nextLine(); // 문자열 한줄 입력받아 리턴
		
		System.out.print("별명을 입력하세요: ");
		String nick = sc.nextLine();
		
		System.out.println("이름은 " + name + "\n별명은 " + nick);
		
		// char 입력
		// nextChar() 라는 메소드 없다.
		System.out.println("성별을 입력하세요 M/F: ");
		char gender = sc.next().charAt(0);
		System.out.println("이름은 " + name + "\n별명은 " + nick + "\n성별은 " + gender);
		
		
		// next() 는 공백단위로 입력된 문자열 읽기
		// nextLine() 은 Enter 단위로 입력된 문자열 읽기
		
		System.out.println("나이를 입력하세요: ");
		int age = sc.nextInt();
		
		sc.nextLine(); // 숫자 입력 받은 뒤에 문자열 입력시에는 반드시 nextLine() 을 해서 버퍼에 남아있는 '\n' 제거
		
		System.out.println("주소를 입력하세요: ");
		String addr = sc.nextLine();
		
		System.out.println("나이는: " + age + "\n주소: " + addr);

		sc.close();
		
	}

}
