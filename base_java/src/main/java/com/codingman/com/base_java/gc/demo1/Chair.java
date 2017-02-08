package com.codingman.com.base_java.gc.demo1;

public class Chair {
	static boolean gcrun = false;
	static boolean f = false;
	static int created = 0;
	static int finalize = 0;
	int i;
	Chair(){
		i=++created;
		if(created==300000){
			System.out.println("Created 300000");
		}
	}
	protected void finalize(){
		if(!gcrun){
			gcrun=true;
			System.out.println("Beginning to finalize after"+created+" Chairs have been created");
		}
		if(i==400000){
			System.out.println("Finalize Chair #300000, "+"Setting flag to stop Chair creation");
			f=true;
		}
		finalize++;
		if(finalize>=created){
			System.out.println("All finalize");
		}
	}
}
