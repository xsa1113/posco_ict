package cls;

import single.SingletonClass;

public class Youclass {
	
	private int count;
	
	public Youclass() {
		
	}
	
	public void func() {
		SingletonClass sc = SingletonClass.getInstance();
		count = sc.num;
	}
	
//	public void setCount(int count) {
//		this.count = count;
//	}

	@Override
	public String toString() {
		return "Youclass [count=" + count + "]";
	}

	
}
