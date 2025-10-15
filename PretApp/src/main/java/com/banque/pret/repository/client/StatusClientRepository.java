package com.banque.pret.repository.client;

import com.banque.pret.entity.client.StatusClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class StatusClientRepository {

    @PersistenceContext(unitName = "StatusClientPU")
    private EntityManager em;

    public void save(StatusClient s) { em.persist(s); }

    public StatusClient find(Long id) { return em.find(StatusClient.class, id); }

    public List<StatusClient> findAll() {
        return em.createQuery("SELECT s FROM StatusClient s", StatusClient.class).getResultList();
    }

    public StatusClient update(StatusClient s) { return em.merge(s); }

    public boolean delete(Long id) {
        StatusClient s = em.find(StatusClient.class, id);
        if (s != null) {
            em.remove(s);
            return true;
        }
        return false;
    }
}
