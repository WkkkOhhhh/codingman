package com.codingman.com.base_java.staticc.demo3;

public class Cups {
	static Cup c1;
	static Cup c2;

	static {
		c1 = new Cup(1);
		c2 = new Cup(2);
	}

	public Cups() {
		System.out.println("Cups()");
	}
	
}
