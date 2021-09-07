package com.lec.java.oop02;

/* 다형성의 유용성
	다형성에 의해서, 자식타입 객체가 부모타입으로 자동 형변환 가능!
	부모타입 만으로도 상속된 모~든 자손 타입들을 담을수 있다.
*/

public class Polymorphism02Main {

	public static void main(String[] args) {
		System.out.println("다형성의 사용 (유용성)");

		Vehicle car1 = new Vehicle();
		Vehicle car2 = new Car();
		Vehicle car3 = new HybridCar();
		
		Vehicle[] car = new Vehicle[3];
		car[0] = new Vehicle();
		car[1] = new Car();
		car[2] = new HybridCar();
		
		for(int i = 0; i< car.length; i++) {
			System.out.println(car[i]);
		} // !! 한가지 타입으로 여러 파생된(상속된) 타입 동작 가능!!
		
		// 다형성이 없었다면?  각 타입별로 변수들을 만들고 따로따로 사용해야 하는 왕불편.
		//		Vehicle car1 = new Vehicle();
		//		Car car2 = new Car();
		//		HybridCar car3 = new HybridCar();
		//		car1.displayInfo();		
		//		car2.displayInfo();
		//		car3.displayInfo();
		
		System.out.println();
		for (int i = 0; i < car.length; i++) {
			driveCar(car[i]);
		}
		
		System.out.println("\n 프로그램 종료");
	} // end main()
	
	public static void driveCar(Vehicle v) { // 조상타입 매개변수 메소드
		v.setSpeed(100);
		System.out.println(v);
	}
	
	// 다형성으로 인해 아래와 같은 불필요한 메소드 overloading을 줄일 수 있다.
//	public static void driveCar(Vehicle v) {
//	v.setSpeed(100);
//	v.displayInfo();
//}
//	public static void driveCar(Car v) {
//		v.setSpeed(100);
//		v.displayInfo();
//	}
//	public static void driveCar(HybridCar v) {
//		v.setSpeed(100);
//		v.displayInfo();
//	}

} // end class












































