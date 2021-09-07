package com.lec.java.array10;

/* Enhanced for (향상된 for) 문
 	
 	for (배열타입 변수 : 배열이름) { ... }
 	
 */
public class Array10Main {

	public static void main(String[] args) {
		System.out.println("Enhanced for (향상된 for) 문");
		
		int [] arr = {11, 222, 33, 44, 55};
		
		for(int e : arr) {
			System.out.print(e + " ");
		}
		System.out.println();
		
		int[][] array = {
				{1, 2},
				{3, 4, 5, 6},
				{7, 8, 9}
		};
		
		for(int[] row : array) {
			for(int x : row) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		
		
		
	} // end main()

} // end class Array10Main









