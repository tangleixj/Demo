package demo.aop.javassist;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.Loader;
import javassist.NotFoundException;

public class StartBoot {
	public static void main(String[] args) {
//		ClassPool pool = new ClassPool();
		ClassPool pool = ClassPool.getDefault();
		Loader loader = new Loader();
		try {
			loader.addTranslator(pool, new MyTranslator());//将自定义的字节码转换器绑定到类加载器上
			loader.run("demo.aop.javassist.MyTranslator", args);//调用自定义转换器中的main方法
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotCompileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
