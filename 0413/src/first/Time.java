package first;

import java.util.Scanner;

public class Time{
	private int day;
	private int hour;
	private int min;
	private int sec;
	
	//생성자 3개인자
	public Time(int hour, int min, int sec) {
		
		this.hour = hour;
		this.min = min;
		this.sec = sec;
	}
	
	public Time(int day, int hour, int min, int sec) {
		this.day = day;
		this.hour = hour;
		this.min = min;
		this.sec = sec;
	}
	
	//add함수
	public Time add(Time second_time) {
		
		int t = second_time.hour * 3600 + second_time.min * 60 +second_time.sec 
				+this.hour * 3600 + this.min * 60 + this.sec;
		
		int n_hour = t/3600;
		int tmp = t%3600; // 초
		int n_min = tmp/60; // 분
		int n_sec = tmp%60;
		int n_day = 0;
		
		if(n_hour > 24) {
			n_day = n_day + 1;
			
			n_hour = n_hour - 24;
		}
		
		return new Time(n_day, n_hour, n_min, n_sec);
	}
	
	//sub함수
	public Time sub(Time second_time) {
		int t =  this.hour * 3600 +  this.min * 60 +this.sec
				-  second_time.hour * 3600 - second_time.min * 60 - second_time.sec;
		
		int n_hour = t/3600;
		int tmp = t%3600; // 초
		int n_min = tmp/60; // 분
		int n_sec = tmp%60;
		int n_day = 0;
		
		if(n_hour < 0) {
			n_day = n_day - 1;
			
		}
		
		if(t < 0) {
			n_hour = n_hour * -1;
			n_min = n_min * -1;
			n_sec = n_sec * -1;
		}
		
		return new Time(n_day, n_hour, n_min, n_sec);
	}
	
	//compare 함수 앞이 크면 1 같으면 0  작으면 -1 리턴
	public int compare(Time second_time) {
		int tmp = this.hour * 3600 + this.min * 60 + this.sec ;
		int tmp2 = second_time.hour * 3600 + second_time.min * 60 + second_time.sec;
		
		if(tmp > tmp2) {
			return 1;
		}else if(tmp < tmp2) {
			return -1;
		}else {
			return 0;
		}
		
	}
	//print 함수
	public void print() {
		String n_day = "";
		
		if(this.day == -1) {
			n_day = "before";
		}else if(this.day == 1) {
			n_day = "after";
		}else {
			n_day = "now";
		}
		
		System.out.println(this.day +n_day + "_ " + this.hour + "hour " + this.min + "min " + this.sec + "sec" );
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Time first_time = new Time(10,10,10);
		int hour = sc.nextInt();
		int min = sc.nextInt();
		int sec = sc.nextInt();
		Time second_time = new Time(hour, min, sec);
		
		Time add_time = first_time.add(second_time); // add메소드 호출
		Time sub_time = first_time.sub(second_time); // sub메소드 호출
		
		System.out.println("two time of sum ");
		add_time.print();
		
		System.out.println("two time of sub ");
		sub_time.print();
		
		int result = first_time.compare(second_time);
		System.out.print("compare : ");
		System.out.println(result);
		
	}

	
}
