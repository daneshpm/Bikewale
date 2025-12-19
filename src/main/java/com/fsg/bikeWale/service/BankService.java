package com.fsg.bikeWale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsg.bikeWale.entity.Bank;
import com.fsg.bikeWale.exception.DuplicateEntryException;
import com.fsg.bikeWale.exception.IDNotPresentException;
import com.fsg.bikeWale.exception.InvalidInputException;
import com.fsg.bikeWale.repo.Bankrepo;

@Service
public class BankService {

	@Autowired
	private Bankrepo repo;

	public Bank save(Bank bank) {
		return repo.save(bank);
	}

	public Bank getById(int id) {
		return repo.findById(id).orElseThrow(() -> new IDNotPresentException("Bank not found " + id));
	}

	public Bank update(int id, Bank bank) {
		Bank db = getById(id);
		db.setName(bank.getName());
		db.setBranch(bank.getBranch());
		return repo.save(db);
	}

	public void delete(int id) {
		repo.delete(getById(id));
	}
}
