package com.banque.pret.repository;

import com.banque.pret.entity.Echeance;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class EcheanceRepository {

    @PersistenceContext(unitName = "EcheancePU")
    private EntityManager em;

    public void save(Echeance e) { em.persist(e); }

    public Echeance find(Long id) { return em.find(Echeance.class, id); }

    public List<Echeance> findAll() {
        return em.createQuery("SELECT e FROM Echeance e", Echeance.class).getResultList();
    }

    public Echeance update(Echeance e) { return em.merge(e); }

    public boolean delete(Long id) {
        Echeance e = em.find(Echeance.class, id);
        if (e != null) {
            em.remove(e);
            return true;
        }
        return false;
    }
}
