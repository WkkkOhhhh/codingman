package com.codingman.com.base_java.pleomorphic;

import com.sun.media.jfxmedia.events.PlayerEvent;

public class Instrument {
	static{
		System.out.println("instrument con true");	
	}
	{
		System.out.println("instrument con false");
	}
	public Instrument() {
		System.out.println("instrument");
	}

	public void play(Note n) {
		System.out.println("instrument play()");
	}
}
