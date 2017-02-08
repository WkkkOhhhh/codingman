package com.codingman.com.base_java.staticc.demo1;
/**
 * 调用static方法时，会初始化staticPojo这个类，所以static静态代码块会被初始化，输出。
 * 但是构造方法不会输出，为什么？
 * 因为没有实例化阿！
 * 
 * */
public class StaticPojo {
	static{
		System.out.println("static输出输出");
	}
	public StaticPojo() {
		System.out.println("构造器输出输出");
	}
	 public static void sayHi(){
		 System.out.println("静态输出输出");
	 }
}
