package com.lec.java.db03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.lec.java.db.Query;

// 공통적으로 사용하는 상수들 인터페이스에 담아서 처리.
public class DB03Main implements Query{
	
	public static final String DRIVER =
			"oracle.jdbc.driver.OracleDriver";
	// DB 서버 정보
	public static final String URL =
			"jdbc:oracle:thin:@localhost:1521:XE";
	// DB 사용자 계정 정보
	public static final String USER = "scott26";
	public static final String PASSWD = "tiger26";

	public static final String TBL_NAME = "test_member";
	public static final String COL_LABEL_NO = "mb_no";
	public static final String COL_LABEL_NAME = "mb_name";
	public static final String COL_LABEL_BIRTHDATE = "mb_birthdate";

	public static void main(String[] args) {
		System.out.println("DB 3 - PreparedStatement");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			Class.forName(DRIVER);
			System.out.println("드라이버 클래스 로딩 성공");
			
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB Connection 성공");
			
			System.out.println();
			System.out.println("INSERT");
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setInt(1, 10);  // 첫번째는 1부터 시작
			pstmt.setString(2, "헐크");
			pstmt.setString(3, "2000-10-10");
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행(row) INSERT 성공");
			
			System.out.println();
			System.out.println("SELECT");
			pstmt.close();
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString(COL_LABEL_NO);
				String name = rs.getString(COL_LABEL_NAME);
				String birthdate = rs.getString(COL_LABEL_BIRTHDATE);
				System.out.println(no + "\t|" + name + "\t|" + birthdate);			
			} // end while
			
			
			String sql_pay = "SELECT deptno, avg(nvl(pay, 0)) avgpay\r\n"
					+ "FROM t_professor\r\n"
					+ "GROUP BY deptno\r\n"
					+ "HAVING avg(nvl(pay, 0)) > ?";
			
			pstmt.close();
			pstmt = conn.prepareStatement(sql_pay);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("평균급여를 입력하세요: ");
			int pay = sc.nextInt();
			
			pstmt.setInt(1, pay);
			
			rs.close();
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(
						rs.getInt("deptno") + " | " + rs.getDouble("avgpay")
						);
			}
			
			
			
			sc.close();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	} // end main()

} // end class DB03Main

