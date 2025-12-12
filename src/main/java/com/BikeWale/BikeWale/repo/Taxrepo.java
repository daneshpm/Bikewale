package com.BikeWale.BikeWale.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikeWale.BikeWale.entity.Tax;

public interface Taxrepo extends JpaRepository<Tax, Integer> {

}
