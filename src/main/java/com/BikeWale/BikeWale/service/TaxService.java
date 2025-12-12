package com.BikeWale.BikeWale.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikeWale.BikeWale.entity.ApiResponse;
import com.BikeWale.BikeWale.entity.Tax;
import com.BikeWale.BikeWale.exception.IDNotPresentException;
import com.BikeWale.BikeWale.exception.InvalidInputException;
import com.BikeWale.BikeWale.exception.RelationNotFoundException;
import com.BikeWale.BikeWale.repo.Bankrepo;
import com.BikeWale.BikeWale.repo.Taxrepo;


@Service
public class TaxService {

    @Autowired
    private Taxrepo repo;

    @Autowired
    private Bankrepo bankRepo;

    // CREATE
    public ApiResponse<Tax> saveTax(Tax tax) {

        if (!bankRepo.existsById(tax.getBank().getId())) {
            throw new RelationNotFoundException("Bank not found for tax");
        }

        if (tax.getPercentage() <= 0) {
            throw new InvalidInputException("Percentage must be positive");
        }

        Tax saved = repo.save(tax);

        ApiResponse<Tax> resp = new ApiResponse<>();
        resp.setStatusCode(201);
        resp.setMessage("Tax Created");
        resp.setData(saved);

        return resp;
    }

    // GET
    public ApiResponse<Tax> getTaxById(int id) {

        Optional<Tax> opt = repo.findById(id);

        if (opt.isEmpty()) {
            throw new IDNotPresentException("Tax ID not found");
        }

        ApiResponse<Tax> resp = new ApiResponse<>();
        resp.setStatusCode(200);
        resp.setMessage("Success");
        resp.setData(opt.get());

        return resp;
    }

    // DELETE
    public ApiResponse<String> deleteTax(int id) {

        if (!repo.existsById(id)) {
            throw new IDNotPresentException("Tax ID not found");
        }

        repo.deleteById(id);

        ApiResponse<String> resp = new ApiResponse<>();
        resp.setStatusCode(200);
        resp.setMessage("Deleted");
        resp.setData("Tax deleted");

        return resp;
    }

    // UPDATE
    public ApiResponse<Tax> updateTax(int id, Tax newData) {

        Optional<Tax> opt = repo.findById(id);

        if (opt.isEmpty()) {
            throw new IDNotPresentException("Tax ID not found for update");
        }

        Tax old = opt.get();

        if (newData.getPercentage() <= 0) {
            throw new InvalidInputException("Percentage must be > 0");
        }

        if (!bankRepo.existsById(newData.getBank().getId())) {
            throw new RelationNotFoundException("Bank not found for tax update");
        }

        old.setTaxname(newData.getTaxname());
        old.setPercentage(newData.getPercentage());
        old.setBank(newData.getBank());

        Tax updated = repo.save(old);

        ApiResponse<Tax> resp = new ApiResponse<>();
        resp.setStatusCode(200);
        resp.setMessage("Updated");
        resp.setData(updated);

        return resp;
    }
}
