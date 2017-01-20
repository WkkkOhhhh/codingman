package com.codingman.www.active_producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codingman.www.active_producer.entity.MqMail;
import com.codingman.www.active_producer.mq.MqProducer;

/**
 * Unit test for simple App.
 */
@ContextConfiguration(locations = { "classpath:spring-core.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {
	@Autowired
	private MqProducer mqProducer;

	@Test
	public void test1() {
		MqMail mail = new MqMail();
		mail.setTo("394759701@qq.com");
		mail.setSubject("异步发邮件");
		mail.setContext("这是一封从mq发来的文件");
		mqProducer.sendMessage(mail);
	}
}
