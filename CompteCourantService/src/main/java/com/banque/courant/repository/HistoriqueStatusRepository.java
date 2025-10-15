package com.banque.courant.repository;

import com.banque.courant.entity.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class HistoriqueStatusRepository {
    @PersistenceContext(unitName = "HistoriqueStatusPU")
    private EntityManager em;

    public void save(HistoriqueStatus type) {
        em.persist(type);
    }

    public HistoriqueStatus find(Long id) {
        return em.find(HistoriqueStatus.class, id);
    }

    public List<HistoriqueStatus> findAll() {
        return em.createQuery("SELECT s FROM HistoriqueStatus s", HistoriqueStatus.class).getResultList();
    }

    public HistoriqueStatus update(HistoriqueStatus type) {
        return em.merge(type);
    }

    public boolean delete(Long id) {
        HistoriqueStatus s = em.find(HistoriqueStatus.class, id);
        if (s != null) {
            em.remove(s);
            return true;
        }
        return false;
    }
}
