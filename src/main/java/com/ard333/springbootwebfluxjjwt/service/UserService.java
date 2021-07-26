package com.ard333.springbootwebfluxjjwt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.ard333.springbootwebfluxjjwt.model.User;

import reactor.core.publisher.Mono;

/**
 * This is just an example, you can load the user from the database from the
 * repository.
 * 
 */
@Service
public class UserService {

	private Map<String, User> data;

	@PostConstruct
	public void init() {
		data = new HashMap<>();

		// username:passwowrd -> user:user
		data.put("user", new User("user", "cBrlgyL2GI2GINuLUUwgojITuIufFycpLG4490dhGtY=", true, new ArrayList()));

		// username:passwowrd -> admin:admin
		data.put("admin", new User("admin", "dQNjUIMorJb8Ubj2+wVGYp6eAeYkdekqAcnYp+aRq5w=", true, new ArrayList()));
	}

	public Mono<User> findByUsername(String username) {
		return Mono.justOrEmpty(data.get(username));
	}
}
