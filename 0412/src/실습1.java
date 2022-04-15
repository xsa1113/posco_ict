
import java.util.*;
public class 실습1 {
	public static void main(String[] args) {
		// Integer.toBinaryString();
		
		// int는 32bit
		// 원본 num을 2진수로 출력
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(); // 1111 1110 ->   1110 1111
								// 0000 1010 ->   0101 0000
		int n  = sc.nextInt(); // 
		int check = 0X80000000; // 
		System.out.println(Integer.toBinaryString(num));
		for(int i=0; i<n; i++) {
			if( (num & check) == 0) {
				num = num << 1;
			}else {
				num = num << 1;
				num = num+1;	
				
				// num = (num << 1) + 1;
			}
		}
		System.out.println(Integer.toBinaryString(num));
	}

}
