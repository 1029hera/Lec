package com.lec.java.class02;


public class Class02Main {

	public static void main(String[] args) {
		System.out.println("클래스 연습");		
		
		Circle c1 = new Circle();
//		c1.radius = 10;
//		c1.bbb = 20;
		
		double perimeter = c1.calcPerimeter();
		System.out.println("c1의 둘레: " + perimeter);
		
		Circle c2 = new Circle(3);
		System.out.println("c2의 둘레: " + c2.calcPerimeter());
		System.out.println("c2의 넓이: " + c2.calcArea());
		
		Rectangle r1 = new Rectangle();
		System.out.println("r1의 둘레: " + r1.getPerimeter());
		System.out.println("r1의 넓이: " + r1.getArea());
		
		Rectangle r2 = new Rectangle(20, 30);
		System.out.println("r2의 둘레: " + r2.getPerimeter());
		System.out.println("r2의 넓이: " + r2.getArea());
		
		System.out.println("프로그램 종료");
	} // end main()

} // end class Class02Main










