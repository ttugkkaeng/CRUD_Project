// ���α׷� ���ϸ�: Dao.java, �ۼ���: 20221221, ���� �����ð�: 10�� 40��
// ����: sql�� ���� ����

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {

	
	
	// Insert 
	public boolean insert(Dto dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;	
		
		try {

			// DB ����
			Driver driver = new Driver();


			
			// Insert - sql ��
			String sql = "INSERT INTO lib"
					+ " (lib_name, lib_code, ad_name, address, phone, url) VALUES(?,?,?, ?,?,?)";
			
			pstmt = conn.prepareStatement(sql);

			// ? �� �Է�
            pstmt.setString(1, "markany");
            pstmt.setString(2, "1234");
            pstmt.setString(3, "�����");
            pstmt.setString(4, "���빮���繮ȭ��");
            pstmt.setString(5, "010-1111-2222");
            pstmt.setString(5, "http://markany.com");

            // sql�� ���� Ƚ��
            res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
	
		// sql�� ���� ����
		if (res > 0) {
			return true;

		// sql�� ���� ����
		} else {
			return false;
		}
	}
	
	
	// R: select All ��� ����Ʈ ���
	public void getList(){

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			// DB ����
			Driver driver = new Driver();

			
			// All select - sql ��
			String sql = "SELECT * FROM lib";

			// �� �޾ƿ���
			rs = pstmt.executeQuery();
			
			
			// ��ü �� �� ���� ����
            while (rs.next()) {

                String lib_index = rs.getString("lib_index");
                String lib_name = rs.getString("lib_name");
                String lib_code = rs.getString("lib_code");
                String ad_name = rs.getString("ad_name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String url = rs.getString("url");
                String lib_time = rs.getString("lib_time");
                String holiday = rs.getString("holiday");
                String devision = rs.getString("devision");
                String dev_name = rs.getString("dev_name");
                String lat = rs.getString("lat");
                String longitude = rs.getString("longitude");
                
                
                // �� ���� �������� ��� ���
                System.out.println(lib_index + " " + lib_name + " " + lib_code + " " + ad_name + " " + address + " " + phone
                		+ " " + url + " " + lib_time + " " + holiday + " " + devision + " " + dev_name + " " + lat + " " + longitude);
            }
            
            
        // Try-Catch: ���� ó��    
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
	
	
	
	// Update
	public boolean update(Dto dto) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			
			// DB ����
			Driver driver = new Driver();
			
			// Update - sql ��
			String sql = "update lib set lib_name=?, lib_code=? where ad_name=?";

			// ? �� ����
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getLib_name());
			pstmt.setString(2, dto.getLib_code());
			pstmt.setString(3, dto.getAd_name());

			// sql �� ���ư� Ƚ��
			res = pstmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		
		// sql �� ���� ����
		if (res > 0) {
			return true;

		// sql �� ���� ����
		} else {
			return false;
		}
	}
	
	// Delete 
	public boolean delete(Dto dto) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		
		try {
			
			// DB ����
			Driver driver = new Driver();

			
			// Delete - sql ��
			String sql = "DELETE FROM lib WHERE lib_index=?";

			pstmt = conn.prepareStatement(sql);
			
			// ���� �ϰ��� �ϴ� �ε��� �� ����: Dto���� ���� ���� ��(setLib_index())�� �����´� 
			pstmt.setString(1, dto.getLib_index());

			// sql�� ���� Ƚ��
			res = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		
		// sql �� ���� ����
		if (res > 0) {
			return true;
		// sql �� ���� ����
		} else {
			return false;
		}
	}
	
	
}
