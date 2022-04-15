import java.util.Scanner;

public class 실습1_문자열 {
	public static void main(String[] args) {
		
		System.out.println("string");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		char c = sc.next().charAt(0);
//		String result = revsqueeze(s,c);
		String result = revsqueeze(s.toCharArray(),c);
		System.out.println(result);
		
	}
	// 본문 string s 기본 문자열, c 비교 문자열
	private static String revsqueeze(String s, char c) {
		// TODO Auto-generated method stub
		String tmp = new String();
		String result = new String();
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) != c) {
				tmp += s.charAt(i);
			}
			
		}
		// 굳이 필요없는 라인 20번에서 검사해주고 반대로 넣기만하면 끝
		for(int i=tmp.length()-1; i>=0; i--) {
			result =  result + tmp.charAt(i); 
		}
		
		return result;
	}
	
	private static String revsqueeze(char[] a, char c) {
		String tmp = "";

		for(char x : a) {
			if(x != c) {
				tmp += x;
			}
			//if 문 변환
			// tmp += x == c? "" : idx; 
		}
		StringBuffer sb = new StringBuffer(tmp);
		
		return sb.reverse().toString();
	}

}
