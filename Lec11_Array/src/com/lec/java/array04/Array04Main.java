package com.lec.java.array04;

/* 연습
 * 길이 5개 int 형 배열을 선언하고
 * 사용자로부터 5개 정수를 입력받아 초기화 한뒤 
 * 
 * 총점, 평균, 최대값, 최소값  출력해보기
 */
public class Array04Main {

	public static void main(String[] args) {
		System.out.println("배열 연습");
		
		int [] score = {78, 2, 23, 98, 41};
		
		// 배열 안에서 최댓값 구하기
		int max = score[0]; // 첫번째 원소 (기준)
		
		for (int i = 1; i < score.length; i++) { // 두번째 원소부터 비교 시작
			if(score[i] > max) {
				max = score[i];
			}
		}
		
		System.out.println("최댓값 = " + max);
		
		// 배열 안에서 최솟값 구하기
		int min = score[0]; // 첫번째 원소 (기준)
		
		for (int i = 1; i < score.length; i++) { // 두번째 원소부터 비교 시작
			if(score[i] < min) {
				min = score[i];
			}
		}
		System.out.println("최솟값 = " + min);
		
		
	} // end main()

} // end class Array04Main








