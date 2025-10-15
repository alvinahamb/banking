package com.banque.pret.repository;

import com.banque.pret.entity.HistoriquePret;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class HistoriquePretRepository {

    @PersistenceContext(unitName = "HistoriquePretPU")
    private EntityManager em;

    public void save(HistoriquePret h) { em.persist(h); }

    public HistoriquePret find(Long id) { return em.find(HistoriquePret.class, id); }

    public List<HistoriquePret> findAll() {
        return em.createQuery("SELECT h FROM HistoriquePret h", HistoriquePret.class).getResultList();
    }

    public HistoriquePret update(HistoriquePret h) { return em.merge(h); }

    public boolean delete(Long id) {
        HistoriquePret h = em.find(HistoriquePret.class, id);
        if (h != null) {
            em.remove(h);
            return true;
        }
        return false;
    }
}
