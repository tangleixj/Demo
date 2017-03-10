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
		Enhancer enhancer = new Enhancer();//创建一个织入器
		enhancer.setSuperclass(BusinessService.class);//注入父类
		enhancer.setCallback(new AceBusinessServiceHandler());//注入切面

		BusinessService service = (BusinessService) enhancer.create();//生成注入切面后代理对象
		service.doBusiness();
		service.doTest();
	}
}
