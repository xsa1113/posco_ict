package 자료구조;

public class 실습2 {
	public static void main(String[] args) {
		double score[][] = { {3.3, 3.4,0.0}, {3.5,3.6,0.0}, {3.7,4.0,0.0}, {4.1,4.2,0.0}, {0.0,0.0,0.0}};
		
		double sum = 0; 
		// 5X3
		 double grade_average ;
		 double grade_result ;
		 double sem1_average ;
		 double sem2_average ;
		 double total = 0;
		 System.out.println("        1sem    2sem   average");
		
		for(int year=0; year<score.length; year++ ) {
			 grade_average = 0;
			 grade_result = 0;
			 
			for(int term=0; term<score[year].length; term++) {
				grade_average += score[year][term];
			}
			grade_result = grade_average / 2; // 2학기
			score[year][2] = grade_result;
		}
		sem1_average = 0;
		sem2_average = 0;
		for(int term = 0; term<2; term++) {
			
				for(int year= 0; year<4; year++) {
					if(term == 0) {
						//1학기
						sem1_average += score[year][term];
					}else if(term ==1) {
						//2학기
						sem2_average += score[year][term];
					}
			}
				if(term == 0) {
					sem1_average = sem1_average / 4;
					score[4][0] = sem1_average;
				}
				sem2_average = sem2_average / 4;
				score[4][1] = sem2_average;
		}
		
		for(int i=0; i<score.length - 1; i++) {
			System.out.print(i + 1 + "grade   ");
			total += score[i][2];
			for(int j=0; j<score[0].length; j++) {
				System.out.print(score[i][j] + "   ");
				if(i == 3 & j != 2) {
					total += score[4][j];
				}
			}
			System.out.println();
		}
		
		System.out.print("average" + "  " + score[4][0] + "  " + score[4][1] + "   " + total/6);
		
	}

}
