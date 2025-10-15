package com.banque.pret.repository;

import com.banque.pret.entity.TypePret;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class TypePretRepository {
    @PersistenceContext(unitName = "TypePretPU")
    private EntityManager em;

    public void save(TypePret type) {
        em.persist(type);
    }

    public TypePret find(Long id) {
        return em.find(TypePret.class, id);
    }

    public List<TypePret> findAll() {
        return em.createQuery("SELECT t FROM TypePret t", TypePret.class).getResultList();
    }

    public TypePret update(TypePret type) {
        return em.merge(type);
    }

    public boolean delete(Long id) {
        TypePret t = em.find(TypePret.class, id);
        if (t != null) {
            em.remove(t);
            return true;
        }
        return false;
    }
}
