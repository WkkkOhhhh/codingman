package com.codingman.com.base_java.masterworker;

public class WorkerImpl extends Worker{

	@Override
	public Object handle(Object obj) {
		int i=(int) obj;
		return i*i*i;
	}

}
