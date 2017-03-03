package com.codingman.com.base_java.finall;

public class TestFinal {
final Value value=new Value();
public void changeValue(){
	value.i=3;
	System.out.println(value.i);
}
public static void main(String[] args) {
	TestFinal tf=new TestFinal();
	tf.changeValue();
}
}
