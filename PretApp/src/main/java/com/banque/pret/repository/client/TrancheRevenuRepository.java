package com.banque.pret.repository.client;

import com.banque.pret.entity.client.TrancheRevenu;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class TrancheRevenuRepository {

    @PersistenceContext(unitName = "TrancheRevenuPU")
    private EntityManager em;

    public void save(TrancheRevenu t) { em.persist(t); }

    public TrancheRevenu find(Long id) { return em.find(TrancheRevenu.class, id); }

    public List<TrancheRevenu> findAll() {
        return em.createQuery("SELECT t FROM TrancheRevenu t", TrancheRevenu.class).getResultList();
    }

    public TrancheRevenu update(TrancheRevenu t) { return em.merge(t); }

    public boolean delete(Long id) {
        TrancheRevenu t = em.find(TrancheRevenu.class, id);
        if (t != null) {
            em.remove(t);
            return true;
        }
        return false;
    }
}
