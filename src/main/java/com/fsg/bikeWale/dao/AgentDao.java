package com.fsg.bikeWale.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fsg.bikeWale.entity.Agent;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

@Repository
public class AgentDao {

    @Autowired
    EntityManagerFactory vikas;

    public String saveAgent(Agent agent) {
        EntityManager em = vikas.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(agent);
        et.commit();
        return "Agent saved";
    }

    public Agent findById(int id) {
        EntityManager em = vikas.createEntityManager();
        return em.find(Agent.class, id);
    }

    public List<Agent> findByName(String name) {
        EntityManager em = vikas.createEntityManager();
        Query q = em.createQuery("select a from Agent a where a.name=?1");
        q.setParameter(1, name);
        return q.getResultList();
    }

    public String updateAgent(Agent agent) {
        EntityManager em = vikas.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(agent);
        et.commit();
        return "Agent updated";
    }

    public String deleteAgent(int id) {
        EntityManager em = vikas.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Agent agent = em.find(Agent.class, id);
        if (agent == null) return "Agent not found";

        et.begin();
        em.remove(agent);
        et.commit();
        return "Agent deleted";
    }
}
