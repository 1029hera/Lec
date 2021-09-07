package com.lec.java.oop07;

public class Interface03Main {

	public static void main(String[] args) {
		System.out.println("인터페이스와 다형성");
		
		TestImple t1 = new TestImple();
		t1.testAAA();
		t1.testBBB();
		
		System.out.println();
		InterfaceAAA tA = new TestImple();
		InterfaceBBB tB = new TestImple();
		
		tA.testAAA();
		//tA.testBBB();
		((InterfaceBBB)tA).testBBB();
		((TestImple)tA).testBBB(); // 권장
		
		//tB.testAAA();
		tB.testBBB();
		
		System.out.println("\n 프로그램 종료");
	} // end main()

} // end class











































