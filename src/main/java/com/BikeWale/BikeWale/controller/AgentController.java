package com.BikeWale.BikeWale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.BikeWale.BikeWale.entity.Agent;
import com.BikeWale.BikeWale.entity.ApiResponse;
import com.BikeWale.BikeWale.service.AgentService;



@RestController
@RequestMapping("/agent")
public class AgentController {

    @Autowired
    private AgentService service;

    @PostMapping
    public ApiResponse<Agent> saveAgent(@RequestBody Agent agent) {
        return service.saveAgent(agent);
    }

    @GetMapping("/{id}")
    public ApiResponse<Agent> getAgent(@PathVariable int id) {
        return service.getAgentById(id);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteAgent(@PathVariable int id) {
        return service.deleteAgent(id);
    }

    @PutMapping("/{id}")
    public ApiResponse<Agent> updateAgent(
            @PathVariable int id,
            @RequestBody Agent agent) {
        return service.updateAgent(id, agent);
    }
}

