package com.codingman.com.base_java.staticc.demo2;

public class ChildPojo extends ParentPojo {
	static {
		System.out.println("static输出输出--子类");
	}

	{
		System.out.println("非static输出输出--子类");
	}

	public ChildPojo() {
		System.out.println("构造器输出输出--子类");
	}

	public static void sayHi1() {
		System.out.println("静态输出输出--子类");
	}

}
