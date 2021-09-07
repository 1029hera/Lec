package com.lec.java.file04;
/* 보조스트림 (filter stream)
Program <=== FilterInputStream <=== InputStream <=== Source
					↓ 상속					↓ 상속
Program <=== BufferedInputStream <=== FileInputStream <=== File

Program ===> FilterOutputStream ===> OutputStream ===> Source
					↓ 상속					↓ 상속
Program ===> BufferedOutputStream ===> FileOutputStream ===> File

java.io.InputStream
 |__ java.io.FilterInputStream
      |__ java.io.BufferedInputStream

java.io.OutputStream
 |__ java.io.FilterOutputStream
      |__ java.io.BufferedOutputStream

참고 ) 보조스트림 (filter stream)
보조스트림(filter stream) 이란 다른 스트림과 연결되어 여러가지 편리한 기능을 제공해주는 스트림
*/

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class File04Main {

	public static void main(String[] args) {
		System.out.println("BufferedInputStream, BufferedOutputStream");

		InputStream in = null;
		BufferedInputStream bin = null;
		OutputStream out = null;
		BufferedOutputStream bout = null;
		
		try {
			in = new FileInputStream("temp/big_text.txt");
			bin = new BufferedInputStream(in); // 장착
			
			out = new FileOutputStream("temp/copy_big_text.txt");
			bout = new BufferedOutputStream(out); // 장착

			int dataRead;
			int bytesCopied = 0;
			
			long startTime = System.currentTimeMillis(); // 현재 시간 저장(ms)
			
			while(true) {				
				dataRead = bin.read();
				if(dataRead == -1) {  // 더 이상 읽을 것이 없으면 read() 는 -1 을 리턴한다.
					break;
				}
				
				bout.write(dataRead);
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
				if(bout != null) bout.close(); // bout을 close하면 bout이 장착된 out도 자동으로 close
				if(bin != null) bin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class














