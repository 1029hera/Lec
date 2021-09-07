package com.lec.java.inner08;

public class Anonymous02Main {

	public static void main(String[] args) {
		System.out.println("익명 내부 클래스 활용");
		
		System.out.println("1. 익명클래스를 사용하지 않을 경우 - 이름있는 클래스 상속");
		Calculable tc1 = new TestMyMath();
		double result = tc1.operate(1.0, 2.0);
		System.out.println("result = " + result);
		
		System.out.println();
		System.out.println("2 익명클래스 사용");
		Calculable tc2 = new Calculable() {
			
			@Override
			public double operate(double x, double y) {
				return x + y;
			}
		};
		result = tc2.operate(1.0, 2.0);
		System.out.println("result = " + result);
		
		System.out.println();
		
		Calculable tc3 = new Calculable() {
			
			@Override
			public double operate(double x, double y) {
				return x - y;
			}
		};
		result = tc3.operate(1.0, 2.0);
		System.out.println("result = " + result);
		
		System.out.println();
		
		result = new Calculable() {
			
			@Override
			public double operate(double x, double y) {
				return x * y;
			}
		}.operate(1.0, 2.0);
		System.out.println("result = " + result);
		
		System.out.println();
		
		System.out.println("result = " + new Calculable() {
			
			@Override
			public double operate(double x, double y) {
				return Math.pow(x, y);
			}
		}.operate(12.3, 3.1));
		
		// ↑ 안드로이드 등의 프레임워크 프로그래밍에서 자주 + 많이 쓰는 기법.
		
	} // end main()

} // end class Anonymous02Main

interface Calculable {
	public abstract double operate(double x, double y);
}

class TestMyMath implements Calculable{

	@Override
	public double operate(double x, double y) {
		return x + y;
	}
	
}















