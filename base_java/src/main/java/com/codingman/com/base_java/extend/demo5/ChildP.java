package com.codingman.com.base_java.extend.demo5;

public class ChildP extends ParentP{
	
	
@Override
	protected void Slf() {
	System.out.println("444");
	}

public void Slq(){
	super.Slf();
}

public static void main(String[] args) {
	ChildP cp=new ChildP();
	cp.Slq();
}
}
