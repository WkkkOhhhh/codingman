package com.codingman.com.base_java.extend.demo2;

public class Square extends Shape{

	@Override
	public void draw() {
		System.out.println("square say draw");
	}

	@Override
	public void erase() {
		System.out.println("square say erase");
	}

	@Override
	public void move() {
		System.out.println("square say move");
	}

	@Override
	public void getColor() {
		System.out.println("square say getColor");
	}

	@Override
	public void setColor() {
		System.out.println("square say setColor");
	}


}
