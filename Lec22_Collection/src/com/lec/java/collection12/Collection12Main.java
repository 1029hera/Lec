package com.lec.java.collection12;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

// Hash: 검색을 빠르게 하기 위한 용도
// Tree: 데이터 정렬을 하기 위한 용도

public class Collection12Main {

	public static void main(String[] args) {
		System.out.println("TreeMap 클래스");
		
		// TreeMap<Integer, String> 타입 인스턴스 생성
		TreeMap<Integer, String> tmap = new TreeMap<>();
		
		// 데이터 저장: put(key, value) 메소드 사용
		tmap.put(1, "강태민");
		tmap.put(4, "박수지");
		tmap.put(2, "이삭");
		tmap.put(3, "안수빈");
		tmap.put(5, "이삭");
		
		
		// values() : value 들로 이루어진 Collection 리턴
		System.out.println("values()");
		System.out.println(tmap.values());
		
		// 데이터 검색: get(key) 메소드를 사용
		// 1. 키값들로만 이루어진 Set을 만듬
		Set<Integer> kset = tmap.keySet();
		
		// 2. keySet을 가지고 iterator를 만듬
		Iterator<Integer> itr = kset.iterator();
		while(itr.hasNext()) {
			int key = itr.next();
			System.out.println(key + ":" + tmap.get(key));
		}

		System.out.println();
		
		
		// TreeMap에만 있는 KeySet을 만들어 내는 메소드
		// TODO
		
		
		// HashMap --> TreeMap 전환하기
		System.out.println("HashMap() -> TreeMap() ");
		// TODO
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
} // end class


















