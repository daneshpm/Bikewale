package com.BikeWale.BikeWale.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikeWale.BikeWale.entity.ApiResponse;
import com.BikeWale.BikeWale.entity.Enquiry;
import com.BikeWale.BikeWale.exception.IDNotPresentException;
import com.BikeWale.BikeWale.exception.InvalidInputException;
import com.BikeWale.BikeWale.exception.RelationNotFoundException;
import com.BikeWale.BikeWale.repo.Bikerepo;
import com.BikeWale.BikeWale.repo.Enquriyrepo;


@Service
public class EnquiryService {

    @Autowired
    private Enquriyrepo repo;

    @Autowired
    private Bikerepo bikeRepo;

    // SAVE
    public ApiResponse<Enquiry> saveEnquiry(Enquiry enquiry) {

        if (enquiry.getCustomername() == null || enquiry.getCustomername().isBlank()) {
            throw new InvalidInputException("Customer name is required");
        }

        if (!bikeRepo.existsById(enquiry.getBike().getId())) {
            throw new RelationNotFoundException("Bike not found for enquiry");
        }

        Enquiry saved = repo.save(enquiry);

        ApiResponse<Enquiry> resp = new ApiResponse<>();
        resp.setStatusCode(201);
        resp.setMessage("Enquiry Created");
        resp.setData(saved);

        return resp;
    }

    // GET
    public ApiResponse<Enquiry> getEnquiryById(int id) {

        Optional<Enquiry> opt = repo.findById(id);

        if (opt.isEmpty()) {
            throw new IDNotPresentException("Enquiry ID not found");
        }

        ApiResponse<Enquiry> resp = new ApiResponse<>();
        resp.setStatusCode(200);
        resp.setMessage("Success");
        resp.setData(opt.get());

        return resp;
    }

    // DELETE
    public ApiResponse<String> deleteEnquiry(int id) {

        if (!repo.existsById(id)) {
            throw new IDNotPresentException("Enquiry ID not found");
        }

        repo.deleteById(id);

        ApiResponse<String> resp = new ApiResponse<>();
        resp.setStatusCode(200);
        resp.setMessage("Deleted");
        resp.setData("Enquiry deleted");

        return resp;
    }

    // UPDATE
    public ApiResponse<Enquiry> updateEnquiry(int id, Enquiry newData) {

        Optional<Enquiry> opt = repo.findById(id);

        if (opt.isEmpty()) {
            throw new IDNotPresentException("Enquiry ID not found for update");
        }

        Enquiry old = opt.get();

        if (newData.getCustomername() == null || newData.getCustomername().isBlank()) {
            throw new InvalidInputException("Customer name cannot be empty");
        }

        if (!bikeRepo.existsById(newData.getBike().getId())) {
            throw new RelationNotFoundException("Bike not found");
        }

        old.setCustomername(newData.getCustomername());
        old.setPhone(newData.getPhone());
        old.setRemarks(newData.getRemarks());
        old.setBike(newData.getBike());

        Enquiry updated = repo.save(old);

        ApiResponse<Enquiry> resp = new ApiResponse<>();
        resp.setStatusCode(200);
        resp.setMessage("Updated");
        resp.setData(updated);

        return resp;
    }
}
