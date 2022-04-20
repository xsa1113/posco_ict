package 자료구조;

import java.util.Scanner;

public class Ex4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("5 of int input.");
		int intArray[] = new int[5];
		
		double sum = 0.0;
		for(int i=0; i<intArray.length; i++) {
			intArray[i] = sc.nextInt();
		}
		
		for(int i=0; i<intArray.length; i++) {
			sum += intArray[i];
		}
		
		System.out.println("average" + sum/intArray.length);
		sc.close();
	}

}
