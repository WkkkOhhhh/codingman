package org.coding.rpc.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.coding.rpc.annotation.RpcService;
import org.coding.rpc.entity.User;
import org.coding.rpc.service.HelloService;

@RpcService(HelloService.class)
public class HelloServiceImpl implements HelloService {

	public String hello(String name) {
		String result = "hello" + name;
		System.out.println(result);
		return result;
	}

	@Override
	public User getUser(String name) {
		User user = new User(name, new Date(), true);
		return user;
	}

	@Override
	public List<User> getUsers(int size) {
		List<User> list = new ArrayList<User>();
		User user = null;
		String name = "foo";
		Date birthday = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(birthday);
		for (int i = 0; i < size; i++) {
			cal.add(Calendar.DAY_OF_MONTH, 1);
			user = new User(name, cal.getTime(), i % 2 == 0 ? true : false);
			list.add(user);
		}
		return list;
	}

	@Override
	public User updateUser(User user) {
		user.setName(user.getName() + "-update");
		return user;
	}

}
