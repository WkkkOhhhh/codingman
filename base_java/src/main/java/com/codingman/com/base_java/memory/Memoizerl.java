package com.codingman.com.base_java.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import sun.launcher.resources.launcher;
import sun.launcher.resources.launcher_de;

public class Memoizerl<A, V> implements Computable<A, V> {
	private final Map<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
	private final Computable<A, V> c;

	public Memoizerl(Computable<A, V> c) {
		this.c = c;
	}

	@Override
	public synchronized V compute(A arg) throws InterruptedException {
		while (true) {
			Future<V> future = cache.get(arg);
			if (future == null) {
				Callable<V> eval = new Callable<V>() {
					@Override
					public V call() throws Exception {
						return c.compute(arg);
					}
				};
				FutureTask<V> futureTask = new FutureTask<V>(eval);
				future = cache.putIfAbsent(arg, futureTask);
				if (future == null) {
					future = futureTask;
					futureTask.run();
				}
			}
			try {
				return future.get();
			} catch (CancellationException e) {
				cache.remove(arg, future);
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

}
