package com.fsg.bikeWale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fsg.bikeWale.entity.Agent;
import com.fsg.bikeWale.service.AgentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/agent")
@Tag(name = "Agent APIs", description = "Operations related to bike agents")
public class AgentController {

	@Autowired
	private AgentService service;

	@Operation(summary = "Save Agent")
	@PostMapping
	public ResponseEntity<Agent> save(@RequestBody Agent agent) {
		return new ResponseEntity<>(service.save(agent), HttpStatus.CREATED);
	}

	@Operation(summary = "Get Agent by ID")
	@GetMapping("/{id}")
	public ResponseEntity<Agent> get(@PathVariable int id) {
		return ResponseEntity.ok(service.getById(id));
	}

	@Operation(summary = "Delete Agent by ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@Operation(summary = "update the user")
	@PutMapping("/{id}")
	public ResponseEntity<Agent> update(@PathVariable int id, @RequestBody Agent agent) {
		return ResponseEntity.ok(service.update(id, agent));
	}
}
