package demo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class CopyDemo {
	public static Object copy(Object obj) throws InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		Class clazz = obj.getClass();
		Object copyObj = clazz.newInstance();

		Field[] fields = clazz.getDeclaredFields();
		String fieldName = null;
		Object value = null;
		String methodName = null;
		Method setMethod = null;
		Method getMethod = null;
		for (Field field : fields) {
			fieldName = field.getName();
			methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			getMethod = clazz.getDeclaredMethod(methodName, new Class[] {});
			value = getMethod.invoke(obj, null);
			System.out.println("field: " + fieldName + " vlaue: " + value);

			methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			setMethod = clazz.getDeclaredMethod(methodName, new Class[] { field.getType() });
			setMethod.invoke(copyObj, value);
		}
		return copyObj;
	}

	public static void main(String[] args) {
		StudentBean bean = new StudentBean();
		bean.setAge(22);
		bean.setName("tl");
		bean.setBirth(new Date(System.currentTimeMillis()));
		try {
			StudentBean copy = (StudentBean) CopyDemo.copy(bean);
			System.out.println(copy);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
