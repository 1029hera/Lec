package com.lec.java.file12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 버퍼사용 문자입출력 : BufferedReader, BufferedWriter
 * 
 * java.lang.Object
 *  └─ java.io.Reader
 *      └─ java.io.BufferedReader
 *       
 * java.lang.Object
 *  └─ java.io.Writer
 *      └─ java.io.BufferedWriter
 *      
 * ★ 문자기반 출력시 꼭 끝에 flush() 해주자 ★     
 *             
*/

/*
 * txt 는 utf-8 로 인코딩 , 영문 텍스트
 */
public class File12Main {
	
	private static final String BIG_TEXT = "temp/big_eng.txt"; 
	
	public static void main(String[] args) {
		System.out.println("FileReader / FileWriter");
		
		
		int charRead = 0;   // 읽은 글자
		int charsCopied = 0;  // 복사한 글자 개수
		long startTime, endTime, elapsedTime;  // 시간체크
		
		System.out.println("Reader/Writer 만 사용");
		try(
				FileReader fr = new FileReader(BIG_TEXT);
				//BufferedReader br; 
				FileWriter fw = new FileWriter("temp/big_eng_copy1.txt");
				){
			
			startTime = System.currentTimeMillis();
			while((charRead = fr.read()) != -1) {  // read()  에서 '한글자' 읽어서
				fw.write(charRead);   // write() '한글자' 쓰기
				charsCopied++;
			} // end while		
			endTime = System.currentTimeMillis();
			elapsedTime = endTime - startTime; // 경과시간
			
			System.out.println("읽고 쓴 문자개수: " + charsCopied);
			System.out.println("경과 시간(ms): " + elapsedTime);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("BufferedReader/BufferedWriter + 버퍼 사용");
		try(
				FileReader fr = new FileReader(BIG_TEXT);
				BufferedReader br = new BufferedReader(fr);  // 장착 
				FileWriter fw = new FileWriter("temp/big_eng_copy2.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				){
			
			char [] buf = new char[1024];  // 버퍼 제공
			
			charRead = 0;  // 읽어온 문자 개수
			charsCopied = 0; // 복사한 문자 개수
			
			startTime = System.currentTimeMillis();
			while((charRead = br.read(buf)) != -1) {  // read() : 읽어온 문자들 buf에 담음
				bw.write(buf, 0, charRead);   // write() : buf 의 데이터를 쓰기.
				charsCopied += charRead;
			} // end while		
			endTime = System.currentTimeMillis();
			elapsedTime = endTime - startTime; // 경과시간
			
			System.out.println("읽고 쓴 문자개수: " + charsCopied);
			System.out.println("경과 시간(ms): " + elapsedTime);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n프로그램 종료");		
		
	} // end main()
} // end class

