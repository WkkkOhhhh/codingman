package com.codingman.com.base_java.extend.demo2;

public class Circle extends Shape{


	@Override
	public void erase() {
		System.out.println("circle say erase");
	}

	@Override
	public void move() {
		System.out.println("circle say move");
	}

	@Override
	public void getColor() {
		System.out.println("circle say getColor");
	}

	@Override
	public void setColor() {
		System.out.println("circle say setColor");
	}

}
