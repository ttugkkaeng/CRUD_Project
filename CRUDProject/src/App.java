// ���α׷� ���ϸ�: App.java, �ۼ���: 20221221, ���� �����ð�: 10�� 40��
// ����: insert, update, delete, All Select ���� �κ�


import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {

		Dao dao = new Dao();
		
		// C: insert
		Dto insertDto = new Dto();
		boolean insertCheck = dao.insert(insertDto);
		
		if(insertCheck) {
			System.out.println("insert ����");
		}else {
			System.out.println("insert ����");
		}
		
		
		// U: update
		Dto updateDto = new Dto();
		boolean updateCheck = dao.update(updateDto);
		
		if(updateCheck) {
			System.out.println("������Ʈ ����");
		}else {
			System.out.println("������Ʈ ����");
		}
		
		
		// D: delete
		Dto deleteDto = new Dto();
		
		// �����ϰ��� �ϴ� ���� Dao�� ����
		deleteDto.setLib_index("1402");
		
		boolean deleteCheck = dao.delete(deleteDto);
		
		if(deleteCheck) {
			System.out.println("���� ����");
		}else {
			System.out.println("���� ����");
		}
			
		
		// R: All Select
		Dto selectDto = new Dto();
		
		

	}
	
}
