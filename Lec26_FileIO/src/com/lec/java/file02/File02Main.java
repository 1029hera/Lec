package com.lec.java.file02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* FileIO
 Program <=== InputStream <=== Source
 Program ===> OutputStream ===> Source
 
 Program <=== FileInputStream <=== File
 Program ===> FileOutputStream ===> File

 java.io.InputStream
  |__ java.io.FileInputStream: 파일로부터 데이터를 읽어오는 통로
 java.io.OutputStream
  |__ java.io.FileOutputStream: 파일로 데이터를 쓰는 통로
*/

public class File02Main {

	public static void main(String[] args) {
		System.out.println("File IO");

		
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream("temp/big_text.txt");
			
			// 해당 파일이 없으면 새로 생성.
			//    ..    있엇으면 지우고 새로 생성.
			
			out = new FileOutputStream("temp/copy_big_text.txt");
			
			
			// 파일 복사
			//  InputStream 에서 한 byte 씩 읽어 들어와서
			//  OutputStream 에 한 byte 씩 쓰기
			
			int dataRead;
			int bytesCopied = 0;
			
			long startTime = System.currentTimeMillis(); // 현재 시간 저장(ms)
			
			while(true) {
				// 데이터 읽기: InputStream에 있는 read() 메소드 사용
				// read()는 InputStream 으로부터 
				// 1byte 씩 읽어서 int(4byte) 에 담아 리턴한다
				// [ ... ][ ... ][ ... ][ 1byte ]				
				dataRead = in.read();
				if(dataRead == -1) {  // 더 이상 읽을 것이 없으면 read() 는 -1 을 리턴한다.
					break;
				}
				
				out.write(dataRead);
				bytesCopied++;
				
			} // end while
			
			long endTime = System.currentTimeMillis(); // 끝난 시간 저장
			long elapsedTime = endTime - startTime; // 경과시간
			
			System.out.println("읽고 쓴 바이트: " + bytesCopied);
			System.out.println("경과 시간(ms): " + elapsedTime);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 리소스 해제
			try {
				if(out != null) out.close();
				if(in != null) in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class

