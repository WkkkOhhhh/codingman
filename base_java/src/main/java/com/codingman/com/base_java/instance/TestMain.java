package com.codingman.com.base_java.instance;

import javax.print.attribute.standard.PrinterInfo;

public class TestMain {
public static void main(String[] args) {
	Class c=null;
	try {
		c=Class.forName("com.codingman.com.base_java.instance.FancyToy");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	printerInfo(c);
	Class[] cc=c.getInterfaces();
	for (int pri = 0; pri < cc.length; pri++) {
		printerInfo(cc[pri]);
		Class cy=c.getSuperclass();
		Object cs=null;
		try {
			cs=cy.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		printerInfo(cs.getClass());
	}
}

private static void printerInfo(Class c) {
System.out.println("Class name: "+c.getName()+" is interface?{"+c.isInterface()+"]");	
}
}
