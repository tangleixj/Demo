package demo.aop.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 基于CGLB形成的切面
 * 
 * @author tony
 *
 */
public class AceBusinessServiceHandler implements MethodInterceptor {

	public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		/**
		 * 通过方法名来确定要切入的位置
		 */
		if ("doBusiness".equals(method.getName())) {
			System.out.println("do business before");//切入逻辑
		}
		/**
		 * 由于CGLB是通过生成被代理类的子类来实现AOP的。故执行原逻辑是通过调用父类方法来实现的。
		 */
		Object result = proxy.invokeSuper(target, args);//执行原有的逻辑
		if ("doTest".equals(method.getName())) {
			System.out.println("do test after");
		}
		return result;
	}

}
