package demo.aop.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * 被代理类。通过CGLB来进行AOP编程时无需实现接口
 * 
 * @author tony
 *
 */
public class BusinessService {
	public void doBusiness() {
		System.out.println("doing business");
	}

	public void doTest() {
		System.out.println("doing test");
	}

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(BusinessService.class);
		enhancer.setCallback(new AceBusinessServiceHandler());

		BusinessService service = (BusinessService) enhancer.create();
		service.doBusiness();
		service.doTest();
	}
}
