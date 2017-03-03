package com.codingman.com.base_java.loading;

import sun.security.util.PropertyExpander.ExpandException;

public class SweetShop {
public static void main(String[] args) {
	System.out.println("inside main");
	new Candy();
	System.out.println("After creating Candy");
	try {
		Class.forName("com.codingman.com.base_java.loading.Gum");
	} catch (Exception e) {
		e.printStackTrace();
	}
	System.out.println("After Class.forName(\"Gum\")");
	new Cookie();
	System.out.println("After creating Cookie");
}
}


