package com.codingman.com.base_java.staticc.demo2;

public class ParentPojo {
	static {
		System.out.println("static输出输出--父类");
	}

	{
		System.out.println("非static输出输出--父类");
	}

	public ParentPojo() {
		System.out.println("构造器输出输出--父类");
	}

	public static void sayHi() {
		System.out.println("静态输出输出--父类");
	}
}
