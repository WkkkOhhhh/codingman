package com.codingman.com.base_java.memory;

public interface Computable<A, V> {
	V compute(A arg) throws InterruptedException;
}
