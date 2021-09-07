package com.lec.java.final01;

public class Final01Main {
	
	// final 멤버 변수
	final int NUM1 = 1;
	//final int NUM2; // (주의) final 멤버변수는 반드시 인스턴스 생성단계에서 초기화 되야 한다.
	final int NUM3; // 생성자에서 초기화 가능
	
	public Final01Main() {
		NUM3 = 10;
	}
	
	public static void main(String[] args) {
		System.out.println("final: 변경할 수 없는 상수");
		
		Final01Main f = new Final01Main();
		System.out.println(f.NUM1);
		// f.NUM1 = 10; final, 값을 더 이상 변경할 수 없다.
		
		
	} // end main()

} // end class Final01Main










