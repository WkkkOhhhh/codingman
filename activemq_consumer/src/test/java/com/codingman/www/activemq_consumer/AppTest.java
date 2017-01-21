package com.codingman.www.activemq_consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {
	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"spring-core.xml"});
			context.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
