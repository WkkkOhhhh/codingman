package com.codingman.com.base_java.extend.demo8;

public class ChildStaticMethod extends ParentStaticMethod{
	static {
		System.out.println("child static");
	}

	public ChildStaticMethod() {
		System.out.println("child con");
	}

	public static void say() {
		System.out.println("child static method");
	}
	

}
