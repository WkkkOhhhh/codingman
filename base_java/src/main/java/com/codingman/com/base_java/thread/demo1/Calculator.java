package com.codingman.com.base_java.thread.demo1;

import java.util.concurrent.locks.ReentrantLock;

public class Calculator implements Runnable {
	private int number;

	public Calculator(int number) {
		this.number = number;
	}
	private final static ReentrantLock lock=new ReentrantLock();
	@Override
	public void run() {
		lock.lock();
		for (int i = 0; i < 10; i++) {
			 System.out.printf("%s: %d * %d = %d\n",Thread. currentThread().getName(),number,i,i*number);
		}
		lock.unlock();
	}

}
