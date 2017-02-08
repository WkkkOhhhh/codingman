package com.codingman.com.base_java.extend.demo1;

public class Dog extends Animal{

	@Override
	public void bellow() {
		System.out.println("Im dog");
	}
	public void Wang(){
		System.out.println("Wang~wang!");
	}
	public static void main(String[] args) {
		Animal d=new Dog();
		d.bellow();
	}

}
