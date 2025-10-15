package com.banque.pret.repository;

import com.banque.pret.entity.Pret;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class PretRepository {

    @PersistenceContext(unitName = "PretPU")
    private EntityManager em;

    public void save(Pret pret) {
        em.persist(pret);
    }

    public Pret find(Long id) {
        return em.find(Pret.class, id);
    }

    public List<Pret> findAll() {
        return em.createQuery("SELECT p FROM Pret p", Pret.class).getResultList();
    }

    public Pret update(Pret pret) {
        return em.merge(pret);
    }

    public boolean delete(Long id) {
        Pret p = em.find(Pret.class, id);
        if (p != null) {
            em.remove(p);
            return true;
        }
        return false;
    }
}
