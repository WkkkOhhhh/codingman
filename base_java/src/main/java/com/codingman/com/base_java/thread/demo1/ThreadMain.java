package com.codingman.com.base_java.thread.demo1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.Thread.State;

public class ThreadMain {
	public static void main(String[] args) {
		PrintWriter pw = null;
		try {
			Thread[] threads = new Thread[10];
			Thread.State[] status = new Thread.State[10];
			for (int i = 0; i < 10; i++) {
				threads[i] = new Thread(new Calculator(i));
				if (i % 2 == 0) {
					threads[i].setPriority(Thread.MAX_PRIORITY);
				} else {
					threads[i].setPriority(Thread.MIN_PRIORITY);
				}
				threads[i].setName("Thread:" + i);
			}
			File file = new File("thread.txt");
			pw = new PrintWriter(file);
			for (int i = 0; i < 10; i++) {
				pw.println("Main:Status of Thread " + i + " : " + threads[i].getState());
			}
			for (int i = 0; i < 10; i++) {
				threads[i].start();
			}
			boolean finish = false;
			while (!finish) {
				for (int i = 0; i < 10; i++) {
					if (threads[i].getState() != status[i]) {
						writeThreadInfo(pw, threads[i], status[i]);
						status[i] = threads[i].getState();
					}
				}
				finish = true;
				for (int i = 0; i < 10; i++) {
					finish = finish && (threads[i].getState() == State.TERMINATED);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (pw != null)
				pw.close();
		}
	}

	private static void writeThreadInfo(PrintWriter pw, Thread thread, State state) {
		pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
		pw.printf("Main : Priority: %d\n", thread.getPriority());
		pw.printf("Main : Old State: %s\n", state);
		pw.printf("Main : New State: %s\n", thread.getState());
		pw.printf("Main : ************************************\n");
	}
}
