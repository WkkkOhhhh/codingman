package com.codingman.com.base_java.extend.demo3;

import com.codingman.com.base_java.extend.demo1.Cat;

public class TestMain {
public static void main(String[] args) {
	Child c1=new Child();
	Children c2=new Children();
	System.out.println(c1.cat==c2.cat);
}
}
