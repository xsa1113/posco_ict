package cls;

import java.util.Scanner;

import dao.StudentDao;
import dto.StudentDto;

//학생 추가
public class InsertClass {
	
	public InsertClass() {
		
	}
	
	public void process() {
		Scanner s = new Scanner(System.in);
		
		System.out.print("번호 = " );
		int number = s.nextInt();
		
		System.out.print("이름 = ");
		String name = s.next();
		
		System.out.print("영어 =");
		int english = s.nextInt();
		
		System.out.print("수학 = ");
		int math = s.nextInt();
		
		StudentDto dto = new StudentDto(number, name, english, math);
		
		StudentDao dao = StudentDao.getInstance();
		dao.list.add(dto);
		
		for(int i=0; i<dao.list.size(); i++) {
			
				
				System.out.print("번호 :" + dao.list.get(i).getNumber() + " ");
				System.out.print("이름 :" + dao.list.get(i).getName() + " ");
				System.out.print("영어 :" + dao.list.get(i).getEnglish() + " ");
				System.out.print("수학 :" + dao.list.get(i).getMath() + " ");

		
		
		}
		
	}

}
