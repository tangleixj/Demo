package demo.aop.dynamicproxy;

import java.lang.reflect.Proxy;

public class BusinessImpl implements IBusiness {

	public void doBusiness() {
		// TODO Auto-generated method stub
		System.out.println("doing busness");
	}

	public void doTest() {
		// TODO Auto-generated method stub
		System.out.println("doing test");
	}

	public static void main(String[] args) {
		/**
		 * 通过newProxyInstance来动态生成代理类
		 * 可以看到参数中需要接口的class故动态代理必须实现相应的接口
		 */
		IBusiness business = (IBusiness) Proxy.newProxyInstance(IBusiness.class.getClassLoader(),
				new Class[] { IBusiness.class }, new BusinessProxyHandler());
		business.doBusiness();
		business.doTest();
	}
}
