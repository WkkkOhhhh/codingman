package com.codingman.com.base_java.pleomorphic;

public class Music {
public static void tune(Instrument i){
	i.play(Note.middleC);
}
public static void main(String[] args) {
	Wins w=new Wins();
	tune(w);
}
}
