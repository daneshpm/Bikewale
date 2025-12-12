package com.BikeWale.BikeWale.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikeWale.BikeWale.entity.ApiResponse;
import com.BikeWale.BikeWale.entity.User_info;
import com.BikeWale.BikeWale.exception.DuplicateEntryException;
import com.BikeWale.BikeWale.exception.IDNotPresentException;
import com.BikeWale.BikeWale.exception.InvalidInputException;
import com.BikeWale.BikeWale.repo.Userrepo;


@Service
public class UserService {

    @Autowired
    private Userrepo repo;

    public ApiResponse<User_info> saveUser(User_info user) {

        if (repo.existsById(user.getId())) {
            throw new DuplicateEntryException("User ID already exists");
        }

        if (user.getName() == null || user.getName().isBlank()) {
            throw new InvalidInputException("User name is required");
        }

        User_info saved = repo.save(user);

        ApiResponse<User_info> resp = new ApiResponse<>();
        resp.setStatusCode(201);
        resp.setMessage("User Created");
        resp.setData(saved);

        return resp;
    }

    // GET
    public ApiResponse<User_info> getUserById(int id) {

        Optional<User_info> opt = repo.findById(id);

        if (opt.isEmpty()) {
            throw new IDNotPresentException("User ID not found");
        }

        ApiResponse<User_info> resp = new ApiResponse<>();
        resp.setStatusCode(200);
        resp.setMessage("Success");
        resp.setData(opt.get());

        return resp;
    }

    // DELETE
    public ApiResponse<String> deleteUser(int id) {

        if (!repo.existsById(id)) {
            throw new IDNotPresentException("User ID not found");
        }

        repo.deleteById(id);

        ApiResponse<String> resp = new ApiResponse<>();
        resp.setStatusCode(200);
        resp.setMessage("Deleted");
        resp.setData("User deleted");

        return resp;
    }

    // UPDATE
    public ApiResponse<User_info> updateUser(int id, User_info newData) {

        Optional<User_info> opt = repo.findById(id);

        if (opt.isEmpty()) {
            throw new IDNotPresentException("User ID not found");
        }

        User_info old = opt.get();

        if (newData.getName() == null || newData.getName().isBlank()) {
            throw new InvalidInputException("User name cannot be empty");
        }

        old.setName(newData.getName());
        old.setEmail(newData.getEmail());
        old.setPhone(newData.getPhone());
       

        User_info updated = repo.save(old);

        ApiResponse<User_info> resp = new ApiResponse<>();
        resp.setStatusCode(200);
        resp.setMessage("Updated");
        resp.setData(updated);

        return resp;
    }
}
