package com.banque.courant.ejb;

import com.banque.courant.entity.CompteCourant;
import com.banque.courant.repository.CompteCourantRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class CompteCourantService {

    @Inject
    private CompteCourantRepository repo;

    public CompteCourant create(CompteCourant compte) {
        repo.save(compte);
        return compte;
    }

    public CompteCourant getOne(Long id) {
        return repo.find(id);
    }

    public List<CompteCourant> getAll() {
        return repo.findAll();
    }

    public CompteCourant update(CompteCourant compte) {
        return repo.update(compte);
    }

    public boolean delete(Long id) {
        return repo.delete(id);
    }
}
