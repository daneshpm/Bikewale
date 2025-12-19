package com.fsg.bikeWale.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsg.bikeWale.entity.Bike;

public interface Bikerepo extends JpaRepository<Bike,Integer>{

}
