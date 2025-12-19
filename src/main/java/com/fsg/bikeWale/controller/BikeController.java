package com.fsg.bikeWale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fsg.bikeWale.entity.Bike;
import com.fsg.bikeWale.service.BikeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/bike")
@Tag(name = "Bike APIs")
public class BikeController {

	@Autowired
	private BikeService service;


	@PostMapping
	@Operation(summary = "Create a new bike")
	public ResponseEntity<Bike> save(@RequestBody Bike bike) {
		return new ResponseEntity<>(service.save(bike), HttpStatus.CREATED);
	}


	@GetMapping("/{id}")
	@Operation(summary = "Get bike by ID")
	public ResponseEntity<Bike> getById(@PathVariable int id) {
		return ResponseEntity.ok(service.getById(id));
	}


	@PutMapping("/{id}")
	@Operation(summary = "Update bike by ID")
	public ResponseEntity<Bike> update(@PathVariable int id, @RequestBody Bike bike) {

		return ResponseEntity.ok(service.update(id, bike));
	}


	@DeleteMapping("/{id}")
	@Operation(summary = "Delete bike by ID")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
