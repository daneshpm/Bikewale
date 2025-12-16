package com.BikeWale.BikeWale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.BikeWale.BikeWale.entity.ApiResponse;
import com.BikeWale.BikeWale.entity.Enquiry;
import com.BikeWale.BikeWale.service.EnquiryService;

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
	public ApiResponse<Enquiry> saveEnquiry(@RequestBody Enquiry enquiry) {
		return service.saveEnquiry(enquiry);
	}

	@Operation(summary = "Get Enquiry by ID")
	@GetMapping("/{id}")
	public ApiResponse<Enquiry> getEnquiry(@PathVariable int id) {
		return service.getEnquiryById(id);
	}

	@Operation(summary = "Delete Enquiry by ID")
	@DeleteMapping("/{id}")
	public ApiResponse<String> deleteEnquiry(@PathVariable int id) {
		return service.deleteEnquiry(id);
	}

	@Operation(summary = "update Enquiry by ID")
	@PutMapping("/{id}")
	public ApiResponse<Enquiry> updateEnquiry(@PathVariable int id, @RequestBody Enquiry enquiry) {
		return service.updateEnquiry(id, enquiry);
	}
}
