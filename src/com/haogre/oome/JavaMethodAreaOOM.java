package com.haogre.oome;

/**
 * 借助于CGLib 是方法去出现内存溢出异常
 * 使用CGLib 来动态的创建对象！！！去填充方法区
 * 
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * 1.8
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 * 
 * @author Administrator
 *
 */
public class JavaMethodAreaOOM {
	static class OOMObject{
		
	}
//	public static void main(String[] args) {
//		while (true) {
//			System.out.println("/////////////");
//			Enhancer enhancer = new Enhancer();
//			enhancer.setSuperclass(OOMObject.class);
//			enhancer.setUseCache(false);
//			// new MethodInterceptor()
//			//动态代理6
//			enhancer.setCallback(new MethodInterceptor() {
//				@Override
//				public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//					return proxy.invokeSuper(obj, args);
//				}
//			});
//			enhancer.create();
//		}
//	}
}
