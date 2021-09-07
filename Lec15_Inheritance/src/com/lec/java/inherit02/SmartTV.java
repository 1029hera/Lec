package com.lec.java.inherit02;
//extends 키워드를 사용하여 상속

//BasicTV
//└─ SmartTV

//자바 에선 오로지 '하나의 부모'로부터 상속받을수 있습니다 (단일 상속)
//다중 상속 허용하지 않음

public class SmartTV extends BasicTV{
	
	String ip;   // 추가되는 필드
	
	public void displayInfo() {
		super.displayInfo();
		System.out.println("IP 주소: " + ip);
	}
}
