import java.util.Scanner;

public class 실습2_가변길이_인수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String a = sc.next();
		String b = sc.next();
		String result = "";
		result = midstr(s,a,b);
		System.out.println(result);
	}

	private static String midstr(String ... strs) {
		//a 번째
		String tmp = "";
		String s = strs[0];
		String a = strs[1];
		String b = strs[2];
		
		char tmp2[] = new char[s.length()];
		if(Integer.parseInt(a) > s.length()) {
			System.out.println("length over");
			System.exit(1);
		}else if(Integer.parseInt(a) + Integer.parseInt(b) > s.length()) {
			System.out.println("length over");
			System.exit(1);
		}
		for(int i=0; i<tmp2.length; i++) {
			tmp2[i] = s.charAt(i);
		}
		
		for(int i=0; i<Integer.parseInt(b); i++ ) {
			tmp += tmp2[Integer.parseInt(a)-1 + i];
		}
		return tmp;
	}
}



