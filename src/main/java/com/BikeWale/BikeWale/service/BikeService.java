package com.BikeWale.BikeWale.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikeWale.BikeWale.entity.Agent;
import com.BikeWale.BikeWale.entity.ApiResponse;
import com.BikeWale.BikeWale.entity.Bike;
import com.BikeWale.BikeWale.entity.Tax;
import com.BikeWale.BikeWale.exception.DuplicateEntryException;
import com.BikeWale.BikeWale.exception.IDNotPresentException;
import com.BikeWale.BikeWale.exception.InvalidInputException;
import com.BikeWale.BikeWale.exception.RelationNotFoundException;
import com.BikeWale.BikeWale.repo.Agentrepo;
import com.BikeWale.BikeWale.repo.Bikerepo;
import com.BikeWale.BikeWale.repo.Taxrepo;

@Service
public class BikeService {

    @Autowired
    private Bikerepo repo;

    @Autowired
    private Agentrepo agentRepo;

    @Autowired
    private Taxrepo taxRepo;


    // ⬛ CREATE
    public ApiResponse<Bike> saveBike(Bike bike) {

        if (repo.existsById(bike.getId())) {
            throw new DuplicateEntryException("Bike with ID " + bike.getId() + " already exists");
        }

        if (bike.getCost() <= 0) {
            throw new InvalidInputException("Bike cost must be greater than 0");
        }

        // Validate relationships
        validateRelations(bike);

        Bike saved = repo.save(bike);

        ApiResponse<Bike> resp = new ApiResponse<>();
        resp.setStatusCode(201);
        resp.setMessage("Bike Created");
        resp.setData(saved);
        return resp;
    }


    // ⬛ GET
    public ApiResponse<Bike> getBikeById(int id) {

        Optional<Bike> opt = repo.findById(id);

        if (opt.isEmpty()) {
            throw new IDNotPresentException("Bike ID " + id + " not found");
        }

        ApiResponse<Bike> resp = new ApiResponse<>();
        resp.setStatusCode(200);
        resp.setMessage("Success");
        resp.setData(opt.get());
        return resp;
    }


    // ⬛ DELETE
    public ApiResponse<String> deleteBike(int id) {

        if (!repo.existsById(id)) {
            throw new IDNotPresentException("Bike ID " + id + " not found to delete");
        }

        repo.deleteById(id);

        ApiResponse<String> resp = new ApiResponse<>();
        resp.setStatusCode(200);
        resp.setMessage("Deleted");
        resp.setData("Bike deleted: " + id);

        return resp;
    }


    // ⬛ UPDATE
    public ApiResponse<Bike> updateBike(int id, Bike newData) {

        Optional<Bike> opt = repo.findById(id);

        if (opt.isEmpty()) {
            throw new IDNotPresentException("Bike ID " + id + " not found to update");
        }

        Bike old = opt.get();

        if (newData.getCost() <= 0) {
            throw new InvalidInputException("Bike cost must be greater than 0");
        }

        validateRelations(newData);

        old.setName(newData.getName());
        old.setBrand(newData.getBrand());
        old.setCost(newData.getCost());
        old.setCc(newData.getCc());
        old.setMilege(newData.getMilege());
        old.setAgent(newData.getAgent());
        old.setTax(newData.getTax());

        Bike updated = repo.save(old);

        ApiResponse<Bike> resp = new ApiResponse<>();
        resp.setStatusCode(200);
        resp.setMessage("Updated");
        resp.setData(updated);

        return resp;
    }



    // ⬛ RELATIONSHIP VALIDATOR
    private void validateRelations(Bike bike) {

        if (bike.getAgent() == null ||
            !agentRepo.existsById(bike.getAgent().getId())) {
            throw new RelationNotFoundException("Agent not found");
        }

        if (bike.getTax() == null ||
            !taxRepo.existsById(bike.getTax().getId())) {
            throw new RelationNotFoundException("Tax not found");
        }
    }
}

