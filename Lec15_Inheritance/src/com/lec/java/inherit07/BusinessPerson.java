package com.lec.java.inherit07;

// Object
//   └ Person
//        └  BusinessPerson

public class BusinessPerson extends Person {
	
private String company;
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	// 메소드 오버라이딩
	@Override
	//void showInfo() { // 에러 접근권한범위가 더 좁아질수는 없다.
	//protected void showInfo() {  // OK 동일한 접근권한
	public void showInfo() {  //  OK 더 넓은 접근 권한
		super.showInfo();
		System.out.println("회사: " + company);
	}

	// 메소드 오버로딩
	public void showInfo(int id) {
		System.out.println("id: " + id);
		this.showInfo();
	}

	// final 메소드는 오버라이딩 불가
//	public void whoAreYou() {
//		
//	}

}
