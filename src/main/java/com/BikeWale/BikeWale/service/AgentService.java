package com.BikeWale.BikeWale.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikeWale.BikeWale.entity.Agent;
import com.BikeWale.BikeWale.entity.ApiResponse;
import com.BikeWale.BikeWale.exception.DuplicateEntryException;
import com.BikeWale.BikeWale.exception.IDNotPresentException;
import com.BikeWale.BikeWale.exception.InvalidInputException;
import com.BikeWale.BikeWale.repo.Agentrepo;

@Service
public class AgentService {

    @Autowired
    private Agentrepo repo;

    // CREATE
    public ApiResponse<Agent> saveAgent(Agent agent) {

        if (repo.existsById(agent.getId())) {
            throw new DuplicateEntryException("Agent with ID " + agent.getId() + " already exists");
        }

        if (agent.getName() == null || agent.getName().isBlank()) {
            throw new InvalidInputException("Agent name cannot be empty");
        }

        Agent saved = repo.save(agent);

        ApiResponse<Agent> resp = new ApiResponse<>();
        resp.setStatusCode(201);
        resp.setMessage("Agent Created");
        resp.setData(saved);

        return resp;
    }

    // GET
    public ApiResponse<Agent> getAgentById(int id) {

        Optional<Agent> opt = repo.findById(id);

        if (opt.isEmpty()) {
            throw new IDNotPresentException("Agent ID " + id + " not found");
        }

        ApiResponse<Agent> resp = new ApiResponse<>();
        resp.setStatusCode(200);
        resp.setMessage("Success");
        resp.setData(opt.get());

        return resp;
    }

    // DELETE
    public ApiResponse<String> deleteAgent(int id) {

        if (!repo.existsById(id)) {
            throw new IDNotPresentException("Agent ID " + id + " not found");
        }

        repo.deleteById(id);

        ApiResponse<String> resp = new ApiResponse<>();
        resp.setStatusCode(200);
        resp.setMessage("Deleted");
        resp.setData("Agent deleted: " + id);

        return resp;
    }

    // UPDATE
    public ApiResponse<Agent> updateAgent(int id, Agent newData) {

        Optional<Agent> opt = repo.findById(id);

        if (opt.isEmpty()) {
            throw new IDNotPresentException("Agent ID " + id + " not found for update");
        }

        Agent old = opt.get();

        if (newData.getName() == null || newData.getName().isBlank()) {
            throw new InvalidInputException("Agent name cannot be empty");
        }

        old.setName(newData.getName());
        old.setEmail(newData.getEmail());
        old.setPhone(newData.getPhone());

        Agent updated = repo.save(old);

        ApiResponse<Agent> resp = new ApiResponse<>();
        resp.setStatusCode(200);
        resp.setMessage("Updated");
        resp.setData(updated);

        return resp;
    }
}
