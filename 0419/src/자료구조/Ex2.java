package 자료구조;

import java.util.Scanner;

public class Ex2 {
	// switch case 문
	public static void main(String[] args) {
		String grade = "";
		Scanner sc = new Scanner(System.in);
		System.out.print("score input(0~100): " );
		int score = sc.nextInt();
		score = score / 10;
		switch(score) {
		case 10 : grade = "A"; break;
		case 9 : grade = "B"; break;
		case 8 : grade = "C"; break;
		case 7 : grade = "D"; break;
		case 6 : grade = "E"; break;
		default : grade = "F"; break;
		}
		System.out.print("grade : " + grade);
	}

}
