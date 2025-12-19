package com.fsg.bikeWale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fsg.bikeWale.entity.Bank;
import com.fsg.bikeWale.service.BankService;

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
	public ResponseEntity<Bank> save(@RequestBody Bank bank) {
		return new ResponseEntity<>(service.save(bank), HttpStatus.CREATED);
	}

	@Operation(summary = "Get Bank by ID")
	@GetMapping("/{id}")
	public ResponseEntity<Bank> get(@PathVariable int id) {
		return ResponseEntity.ok(service.getById(id));
	}

	@Operation(summary = "Delete Bank by ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@Operation(summary = "update Bank by ID")
	@PutMapping("/{id}")
	public ResponseEntity<Bank> update(@PathVariable int id, @RequestBody Bank bank) {
		return ResponseEntity.ok(service.update(id, bank));
	}
}