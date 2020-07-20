package com.haogre.oome;

import java.util.ArrayList;
import java.util.List;

/**
 * 如果堆中的对象数量达到最大堆容量限制后就会产生OutOfMemoryError
 * 这里演示的是java内存区------- 堆内存溢出异常
 * 
 * VM args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 
 * -XX:+HeapDumpOnOutOfMemoryError 开启快照，如果溢出 Dump出当前存储快照以便事后分析 可使用 Eclipse
 * Memory Analyzer 来打开堆转储快照文件
 * 
 * 逃逸分析，
 * -XX:+DoEscapeAnalysis -XX:+PrintEscapeAnalysis
 * 
 * @author Administrator
 *
 */
public class HeapOOM {
	static class OOMObject {

	}

	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<>();
		while (true) {
			list.add(new OOMObject());
		}
	}

}
