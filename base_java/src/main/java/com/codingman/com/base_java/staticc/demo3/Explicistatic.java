package com.codingman.com.base_java.staticc.demo3;

public class Explicistatic {
	static Cups x=new Cups();
	static Cups y=new Cups();
	public static void main(String[] args) {
		System.out.println("Inside main()");
		Cups.c1.f(99);
	}
}
