package com.BikeWale.BikeWale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.BikeWale.BikeWale.entity.Tax;
import com.BikeWale.BikeWale.service.TaxService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.BikeWale.BikeWale.entity.ApiResponse;


@RestController
@RequestMapping("/tax")
@Tag(name = "Tax APIs", description = "Operations related to tax details")
public class TaxController {

	@Autowired
	private TaxService service;

	@Operation(summary = "Save Tax")
	@PostMapping
	public ApiResponse<Tax> saveTax(@RequestBody Tax tax) {
		return service.saveTax(tax);
	}

	@Operation(summary = "Get Tax by ID")
	@GetMapping("/{id}")
	public ApiResponse<Tax> getTax(@PathVariable int id) {
		return service.getTaxById(id);
	}

	@Operation(summary = "Delete Tax by ID")
	@DeleteMapping("/{id}")
	public ApiResponse<String> deleteTax(@PathVariable int id) {
		return service.deleteTax(id);
	}

	@Operation(summary = "update Tax by ID")
	@PutMapping("/{id}")
	public ApiResponse<Tax> updateTax(@PathVariable int id, @RequestBody Tax tax) {
		return service.updateTax(id, tax);
	}
}
