package com.BikeWale.BikeWale.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.BikeWale.BikeWale.entity.Bike;

public interface Bikerepo extends JpaRepository<Bike,Integer>{

}
