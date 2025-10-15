package com.banque.pret.repository.client;

import com.banque.pret.entity.client.Clients;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ClientsRepository {

    @PersistenceContext(unitName = "ClientsPU")
    private EntityManager em;

    public void save(Clients c) { em.persist(c); }

    public Clients find(Long id) { return em.find(Clients.class, id); }

    public List<Clients> findAll() {
        return em.createQuery("SELECT c FROM Clients c", Clients.class).getResultList();
    }

    public Clients update(Clients c) { return em.merge(c); }

    public boolean delete(Long id) {
        Clients c = em.find(Clients.class, id);
        if (c != null) {
            em.remove(c);
            return true;
        }
        return false;
    }
}
