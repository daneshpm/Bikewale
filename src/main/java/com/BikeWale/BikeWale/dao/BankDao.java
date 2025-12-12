package com.BikeWale.BikeWale.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BikeWale.BikeWale.entity.Bank;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

@Repository
public class BankDao {

    @Autowired
    EntityManagerFactory vikas;

    public String saveBank(Bank bank) {
        EntityManager em = vikas.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(bank);
        et.commit();
        return "Bank saved";
    }

    public Bank findById(int id) {
        EntityManager em = vikas.createEntityManager();
        return em.find(Bank.class, id);
    }

    public List<Bank> findByName(String name) {
        EntityManager em = vikas.createEntityManager();
        Query q = em.createQuery("select b from Bank b where b.name=?1");
        q.setParameter(1, name);
        return q.getResultList();
    }

    public String updateBank(Bank bank) {
        EntityManager em = vikas.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(bank);
        et.commit();
        return "Bank updated";
    }

    public String deleteBank(int id) {
        EntityManager em = vikas.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Bank bank = em.find(Bank.class, id);
        if (bank == null) return "Bank not found";

        et.begin();
        em.remove(bank);
        et.commit();
        return "Bank deleted";
    }
}
