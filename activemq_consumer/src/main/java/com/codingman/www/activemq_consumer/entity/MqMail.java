package com.codingman.www.activemq_consumer.entity;

public class MqMail {
	private String subject;
	private String from;
	private String to;
	private String context;

	public MqMail() {
	}

	public MqMail(String subject, String from, String to, String context) {
		super();
		this.subject = subject;
		this.from = from;
		this.to = to;
		this.context = context;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
}
