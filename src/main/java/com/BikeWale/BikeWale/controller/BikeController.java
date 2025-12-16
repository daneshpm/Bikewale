package com.BikeWale.BikeWale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.BikeWale.BikeWale.entity.ApiResponse;
import com.BikeWale.BikeWale.entity.Bike;
import com.BikeWale.BikeWale.service.BikeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/bike")
@Tag(name = "Bike APIs", description = "Operations related to bikes")
public class BikeController {

	@Autowired
	private BikeService service;

	@Operation(summary = "Save Bike")
	@PostMapping
	public ApiResponse<Bike> saveBike(@RequestBody Bike bike) {
		return service.saveBike(bike);
	}

	@Operation(summary = "Get Bike by ID")
	@GetMapping("/{id}")
	public ApiResponse<Bike> getBike(@PathVariable int id) {
		return service.getBikeById(id);
	}

	@Operation(summary = "Delete Bike by ID")
	@DeleteMapping("/{id}")
	public ApiResponse<String> deleteBike(@PathVariable int id) {
		return service.deleteBike(id);
	}

	@Operation(summary = "update Bike by ID")
	@PutMapping("/{id}")
	public ApiResponse<Bike> updateBike(@PathVariable int id, @RequestBody Bike bike) {

		return service.updateBike(id, bike);
	}
}
