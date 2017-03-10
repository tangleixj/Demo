package demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

import demo.reflect.bean.StudentBean;

public class ReflectDemo {
	private static Class clazz;
	static {
		try {
			clazz = Class.forName("demo.reflect.bean.StudentBean");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testRefConstructor() throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		/**
		 * 获取所有public 定义的构造函数
		 */
		Constructor[] constructors = clazz.getConstructors();
		StringBuffer buffer = new StringBuffer("all constructors : ");
		for (Constructor constructor : constructors) {
			buffer.append(constructor).append(" ");
		}
		System.out.println(buffer.toString());

		/**
		 * 获取所有的构造函数，包括私有
		 */
		buffer = new StringBuffer("get all declared constructors : ");
		constructors = clazz.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			buffer.append(constructor).append(" ");
		}
		System.out.println(buffer.toString());

		/**
		 * 通过私有的构造函数来实例化对象
		 */
		Constructor constructor = clazz.getDeclaredConstructor(String.class);// 通过指定构造函数的入参类型来获取构造函数
		constructor.setAccessible(true);// 由于获取的构造函数是私有的，设置可访问。便可以调用私有构造函数
		StudentBean bean = (StudentBean) constructor.newInstance("tl");// 调用私有构造函数，同时传入实参来实例化对象
		System.out.println(bean);

		/**
		 * 获取所实现的接口（直接实现）
		 */
		buffer = new StringBuffer("get implements interfaces: ");
		Type[] types = clazz.getGenericInterfaces();
		for (Type type : types) {
			// buffer.append(type.getTypeName()).append(" ");
			buffer.append(type.toString()).append(" ");
		}
		System.out.println(buffer.toString());

		/**
		 * 获取所继承的父类（直接继承）
		 */
		buffer = new StringBuffer("get extends superclass：　");
		Type type = clazz.getGenericSuperclass();
		buffer.append(type.toString());
		System.out.println(buffer.toString());

		/**
		 * 获取目标类中定义的所有类（即内部类，不包含内部类的内部类）
		 */
		buffer = new StringBuffer("get defined class in targetclass: ");
		Class[] res = clazz.getClasses();
		for (Class s : res) {
			buffer.append(s.toString()).append(" ");
			// buffer.append(s.getName()).append(" ");
		}
		System.out.println(buffer.toString());

		/**
		 * 获取该类实现的接口
		 */
		buffer = new StringBuffer("get all interfaces in targetclass: ");
		res = clazz.getInterfaces();
		for (Class s : res) {
			buffer.append(s.toString()).append(" ");
			// buffer.append(s.getName()).append(" ");
		}
		System.out.println(buffer.toString());
	}

	public static void testField() {
		/**
		 * 获取所有公共属性
		 */
		StringBuffer buffer = new StringBuffer("get all public field : ");
		Field[] fields = clazz.getFields();
		for (Field field : fields) {
			buffer.append(field.toString()).append(" ");
		}
		System.out.println(buffer.toString());

		/**
		 * 获取所有定义的属性，包括私有
		 */
		buffer = new StringBuffer("get all defined field: ");
		fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			buffer.append(field.toString()).append(" ");
		}
		System.out.println(buffer.toString());
		
	}

	public static void main(String[] args) {
		try {
			// testRefConstructor();
			testField();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
