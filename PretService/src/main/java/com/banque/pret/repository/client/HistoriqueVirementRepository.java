package com.banque.pret.repository.client;

import com.banque.pret.entity.client.HistoriqueVirement;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class HistoriqueVirementRepository {

    @PersistenceContext(unitName = "HistoriqueVirementPU")
    private EntityManager em;

    public void create(HistoriqueVirement virement) {
        em.persist(virement);
    }

    public HistoriqueVirement find(Long id) {
        return em.find(HistoriqueVirement.class, id);
    }

    public List<HistoriqueVirement> findAll() {
        return em.createQuery("SELECT v FROM HistoriqueVirement v", HistoriqueVirement.class)
                 .getResultList();
    }

    public HistoriqueVirement update(HistoriqueVirement virement) {
        return em.merge(virement);
    }

    public void delete(Long id) {
        HistoriqueVirement v = em.find(HistoriqueVirement.class, id);
        if (v != null) {
            em.remove(v);
        }
    }
}
