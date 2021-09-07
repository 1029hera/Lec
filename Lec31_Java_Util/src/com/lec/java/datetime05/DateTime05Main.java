package com.lec.java.datetime05;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * java.sql.Timestamp;
 * 1970.01.01 00:00:00  GMT 기준 의 경과 시간을 ms 로 계산해 담은 객체
 */
public class DateTime05Main {

	public static void main(String[] args) {
		System.out.println("java.sql.Timestamp");
		Timestamp t;
		
		t = new Timestamp(0L);
		System.out.println(t);
		
		// 현재시간 ms
		System.out.println("현재시간(ms) : " + System.currentTimeMillis());
		t = new Timestamp(System.currentTimeMillis());
		System.out.println(t);
		
		
		
		//----------------------------------------------
		// 문자열 -> Timestamp
		// 	방법1 : 정해진 형식 + Timesatmp.valutOf()
		System.out.println("String -> Timestamp");
		// TODO
		
		
		// 	방법2 : String -> Date -> Timestamp 
		String now = "2021-02-01 16:30:43";
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			t = new Timestamp(dateFormat.parse(now).getTime());
			System.out.println(t);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//----------------------------------------------
		// Timestamp -> 문자열
		// SimpleDateFormat + Timestamp:getTime()
		System.out.println(
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(t.getTime())
				);
		
	}

}
