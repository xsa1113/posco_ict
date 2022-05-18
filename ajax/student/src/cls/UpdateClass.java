package cls;

import java.util.Scanner;

import dao.StudentDao;

//학생 수정 , 이름으로 검색해서 , 영어와 수학점수 수정
public class UpdateClass {
	
	public UpdateClass() {
		
	}
	
	public void process() {
		Scanner s = new Scanner(System.in);
		
		System.out.print("이름 = ");
		String name = s.next();
		System.out.print("영어수정 = ");
		int tmp = s.nextInt();
		System.out.print("수학수정 = ");
		int tmp2 = s.nextInt();
		
		StudentDao dao = StudentDao.getInstance();
		
		for(int i=0; i<dao.list.size(); i++) {
			if(dao.list.get(i).getName().equals(name)) {
				dao.list.get(i).setEnglish(tmp);
				dao.list.get(i).setMath(tmp2);

			}
			
		}
	}

}
