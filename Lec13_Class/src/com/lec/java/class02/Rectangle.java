package com.lec.java.class02;

public class Rectangle {
	
	// 속성: 멤버변수
	// 가로
	private double width;
	// 높이
	private double height;
	
	// 생성자
	// 1) 기본생성자
	public Rectangle() {
		System.out.println("Rectangle() 생성자 호출");
		width = 100;
		height = 100;
		System.out.println("가로: " + width);
		System.out.println("세로: " + height);
	}
	
	// 2) 매개변수 받는 생성자
	public Rectangle(double w, double h) {
		System.out.println("Rectangle() 생성자 호출");
		width = w;
		height = h;
		System.out.println("가로: " + width);
		System.out.println("세로: " + height);
	}
	
	
	// 동작: 메소드
	
	// 사각형의 둘레
	public double getPerimeter() {
		return 2 * (width + height);
	}
	
	// 사각형의 넓이
	public double getArea() {
		return width * height;
	}
	

}
