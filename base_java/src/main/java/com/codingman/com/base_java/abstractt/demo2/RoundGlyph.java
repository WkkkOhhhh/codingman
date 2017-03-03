package com.codingman.com.base_java.abstractt.demo2;

public class RoundGlyph extends Glyph {
	int radius = 1;

	public RoundGlyph(int radius) {
		this.radius = radius;
		System.out.println("RoundGlyph.RoundGlyph" + radius);
	}

	@Override
	void draw() {
		System.out.println("RoundGlyph.draw(),radius" + radius);

	}

}
