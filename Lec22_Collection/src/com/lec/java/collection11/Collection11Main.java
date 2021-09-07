package com.lec.java.collection11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Collection11Main {

	public static void main(String[] args) {
		System.out.println("HashMap 클래스");
		
		// HashMap 인스턴스 생성
		// Key - Integer 타입
		// Value - String 타입
		HashMap<Integer, String> hmap = 
				new HashMap<Integer, String>();
		
		// 데이터 저장: put() 메소드 사용
		System.out.println("put 결과: " + hmap.put(1, "최유진"));
		System.out.println("put 결과: " + hmap.put(2, "정을영"));
		System.out.println("put 결과: " + hmap.put(3, "김성중"));
		System.out.println("put 결과: " + hmap.put(1, "문혜진"));
		hmap.put(4, "김병진");
		hmap.put(100, "임창호");
		hmap.put(50, "조호철");
		
		
		// 같은 키 값으로 데이터를 put하게 되면, 기존 값이 수정(replace)이 됨.
		
		// 저장된 데이터 개수 확인 : size()
		System.out.println("k-v 쌍 개수: " + hmap.size());
		
		System.out.println();
		
		
		// 데이터 읽기
		// get(key) 사용해서 읽기
		System.out.println(hmap.get(1)); // key : 1의 value
		System.out.println(hmap.get(5)); // 없는 key 값 => null
		
		// 데이터 삭제
		// remove(key) : 삭제된 value 리턴
		System.out.println("삭제: " + hmap.remove(2));

		
		// 방법1 HashMap에서 Iterator 사용
		// 1. HashMap의 keySet() 메소드를 사용해서
		// 저장된 키(key)값들로만 이루어진 Set을 만듬.
		// 2. 1에서 만들어진 Set에 있는 iterator() 메소드를 사용해서
		// Iterator를 생성

		Set<Integer> ketSet = hmap.keySet();
		Iterator<Integer> itr = ketSet.iterator();
		while(itr.hasNext()) {
			int key = itr.next();
			
			System.out.println(key + ":" + hmap.get(key));
		}
		
		
		System.out.println();
		
		// 방법2 : Map.Entry 사용
		// entrySet() 은 Set<Entry<Integer, String>> 리턴함

		for(Map.Entry<Integer, String> m : hmap.entrySet()) {
			System.out.println(m.getKey() + " : " + m.getValue());
		}
		
		
		System.out.println();
		
		// 도전과제
		// arr[] = {2, 4, 5, 4, 3, 3, 4}
		// 주어진 배열이 위와 같을때 다음과 같이 발생회수 나타내기 
		// 2 : 1개 
		// 3 : 2개 
		// 4 : 3개 
		// 5 : 1개
		
		System.out.println("HashMap 응용: 배열에서 발생빈도 구하기");
		int arr[] = {2, 4, 5, 4, 3, 3, 4};
		printFreq(arr);
		
		System.out.println("\n프로그램 종료");
	} // end main()

	static void printFreq(int [] arr) {
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			Integer v = hmap.get(arr[i]);
			
			if(v == null) { // 기존에 해당 key 값이 없었다면. (즉, 첫 등장이면)
				hmap.put(arr[i], 1); // 첫등장 1
			} else {
				hmap.put(arr[i], v + 1); // 기존 등장횟수 +1 증가
			}
		}
		
		// 결과출력
		for(Map.Entry<Integer, Integer> e : hmap.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue() + "개");
		}
	}
	
} // end class















