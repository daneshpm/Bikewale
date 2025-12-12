package com.BikeWale.BikeWale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.BikeWale.BikeWale.entity.Tax;
import com.BikeWale.BikeWale.service.TaxService;
import com.BikeWale.BikeWale.entity.ApiResponse;
import java.util.List;

@RestController
@RequestMapping("/tax")
public class TaxController {

    @Autowired
    private TaxService service;

    @PostMapping
    public ApiResponse<Tax> saveTax(@RequestBody Tax tax) {
        return service.saveTax(tax);
    }

    @GetMapping("/{id}")
    public ApiResponse<Tax> getTax(@PathVariable int id) {
        return service.getTaxById(id);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteTax(@PathVariable int id) {
        return service.deleteTax(id);
    }

    @PutMapping("/{id}")
    public ApiResponse<Tax> updateTax(
            @PathVariable int id,
            @RequestBody Tax tax) {
        return service.updateTax(id, tax);
    }
}

