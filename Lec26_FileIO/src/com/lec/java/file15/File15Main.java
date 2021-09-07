package com.lec.java.file15;

import java.io.File;

public class File15Main {

	public static void main(String[] args) {
		System.out.println("디렉토리 정보 확인");
		System.out.println();
		// current working directory : 현재작업경로
		String curWorkingDir = System.getProperty("user.dir");
		System.out.println("현재 작업경로: " + curWorkingDir);
		
		System.out.println();
		// 현재 작업 디렉토리의 파일 리스트 출력
		// File 클래스: 파일(txt, doc, ...) 객체 또는 디렉토리(폴더) 객체
		File curDir = new File(curWorkingDir);    // 현재 작업 디렉토리 객체
		//curDir = new File("D:\\DevRoot");
		File [] list = curDir.listFiles();  // listFiles() : 디렉토리 안에 있는 파일과 디렉토리들을 File 배열로 리턴
		
		for (int i = 0; i < list.length; i++) {
			if(list[i].isDirectory()) {  // File객체가 '디렉토리' 이면 true 리턴  <--> isFile()
				System.out.print("DIR" + "\t");
			} else {
				System.out.print("FILE" + "\t");
			}
			System.out.print(list[i].getName() + "\t");   // 파일/디렉토리 이름
			System.out.println(list[i].length());    // 파일의 크기(byte)  디렉토리의 경우 의미 없슴.
		}
		
		System.out.println();
		// 디렉토리의 내용 출력, enhanced for 문 이용
		// TODO
		
		System.out.println();
		// 파일 하나에 대한 정보
		String path = "dummy.txt";
		
		path = "temp\\big_text.txt";
		
		File f = new File(path);   // 새로운 파일 객체 하나 생성
		System.out.println("파일 이름: " + f.getName());   // 상대 경로
		System.out.println("절대 경로: " + f.getAbsolutePath());  // 절대 경로
		System.out.println("있냐? " + f.exists());
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end File15Main
