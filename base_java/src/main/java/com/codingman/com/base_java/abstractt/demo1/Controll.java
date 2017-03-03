package com.codingman.com.base_java.abstractt.demo1;

public class Controll extends TestAbstract{

	@Override
	public Controll buildControll() {
		return new Controll();
	}
	@Override
	public void sayControll(){
		System.out.println("111");
	}

}
