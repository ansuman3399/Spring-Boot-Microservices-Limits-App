package com.boot.rest.restwebservices.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.boot.rest.restwebservices.model.User;

@Component
public class UserService {

	private static List<User> users = new ArrayList<>();

	private static int usersCount = 3;
	static {
		users.add(new User(1, "A", new Date()));
		users.add(new User(2, "B", new Date()));
		users.add(new User(3, "C", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			usersCount++;
		}
		User newUser = new User(usersCount, user.getName(), new Date());
		users.add(newUser);
		return newUser;
	}

	public User findOne(Integer id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User deleteById(int id) {
		if (users.contains(findOne(id))) {
			User user= findOne(id);
			users.remove(findOne(id));
			return user;
		}
		return null;
	}
}
