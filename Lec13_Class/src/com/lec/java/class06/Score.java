package com.lec.java.class06;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @애노테이션 (annotation) 
// 클래스, 메소드, 변수 위에 붙여서
// 컴파일러 등에 특별한 동작을 함.

//@Setter
//@Getter
@AllArgsConstructor // 모든 매개변수를 받는 생성자
@NoArgsConstructor // 기본 생성자
@Data // @Setter + @Getter + @ToString + @EqualsAndHashCode 
public class Score {
	// 멤버변수 : 
	// 	학생 이름 String
	// 	국어점수 int 
	// 	수학점수 int
	// 	영어점수 int
	private String name;
	private int korean;
	private int eng;
	private int math;
//	private long age;
	
	// 생성자: 멤버 변수 초기화
	//   1) 디폴트 생성자
	// TODO
	
	//   2) 매개변수 받는 생성자 (이름, 국어점수, 수학점수, 영어점수)
	
	
	// 메소드
	// 총점계산 메소드
	// 메소드이름 :calcTotal()
	// 리턴타입 : int
	public int calcTotal() {
		return korean + eng + math;
	}
	
	// 평균계산 메소드
	// 메소드 이름 : calcAvg()
	// 리턴타입 : double
	public double calcAvg() {
		return calcTotal() / 3.0;
	}
	
	// 메소드
	// 이름: displayInfo()
	// 리턴: void
	// 매개변수: none
	//   학생의 이름, 국어, 영어, 수학 점수 출력
	public void displayInfo() {
		System.out.println("이름: " + this.name);
		System.out.println("국어: " + this.korean);
		System.out.println("영어: " + this.eng);
		System.out.println("수학: " + this.math);
		System.out.println("총점] " + calcTotal());
		System.out.println("평균] " + calcAvg());
	}
	
	
	
}


















