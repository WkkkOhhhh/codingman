package com.codingman.www.activemq_publish.publish;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Publish {
	private ConnectionFactory connectionFactory;
	private Connection connection;
	private Session session;

	private Publish() {
		try {
			connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
					ActiveMQConnectionFactory.DEFAULT_PASSWORD, ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
			connection = connectionFactory.createConnection();
			session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
			connection.start();
		} catch (JMSException e) {
			try {
				connection.close();
				e.printStackTrace();
			} catch (JMSException e1) {
				e1.printStackTrace();
			}
		}
	}

	private static class SinglePublish {
		public static final Publish INSTANCE = new Publish();
	}

	public static final Publish getInstance() {
		return SinglePublish.INSTANCE;
	}
}
