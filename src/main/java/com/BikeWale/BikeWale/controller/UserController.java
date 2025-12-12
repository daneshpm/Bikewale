package com.BikeWale.BikeWale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.BikeWale.BikeWale.entity.ApiResponse;
import com.BikeWale.BikeWale.entity.User_info;
import com.BikeWale.BikeWale.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ApiResponse<User_info> saveUser(@RequestBody User_info user) {
        return service.saveUser(user);
    }

    @GetMapping("/{id}")
    public ApiResponse<User_info> getUser(@PathVariable int id) {
        return service.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }

    @PutMapping("/{id}")
    public ApiResponse<User_info> updateUser(
            @PathVariable int id,
            @RequestBody User_info user) {
        return service.updateUser(id, user);
    }
}

