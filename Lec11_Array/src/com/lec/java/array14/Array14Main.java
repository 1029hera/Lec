package com.lec.java.array14;

import java.util.Arrays;

public class Array14Main {

	public static void main(String[] args) {
		System.out.println("Reference 타입 주의");
		
		int a = 10;
		int b = 20;
		
		System.out.println("a:" + a + ", b:" + b);
		a = b;
		System.out.println("a:" + a + ", b:" + b);
		a = 30;
		System.out.println("a:" + a + ", b:" + b);
		
		int [] arrA = new int[] {1, 2, 3};
		int [] arrB = new int[] {100, 200, 300};
		System.out.println(Arrays.toString(arrA) + " " + Arrays.toString(arrB));
		arrA = arrB;
		System.out.println(Arrays.toString(arrA) + " " + Arrays.toString(arrB));
		arrA[0] = 55;
		System.out.println(Arrays.toString(arrA) + " " + Arrays.toString(arrB));
	}

}
