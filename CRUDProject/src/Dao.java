// 프로그램 파일명: Dao.java, 작성일: 20221221, 최종 마감시간: 10시 40분
// 설명: sql문 실행 파일

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

			// DB 연결
			Driver driver = new Driver();


			
			// Insert - sql 문
			String sql = "INSERT INTO lib"
					+ " (lib_name, lib_code, ad_name, address, phone, url) VALUES(?,?,?, ?,?,?)";
			
			pstmt = conn.prepareStatement(sql);

			// ? 값 입력
            pstmt.setString(1, "markany");
            pstmt.setString(2, "1234");
            pstmt.setString(3, "서울시");
            pstmt.setString(4, "동대문역사문화역");
            pstmt.setString(5, "010-1111-2222");
            pstmt.setString(5, "http://markany.com");

            // sql문 실행 횟수
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
	
		// sql문 실행 성공
		if (res > 0) {
			return true;

		// sql문 실행 실패
		} else {
			return false;
		}
	}
	
	
	// R: select All 모든 리스트 출력
	public void getList(){

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			// DB 연결
			Driver driver = new Driver();

			
			// All select - sql 문
			String sql = "SELECT * FROM lib";

			// 값 받아오기
			rs = pstmt.executeQuery();
			
			
			// 전체 행 값 가져 오기
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
                
                
                // 각 행의 정보값들 모두 출력
                System.out.println(lib_index + " " + lib_name + " " + lib_code + " " + ad_name + " " + address + " " + phone
                		+ " " + url + " " + lib_time + " " + holiday + " " + devision + " " + dev_name + " " + lat + " " + longitude);
            }
            
            
        // Try-Catch: 오류 처리    
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
			
			// DB 연결
			Driver driver = new Driver();
			
			// Update - sql 문
			String sql = "update lib set lib_name=?, lib_code=? where ad_name=?";

			// ? 값 설정
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getLib_name());
			pstmt.setString(2, dto.getLib_code());
			pstmt.setString(3, dto.getAd_name());

			// sql 문 돌아간 횟수
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
		
		// sql 문 실행 성공
		if (res > 0) {
			return true;

		// sql 문 실행 실패
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
			
			// DB 연결
			Driver driver = new Driver();

			
			// Delete - sql 문
			String sql = "DELETE FROM lib WHERE lib_index=?";

			pstmt = conn.prepareStatement(sql);
			
			// 제거 하고자 하는 인덱스 값 셋팅: Dto에서 전달 받은 값(setLib_index())을 가져온다 
			pstmt.setString(1, dto.getLib_index());

			// sql문 실행 횟수
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
		
		// sql 문 실행 성공
		if (res > 0) {
			return true;
		// sql 문 실행 실패
		} else {
			return false;
		}
	}
	
	
}
