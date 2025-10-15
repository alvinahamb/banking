package com.banque.courant.repository;

import com.banque.courant.entity.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class StatusRepository {
    @PersistenceContext(unitName = "StatusPU")
    private EntityManager em;

    public void save(Status type) {
        em.persist(type);
    }

    public Status find(Long id) {
        return em.find(Status.class, id);
    }

    public List<Status> findAll() {
        return em.createQuery("SELECT s FROM Status s", Status.class).getResultList();
    }

    public Status update(Status type) {
        return em.merge(type);
    }

    public boolean delete(Long id) {
        Status s = em.find(Status.class, id);
        if (s != null) {
            em.remove(s);
            return true;
        }
        return false;
    }
}
