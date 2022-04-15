package sec08;
// 자바 추상 메소드에 대한 이해
// abstract는 기본적으로 publis static이 기본
// 추상 클래스를 만들고 추상메소드를 만들어서 안에서 구현하는게 아니라 외부에서 메소드 구현

import java.util.Scanner;

public class Chkstr2 {
	public static void main(String[] args) {
		// 안에 메소드는 그대로 
		// 리턴을 객체로 
		//connect
		// 해당되는 객체로 다운캐스팅 후에, instanceof 활용해서 진행, 그 결과값에 맞는 strcmp, numcmp실행
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine(); //-21.5
		String t = sc.nextLine(); //-21.3
		Select P;
		Tr Q;
		
		P = new Select(s,t); //up-casting
		Q = P.check();
		
		System.out.println(Q.cmp());
	}

}

abstract class Tr{
	// 두 문자열과 두 문자열 상태의 정보를 가지는 부모 클래스dd
	String s;
	String t;
	public Tr(String s, String t) {
		this.s = s;
		this.t = t;
	}
	public abstract int cmp();
	
}

class Strcmp extends Tr {
	
	public Strcmp(String s, String t) {
		super(s,t);
		
	}
	//cmp메소드
	
	public int cmp(){
		return s.compareTo(t); 
	}
	
}

class Numcmp extends Tr{
	
	public Numcmp(String s, String t) {
		super(s,t);
	}
	
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

// 두 문자열의 상태를 체크 해당 cmp 메소드 실행 
class Select{
	String s;
	String t;
	public Select(String s, String t) {
		this.s = s;
		this.t = t;
		
	}
	
	//check 메소드

	public Tr check() {
		int s_len = s.length();
		int t_len = t.length();
		// 길이대로 체크를 먼저 맨처음 
		// -가 나올경우 
		// 숫자가 나올경우
		// 문자가 나올경우
		
		for(int i=0; i<s_len; i++) {
			if(s.charAt(i) != '-' && s.charAt(i) !='.'&& !Character.isDigit(s.charAt(i))) {
				return new Strcmp(s,t);
			}
		}
		
		for(int i=0; i<t_len; i++) {
			if(t.charAt(i) != '-' && t.charAt(i) !='.'&& !Character.isDigit(t.charAt(i))) {
				return new Strcmp(s,t);
			}
		}
		
		return new Numcmp(s,t);
	}
}
