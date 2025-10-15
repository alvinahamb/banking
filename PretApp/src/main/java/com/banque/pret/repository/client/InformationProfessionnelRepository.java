package com.banque.pret.repository.client;

import com.banque.pret.entity.client.InformationProfessionnel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class InformationProfessionnelRepository {

    @PersistenceContext(unitName = "InformationProfessionnelPU")
    private EntityManager em;

    public void save(InformationProfessionnel i) { em.persist(i); }

    public InformationProfessionnel find(Long id) { return em.find(InformationProfessionnel.class, id); }

    public List<InformationProfessionnel> findAll() {
        return em.createQuery("SELECT i FROM InformationProfessionnel i", InformationProfessionnel.class).getResultList();
    }

    public InformationProfessionnel update(InformationProfessionnel i) { return em.merge(i); }

    public boolean delete(Long id) {
        InformationProfessionnel i = em.find(InformationProfessionnel.class, id);
        if (i != null) {
            em.remove(i);
            return true;
        }
        return false;
    }
}
