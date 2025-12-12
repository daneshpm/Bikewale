package com.BikeWale.BikeWale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.BikeWale.BikeWale.entity.ApiResponse;
import com.BikeWale.BikeWale.entity.Bike;
import com.BikeWale.BikeWale.service.BikeService;

@RestController
@RequestMapping("/bike")
public class BikeController {

    @Autowired
    private BikeService service;

    @PostMapping
    public ApiResponse<Bike> saveBike(@RequestBody Bike bike) {
        return service.saveBike(bike);
    }

    @GetMapping("/{id}")
    public ApiResponse<Bike> getBike(@PathVariable int id) {
        return service.getBikeById(id);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteBike(@PathVariable int id) {
        return service.deleteBike(id);
    }

    @PutMapping("/{id}")
    public ApiResponse<Bike> updateBike(
            @PathVariable int id,
            @RequestBody Bike bike) {

        return service.updateBike(id, bike);
    }
}

