package com.codingman.com.base_java.masterworker;

import java.util.Map;
import java.util.Set;
//计算1*1*1+2*2*2+++++++100*100*100
public class TestMain {
	public static void main(String[] args) {
		Master master = new Master(new WorkerImpl(), 4);
		for (int i = 1; i <= 100; i++) {
			master.submit(i);
		}
		master.execute();
		Map<String, Object> resultMap = master.getResultMap();
		int result = 0;
		while (true) {
			Set<String> keySet = resultMap.keySet();
			String key = ""; 
			for (String k : keySet) {
				key = k;
				break;
			}
			int i = 0;
			if (key != null) {
				i = (int) resultMap.get(key);
				resultMap.remove(key);
			}
			if (i != 0) {
				result += i;
			}
			if (master.isComplete() && resultMap.size() == 0)
				break;
		}
		System.out.println(result);
	}
}
