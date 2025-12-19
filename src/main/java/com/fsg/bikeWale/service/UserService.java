package com.fsg.bikeWale.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsg.bikeWale.entity.User_info;
import com.fsg.bikeWale.exception.DuplicateEntryException;
import com.fsg.bikeWale.exception.IDNotPresentException;
import com.fsg.bikeWale.exception.InvalidInputException;
import com.fsg.bikeWale.repo.Userrepo;
import com.fsg.bikeWale.util.AESUtil;

@Service
public class UserService {

	@Autowired
	private Userrepo repo;

	public User_info save(User_info user) {
		String encryptedPassword = AESUtil.encrypt(user.getPassword());

		user.setPassword(encryptedPassword);

		return repo.save(user);
	}

	public User_info getById(int id) {
		return repo.findById(id).orElseThrow(() -> new IDNotPresentException("User not found " + id));
	}

	public User_info update(int id, User_info user) {
		User_info db = getById(id);

		db.setName(user.getName());
		db.setEmail(user.getEmail());

		// 🔐 Encrypt only if password is updated
		if (user.getPassword() != null && !user.getPassword().isEmpty()) {

			db.setPassword(AESUtil.encrypt(user.getPassword()));
		}

		return repo.save(db);
	}

	public void delete(int id) {
		repo.delete(getById(id));
	}
}