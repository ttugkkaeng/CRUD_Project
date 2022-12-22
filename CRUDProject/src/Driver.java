// ���α׷� ���ϸ�: Driver.java, �ۼ���: 20221222, ���� �����ð�: 10�� 40��
// ����: java�� DB ���� ����


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Driver {

	
	// ����(�� ����) �Ұ��� 
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
			System.out.println("DB Connection ����!");



		} catch (ClassNotFoundException e) {

			System.out.println("Loading ����");

		} catch (SQLException e) {

			System.out.println("DB ���� ����");

		}

	}



	public static void main(String[] args) {

		Driver dbCon = new Driver();
		dbCon.connectDB();
	}
	
}
