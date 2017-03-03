package com.codingman.com.base_java.extend.demo6;

public class ChildStaticP extends ParentStaticP {

	public ChildStaticP() {
		System.out.println("childConstructor");
	}
	public static void main(String[] args) {
		ChildStaticP cp=new ChildStaticP();
		cp.Apply();
	}
	@Override
	public void Say() {
		System.out.println("444");
		
	}
	@Override
	public void Apply() {
		System.out.println("11111222");
	}
	

}
