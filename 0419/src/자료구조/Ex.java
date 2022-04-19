package 자료구조;

import java.util.Scanner;

public class Ex {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("price input : "); //56450
		//40000
		int a  = sc.nextInt();
		int tmp;
		
		int b = a / 50000; // 50000원 몇장
		System.out.println("50000won " + b);
		tmp = a%50000;
		int c = tmp / 10000;
		tmp = tmp%10000;
		System.out.println("10000won " + c);
		int d = tmp / 5000;
		tmp = tmp%5000;
		System.out.println("5000won " + d);
		int e = tmp / 1000;
		tmp = tmp%1000;
		System.out.println("1000won " + e);
		int f = tmp / 500;
		tmp = tmp %500;
		System.out.println("500won " + f);
		int g = tmp / 100;
		tmp = tmp % 100;
		System.out.println("100won " + g);
		int h = tmp / 50;
		tmp = tmp % 50;
		System.out.println("50won " + h);
		
	}

}
