package main;

import java.util.Scanner;

import cls.DeleteClass;
import cls.InsertClass;
import cls.SelectClass;
import cls.UpdateClass;

public class MainClass {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// initialize
		
		// loop
		
		// release
		
		//menu 추가(insert), 삭제(delete), 검색(select), 수정(update)
		
		while(true) {
			System.out.println(">>>>>>>>>> menu");
			System.out.println("1. 학생추가");
			System.out.println("2. 학생삭제");
			System.out.println("3. 학생검색");
			System.out.println("4. 학생수정");
			System.out.println("5. 종료");

			System.out.println("작업번호 >>>");
			int number = s.nextInt();
			
			switch(number) {
			case 1 :
				InsertClass ic = new InsertClass();
				//메소드 호출
				ic.process();
				break;
			case 2 : 
				DeleteClass dc = new DeleteClass();
				dc.process();
				break;
			case 3 : 
				SelectClass sc = new SelectClass();
				sc.process();
				break;
			case 4 : 
				UpdateClass uc = new UpdateClass();
				uc.process();
				break;
			case 5 : 
				System.exit(0);
				break;
			case 6 :
				
				
			}

		}
	}

}
