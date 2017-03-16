package org.coding.rpc.service;

import java.util.List;

import org.coding.rpc.entity.User;

public interface HelloService {
	String hello(String name);

	User getUser(String name);

	List<User> getUsers(int size);

	User updateUser(User user);
}
