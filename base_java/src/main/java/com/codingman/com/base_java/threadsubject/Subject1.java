package com.codingman.com.base_java.threadsubject;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 子线程循环10次，然后主线程循环100次，然后继续反复
 */
public class Subject1 {
	private final static ReentrantLock lock = new ReentrantLock();
	private final static Condition condition = lock.newCondition();

	public static void main(String[] args) throws InterruptedException {
		while(true){
			Thread th = new Thread(new SubjectOne(condition,lock), "子线程");
			th.start();
			xunhuan100();
		}
	}

	public static void xunhuan100() throws InterruptedException {
		lock.lock();
		condition.await();
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + ":   " + i);
		}
		lock.unlock();
	}
}
