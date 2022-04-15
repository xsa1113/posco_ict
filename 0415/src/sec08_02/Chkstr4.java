package sec08_02;

import java.util.Scanner;


// 2번째 예제

public class Chkstr4 {
	public static void main(String[] args) {
		// 안에 메소드는 그대로 
		// 리턴을 객체로 
		//connect
		// 해당되는 객체로 다운캐스팅 후에, instanceof 활용해서 진행, 그 결과값에 맞는 strcmp, numcmp실행
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine(); //-21.5
		String t = sc.nextLine(); //-21.3
			
		
		Tr P;
		Ti Q;
		
		P = new Select(s,t); //up-casting
		
		// q에서 ti로 선언했어도 반환받는 값에서 상속을 tr interface ti로 받고 있기 때문에 ti로 반환하는것도 가능하다 
		// 단 tr로 반환받았을 경우 ti로 캐스팅이 필요 (Ti)
		Q = ((Select)P).check();
		
		System.out.println(Q.cmp());
	}

}

