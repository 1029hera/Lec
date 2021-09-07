package com.lec.java.class04;

public class Number {
	private int num = 100; // 멤버변수 선언시 초깃값 명시 가능.

	
	// 생성자
	public Number() {}
	
	public Number(int num) {
		this.num = num;
	}

	// getter & setter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public Number add(Number x) {
		this.num += x.num;
		return this;
	}
	
	public Number sub(Number x) {
		this.num -= x.num;
		return this;
	}
	
	
}
