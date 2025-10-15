package com.banque.pret.repository;

import com.banque.pret.entity.Remboursement;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class RemboursementRepository {

    @PersistenceContext(unitName = "RemboursementPU")
    private EntityManager em;

    public void save(Remboursement r) { em.persist(r); }

    public Remboursement find(Long id) { return em.find(Remboursement.class, id); }

    public List<Remboursement> findAll() {
        return em.createQuery("SELECT r FROM Remboursement r", Remboursement.class).getResultList();
    }

    public Remboursement update(Remboursement r) { return em.merge(r); }

    public boolean delete(Long id) {
        Remboursement r = em.find(Remboursement.class, id);
        if (r != null) {
            em.remove(r);
            return true;
        }
        return false;
    }
}
