package com.banque.pret.ejb.client;

import com.banque.pret.entity.client.Clients;
import com.banque.pret.repository.client.ClientsRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class ClientsService {

    @Inject
    private ClientsRepository repo;

    public Clients create(Clients c) { repo.save(c); return c; }

    public Clients getOne(Long id) { return repo.find(id); }

    public List<Clients> getAll() { return repo.findAll(); }

    public Clients update(Clients c) { return repo.update(c); }

    public boolean delete(Long id) { return repo.delete(id); }
}
