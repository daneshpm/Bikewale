package com.fsg.bikeWale.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fsg.bikeWale.entity.Tax;
import com.fsg.bikeWale.exception.IDNotPresentException;
import com.fsg.bikeWale.exception.InvalidInputException;
import com.fsg.bikeWale.exception.RelationNotFoundException;
import com.fsg.bikeWale.repo.Bankrepo;
import com.fsg.bikeWale.repo.Taxrepo;

@Service
public class TaxService {

	@Autowired
	private Taxrepo repo;

	public Tax save(Tax tax) {
		return repo.save(tax);
	}

	public Tax getById(int id) {
		return repo.findById(id).orElseThrow(() -> new IDNotPresentException("Tax not found " + id));
	}

	public Tax update(int id, Tax tax) {
		Tax db = getById(id);
		db.setTaxname(tax.getTaxname());
		db.setPercentage(tax.getPercentage());
		db.setBank(tax.getBank());
		return repo.save(db);
	}

	public void delete(int id) {
		repo.delete(getById(id));
	}
}
