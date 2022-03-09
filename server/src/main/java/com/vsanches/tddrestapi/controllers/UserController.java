package com.vsanches.tddrestapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vsanches.tddrestapi.dto.UserDTO;
import com.vsanches.tddrestapi.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userSerivce;

	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		List<UserDTO> userList = userSerivce.findAllUsers();
		return ResponseEntity.ok(userList);
	}
}
 