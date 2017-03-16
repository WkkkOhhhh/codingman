package com.codingman.com.base_java.threadsubject;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SubjectOne implements Runnable{
	private final Condition con;
	private final ReentrantLock lock;


	public SubjectOne(Condition con, ReentrantLock lock) {
		this.con = con;
		this.lock = lock;
	}


	@Override
	public void run() {
		lock.lock();
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + ":   " + i);
		}
		con.signal();
		lock.unlock();
	}
}
