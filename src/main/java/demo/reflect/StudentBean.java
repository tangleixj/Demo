package demo.reflect;

import java.util.Date;

public class StudentBean {
	private String name;
	private int age;
	private Date birth;

	public StudentBean(String name, int age, Date birth) {
		super();
		this.name = name;
		this.age = age;
		this.birth = birth;
	}

	public StudentBean() {
		super();
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

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "StudentBean [name=" + name + ", age=" + age + ", birth=" + birth + "]";
	}
	

}
