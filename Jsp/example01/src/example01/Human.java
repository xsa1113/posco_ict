package example01;

import java.util.Arrays;

public class Human {
	String id;
	String pwd;
	String[] hobby;
	String age;
	String talk;
	
	public Human() {
		
	}
	public Human(String id, String pwd, String[] hobby, String age, String talk) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.hobby = hobby;
		this.age = age;
		this.talk = talk;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getTalk() {
		return talk;
	}
	public void setTalk(String talk) {
		this.talk = talk;
	}
	@Override
	public String toString() {
		return "Human [id=" + id + ", pwd=" + pwd + ", hobby=" + Arrays.toString(hobby) + ", age=" + age + ", talk="
				+ talk + "]";
	}
	
	
	

}
