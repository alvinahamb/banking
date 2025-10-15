package com.banque.courant.repository;

import com.banque.courant.entity.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class TypeOperationRepository {
    @PersistenceContext(unitName = "TypeOperationPU")
    private EntityManager em;

    public void save(TypeOperation type) {
        em.persist(type);
    }

    public TypeOperation find(Long id) {
        return em.find(TypeOperation.class, id);
    }

    public List<TypeOperation> findAll() {
        return em.createQuery("SELECT s FROM TypeOperation s", TypeOperation.class).getResultList();
    }

    public TypeOperation update(TypeOperation type) {
        return em.merge(type);
    }

    public boolean delete(Long id) {
        TypeOperation s = em.find(TypeOperation.class, id);
        if (s != null) {
            em.remove(s);
            return true;
        }
        return false;
    }
}
