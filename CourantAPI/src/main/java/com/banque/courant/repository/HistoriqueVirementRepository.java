package com.banque.courant.repository;

import com.banque.courant.entity.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class HistoriqueVirementRepository {
    @PersistenceContext(unitName = "HistoriqueVirementPU")
    private EntityManager em;

    public void save(HistoriqueVirement type) {
        em.persist(type);
    }

    public HistoriqueVirement find(Long id) {
        return em.find(HistoriqueVirement.class, id);
    }

    public List<HistoriqueVirement> findAll() {
        return em.createQuery("SELECT s FROM HistoriqueVirement s", HistoriqueVirement.class).getResultList();
    }

    public HistoriqueVirement update(HistoriqueVirement type) {
        return em.merge(type);
    }

    public boolean delete(Long id) {
        HistoriqueVirement s = em.find(HistoriqueVirement.class, id);
        if (s != null) {
            em.remove(s);
            return true;
        }
        return false;
    }
}
