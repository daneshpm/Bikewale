package com.fsg.bikeWale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.fsg.bikeWale.entity.Enquiry;
import com.fsg.bikeWale.service.EnquiryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/enquiry")
@Tag(name = "Enquiry APIs", description = "User enquiries on bikes")
public class EnquiryController {

	@Autowired
	private EnquiryService service;

	@Operation(summary = "Create Enquiry")
	@PostMapping
	public ResponseEntity<Enquiry> save(@RequestBody Enquiry enquiry) {
		return new ResponseEntity<>(service.save(enquiry), HttpStatus.CREATED);
	}

	@Operation(summary = "Get Enquiry by ID")
	@GetMapping("/{id}")
	public ResponseEntity<Enquiry> get(@PathVariable int id) {
		return ResponseEntity.ok(service.getById(id));
	}

	@Operation(summary = "Delete Enquiry by ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@Operation(summary = "update Enquiry by ID")
	@PutMapping("/{id}")
	public ResponseEntity<Enquiry> update(@PathVariable int id, @RequestBody Enquiry enquiry) {
		return ResponseEntity.ok(service.update(id, enquiry));
	}
}
