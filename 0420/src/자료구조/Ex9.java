package 자료구조;

//클래스 상속
public class Ex9 {
	public static void main(String[] args) {
		Point p = new Point();
		p.set(1, 2);
		p.showPoint();
		
		ColorPoint cp = new ColorPoint();
		cp.set(3, 4);
		cp.setColor("red");
		cp.showColorPoint();
	}

}

class Point{
	private int x, y;
	void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	void showPoint() {
		System.out.println("(" + x + "," + y + ")");
	}
}

class ColorPoint extends Point{
	private String color;
	void setColor(String color) {
		this.color = color;
	}
	
	void showColorPoint() {
		System.out.print(color);
		showPoint();
	}
}
