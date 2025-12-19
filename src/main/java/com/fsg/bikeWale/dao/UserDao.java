package com.fsg.bikeWale.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fsg.bikeWale.entity.User_info;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

@Repository
public class UserDao {

    @Autowired
    EntityManagerFactory vikas;

    public String saveUser(User_info user) {
        EntityManager em = vikas.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(user);
        et.commit();
        return "User saved";
    }

    public User_info findById(int id) {
        EntityManager em = vikas.createEntityManager();
        return em.find(User_info.class, id);
    }

    public List<User_info> findByName(String name) {
        EntityManager em = vikas.createEntityManager();
        Query q = em.createQuery("select u from User_info u where u.name=?1");
        q.setParameter(1, name);
        return q.getResultList();
    }

    public String updateUser(User_info user) {
        EntityManager em = vikas.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(user);
        et.commit();
        return "User updated";
    }

    public String deleteUser(int id) {
        EntityManager em = vikas.createEntityManager();
        EntityTransaction et = em.getTransaction();

        User_info u = em.find(User_info.class, id);
        if (u == null) return "User not found";

        et.begin();
        em.remove(u);
        et.commit();
        return "User deleted";
    }
}
