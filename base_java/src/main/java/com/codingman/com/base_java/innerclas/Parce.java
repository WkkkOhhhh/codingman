package com.codingman.com.base_java.innerclas;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Parce {
	public Wrapping wrap(int x) {
		return new Wrapping(x) {
			public int value() {
				return super.value() * 47;
			}
		};
	}
	public static void main(String[] args) {
		Parce p=new Parce();
		Wrapping w=p.wrap(1);
		System.out.println(w.value());
	}
}
