package demo.aop.javassist;

import demo.aop.cglib.BusinessService;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.Translator;

/**
 * 自定义的字节码转换器
 * @author tony
 *
 */
public class MyTranslator implements Translator {

	public void onLoad(ClassPool pool, String classname) throws NotFoundException, CannotCompileException {
		if (!"demo.aop.cglib.BusinessService".equals(classname)) {//通过类名来确立需要转换的类
			return;
		}
		CtClass cc = pool.get(classname);
		CtMethod method = cc.getDeclaredMethod("doTest");//获取需要处理的方法
		method.insertBefore("{ System.out.println(\"do test before\"); }");//注入advance
	}

	public void start(ClassPool pool) throws NotFoundException, CannotCompileException {
	}

	public static void main(String[] args) {
		BusinessService service = new BusinessService();
		service.doBusiness();
		service.doTest();
	}
}
