package com.codingman.com.base_java.thread.demo2;

import java.util.Collections;

public class HolderTest {
	public Hold hold;
public void initialize(){
	hold=new Hold(42);
}

public static void main(String[] args) {
	HolderTest ht=new HolderTest();
	ht.initialize();
	Thread a=new Thread(new Runnable() {
		
		@Override
		public void run() {
			ht.initialize();
		}
	});
	Thread b=new Thread(new Runnable() {
		
		@Override
		public void run() {
			ht.hold.assertSanity();
		}
	});
	b.start();
}
}
