package com.lec.java.casting;
/*
 * 암묵적 형변환(Implicit casting): 자바 언어가 자동으로 해주는 형변환
 * 
 * 		primitive type 에서 implicit casting 방향
 * 
 * 		byte → short → int → long → float → long  
 *                 		↑
 *                    char
 * 
 * 명시적 형변환(Explicit casting): 프로그래머가 직접 타입을 변환하는 것
 *      
 *      (변환하고자 하는 타입명)변수/값
 *      
 *      
 *            
 */
public class CastingMain {

	public static void main(String[] args) {
		
		// 명시적 형변환
		byte num5 = (byte)513;
		System.out.println("num5 = " + num5);
		
		double avg1 = (99 + 88 + 78) / 3;
		System.out.println("avg1 = " + avg1);
		
		double avg2 = (99 + 88 + 78) / 3.0;
		System.out.println("avg2 = " + avg2);
		
		
		
	}

}
