package com.codingman.www.activemq_cluster;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Send {
public static void main(String[] args) throws Exception {
	ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
			ActiveMQConnectionFactory.DEFAULT_PASSWORD,
			"failover:(tcp://192.168.232.128:61616,tcp://192.168.232.129:61616,tcp://192.168.232.130:61616)?Randomize=false");
	Connection connection = connectionFactory.createConnection();
	connection.start();
	Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
	Destination destination = session.createQueue("queueTT1");
	MessageProducer messageProducer = session.createProducer(destination);
	messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	for (int i = 0; i < 50000; i++) {
		TextMessage msg = session.createTextMessage();
		msg.setText("发送消息:" + i);
		messageProducer.send(msg);
		System.out.println("发送"+i);
		Thread.sleep(1000);
	}
	if (connection != null) {
		connection.close();
	}
}
}
