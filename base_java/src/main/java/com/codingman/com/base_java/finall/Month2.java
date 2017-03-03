package com.codingman.com.base_java.finall;

/**
 * 定义月数，尝试下
 */
public final class Month2 {
	private String name = "";
	public final static Month2 JAN=new Month2("January"),
			FEB=new Month2("February"),
			MAR=new Month2("March"),
			ARP=new Month2("April"),
			MAY=new Month2("May"),
			JUN=new Month2("June"),
			JUL=new Month2("July"),
			AUG=new Month2("August"),
			SEP=new Month2("September"),
			OCT=new Month2("October"),
			NOV=new Month2("November"),
			DEC=new Month2("December");
	
	private static final Month2 month[]={
			JAN,FEB,MAR,ARP,MAY,JUN,JUL,AUG,SEP,OCT,NOV,DEC
	};
	public Month2(String name) {
		name = name;
	}
	public static void main(String[] args) {
		Month2 m2=Month2.JAN;
		System.out.println(m2);
		m2=Month2.month[11];
		System.out.println(m2);
		System.out.println(m2==Month2.DEC);
		System.out.println(m2.equals(Month2.DEC));
	}

}
