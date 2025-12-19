package com.fsg.bikeWale.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fsg.bikeWale.entity.Tax;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

@Repository
public class TaxDao {

    @Autowired
    EntityManagerFactory vikas;

    public String saveTax(Tax tax) {
        EntityManager em = vikas.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(tax);
        et.commit();
        return "Tax saved";
    }

    public Tax findById(int id) {
        EntityManager em = vikas.createEntityManager();
        return em.find(Tax.class, id);
    }

    public List<Tax> findByTaxName(String taxname) {
        EntityManager em = vikas.createEntityManager();
        Query q = em.createQuery("select t from Tax t where t.taxname=?1");
        q.setParameter(1, taxname);
        return q.getResultList();
    }

    public String updateTax(Tax tax) {
        EntityManager em = vikas.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(tax);
        et.commit();
        return "Tax updated";
    }
    public String deleteTax(int id) {
        EntityManager em = vikas.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Tax tax = em.find(Tax.class, id);
        if (tax == null) return "Tax not found";

        et.begin();
        em.remove(tax);
        et.commit();
        return "Tax deleted";
    }
}
