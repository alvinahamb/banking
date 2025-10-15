package com.banque.pret.repository;

import com.banque.pret.entity.ModeDePaiement;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ModeDePaiementRepository {
    @PersistenceContext(unitName = "ModeDePaiementPU")
    private EntityManager em;

    public void save(ModeDePaiement type) {
        em.persist(type);
    }

    public ModeDePaiement find(Long id) {
        return em.find(ModeDePaiement.class, id);
    }

    public List<ModeDePaiement> findAll() {
        return em.createQuery("SELECT m FROM ModeDePaiement m", ModeDePaiement.class).getResultList();
    }

    public ModeDePaiement update(ModeDePaiement type) {
        return em.merge(type);
    }

    public boolean delete(Long id) {
        ModeDePaiement m = em.find(ModeDePaiement.class, id);
        if (m != null) {
            em.remove(m);
            return true;
        }
        return false;
    }
}
