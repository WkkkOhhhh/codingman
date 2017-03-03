package com.codingman.com.base_java.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {
	// 一个任务队列
	protected Queue<Object> concurrentLinkedQueue;
	// worker线程的结果集
	protected Map<String, Object> resultMap;

	public Object handle(Object obj) {
		return obj;
	}

	public void setConcurrentLinkedQueue(Queue<Object> concurrentLinkedQueue) {
		this.concurrentLinkedQueue = concurrentLinkedQueue;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	@Override
	public void run() {
		while (true) {
			// 获取子任务
			Object input = concurrentLinkedQueue.poll();
			if (input == null)
				break;
			// 处理子任务
			Object re = handle(input);
			// 将处理结果写入结果集
			resultMap.put(Integer.toString(input.hashCode()), re);
		}
	}

}
