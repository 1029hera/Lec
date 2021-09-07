package com.lec.java.collection02;

import java.util.ArrayList;
import java.util.Iterator;

public class Collection02Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		// String 타입을 담는 ArrayList를 만들고
		// 5개 이상의 String을 저장하고
		// set(), remove() 등의 메소드 사용하여
		// 임의의 것을 수정, 삭제 도 해보시고
		// 3가지 방식으로 출력해보세요
		//  for, Enhanced-for, Iterator
		
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("Hello");
		list1.add("Sweet");
		list1.add("Happy~");
		list1.add("Good!!");
		list1.add("Nice~!");
		
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		System.out.println();
		
		list1.add(1, "Lucky!");
		
		for(String e : list1) {
			System.out.println(e);
		}
		System.out.println();
		
		list1.set(0, "Hi");
		list1.remove(1);
		
		Iterator<String> itr = list1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}


		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












