package main;

import cls.Myclass;
import cls.Youclass;
import single.SingletonClass;



public class Mainclass {
	public static void main(String[] args) {
		Myclass mycls = new Myclass();
		Youclass youcls = new Youclass();
		
//		youcls.setCount(mycls.getNumber());
		
		mycls.method();
		youcls.func();
		
		System.out.println(youcls.toString());
		
//		System.out.println(SingletonClass.getInstance());		
//		System.out.println(SingletonClass.getInstance());		
//		System.out.println(SingletonClass.getInstance());		

		
	}

}
