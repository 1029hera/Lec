package com.lec.java.inherit01;

// 클래스: 멤버변수 (+ 생성자) + 메소드 => 데이터 타입
public class SmartTV {
	// 멤버 변수
	boolean isPowerOn;
	int channel;
	int volume;
	String ip; // <-- SmartTV에 새로 추가될 필드
	
	// 메소드
	public void displayInfo() {
		System.out.println("--- TV 현재 상태 ---");
		System.out.println("전원: " + isPowerOn);
		System.out.println("채널: " + channel);
		System.out.println("볼륨: " + volume);
		System.out.println("IP주소: " + ip); // SmartTV에 추가된 코드
	} // end displayInfo()
	
} // end class BasicTV








