package com.BikeWale.BikeWale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.BikeWale.BikeWale.entity.ApiResponse;
import com.BikeWale.BikeWale.entity.Enquiry;
import com.BikeWale.BikeWale.service.EnquiryService;


@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

    @Autowired
    private EnquiryService service;

    @PostMapping
    public ApiResponse<Enquiry> saveEnquiry(@RequestBody Enquiry enquiry) {
        return service.saveEnquiry(enquiry);
    }

    @GetMapping("/{id}")
    public ApiResponse<Enquiry> getEnquiry(@PathVariable int id) {
        return service.getEnquiryById(id);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteEnquiry(@PathVariable int id) {
        return service.deleteEnquiry(id);
    }

    @PutMapping("/{id}")
    public ApiResponse<Enquiry> updateEnquiry(
            @PathVariable int id,
            @RequestBody Enquiry enquiry) {
        return service.updateEnquiry(id, enquiry);
    }
}

