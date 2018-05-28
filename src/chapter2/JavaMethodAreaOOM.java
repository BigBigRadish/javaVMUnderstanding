package chapter2;

import java.lang.reflect.Method;

/**
 * 运用CGLib直接操作字节码生成大量动态类，使得方法区溢出
 * VM Args： -XX:PermSize=10M -XX:MaxPermSize=10M//最大也设置为10，防止方法区动态拓展
 * @author Agnostic
 */
public class JavaMethodAreaOOM {

	public static void main(String[] args) {
		while (true) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {
				public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
					return proxy.invokeSuper(obj, args);
				}
			});
			enhancer.create();
		}
	}

	static class OOMObject {

	}
}

