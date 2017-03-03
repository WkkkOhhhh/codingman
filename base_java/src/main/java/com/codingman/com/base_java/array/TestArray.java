package com.codingman.com.base_java.array;

public class TestArray {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		int b[];
		b = a;
		for (int i = 0; i < b.length; i++) {
			b[i]++;
		}
		for (int i = 0; i < a.length; i++) {
			prt(a[i]);
		}
	}

	public static void prt(int i) {
		System.out.println(i);
	}
}
