package com.codingman.com.base_java.extend.demo4;

public class ThreadIncr {
public static void main(String[] args) {
	StaticIncr sti1=new StaticIncr();
	StaticIncr sti2=new StaticIncr();
	StaticIncr sti3=new StaticIncr();
	StaticIncr sti4=new StaticIncr();
	StaticIncr sti5=new StaticIncr();
	StaticIncr sti6=new StaticIncr();
	StaticIncr sti7=new StaticIncr();
	StaticIncr sti8=new StaticIncr();
	StaticIncr sti9=new StaticIncr();
	sti1.start();
	sti2.start();
	sti3.start();
	sti4.start();
	sti5.start();
	sti6.start();
	sti7.start();
	sti8.start();
	sti9.start();
}
}
