package com.codingman.www.activemq_consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.codingman.www.activemq_consumer.entity.MqMail;

@Service("mailService")
public class MailService {
	@Autowired
	private ThreadPoolTaskExecutor threadPool;
	@Autowired
	private SimpleMailMessage simpleMailMessage;
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	public void mailSend(final MqMail mqMail) {
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				try {
					simpleMailMessage.setFrom(mqMail.getFrom());
					simpleMailMessage.setTo(mqMail.getTo());
					simpleMailMessage.setSubject(mqMail.getSubject());
					simpleMailMessage.setText(mqMail.getContext());
					mailSender.send(simpleMailMessage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		});
	}
}
