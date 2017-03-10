package demo.aop.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理的切面
 * 
 * @author tony
 *
 */
public class BusinessProxyHandler implements InvocationHandler {
	private BusinessImpl target = new BusinessImpl();// 被代理对象

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		/**
		 * 通过对method的名称判断来确定要注入的位置 如果是则注入相关代码
		 */
		if ("doTest".equals(method.getName())) {
			System.out.println("do prepare work before test");
		}
		Object result = method.invoke(target, args);
		if ("doTest".equals(method.getName())) {
			System.out.println("do rest work after test");
		}
		return result;
	}

}
