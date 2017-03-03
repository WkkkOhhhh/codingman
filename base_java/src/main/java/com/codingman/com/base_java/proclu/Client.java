package com.codingman.com.base_java.proclu;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Client {
	public static void main(String[] args) {
		BlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue(1);
		Producter p=new Producter(blockingQueue);
		Consumer c=new Consumer(blockingQueue);
		Thread t1=new Thread(p);
		t1.start();
		Thread t2=new Thread(c);
		t2.start();
	}
}
