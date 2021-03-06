package com.codingman.com.base_java.proclu;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private final BlockingQueue<Integer> blockingQueue;

	public Consumer(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Integer i = blockingQueue.take();
				System.out.println("Consumer:  " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
