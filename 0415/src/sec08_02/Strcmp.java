package sec08_02;

public class Strcmp extends Tr implements Ti{

	public Strcmp(String s, String t) {
		super(s,t);
		
	}
	//cmp메소드
	
	public int cmp(){
		return s.compareTo(t); 
	}
}
