package com.cache.poc;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.cache.poc.model.User;
import com.cache.poc.service.UserService;

@SpringBootApplication
@EnableCaching
public class CachePocApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(CachePocApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User yogesh = User.of("Yogesh");
	    User manish = User.of("Manish");
	    User john = User.of("John");
	    List<User> users  = Arrays.asList(yogesh, manish,john);
	    userService.createInBatch(users);
		
	}

}
