// 프로그램 파일명: Driver.java, 작성일: 20221222, 최종 마감시간: 10시 40분
// 설명: java와 DB 연동 파일


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Driver {

	
	// 수정(값 변경) 불가능 
	private static final String DB_DRIVER_CLASS = "org.mariadb.jdbc.Driver";
	private static final String DB_URL = "jdbc:mariadb://localhost:3306/db01";
	private static final String DB_USER = "root";
	private static final String DB_PWD = "1234";


	private static Connection conn;
	PreparedStatement pstmt = null;



	private static void connectDB() {

		try {

			Class.forName(DB_DRIVER_CLASS);
			
			// url, userID, PWD
			Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
			System.out.println("DB Connection 성공!");



		} catch (ClassNotFoundException e) {

			System.out.println("Loading 실패");

		} catch (SQLException e) {

			System.out.println("DB 연결 실패");

		}

	}



	public static void main(String[] args) {

		Driver dbCon = new Driver();
		dbCon.connectDB();
	}
	
}
