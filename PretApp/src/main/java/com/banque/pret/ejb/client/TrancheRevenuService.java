package com.banque.pret.ejb.client;

import com.banque.pret.entity.client.TrancheRevenu;
import com.banque.pret.repository.client.TrancheRevenuRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class TrancheRevenuService {

    @Inject
    private TrancheRevenuRepository repo;

    public TrancheRevenu create(TrancheRevenu t) { repo.save(t); return t; }

    public TrancheRevenu getOne(Long id) { return repo.find(id); }

    public List<TrancheRevenu> getAll() { return repo.findAll(); }

    public TrancheRevenu update(TrancheRevenu t) { return repo.update(t); }

    public boolean delete(Long id) { return repo.delete(id); }
}
