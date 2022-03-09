package com.vsanches.tddrestapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vsanches.tddrestapi.entities.User;

@RestController
@RequestMapping("/api")
public class UserController {

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> userList = new ArrayList<>();
		userList.add(new User(1L, "Fulano", "Fulaninho", "fulano@gmail.com", "12345678"));
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}
}
