package com.lec.java.file11;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
문자(character) 단위 입출력 스트림 클래스
 java.io.Reader: 프로그램이 '문자 단위' 데이터를 읽어들이는(read) 통로
  └─ java.io.InputStreamReader
      └─ java.io.FileReader

 java.io.Writer: 프로그램이 '문자 단위' 데이터를 쓰는(write) 통로
  └─ java.io.OutputStreamWriter
      └─ java.io.FileWriter

 FileReader / FileWriter 객체는 '텍스트파일, 즉 문자 단위' 데이터를 읽고/쓰기 할때
 사용하는 기반 스트립 입니다.   따라서 텍스트가 아닌 오디오, 비디오, 등의 파일을 다룰수 없습니다.
 주로 String 이나 char [] 내용을 입/출력 할때 사용합니다.

 텍스트 파일 (Text File) 이란
   사람이 읽을수 있는 글자들이 저장된 파일
   암호화 되지 않은 평범한 텍스트

 이진파일 (Binary File) 이란
   사람이 직접 읽을수는 없슴.

   ★ 문자기반 출력시 꼭 끝에 flush() 해주자 ★
*/


public class File11Main {
	public static void main(String[] args) {
		System.out.println("FileReader / FileWriter");
		
		String src = "temp/FileData.txt";	// src : source
		String dst = src;					// dst : destination
		
		FileWriter fw = null;
		FileReader fr = null;
		
		try {
			fw = new FileWriter(dst);
			fr = new FileReader(src);
			
			String str = "안녕하세요"; // 한글 5글자
			char [] charArr = {'J', 'A', 'V', 'A'}; // 영무 4글자
			// 저장은 시스템 인코딩 상태에 따라 저장됨
			// UTF-9 인코딩의 경우
			// 한글 1글자 --> 3byte
			// 영문 1글자 --> 1byte
			
			fw.write(str);
			fw.write(charArr);
			fw.flush(); // 쓰기 작업이 다 끝나면 flush() 호출로 풀력버퍼의 데이터 완전히 출력하기
			
			// 읽기
			char [] buff = new char[100]; // char[] 배열 버퍼 준비
			int charsRead = 0; // 읽어들인 '문자'의 개수
			
			charsRead = fr.read(buff); // 긴 텍스트의 경우 while(true)로 돌려주어야 함.
			
			for(int i = 0; i < charsRead; i++) {
				System.out.println(buff[i]);
			}
			
			System.out.println();
			System.out.println("읽은 문자 개수: " + charsRead);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw != null) fw.close();
				if(fr != null) fr.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("\n프로그램 종료");
		
	} // end main()
} // end class
