package com.fsg.bikeWale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.fsg.bikeWale.entity.User_info;
import com.fsg.bikeWale.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/user")
@Tag(name = "User APIs", description = "Operations related to users")
public class UserController {

	@Autowired
	private UserService service;

	@Operation(summary = "Save user")
	@PostMapping
	public ResponseEntity<User_info> save(@RequestBody User_info user) {
		return new ResponseEntity<>(service.save(user), HttpStatus.CREATED);
	}

	@Operation(summary = "Get user by ID")
	@GetMapping("/{id}")
	public ResponseEntity<User_info> get(@PathVariable int id) {
		return ResponseEntity.ok(service.getById(id));
	}

	@Operation(summary = "Delete user by ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@Operation(summary = "update the user")
	@PutMapping("/{id}")
	public ResponseEntity<User_info> update(@PathVariable int id, @RequestBody User_info user) {
		return ResponseEntity.ok(service.update(id, user));
	}
}
