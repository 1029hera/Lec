package com.lec.java.array02;
/*  배열의 선언과 초기화
 	
 	배열 선언 따로, 초기화 따로
		타입[] 이름 = new 타입[배열의 길이];
		
	배열을 선언과 동시에 초기화 1
		타입[] 이름 = new 타입[] {a, b, c, ...};
		
	배열을 선언과 동시에 초기화 2
		타입[] 이름 = {a, b, c, ...};
		
	배열의 길이를 자동으로 알 수 있는 방법
		배열이름.length 
 */
public class Array02Main {

	public static void main(String[] args) {
		System.out.println("배열의 선언과 초기화");
		
		int[] korean = new int[3]; // 선언 (생성)
		
		korean[0] = 100; // 초깃값
		korean[1] = 90;
		korean[2] = 80;
		
		// 배열 선언과 동시에 초기화 1
		
		int [] english = new int[] {30, 20, 30};
		for (int i = 0; i < english.length; i++) {
			System.out.println("영어" + i + " : " + english[i]);
		}
		
		// 배열 선언과 동시에 초기화 2
		int [] math = {99, 88, 77, 66};
		for (int i = 0; i < math.length; i++) {
			System.out.println("수학" + i + " : " + math[i]);
		}
		
		// 수학점수의 '총점'과 '평균' 계산해서 출력
		
		int total = 0;
		for (int i = 0; i < math.length; i++) {
			total += math[i];
		}
		double avg = (double)total / math.length;
		System.out.println("수학총점 : " + total + "\n수학평균 : " + avg);
		
		// 배열 원소 개수
		System.out.println("math.length + " + math.length);
		
		// 배열변수 직접 출력하면 -> [I@주소
		System.out.println(math); // ????
		
		
		
	} // end main()

	
} // end class Array02Main











