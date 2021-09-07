package practice.stddev;

import java.util.Random;

public class StdDev {

	public static void main(String[] args) {

		int [] array = new int[5];
		for(int i = 0; i < array.length; i++) {
			array[i] = new Random().nextInt(100) + 1;
			System.out.print(array[i] + " ");
		}
		System.out.println();
		// 임의정수 5개로 초기화한 정수로
		// 평균, 분산, 표준편차 구하기
		System.out.println("평균 : " + calcAvg(array));
		System.out.println("분산 : " + calcVariance(array));
		System.out.println("표준편차 : " + calcStdDev(array));
		
		

	} // end main
	
	/**
	 * 메소드 이름 : calcAvg
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '평균값' 리턴
	 */
	public static double calcAvg(int [] arr) {
		int sum = 0;
		for(int k: arr) {
			sum += k;
		}
		return sum / 5.0;
	}
	
	
	/**
	 * 메소드 이름 : calcVariance
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '분산값' 리턴
	 */
	public static double calcVariance(int [] arr) {
		double avg = calcAvg(arr);
		double sum = 0;
		for(int k: arr) {
			sum += Math.pow((k - avg), 2);
		}
		return sum / 5;
	}
	
	/**
	 * 메소드 이름 : calcStdDev
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '표준편차' 리턴
	 */
	public static double calcStdDev(int [] arr) {
		double var = calcVariance(arr);
		return Math.sqrt(var);
	}

} // end class
