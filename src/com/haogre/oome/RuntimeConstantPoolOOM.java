package com.haogre.oome;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池导致的oom
 * 
 * VM args： -XX:PermSize=10M -XX:MaxPermSize=10M
 * 
 * 这里1.6的代码会出现异常 但是高版本的就不会出现异常，这里就是itern方法的实现变了
 * 
 * @author Administrator
 *
 */
public class RuntimeConstantPoolOOM {
	public static void main(String[] args) {

		String str1 = new StringBuilder("计算机").append("软件").toString();
		//常量池中没有 计算机软件，所以是新的常量，就放进去了
		System.out.println(str1.intern() == str1);
		//常量池中 有java 所以 str2就是常量池中的copy
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
		
		System.out.println(new String("开心").intern() == new String("开心").intern() );
		System.out.println(new String("开心") == new String("开心") );

		List<String> list = new ArrayList<>();
		int i = 0;
		while (true) {
			list.add(String.valueOf(i++).intern());
		}
	}
}
