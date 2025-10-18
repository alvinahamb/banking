package com.banque.pret.repository.client;

import com.banque.pret.entity.client.HistoriqueClients;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class HistoriqueClientsRepository {

    @PersistenceContext(unitName = "HistoriqueClientsPU")
    private EntityManager em;

    public void save(HistoriqueClients h) { em.persist(h); }

    public HistoriqueClients find(Long id) { return em.find(HistoriqueClients.class, id); }

    public List<HistoriqueClients> findAll() {
        return em.createQuery("SELECT h FROM HistoriqueClients h", HistoriqueClients.class).getResultList();
    }

    public HistoriqueClients update(HistoriqueClients h) { return em.merge(h); }

    public boolean delete(Long id) {
        HistoriqueClients h = em.find(HistoriqueClients.class, id);
        if (h != null) {
            em.remove(h);
            return true;
        }
        return false;
    }

    public HistoriqueClients findLatestByClientId(Long clientId) {
        List<HistoriqueClients> results = em.createQuery(
                "SELECT h FROM HistoriqueClients h WHERE h.client.idClients = :clientId ORDER BY h.date_changement DESC",
                HistoriqueClients.class)
                .setParameter("clientId", clientId)
                .setMaxResults(1)
                .getResultList();
        return results.isEmpty() ? null : results.get(0);
    }
}
