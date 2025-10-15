package com.banque.courant.repository;

import com.banque.courant.entity.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class CompteCourantRepository {
    @PersistenceContext(unitName = "CompteCourantPU")
    private EntityManager em;

    public void save(CompteCourant type) {
        em.persist(type);
    }

    public CompteCourant find(Long id) {
        return em.find(CompteCourant.class, id);
    }

    public List<CompteCourant> findAll() {
        return em.createQuery("SELECT s FROM CompteCourant s", CompteCourant.class).getResultList();
    }

    public CompteCourant update(CompteCourant type) {
        return em.merge(type);
    }

    public boolean delete(Long id) {
        CompteCourant s = em.find(CompteCourant.class, id);
        if (s != null) {
            em.remove(s);
            return true;
        }
        return false;
    }
}
