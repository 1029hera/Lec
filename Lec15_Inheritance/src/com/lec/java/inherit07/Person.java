package com.lec.java.inherit07;

public class Person {
	String name;
	

	// ALT + SHIFT + S
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	protected void showInfo() {
		System.out.println("제 이름은 " + name + " 입니다.");
	}

	// ALT + SHIFT + S, V
	@Override
	public String toString() {
		return "[Person] : " + name;
	}
	
	// final 메소드는 더이상 오버라이딩 불가!
	public final void whoAreYou() {
		System.out.println("이름: " + name);
	}
}