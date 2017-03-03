package com.codingman.com.base_java.pleomorphic;

public class Wins extends Instrument{
	static{
		System.out.println("Wins con true");	
	}
	{
		System.out.println("Wins con false");
	}
	

	public Wins() {
		System.out.println("Wins");
	}


	@Override
	public void play(Note n) {
		System.out.println("Wins play()");
	}

}
