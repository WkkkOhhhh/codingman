package org.coding.rpc.entity;

import java.util.Date;

/**
 * @author 王坤
 *
 * @date 2017年3月13日上午10:01:38
 *
 */
public class User {
	private String name;
	private Date birthday;
	private boolean sex;

	public User(String name, Date birthday, boolean sex) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}
}
