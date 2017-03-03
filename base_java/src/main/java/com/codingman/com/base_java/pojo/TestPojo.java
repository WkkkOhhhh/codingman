package com.codingman.com.base_java.pojo;

public class TestPojo {
public static void main(String[] args) {
	User user=new User("wk","m");
	User user1;
	user1=user;
	user1.setName("jm");
	System.out.println(user.getName());
	
	int i=1;
	int j;
	j=i;
	j++;
	System.out.println(i);
}
}
