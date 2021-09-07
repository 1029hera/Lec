package com.lec.java.array03;

import java.util.Arrays;

public class Array03Main {

	public static void main(String[] args) {
		System.out.println("여러가지 자료형의 배열");
		
		System.out.println();
		System.out.println("[1] double형 배열");
		// 타입[] 이름 = new 타입[배열 길이];
		// 타입[] 이름 = new 타입[] {a, b, ...};
		// 타입[] 이름 = {a, b, ...};

		double [] array = {1.2, 2.3, 3.4};
		for (int i = 0; i < array.length; i++) {
			System.out.println("array[" + i + "] = " + array[i]);
		}
		
		
		System.out.println();
		System.out.println("[2] char형 배열");
		
		// TODO
		
		
		System.out.println();
		System.out.println("[3] boolean형 배열");

		// TODO
		
		
		System.out.println();
		System.out.println("[4] String형의 배열");

		String [] array4 = new String[] {
				"Hello Java",
				"Hello C++",
				"Hello Html5"
		};
		
		System.out.println(Arrays.toString(array4));
		
	} // end main()

} // end class Array03Main



























