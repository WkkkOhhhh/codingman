package com.codingman.www.activemq_cluster;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Recevie {
	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
				ActiveMQConnectionFactory.DEFAULT_PASSWORD,
				"failover:(tcp://192.168.232.128:61616,tcp://192.168.232.129:61616,tcp://192.168.232.130:61616)?Randomize=false");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("queueTT1");
		MessageConsumer messageConsumer = session.createConsumer(destination);
		while (true) {
	   TextMessage msg=(TextMessage) messageConsumer.receive();
	   if(msg==null)break;
			System.out.println(msg.getText());
		}
		if (connection != null) {
			connection.close();
		}
	}

}
