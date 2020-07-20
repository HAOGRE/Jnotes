package me.czd.jvm.jvm_learn.memoryerror;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * 本机直接内存溢出，jvm中还有一部分直接内存，DirectByteBuffer
 * 
 * VM args: -Xmx20M -XX:MaxDirectMemorySize=10M
 * 
 * Unsafe       java中rt.jar中的类，必须通过反射才能调用
 * 
 * @author Administrator
 *
 */
public class DirectMemoryOOM {
	private static final long _1MB = 1024 * 1024;

	public static void main(String[] args) throws Exception {

		Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe) unsafeField.get(null);
		while (true) {
			System.out.println("分配1MB");
			unsafe.allocateMemory(_1MB);
		}

	}
}
