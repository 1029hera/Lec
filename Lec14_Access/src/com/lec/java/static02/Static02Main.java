package com.lec.java.static02;

//클래스 변수 / 메소드 특징 (static)
//1. 메모리의 '메소드 영역'에 클래스가 로드 될때(프로그램 시작될때) '한번만' 생긴다
//2. 인스턴스가 생성되지 않아도 사용할 수 있다.
//		- 클래스이름.static변수,  클래스이름.static메소드()  <-- 요렇게 사용한다
//3. 모든 인스턴스는 하나의 static 변수/메소드를 '공유'한다.


public class Static02Main {

	public static void main(String[] args) {
		System.out.println("인스턴스 변수/메소드");

		Test.show2(); // static 변수도 기본값으로 초기화 됨을 확인
		
		Test.sNum = 123;
		Test.show2();
		
		//Test.num = 10; // 에러
		
		// 인스턴스 변수/메소드 사용하려면
		// 인스턴스 부터 생성(new) 해야 함
		Test t = new Test();
		t.num = 100;
		t.show();
		
		Test t2 = new Test();
		t2.show();
		
		Test.sNum = 987;
		t.show();
		t2.show();
		
		t2.sNum = 340;  // 가능은 하나, 바람직한 static 사용법 아님
		t.show();
		
		Test.sNum = 100;  // static 은 클래스 이름으로 사용하자
		t.sNum = 500;
		t2.sNum = 700;
		System.out.println(Test.sNum);
		System.out.println(t.sNum);
		System.out.println(t2.sNum);

		
	} // end main()

} // end class Static02Main







