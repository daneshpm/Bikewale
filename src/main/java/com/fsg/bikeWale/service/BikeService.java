package com.fsg.bikeWale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsg.bikeWale.entity.Bike;
import com.fsg.bikeWale.exception.IDNotPresentException;
import com.fsg.bikeWale.repo.Bikerepo;

@Service
public class BikeService {

	@Autowired
	private Bikerepo repo;

	// CREATE
	public Bike save(Bike bike) {
		return repo.save(bike);
	}

	// READ
	public Bike getById(int id) {
		return repo.findById(id).orElseThrow(() -> new IDNotPresentException("Bike not found with id " + id));
	}

	// UPDATE
	public Bike update(int id, Bike bike) {

		Bike dbBike = repo.findById(id).orElseThrow(() -> new IDNotPresentException("Bike not found with id " + id));

		dbBike.setName(bike.getName());
		dbBike.setBrand(bike.getBrand());
		dbBike.setCost(bike.getCost());
		dbBike.setCc(bike.getCc());
		dbBike.setMilege(bike.getMilege());
		dbBike.setAgent(bike.getAgent());
		dbBike.setTax(bike.getTax());

		return repo.save(dbBike);
	}

	// DELETE
	public void delete(int id) {
		if (!repo.existsById(id)) {
			throw new IDNotPresentException("Bike not found with id " + id);
		}
		repo.deleteById(id);
	}
}
