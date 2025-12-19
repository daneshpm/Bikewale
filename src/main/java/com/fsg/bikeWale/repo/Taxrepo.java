package com.fsg.bikeWale.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsg.bikeWale.entity.Tax;

public interface Taxrepo extends JpaRepository<Tax, Integer> {

}
