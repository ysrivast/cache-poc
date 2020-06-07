package com.cache.poc.service;

import java.util.List;

import com.cache.poc.model.User;

public interface UserService {

	List<User> getAll();

	User getUserById(Long id);

	User create(User user);

	List<User> createInBatch(List<User> users);

	User upate(Long id, User user);

	void deleteById(Long id);

}
