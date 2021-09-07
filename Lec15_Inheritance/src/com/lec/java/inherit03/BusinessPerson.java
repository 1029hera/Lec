package com.lec.java.inherit03;

//Object
//	└ Person
//    	 └  BusinessPerson

public class BusinessPerson extends Person {
	
	String company;
	
	public void shoInfo() {
		whoAmI();
		System.out.println("회사는 " + company + " 입니다.");
	}
}
