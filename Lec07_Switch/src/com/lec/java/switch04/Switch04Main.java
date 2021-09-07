package com.lec.java.switch04;

public class Switch04Main {

	public static void main(String[] args) {
		System.out.println("String 타입을 switch에서 사용하기");
		
		String language = "C++";
		switch(language) {
		case "Java":
			System.out.println("Hello Java!");
			break;
		case "C++":
			System.out.println("Good morning, C++");
			break;
		case "Swift":
			System.out.println("Hello, Swift!");
			break;
		default:
			System.out.println("하늘의 별처럼 많은 플밍언어");
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









