package com.fsg.bikeWale.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsg.bikeWale.entity.Agent;
import com.fsg.bikeWale.exception.DuplicateEntryException;
import com.fsg.bikeWale.exception.IDNotPresentException;
import com.fsg.bikeWale.exception.InvalidInputException;
import com.fsg.bikeWale.repo.Agentrepo;

@Service
public class AgentService {

    @Autowired
    private Agentrepo repo;

    public Agent save(Agent agent) {
        return repo.save(agent);
    }

    public Agent getById(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new IDNotPresentException("Agent not found " + id));
    }

    public Agent update(int id, Agent agent) {
        Agent db = getById(id);
        db.setName(agent.getName());
        db.setEmail(agent.getEmail());
        db.setPhone(agent.getPhone());
        return repo.save(db);
    }

    public void delete(int id) {
        repo.delete(getById(id));
    }
}
