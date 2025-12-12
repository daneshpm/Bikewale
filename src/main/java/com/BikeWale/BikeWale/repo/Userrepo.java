package com.BikeWale.BikeWale.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikeWale.BikeWale.entity.User_info;

public interface Userrepo extends JpaRepository<User_info,Integer> {
   public List<User_info> findByName(String name);
}
