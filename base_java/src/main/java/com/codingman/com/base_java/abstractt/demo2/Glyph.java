package com.codingman.com.base_java.abstractt.demo2;

public abstract class Glyph {
	abstract void draw();

	public Glyph() {
		System.out.println("Glyph before()");
		draw();
		System.out.println("Glyph after()");
	}

}
