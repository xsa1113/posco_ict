package sample01;

import java.util.Arrays;

public class Human {
	private String name;
	private int age;
	private String hobby[];
	
	public Human() {
	}

	public Human(String name, int age, String[] hobby) {
		this.name = name;
		this.age = age;
		this.hobby = hobby;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + ", hobby=" + Arrays.toString(hobby) + "]";
	}
	
	
	
}
