package cls;


import java.util.Scanner;
import dao.StudentDao;


//학생 검색, 이름 검색
public class SelectClass {
	
	public SelectClass() {
		
	}
	
	public void process() {
		Scanner s = new Scanner(System.in);
		
		System.out.print("이름 = ");
		String name = s.next();

		StudentDao dao = StudentDao.getInstance();
		
		for(int i=0; i<dao.list.size(); i++) {
			if(dao.list.get(i).getName().equals(name)) {
					
				System.out.print("번호 :" + dao.list.get(i).getNumber() + " ");
				System.out.print("이름 :" + dao.list.get(i).getName() + " ");
				System.out.print("영어 :" + dao.list.get(i).getEnglish() + " ");
				System.out.print("수학 :" + dao.list.get(i).getMath() + " ");
				System.out.println();

			}
			
		}
	}

}
