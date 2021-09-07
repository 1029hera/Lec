package com.lec.java.db01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
JDBC (Java DataBase Connectivity) 사용
 0. 라이브러리(jar) 추가:
  1) 이클립스 프로젝트 폴더에 libs 폴더를 생성
  2) C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6_g.jar
 파일을 libs 폴더로 복사
  3) 복사한 라이브러리를 빌드패스에 추가   
		BulidPath - Configure Build Path..
		Libraries 탭에서  [Add JARs..]   ->  위 libs 폴더의 ojdbc6_g.jar 파일 추가
		Order and Export 탭에서  우선순위 Up (권장)

 1. Oracle 연동을 위한 정보들(상수들)을 정의(세팅)
 2. JDBC 드라이버 클래스를 메모리에 로드
 3. DB와 connection(연결)을 맺음
 4. Statement 인스턴스를 생성 (SQL을 사용하기 위한 인스턴스)
 5. SQL 문장 작성(SELECT, INSERT, UPDATE, DELETE)
 6. SQL 문장을 DB 서버로 전송
 7. 실행 결과 확인
*/

// er-diagram 만들기
// http://ermaster.sourceforge.net/update-site


public class DB01Main {

//		 1. Oracle 연동을 위한 정보들(상수들)을 정의(세팅)
	// JDBC 드라이버 클래스 정보
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	// DB 서버 접속
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	// DB 사용자 계정 정보
	public static final String USER = "scott26";
	public static final String PASSWD = "tiger26";
	
	
	public static void main(String[] args) {
		System.out.println("DB 1 : JDBC 프로그래밍");
		
		Connection conn = null;
		Statement stmt = null;  // java.sql.Statement
		ResultSet rs = null;  // SELECT 쿼리 결과
		
		try {
			// 2. JDBC 드라이버 클래스를 메모리에 로드
			Class.forName(DRIVER);  // <-- 동적 클래스 로딩.
			System.out.println("드라이버 클래스 로딩 성공");
			
//		 3. DB와 connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB connect 성공");
			
//		 4. Statement 인스턴스를 생성 (SQL을 사용하기 위한 인스턴스)
			stmt = conn.createStatement();
			System.out.println("Statement 생성 성공");
			
//		 5. SQL 문장 작성(SELECT, INSERT, UPDATE, DELETE)
			System.out.println();
			String sql_insert = "INSERT INTO test_member VALUES(100, '마징가', SYSDATE)";
//					"INSERT INTO t_emp3 VALUES(\r\n"
//					+ "	1, '오라클', '1234561234567', 4, 1000\r\n"
//					+ ")";
					
			System.out.println(sql_insert);

//		 6. SQL 문장을 DB 서버로 전송
			int cnt = stmt.executeUpdate(sql_insert); // 'DML' 의 경우 executeUpdate() 로 쿼리실행
													// 리턴값 정수 (int)
			System.out.println(cnt + "개 row(행)이 INSERT됨");
			
			System.out.println();
			String sql_select = "SELECT * FROM test_member";
			System.out.println(sql_select);
			
			rs = stmt.executeQuery(sql_select);  // 'SELECT 및 기타쿼리' 는 executeQuery() 로 실행
											// 리턴값 ResultSet  객체
//		 7. 실행 결과 확인
			
			System.out.println();
			// 7-1 컬럼이름으로 받기
//			while(rs.next()) {  // next() 레코드 하나 추출하고 true 리턴, 추출할 레코드가 없으면 false 리턴.
//				String no = rs.getString("mb_no");  // getXXXX()  에 '컬럼명 혹은 별명' 명시
//				String name = rs.getString("mb_name");
//				String birthdate = rs.getString("mb_birthdate");
//				System.out.println(no + "\t|" + name + "\t|" + birthdate);
//			} // end while
			// 위에서 컬럼이름 오류시 java.sql.SQLException: 부적합한 열 이름   
			
			// 7-2 컬럼 인덱스로 받기
//			while(rs.next()) {
//				String no = rs.getString(1);  // getXXXX() 에 컬럼인덱스 명시 (1부터 시작!)
//				String name = rs.getString(2);
//				String birthdate = rs.getString(3);
//				System.out.println(no + "\t|" + name + "\t|" + birthdate);
//			}
			
			// 7-3 null 처리 하기
			// SQL 데이터가 null  값이면 getXXX() 는 null  을 리턴한다.
//			while(rs.next()) {
//				String no = rs.getString("mb_no");
//				if(no == null) no = "";
//				String name = rs.getString("mb_name");
//				if(name == null) name = "";
//				String birthdate = rs.getString("mb_birthdate");
//				if(birthdate == null) birthdate = "";
//				System.out.println(no + "\t|" + name + "\t|" + birthdate);
//			} // end while		
			
			// 7-4 개별 타입으로 getXXX() 하기
			while(rs.next()) {
				int no = rs.getInt("mb_no");  // getInt() , 만약  SQL null 이면 0 리턴
				String name = rs.getString("mb_name");
				if(name == null) name = "";
				
				Timestamp timestamp = null; 
				LocalDateTime localDateTime = null;
				
				timestamp = rs.getTimestamp("mb_birthdate");
				String birthdate = "";
				if(timestamp != null) {
					localDateTime = timestamp.toLocalDateTime();
					birthdate = localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
				}
				
				// 만약 '최신' JDBC 드라이버라면 아래 코드로도 작동한다.  Timestamp 를 안거치고도 가능
				// 안타깝게도 ojdbc6 로는 불가.
				//localDateTime = rs.getObject("mb_birthdate", LocalDateTime.class);
				
				System.out.println(no + "\t|" + name + "\t|" + birthdate);
				
			}
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 8. 자원 반납
				// 나중에 만들어진 인스턴스들을 먼저 close 한다.
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		

		System.out.println("프로그램 종료");
	} // end main()

} // end class DB01Main













