package com.BikeWale.BikeWale.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BikeWale.BikeWale.entity.Bike;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

@Repository
public class BikeDao {

    @Autowired
    EntityManagerFactory vikas;

    public String saveBike(Bike bike) {
        EntityManager em = vikas.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(bike);
        et.commit();
        return "Bike saved";
    }

    public Bike findById(int id) {
        EntityManager em = vikas.createEntityManager();
        return em.find(Bike.class, id);
    }

    public List<Bike> findByBrand(String brand) {
        EntityManager em = vikas.createEntityManager();
        Query q = em.createQuery("select b from Bike b where b.brand=?1");
        q.setParameter(1, brand);
        return q.getResultList();
    }

    public String updateBike(Bike bike) {
        EntityManager em = vikas.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(bike);
        et.commit();
        return "Bike updated";
    }

    public String deleteBike(int id) {
        EntityManager em = vikas.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Bike bike = em.find(Bike.class, id);
        if (bike == null) return "Bike not found";

        et.begin();
        em.remove(bike);
        et.commit();
        return "Bike deleted";
    }
}
