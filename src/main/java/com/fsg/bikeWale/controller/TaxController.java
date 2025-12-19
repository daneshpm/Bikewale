package com.fsg.bikeWale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.fsg.bikeWale.entity.Tax;
import com.fsg.bikeWale.service.TaxService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/tax")
@Tag(name = "Tax APIs", description = "Operations related to tax details")
public class TaxController {

	@Autowired
	private TaxService service;

	@Operation(summary = "Save Tax")
	@PostMapping
	public ResponseEntity<Tax> save(@RequestBody Tax tax) {
		return new ResponseEntity<>(service.save(tax), HttpStatus.CREATED);
	}

	@Operation(summary = "Get Tax by ID")
	@GetMapping("/{id}")
	public ResponseEntity<Tax> get(@PathVariable int id) {
		return ResponseEntity.ok(service.getById(id));
	}

	@Operation(summary = "Delete Tax by ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@Operation(summary = "update Tax by ID")
	@PutMapping("/{id}")
	public ResponseEntity<Tax> update(@PathVariable int id, @RequestBody Tax tax) {
		return ResponseEntity.ok(service.update(id, tax));
	}
}
