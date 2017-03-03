package com.codingman.com.base_java.proclu;

import java.util.concurrent.BlockingQueue;

public class Producter implements Runnable {
	private final BlockingQueue<Integer> blockingQueue;
	

	public Producter(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}


	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("Producter:  "+i);
				blockingQueue.put(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
