package com.BikeWale.BikeWale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.BikeWale.BikeWale.entity.ApiResponse;
import com.BikeWale.BikeWale.entity.Bank;
import com.BikeWale.BikeWale.service.BankService;



@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankService service;

    @PostMapping
    public ApiResponse<Bank> saveBank(@RequestBody Bank bank) {
        return service.saveBank(bank);
    }

    @GetMapping("/{id}")
    public ApiResponse<Bank> getBank(@PathVariable int id) {
        return service.getBankById(id);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteBank(@PathVariable int id) {
        return service.deleteBank(id);
    }

    @PutMapping("/{id}")
    public ApiResponse<Bank> updateBank(
            @PathVariable int id,
            @RequestBody Bank bank) {
        return service.updateBank(id, bank);
    }
}