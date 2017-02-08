package com.codingman.com.base_java.extend.demo3;

import com.codingman.com.base_java.extend.demo1.Cat;

public class Parent {
public int a=1;
public Cat cat;
public Cat getCat() {
	return cat;
}
public void setCat(Cat cat) {
	this.cat = new Cat();
}
}
