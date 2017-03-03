package com.codingman.com.base_java.concurrent;

public class TestReentrantImpl extends TestReentrant{

	public synchronized void doSomething() {
		System.out.println("doSomething method child");
		super.doSomething();
	}
public static void main(String[] args) {
	TestReentrantImpl is=new TestReentrantImpl();
	is.doSomething();
}
}
