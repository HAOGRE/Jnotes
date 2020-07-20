package com.haogre.oome;

/**
 * 方法调用中不断的创建线程，导致内存溢出
 * 可以通过减少最大堆和减少栈容量来换取更多的线程
 * VM args:-Xss2M
 * 由于 Windows平台的虚拟机中，java的线程是映射到操作系统的内核线程上的，因此这里代码很疯狂
 * @author Administrator
 *
 */
public class JavaVMStackOOM {
	private void dontStop(){
		while(true){
			
		}
	}
	
	public void stackLeakByThread(){
		while(true){
			Thread thread = new Thread(() -> {
				dontStop();
			});
			thread.start();
		}
	}
	
	public static void main(String[] args) {
		new JavaVMStackOOM().stackLeakByThread();
	}
}
