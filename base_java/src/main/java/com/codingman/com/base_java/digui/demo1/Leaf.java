package com.codingman.com.base_java.digui.demo1;

public class Leaf {
	private int i=0;
Leaf incream(){
	if(i<=5){
		i++;
		print();
		return incream();
	}
	return null;
}
void print(){
	System.out.println("i="+i);
}
public static void main(String[] args) {
	Leaf le=new Leaf();
	le.incream();
}
}
