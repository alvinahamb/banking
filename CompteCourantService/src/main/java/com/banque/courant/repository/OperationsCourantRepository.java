package com.banque.courant.repository;

import com.banque.courant.entity.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class OperationsCourantRepository {
    @PersistenceContext(unitName = "OperationsCourantPU")
    private EntityManager em;

    public void save(OperationsCourant type) {
        em.persist(type);
    }

    public OperationsCourant find(Long id) {
        return em.find(OperationsCourant.class, id);
    }

    public List<OperationsCourant> findAll() {
        return em.createQuery("SELECT s FROM OperationsCourant s", OperationsCourant.class).getResultList();
    }

    public OperationsCourant update(OperationsCourant type) {
        return em.merge(type);
    }

    public boolean delete(Long id) {
        OperationsCourant s = em.find(OperationsCourant.class, id);
        if (s != null) {
            em.remove(s);
            return true;
        }
        return false;
    }
}
