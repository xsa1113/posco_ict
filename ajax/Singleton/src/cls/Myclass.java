package cls;

import single.SingletonClass;

public class Myclass {
	private int number;
	
	public Myclass() {
		number = 123;
	}
	
	public void method() {
		SingletonClass sc = SingletonClass.getInstance();
		sc.num = number;
	}

//	public int getNumber() {
//		return number;
//	}
	
	
}
