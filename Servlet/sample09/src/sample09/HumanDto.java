package sample09;

import java.util.Arrays;
import java.util.Date;

public class HumanDto {
	String name;
	String age;
	String eee;
	String[] hobby;
	String date;
	String salary;
	
	public HumanDto() {
		
	}
	
	

	public HumanDto(String name, String age, String eee, String[] hobby, String date, String salary) {
		super();
		this.name = name;
		this.age = age;
		this.eee = eee;
		this.hobby = hobby;
		this.date = date;
		this.salary = salary;
	}



	@Override
	public String toString() {
		return "HumanDto [name=" + name + ", age=" + age + ", eee=" + eee + ", hobby=" + Arrays.toString(hobby)
				+ ", date=" + date + ", salary=" + salary + "]";
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEee() {
		return eee;
	}

	public void setEee(String eee) {
		this.eee = eee;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
}
