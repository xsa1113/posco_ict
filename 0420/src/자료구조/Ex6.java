package 자료구조;

public class Ex6 {
	int radius;
	String name;
	
	public double getArea() {
		return 3.14*radius*radius;
	}
	public static void main(String[] args) {
		Ex6 pizza;
		pizza = new Ex6();
		pizza.radius = 10;
		pizza.name = "javapizza";
		double area = pizza.getArea();
		System.out.println(pizza.name + " of area " + area);
		
		Ex6 donut = new Ex6();
		donut.radius = 2;
		donut.name = "javadonut";
		area = donut.getArea();
		System.out.println(donut.name + " of area " + area);
	}

}
