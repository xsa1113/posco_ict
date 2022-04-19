package 자료구조;

import java.util.Scanner;

public class Ex3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("game. input : ");
		System.out.print("A >> ");
		String a = sc.next();
		System.out.print("B >> ");
		String b = sc.next();
		// 가위1 바위2 보3
		if(a.equals("가위")) {
			if(b.equals("바위")) {
				System.out.println("A lose");
			}else if(b.equals("가위")) {
				System.out.println("A draw");
			}else {
				System.out.println("A win");
			}
			
		}else if(a.equals("바위")) {
			if(b.equals("바위")) {
				System.out.println("A draw");
			}else if(b.equals("가위")) {
				System.out.println("A win");
			}else {
				System.out.println("A lose");
			}
			
		}else if(a.equals("보")) {
			if(b.equals("바위")) {
				System.out.println("A win");
			}else if(b.equals("가위")) {
				System.out.println("A lose");
			}else {
				System.out.println("A draw");
				
			}
		}
	}

}
