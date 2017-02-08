package com.codingman.com.base_java.extend.demo4;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class StaticIncr extends Thread{
	//static int i=1;
	AtomicInteger ai=new AtomicInteger(1);
	private final static ReentrantLock rl=new ReentrantLock();
	public void incr(){
		rl.lock();
		System.out.println(ai.incrementAndGet());
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		rl.unlock();
	}
	@Override
	public void run() {
		incr();
	}

}
