package com.BikeWale.BikeWale.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikeWale.BikeWale.entity.ApiResponse;
import com.BikeWale.BikeWale.entity.Bank;
import com.BikeWale.BikeWale.exception.DuplicateEntryException;
import com.BikeWale.BikeWale.exception.IDNotPresentException;
import com.BikeWale.BikeWale.exception.InvalidInputException;
import com.BikeWale.BikeWale.repo.Bankrepo;


@Service
public class BankService {

    @Autowired
    private Bankrepo repo;

    // CREATE
    public ApiResponse<Bank> saveBank(Bank bank) {

        if (repo.existsById(bank.getId())) {
            throw new DuplicateEntryException("Bank ID already exists");
        }

        if (bank.getName() == null || bank.getName().isBlank()) {
            throw new InvalidInputException("Bank name cannot be empty");
        }

        Bank saved = repo.save(bank);

        ApiResponse<Bank> resp = new ApiResponse<>();
        resp.setStatusCode(201);
        resp.setMessage("Bank Created");
        resp.setData(saved);

        return resp;
    }

    // GET
    public ApiResponse<Bank> getBankById(int id) {

        Optional<Bank> opt = repo.findById(id);

        if (opt.isEmpty()) {
            throw new IDNotPresentException("Bank ID " + id + " not found");
        }

        ApiResponse<Bank> resp = new ApiResponse<>();
        resp.setStatusCode(200);
        resp.setMessage("Success");
        resp.setData(opt.get());

        return resp;
    }

    // DELETE
    public ApiResponse<String> deleteBank(int id) {

        if (!repo.existsById(id)) {
            throw new IDNotPresentException("Bank ID not found");
        }

        repo.deleteById(id);

        ApiResponse<String> resp = new ApiResponse<>();
        resp.setStatusCode(200);
        resp.setMessage("Deleted");
        resp.setData("Bank deleted: " + id);

        return resp;
    }

    // UPDATE
    public ApiResponse<Bank> updateBank(int id, Bank newData) {

        Optional<Bank> opt = repo.findById(id);

        if (opt.isEmpty()) {
            throw new IDNotPresentException("Bank ID not found for update");
        }

        Bank old = opt.get();

        if (newData.getName() == null || newData.getName().isBlank()) {
            throw new InvalidInputException("Bank name cannot be blank");
        }

        old.setName(newData.getName());
        old.setBranch(newData.getBranch());
        old.setIfsc(newData.getIfsc());

        Bank updated = repo.save(old);

        ApiResponse<Bank> resp = new ApiResponse<>();
        resp.setStatusCode(200);
        resp.setMessage("Updated");
        resp.setData(updated);

        return resp;
    }
}
