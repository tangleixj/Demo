package demo.reflect.bean;

import java.io.Serializable;
import java.util.Arrays;

public class StudentBean extends Object implements Serializable {
	private static final long serialVersionUID = 1707661032756868282L;
	private String name;
	private int age;
	private String[] address;
	public String demo;

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

	public String[] getAddress() {
		return address;
	}

	public void setAddress(String[] address) {
		this.address = address;
	}

	public StudentBean(String name, int age, String[] address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public StudentBean() {
		super();
	}

	private StudentBean(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "StudentBean [name=" + name + ", age=" + age + ", address=" + Arrays.toString(address) + "]";
	}

	public class demo {
		class child {

		}
	}

	public interface test {
		public void es();
	}
}
