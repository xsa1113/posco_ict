package sec08_03;

import java.util.Scanner;

//1안
//select class -> numcmp class, strcmpclass, check 메소드

public class Chkstr5 {
	public static void main(String[] args) {
		// 안에 메소드는 그대로 
		// 리턴을 객체로 
		//connect
		// 해당되는 객체로 다운캐스팅 후에, instanceof 활용해서 진행, 그 결과값에 맞는 strcmp, numcmp실행
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine(); //-21.5
		String t = sc.nextLine(); //-21.3

		
		Select P = new Select(s,t);
		Object Q ;
		Q= P.check();
		
		if(Q instanceof Select.Numcmp) {
			System.out.print(((Select.Numcmp)Q).cmp());
		}else {
			System.out.print(((Select.Strcmp)Q).cmp());
		}
		
	}
}

class Select extends Tr{
	
	public Select(String s, String t) {
		super(s,t);
		
	}
	
	class Numcmp  {

		//cmp메소드
		public int cmp() {
			
			int result = 0;
			double a= Double.parseDouble(s);
			double b= Double.parseDouble(t);
			System.out.println(a + " " + b);
			if(a>b) 
				result = 1;
			else if (a<b)
				result = -1;
			else
				result = 0;
			
			return result ;
		}
		
	}
	
	class Strcmp {	
		//cmp메소드
		
		public int cmp(){
			return s.compareTo(t); 
		}
	}
	//check 메소드
	
	// 최상위 객체인 object를 활용해서도 가능
	public Object check() {
		int s_len = s.length();
		int t_len = t.length();
		// 길이대로 체크를 먼저 맨처음 
		// -가 나올경우 
		// 숫자가 나올경우
		// 문자가 나올경우
		
		for(int i=0; i<s_len; i++) {
			if(s.charAt(i) != '-' && s.charAt(i) !='.'&& !Character.isDigit(s.charAt(i))) {
				return new Strcmp();
			}
		}
		
		for(int i=0; i<t_len; i++) {
			if(t.charAt(i) != '-' && t.charAt(i) !='.'&& !Character.isDigit(t.charAt(i))) {
				return new Strcmp();
			}
		}
		
		return new Numcmp();
	}
	
}

class Tr{
	// 두 문자열과 두 문자열 상태의 정보를 가지는 부모 클래스dd
	String s;
	String t;
	public Tr(String s, String t) {
		this.s = s;
		this.t = t;
	}
}



// 처음 구조 
// strcmp 객체 생성후에 cmp 메소드 실행 
// numcmp 객체 생성후에 cmp 메소드 실행



