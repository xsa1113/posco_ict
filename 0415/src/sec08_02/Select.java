package sec08_02;


public class Select extends Tr {
	
	public Select(String s, String t) {
		super(s,t);
		
	}
	
	//check 메소드

	public Ti check() {
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
