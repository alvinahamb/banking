package com.banque.pret.ejb;

import com.banque.pret.entity.Pret;
import com.banque.pret.repository.PretRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class PretService {

    @Inject
    private PretRepository repo;

    public Pret create(Pret p) { repo.save(p); return p; }

    public Pret getOne(Long id) { return repo.find(id); }

    public List<Pret> getAll() { return repo.findAll(); }

    public Pret update(Pret p) { return repo.update(p); }

    public boolean delete(Long id) { return repo.delete(id); }
}
