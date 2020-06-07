package com.cache.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cache.poc.dto.request.UserRequest;
import com.cache.poc.model.User;
import com.cache.poc.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		log.info("request for all users");
		return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable final Long id) {
		log.info("request for user id : {} ",id);
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
	}
	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody final UserRequest request) {
		log.info("request for creating user : {}", request);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(User.of(request.getName())));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable final Long id,@RequestBody final UserRequest request) {
		log.info("request for updating user : {}", request);
		return ResponseEntity.status(HttpStatus.OK).body(userService.upate(id, User.of(request.getName())));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") final Long id) {
		log.info("request for deleting user by id : {}", id);
		userService.deleteById(id);
	}
}
