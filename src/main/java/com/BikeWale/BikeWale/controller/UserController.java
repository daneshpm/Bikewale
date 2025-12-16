package com.BikeWale.BikeWale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.BikeWale.BikeWale.entity.ApiResponse;
import com.BikeWale.BikeWale.entity.User_info;
import com.BikeWale.BikeWale.service.UserService;

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
	public ApiResponse<User_info> saveUser(@RequestBody User_info user) {
		return service.saveUser(user);
	}

	@Operation(summary = "Get user by ID")
	@GetMapping("/{id}")
	public ApiResponse<User_info> getUser(@PathVariable int id) {
		return service.getUserById(id);
	}

	@Operation(summary = "Delete user by ID")
	@DeleteMapping("/{id}")
	public ApiResponse<String> deleteUser(@PathVariable int id) {
		return service.deleteUser(id);
	}

	@Operation(summary = "update the user")
	@PutMapping("/{id}")
	public ApiResponse<User_info> updateUser(@PathVariable int id, @RequestBody User_info user) {
		return service.updateUser(id, user);
	}
}
