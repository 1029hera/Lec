package com.lec.java.for01;


/*
 * ■ 순환문(loop)
 * 	- for
 * 	- while
 * 	- do ~ while

 * 
 * ■ for 순환문 구문
 * 
 * for(①초기식; ②조건식; ④증감식){
 * 		③수행문;
 * 		..
 * }
 *      ①초기식 : 최초에 단한번 수행
 *      ②조건식 : true / false 결과값
 *      		위 조건식의 결과가 false 이면 for문 종료
 *      ③수행문 : 위 조건식이 true 이면  수행
 *      ④증감식 : 수행문이 끝나면 증감식 수행
 *               증감식이 끝나면 다시 ②조건식 으로.. 
 * 
 * 순환문을 작성시 내가 만드는 순환문에 대해 다음을 확실하게 인지하고 작성해야 한다
 * 1. 몇번 순환하는 가?
 * 2. 순환중에 사용된 인덱스값의 시작값과 끝값은? 
 * 3. 순환문이 끝난뒤 인덱스값은?
 * 
 * 
    for문 작성시 TIP
	 1) n번 순환 하는 경우 (즉 횟수가 촛점인 경우)
	 for(int i = 0; i < n; i++){ .. }
	
	 2) a ~ b 까지 순환하는 경우 (즉 시작값과 끝값이 중요한 경우)
	 for(int i = a; i <= b; i++){ .. }
 */


public class For01Main {

	public static void main(String[] args) {
		System.out.println("for 반복문");
		
		System.out.println("Hello Java 1");
		System.out.println("Hello Java 2");
		System.out.println("Hello Java 3");
		
		System.out.println();
		
		for(int count = 1; count <= 3; count++) {
			System.out.println("Hello Java " + count);
		} // end for
		
		// 1 ~ 10 까지 for 사용하여 출력
		
		for(int count = 1; count <= 10; count++) {
			System.out.print(count + " ");
		}
		System.out.println();
		
		// 10 ~ 1 까지 출력
		for (int count = 10; count >= 1; count--) {
			System.out.println(count + " ");
		}
		
		// local variable : 블럭 { } 안에서 선언되는 변수
		// 블럭 안에서만 유효하고, 블럭 종료하면 소멸된다
		
		int x = 200;
		{
			int aaa = 100; // 블럭 안에서 선언된 지역변수 aaa
			System.out.println("블럭안 :  x = " + x + "aaa = " + aaa);
		} // 블럭이 끝나면 aaa는 소멸된다.
		
		System.out.println("블럭밖 : x = " + x);
		// 변수(이름)가 유효한 범위 ==> scope
		
		
		// 초기식과 증감식에 식을 여러개 사용 가능!
		System.out.println();
		int i, j;
		for(i = 0, j = 10; i < j; i++, j -= 2) {
			System.out.println("i:" + i + " j:");
		}
		System.out.println("for 종료 후 i : " + i + "j : " + j);
		
	} // end main()

} // end class For01Main








