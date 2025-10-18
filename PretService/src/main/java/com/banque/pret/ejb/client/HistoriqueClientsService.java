package com.banque.pret.ejb.client;

import com.banque.pret.entity.client.HistoriqueClients;
import com.banque.pret.repository.client.HistoriqueClientsRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class HistoriqueClientsService {

    @Inject
    private HistoriqueClientsRepository repo;

    public HistoriqueClients create(HistoriqueClients h) { repo.save(h); return h; }

    public HistoriqueClients getOne(Long id) { return repo.find(id); }

    public List<HistoriqueClients> getAll() { return repo.findAll(); }

    public HistoriqueClients update(HistoriqueClients h) { return repo.update(h); }

    public boolean delete(Long id) { return repo.delete(id); }

    public HistoriqueClients getLatestByClientId(Long clientId) {
        return repo.findLatestByClientId(clientId);
    }
}
