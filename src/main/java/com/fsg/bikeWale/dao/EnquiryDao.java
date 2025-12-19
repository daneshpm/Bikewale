package com.fsg.bikeWale.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fsg.bikeWale.entity.Enquiry;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

@Repository
public class EnquiryDao {

    @Autowired
    EntityManagerFactory vikas;

    public String saveEnquiry(Enquiry enquiry) {
        EntityManager em = vikas.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(enquiry);
        et.commit();
        return "Enquiry saved";
    }

    public Enquiry findById(int id) {
        EntityManager em = vikas.createEntityManager();
        return em.find(Enquiry.class, id);
    }

    public List<Enquiry> findByStatus(String status) {
        EntityManager em = vikas.createEntityManager();
        Query q = em.createQuery("select e from Enquiry e where e.status=?1");
        q.setParameter(1, status);
        return q.getResultList();
    }

    public String updateEnquiry(Enquiry enquiry) {
        EntityManager em = vikas.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(enquiry);
        et.commit();
        return "Enquiry updated";
    }

    public String deleteEnquiry(int id) {
        EntityManager em = vikas.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Enquiry enquiry = em.find(Enquiry.class, id);
        if (enquiry == null) return "Enquiry not found";

        et.begin();
        em.remove(enquiry);
        et.commit();
        return "Enquiry deleted";
    }
}
