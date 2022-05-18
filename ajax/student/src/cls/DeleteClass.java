package cls;

import java.util.Scanner;

import dao.StudentDao;

// 학생 삭제
public class DeleteClass {
	
	public DeleteClass() {
		
	}
	
	public void process() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("이름 = ");
		String name = s.next();
		
		StudentDao dao = StudentDao.getInstance();
		
		for(int i=0; i<dao.list.size(); i++) {
			if(dao.list.get(i).getName().equals(name)) {
				dao.list.remove(i);
			}
		}
		
	}

}
