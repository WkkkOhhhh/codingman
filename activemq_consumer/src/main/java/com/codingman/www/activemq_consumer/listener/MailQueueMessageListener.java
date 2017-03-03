package com.codingman.www.activemq_consumer.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.codingman.www.activemq_consumer.entity.MqMail;
import com.codingman.www.activemq_consumer.service.MailService;

@Component
public class MailQueueMessageListener implements SessionAwareMessageListener<Message> {
	@Autowired
	private MailService mailService;

	@Override
	public void onMessage(Message msg, Session session) throws JMSException {
		try {
			TextMessage textMessage = (TextMessage) msg;
			String str = textMessage.getText();
			System.out.println("收到消息" + str);
			MqMail mqMail = JSONObject.parseObject(str, MqMail.class);
			if (mqMail == null) {
				return;
			}
			try {
				mailService.mailSend(mqMail);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
