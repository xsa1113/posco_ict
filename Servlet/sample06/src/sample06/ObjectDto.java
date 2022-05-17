package sample06;

import java.util.Arrays;

//Data Transfer Object == DTO -> 하나의 데이터를 저장할 수 있는 클래스, 데이터 저장 단위
//Value Object == VO ->
public class ObjectDto {
	private String name;
	private int age;
	private String fruits[];
	
	public ObjectDto() {
		
	}
	public ObjectDto(String name, int age, String[] fruits) {
		super();
		this.name = name;
		this.age = age;
		this.fruits = fruits;
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
	public String[] getFruits() {
		return fruits;
	}
	public void setFruits(String[] fruits) {
		this.fruits = fruits;
	}
	@Override
	public String toString() {
		return "ObjectDto [name=" + name + ", age=" + age + ", fruits=" + Arrays.toString(fruits) + "]";
	}
	
	
	

}
