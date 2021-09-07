package com.lec.java.file09;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

// Object Filter Stream + Collection

// Program <=== ObjectInputStream <=== FileInputStream <=== File
// Program ===> ObjectOutputStream ===> FileOutputStream ===> File

// ArrayList<> 와 같은 Collection 에서,
// 모든 데이터들이 Serializable 되어 있으면 ObjectInputStream / ObjectOutputStream 으로
// read/write 가능.

public class File09Main {
	
	public static final String FILEPATH  = "temp/member2.dat";

	public static void main(String[] args) {
		System.out.println("Object Filter Stream");

		try (
				OutputStream out = new FileOutputStream(FILEPATH);
				ObjectOutputStream oout = new ObjectOutputStream(out);
				
				InputStream in = new FileInputStream(FILEPATH);
				ObjectInputStream oin = new ObjectInputStream(in);
				) {
			
			Member m1 = new Member("root", "root1234");
			oout.writeObject(m1); // 파일에 Object 저장
			
			Member m2 = new Member("guest", "guest");
			oout.writeObject(m2);
			
			Member m3 = new Member("admin", "admin123456");
			oout.writeObject(m3);
			
			// List<>
			List<Member> list = new ArrayList<>();
			
			list.add(m1);
			list.add(m2);
			list.add(m3);
			
			oout.writeObject(list); // List<> 객체 한개 저장
			
			// 읽어오기
			list = null; // 제대로 읽어오는지 확인차.
			
			list = (List<Member>)oin.readObject();
			for(Member m : list) {
				m.displayInfo();
			}
			
			
				
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) { // IOException 자손
			System.out.println("파일을 끝까지 읽었습니다.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class File08Main
















