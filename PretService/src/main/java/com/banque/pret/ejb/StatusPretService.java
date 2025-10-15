package com.banque.pret.ejb;

import com.banque.pret.entity.StatusPret;
import com.banque.pret.repository.StatusPretRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class StatusPretService {
    @Inject
    private StatusPretRepository repo;

    public StatusPret create(StatusPret t) { repo.save(t); return t; }

    public StatusPret getOne(Long id) { return repo.find(id); }

    public List<StatusPret> getAll() { return repo.findAll(); }

    public StatusPret update(StatusPret t) { return repo.update(t); }

    public boolean delete(Long id) { return repo.delete(id); }
}
