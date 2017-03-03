package com.codingman.com.base_java.concurrent;

public class TestReentrant {
	public synchronized void doSomething() {
		System.out.println("doSomething method parent");
	}
}
