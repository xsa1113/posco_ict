
import java.util.*;
public class 실습2 {
	public static void main(String[] args) {
		// int는 32bit
		// 원본 num을 2진수로 출력
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(); 
		int n  = sc.nextInt();  
		int check = 1;
	
		System.out.println(Integer.toBinaryString(num));
		for(int i=0; i<n; i++) {
			if(num >= 0) {
				//양수일때 or
				if((num & check) == 0) {
					// 끝 0
					num = num >> 1;
				}else {
					// 끝 1
					num = num >> 1;
					num = num | 0X81111111;
				}
			}else {
				//음수일대
				if((num & check) == 1) {
					num = num >> 1;
					//끝 1
				}else {
					num = num >> 1;
					// 끝 0
					num = num & 0X7FFFFFFF;
				}
			}
		}
		System.out.println(Integer.toBinaryString(num));
		System.out.println("ㅎㅇ");
	}

}
