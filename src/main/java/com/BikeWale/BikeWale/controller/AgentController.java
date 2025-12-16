package com.BikeWale.BikeWale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.BikeWale.BikeWale.entity.Agent;
import com.BikeWale.BikeWale.entity.ApiResponse;
import com.BikeWale.BikeWale.service.AgentService;

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
	public ApiResponse<Agent> saveAgent(@RequestBody Agent agent) {
		return service.saveAgent(agent);
	}

	@Operation(summary = "Get Agent by ID")
	@GetMapping("/{id}")
	public ApiResponse<Agent> getAgent(@PathVariable int id) {
		return service.getAgentById(id);
	}

	@Operation(summary = "Delete Agent by ID")
	@DeleteMapping("/{id}")
	public ApiResponse<String> deleteAgent(@PathVariable int id) {
		return service.deleteAgent(id);
	}

	@Operation(summary = "update the user")
	@PutMapping("/{id}")
	public ApiResponse<Agent> updateAgent(@PathVariable int id, @RequestBody Agent agent) {
		return service.updateAgent(id, agent);
	}
}
