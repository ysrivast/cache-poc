package com.cache.poc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cache.poc.model.User;
import com.cache.poc.repository.AddressRepository;
import com.cache.poc.repository.UserRepository;
import com.cache.poc.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServieImpl implements UserService {

	@Autowired
	private UserRepository userRepository; 
	@Autowired
	private AddressRepository addressRepository; 
	
	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Cacheable(value = "users", key = "#id")
	@Override
	public User getUserById(Long id) {
		log.info("inside service request for user id : {} ",id);
		  Optional<User> op = userRepository.findById(id);
		  if (!op.isPresent()) {
			throw new RuntimeException();
		}
		 return op.get();
	}

	@Override
	public User create(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public List<User> createInBatch(List<User> users) {
		return userRepository.saveAll(users);
	}

	@CachePut(value = "users", key = "#id")
	@Override
	public User upate(Long id, User user) {
		User pUser = userRepository.getOne(id);
		pUser.setName(user.getName());
		return userRepository.save(pUser);
	}

	@CacheEvict(value = "users", key = "#id")
	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
}