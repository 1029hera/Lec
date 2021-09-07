package com.lec.java.collection04;

import java.util.ArrayList;
import java.util.List;

public class Collection04Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");

		/// MemberModel 을 담는 List<> 생성
		List<MemberModel> list = new ArrayList<MemberModel>();
		
		MemberModel m1 = new MemberModel("root", "1234"); 
		list.add(m1);
		
		list.add(new MemberModel("admin", "admin1234"));
		list.add(new MemberModel("guest", "1111"));
		
		for(MemberModel e : list) {
			System.out.println(e);
		}
		
		list.remove(1);
		
		System.out.println(list);
		
		list.get(0).setPasswd("9999");
		
		System.out.println(list);
		

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









