package dto;

public class MemberDto {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private int tall;
	private String birth;
	private int age;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTall() {
		return tall;
	}
	public void setTall(int tall) {
		this.tall = tall;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public MemberDto() {
		
	}
	
	public MemberDto(String id, String pwd) {
		this.id = id;
		this.pwd =pwd;
		
	}
	
	public MemberDto(String id, String pwd, String name, String email, int tall, String birth, int age) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.tall = tall;
		this.birth = birth;
		this.age = age;
	}
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", tall=" + tall
				+ ", birth=" + birth + ", age=" + age + "]";
	}
	
	
	
	
	
	

}
