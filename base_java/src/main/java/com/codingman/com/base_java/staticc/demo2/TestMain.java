package com.codingman.com.base_java.staticc.demo2;

import com.codingman.com.base_java.staticc.demo1.StaticPojo;
/**
 * 由于静态方法都是前期绑定的所以没有经过子类  直接奔向了父类
 * */
public class TestMain {
	public static void main(String[] args) {
//		ParentPojo pp=new ChildPojo();
//		pp.sayHi();
		ChildPojo.sayHi();
	}
}
