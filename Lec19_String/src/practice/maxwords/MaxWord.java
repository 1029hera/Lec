package practice.maxwords;

import java.util.Scanner;
import java.util.StringTokenizer;
/* MaxWrod
	여러문장으로 구성된 문자열을 입력받은뒤 
	문자열에서 가장 단어의 개수가 많은 문장을 찾아서, 
	그 문장과 문장의 단어의 개수를 출력
	'문장'의 구분은  .(마침표) !(느낌표) ?(물음표) 로 한다.
	'단어'구분은 '공백' 으로 한다
	
	입력예]
	We test coders. Give us a try. Can you make it out? It's awesome.
	
	출력예]
	5개
	Can you make it out
 */
public class MaxWord {
	
	// TODO : 필요한 메소드 있으면 추가 작성
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cnt = 0, max = 0; // 몇번째 문장, 최대 단어 수
		String str = sc.nextLine();
		
		String[] word = str.split("[.!?]"); // 문장 구분
		
		for(int i = 0; i < word.length; i++) {
			word[i] = word[i].trim(); // 앞뒤 공백 제거
			StringTokenizer token = new StringTokenizer(word[i], " "); // 공백으로 단어 구분
			if(token.countTokens() > max) {
				max = token.countTokens();
				cnt = i;
			}
		}
		
		System.out.println(max + "개");
		System.out.println(word[cnt]);
		
		
		sc.close();
	} // end main
} // end class
