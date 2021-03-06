package com.codingman.com.base_java.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {
	// 一个任务队列
	protected Queue<Object> concurrentLinkedQueue = new ConcurrentLinkedQueue<Object>();
	// 一个worker的map
	protected Map<String, Thread> wordMap = new HashMap<String, Thread>();
	// worker线程的结果集
	protected Map<String, Object> resultMap = new ConcurrentHashMap<String, Object>();

	public Master(Worker worker, int countWorker) {
		worker.setConcurrentLinkedQueue(concurrentLinkedQueue);
		worker.setResultMap(resultMap);
		 for(int i=0; i<countWorker; i++) {  
			 wordMap.put(Integer.toString(i),   
	                    new Thread(worker, Integer.toString(i)));  
	        } 
	}

	// 检测是否所有worker都已经结束
	public boolean isComplete() {
		for (Map.Entry<String, Thread> entry : wordMap.entrySet()) {
			if (entry.getValue().getState() != Thread.State.TERMINATED)
				// 存在为完成的线程
				return false;
		}
		return true;
	}

	// 把任务扔到队列里
	public void submit(Object job) {
		concurrentLinkedQueue.add(job);
	}

	// 返回worker结果集
	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	// 执行所有Worker进程，进行处理
	public void execute() {
		for (Map.Entry<String, Thread> entry : wordMap.entrySet()) {
			entry.getValue().start();
		}
	}

}
