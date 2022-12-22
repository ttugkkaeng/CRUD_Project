// 프로그램 파일명: App.java, 작성일: 20221221, 최종 마감시간: 10시 40분
// 설명: insert, update, delete, All Select 실행 부분


import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {

		Dao dao = new Dao();
		
		// C: insert
		Dto insertDto = new Dto();
		boolean insertCheck = dao.insert(insertDto);
		
		if(insertCheck) {
			System.out.println("insert 성공");
		}else {
			System.out.println("insert 실패");
		}
		
		
		// U: update
		Dto updateDto = new Dto();
		boolean updateCheck = dao.update(updateDto);
		
		if(updateCheck) {
			System.out.println("업데이트 성공");
		}else {
			System.out.println("업데이트 실패");
		}
		
		
		// D: delete
		Dto deleteDto = new Dto();
		
		// 삭제하고자 하는 값을 Dao에 전달
		deleteDto.setLib_index("1402");
		
		boolean deleteCheck = dao.delete(deleteDto);
		
		if(deleteCheck) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
			
		
		// R: All Select
		Dto selectDto = new Dto();
		
		

	}
	
}
