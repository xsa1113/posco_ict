import java.util.Scanner;

public class Chkstr {
	// 두 문자열 
	// 숫자면 -> 실수형으로
	// 문자면 -> 문자로
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String t = sc.nextLine();
		double a,b;
		int result;
		
		Ts p = new Ts(s,t);
		int cond = p.check();
		
		if(cond == Ts.str) {
			result = s.compareTo(t);
		}else {
			a= Double.parseDouble(s);
			b= Double.parseDouble(t);
			System.out.println(a + " " + b);
			if(a>b) 
				result = 1;
			else if (a<b)
				result = -1;
			else
				result = 0;
		}
		System.out.println(result);
	}
}

class Ts{
	static final int num = 0;
	static final int str = 1;
	private String s ;
	private String t ;
	
	public Ts(String s, String t) {
		this.s = s;
		this.t = t;
	}

	public int check() {
		int s_len = s.length();
		int t_len = t.length();
		// 길이대로 체크를 먼저 맨처음 
		// -가 나올경우 
		// 숫자가 나올경우
		// 문자가 나올경우
		int flag = 0;
		int flag2 = 0;

		// flag필요없음

		loop : for(int i=0; i<s_len; i++) {
			flag = 0; // 0일때 숫자, 1일때 문자
			if(s.charAt(i) == '-') {
				flag = num;
			}else if(s.charAt(i) == '.') {
				flag = num;
			}else {
				// 아니면 숫자인지 문자인지 판단 ,숫자이면 true,아니면 false
				if(Character.isDigit(s.charAt(i))){
					flag = num;
				}else {
					flag = str;
					break loop;
				}
			}
		}
		
		// 두번 검사할 필요없음
		if(flag != str) {
			loop : for(int i=0; i<t_len; i++) {
				flag2 = 0; // 0일때 숫자, 1일때 문자
				if(t.charAt(i) == '-') {
					flag2 = num;
				}else if(s.charAt(i) == '.') {
					flag2 = num;
				}else {
					// 아니면 숫자인지 문자인지 판단 ,숫자이면 true,아니면 false
					if(Character.isDigit(t.charAt(i))){
						flag2 = num;
					}else {
						flag2 = str;
						break loop;
					}
				}
			}
			
		}
		
		if(flag == 0 && flag2 == 0) {
			return num;
		}else {
			return str;
		}
		
	}
}
