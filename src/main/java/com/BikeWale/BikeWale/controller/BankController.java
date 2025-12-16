package com.BikeWale.BikeWale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.BikeWale.BikeWale.entity.ApiResponse;
import com.BikeWale.BikeWale.entity.Bank;
import com.BikeWale.BikeWale.service.BankService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/bank")
@Tag(name = "Bank APIs", description = "Operations related to banks")
public class BankController {

	@Autowired
	private BankService service;

	@Operation(summary = "Save Bank")
	@PostMapping
	public ApiResponse<Bank> saveBank(@RequestBody Bank bank) {
		return service.saveBank(bank);
	}

	@Operation(summary = "Get Bank by ID")
	@GetMapping("/{id}")
	public ApiResponse<Bank> getBank(@PathVariable int id) {
		return service.getBankById(id);
	}

	@Operation(summary = "Delete Bank by ID")
	@DeleteMapping("/{id}")
	public ApiResponse<String> deleteBank(@PathVariable int id) {
		return service.deleteBank(id);
	}

	@Operation(summary = "update Bank by ID")
	@PutMapping("/{id}")
	public ApiResponse<Bank> updateBank(@PathVariable int id, @RequestBody Bank bank) {
		return service.updateBank(id, bank);
	}
}