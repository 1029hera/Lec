package practice.capitalize;

import java.util.Scanner;

/* LetterCapitalize
 * 	문장을 입력하고,  단어의 앞 문자를 대문자로 만들어 출력하기를 반복하다가
 *  quit 을 입력 받으면 종료하기
 * 
 * 	[입력예]
 * 		hello my world
 *  [출력예]
 * 		Hello My World  
 */

public class LetterCapitalize {
	
	// TODO : 필요한 메소드 있으면 추가 작성
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str;
		String [] words;
		
		while(true) {
			str = sc.nextLine();
			
			if(str.trim().equalsIgnoreCase("quit")) break; // 대소문자 관계없이 비교
			
			str = str.toLowerCase(); // 일단 소문자로 변환
			words = str.split("\\s+"); // 단어
			
			for(String word : words) {
				// 각 단어의 첫글자만 추출
				String firstLetter = word.substring(0, 1).toUpperCase(); // 0번부터 1번전까지 추출
				String rest = word.substring(1); // 나머지 문자열
				System.out.println(firstLetter + rest + " ");
			}
			System.out.println();
		}
		
		sc.close();
	} // end main()
} // end class
