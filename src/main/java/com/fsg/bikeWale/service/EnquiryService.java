package com.fsg.bikeWale.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fsg.bikeWale.entity.Enquiry;
import com.fsg.bikeWale.exception.IDNotPresentException;
import com.fsg.bikeWale.exception.InvalidInputException;
import com.fsg.bikeWale.exception.RelationNotFoundException;
import com.fsg.bikeWale.repo.Bikerepo;
import com.fsg.bikeWale.repo.Enquriyrepo;

@Service
public class EnquiryService {

	@Autowired
	private Enquriyrepo repo;

	public Enquiry save(Enquiry enquiry) {
		return repo.save(enquiry);
	}

	public Enquiry getById(int id) {
		return repo.findById(id).orElseThrow(() -> new IDNotPresentException("Enquiry not found " + id));
	}

	public Enquiry update(int id, Enquiry enquiry) {
		Enquiry db = getById(id);
		db.setUser(enquiry.getUser());
		db.setBike(enquiry.getBike());
		db.setStatus(enquiry.getStatus());
		return repo.save(db);
	}

	public void delete(int id) {
		repo.delete(getById(id));
	}
}
