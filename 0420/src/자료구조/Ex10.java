package 자료구조;

import java.util.Scanner;

//추상클래스
public class Ex10 extends Calculator {
	public static void main(String[] args) {
		/*
		 * 3
		 * 4
		 * 10
		 * 20
		 * 30
		 * 
		 * */
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[3];
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Ex10 ex = new Ex10();
		System.out.println(ex.add(a, b));
		System.out.println(ex.subtract(a, b));
		System.out.println(ex.average(arr));
	}

	@Override
	public int add(int a, int b) {
		
		return a + b;
	}

	@Override
	public int subtract(int a, int b) {
		
		return a - b;
	}

	@Override
	public double average(int[] a) {
		int result = 0;
		for(int i=0; i<a.length; i++) {
			result += a[i]; 
		}
		
		return result / a.length;
	}
}

abstract class Calculator{
	public abstract int add(int a, int b);
	public abstract int subtract(int a, int b);
	public abstract double average(int[] a);
}
