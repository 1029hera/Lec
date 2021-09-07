package com.lec.java.array05;

import java.util.Scanner;

/* 2차원 배열 (2-dimensional array)
 * 	직전의 예제와 같이 같이 배열 첨자를 하나만 쓰는 배열을 
 * 1차원 배열 (one-dimensional array) 이라고 함
 *   배열원소가 '1차원 배열' 들로 이루어진 배열을 2차원 배열 이라 한다
 *   배열원소가 '2차원 배열' 들로 이루어진 배열을 3차원 배열 이라 한다
 *   
 *   100차원 배열의 원소는 무슨 타입? --> 99차원 배열
 *   1000차원 배열의 원소는 무슨 타입? --> 999차원 배열
*/
public class Array05Main {

	public static void main(String[] args) {
		System.out.println("2차원 배열");
		
		int [] arr1 = {1, 2};
		
		// arr1 <-- int[] 타입
		// arr1[0] <-- int 타입
		
		// 3개의 1차원 배열을 원소로 갖고 있는 2차원 배열 선언
		int[][] array = {
				{1, 2}, // <-- array[0]
				{3, 4}, // <-- array[1]
				{5, 6}  // <-- array[2]
		};
		
		System.out.println(array[0][0]);
		System.out.println(array[0][1]);
		System.out.println(array[1][0]);
		System.out.println(array[1][1]);
		System.out.println(array[2][0]);
		System.out.println(array[2][1]);
		
		// ※ 흔히 2차원 배열을 행과 열로 표현하기도 함
		// array 는 행(row) 3개, 열(column)이 2개인 2차원 배열
		
		// 2차원 배열에서 length의 의미:
		// array.length: 2차원 배열의 원소, 즉 1차원배열의 개수 
		//  			행열의 개념에선 2차원 배열의 행(row)의 개수를 의미
		
		System.out.println("array.length = " + array.length);
		System.out.println("array[0].length = " + array[0].length);
		
		// array의 타입은? --> int[][]
		// array[0]의 타입은? --> int[]
		// array[0][0]의 타입은? --> int
		
		for(int x = 0; x < array.length; x++) {
			for(int y = 0; y < array[x].length; y++) {
				System.out.print(array[x][y] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		
		// TODO: 
		// 2행 4열의 2차원배열 두 개를 만들어서 
		// 아래와 같이 초기화하고 출력하기
		
		// 첫번째 배열 출력
		// 1 2 3 4
		// 5 6 7 8			
		
		// 두번째 배열 출력
		// 1 4 7 8
		// 3 6 9 8
		
		int [][] a = {
				{1, 2, 3, 4},
				{5, 6, 7, 8}
		};
		for(int x = 0; x < a.length; x++) {
			for(int y = 0; y < a[x].length; y++) {
				System.out.print(a[x][y] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		
		int [][] b = {
				{1, 4, 7, 8},
				{3, 6, 9, 8}
		};
		
		for(int x = 0; x < b.length; x++) {
			for(int y = 0; y < b[x].length; y++) {
				System.out.print(b[x][y] + "\t");
			}
			System.out.println();
		}
		
		
	} // end main()

} // end class Array05Main









