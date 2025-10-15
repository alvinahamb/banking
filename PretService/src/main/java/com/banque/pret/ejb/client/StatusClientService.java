package com.banque.pret.ejb.client;

import com.banque.pret.entity.client.StatusClient;
import com.banque.pret.repository.client.StatusClientRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class StatusClientService {

    @Inject
    private StatusClientRepository repo;

    public StatusClient create(StatusClient s) { repo.save(s); return s; }

    public StatusClient getOne(Long id) { return repo.find(id); }

    public List<StatusClient> getAll() { return repo.findAll(); }

    public StatusClient update(StatusClient s) { return repo.update(s); }

    public boolean delete(Long id) { return repo.delete(id); }
}
