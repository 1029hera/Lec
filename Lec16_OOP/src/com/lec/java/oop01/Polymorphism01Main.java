package com.lec.java.oop01;
/*
 	다형성  ( Polymorphism )
 	하나의 이름의 클래스나 메소드가 '여러 가지 형태의 동작을 하는 능력'
 	
 	클래스의 다형성:
	 	한 타입의 참조변수로 여러타입의 객체를 참조 가능.
	 	조상클래스 타입의 참조변수로 자손클래스의 인스턴스를 참조가능한것
 	
 	메소드의 다형성:
 		메소드 오버로딩, 메소드 오버라이딩
 		
 	어떤 경우에 상속으로 객체를 설계하나?
 		HAS-A 관계 ===> 멤버로 설계
 					Car, Tire
 					Car is-a Tire (X)
 					Tire is-a Car (X)
 					Car has-a Tire (OK)
 		IS-A 관계 ===> 상속으로 설계
 					Vehicle is-a Car (NO)
 					Car is-a Vehicle (OK) <- 상속
 					HybridCar is-a Car (OK)
 	
 */
public class Polymorphism01Main {

	public static void main(String[] args) {
		System.out.println("다형성(Polymorphism)");
		
		Vehicle v1 = new Vehicle();
		Car c1 = new Car();
		HybridCar h1 = new HybridCar();
		
		System.out.println(v1);
		System.out.println(c1);
		System.out.println(h1);
		
		Vehicle car1 = new Car(); // !!?
		
		Vehicle car2 = new HybridCar(); // ??!
		
		Car car3 = new HybridCar();
		
		// car1 ~ car3 변수타입에 '관계없이'
		// 오버라이딩 된 메소드가 '알아서' 동작한다
		System.out.println("---------------");
		System.out.println(car1);
		System.out.println(car2);
		System.out.println(car3);
		
		System.out.println("\n 프로그램 종료");
	} // end main()
	
	// TODO

} // end class


// Vehicle
//   └ Car
//      └ HybridCar





































