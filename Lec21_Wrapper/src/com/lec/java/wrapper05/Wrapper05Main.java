package com.lec.java.wrapper05;

/* Wrapper 클래스의 유용성
 * 1. Object 타입이 모~든 (심지어 primitive) 타입도 받을수 있다.
 * 2. Collection 과 같은 Generic 클래스에선
 *     primitive 타입을 담을수 없다. 그러나 ,Wrapper 를 통해 가능하다.
 */
public class Wrapper05Main {

	public static void main(String[] args) {
		System.out.println("Wrapper 클래스의 유용성");
		
		Object obj1 = new A();
		Object obj2 = new A2();
		Object obj3 = 123;
		// 123 --> (auto-boxing) --> Integer --> (다형성) --> Object

		System.out.println("\n프로그램 종료");
	} // end main()

	// TODO
	
} // end class

class A {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "A";
	}
}

class A2 extends A {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "A2";
	}
}