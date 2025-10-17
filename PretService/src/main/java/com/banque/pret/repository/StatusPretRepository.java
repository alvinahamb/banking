package com.banque.pret.repository;

import com.banque.pret.entity.StatusPret;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class StatusPretRepository {
    @PersistenceContext(unitName = "StatusPretPU")
    private EntityManager em;

    public void save(StatusPret type) {
        em.persist(type);
    }

    public StatusPret find(Long id) {
        return em.find(StatusPret.class, id);
    }

    public List<StatusPret> findAll() {
        return em.createQuery("SELECT s FROM StatusPret s", StatusPret.class).getResultList();
    }

    public StatusPret update(StatusPret type) {
        return em.merge(type);
    }

    public boolean delete(Long id) {
        StatusPret s = em.find(StatusPret.class, id);
        if (s != null) {
            em.remove(s);
            return true;
        }
        return false;
    }

     public StatusPret findByLibelle(String libelle) {
        List<StatusPret> result = em.createQuery("SELECT s FROM StatusPret s WHERE s.libelle = :libelle", StatusPret.class)
                .setParameter("libelle", libelle)
                .getResultList();
        return result.isEmpty() ? null : result.get(0);
    }
}
