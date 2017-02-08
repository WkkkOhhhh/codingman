package com.codingman.com.base_java.gc.demo1;

public class Garbage {
	public static void main(String[] args) {
	
		while(!Chair.f){
			new Chair();
			new String("To take up space");
		}
		System.out.println("After all Chairs have been created:\n"+"total created = "+Chair.created
				+", total finalized= "+Chair.finalize);
		if(args[0].equals("before")){
			System.out.println("gc();");
			System.gc();
			System.out.println("runFinalizetion()");
			System.runFinalization();
		}
		System.out.println("bye");
		if(args[0].equals("after")){
			System.runFinalizersOnExit(true);
		}
	}

}
