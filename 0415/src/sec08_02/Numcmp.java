package sec08_02;

public class Numcmp extends  Tr implements Ti{

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
