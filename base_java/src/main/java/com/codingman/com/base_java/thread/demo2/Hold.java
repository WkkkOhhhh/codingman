package com.codingman.com.base_java.thread.demo2;

public class Hold {
private int n;
	public Hold(int i) {
		this.n=i;
	}
	public void assertSanity(){
		if(n!=n){
			throw new AssertionError("Error");
		}
	}
}
