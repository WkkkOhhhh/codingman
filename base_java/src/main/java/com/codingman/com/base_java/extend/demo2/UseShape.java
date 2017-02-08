package com.codingman.com.base_java.extend.demo2;

public class UseShape {
public static void doBuff(Shape s){
	s.draw();
	s.getColor();
}
public static void main(String[] args) {
	Shape c=new Circle();
	Shape sq=new Square();
	doBuff(c);
	doBuff(sq);
}
}
