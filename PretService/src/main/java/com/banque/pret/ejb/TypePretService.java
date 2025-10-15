package com.banque.pret.ejb;

import com.banque.pret.entity.TypePret;
import com.banque.pret.repository.TypePretRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class TypePretService {
    @Inject
    private TypePretRepository repo;

    public TypePret create(TypePret t) { repo.save(t); return t; }

    public TypePret getOne(Long id) { return repo.find(id); }

    public List<TypePret> getAll() { return repo.findAll(); }

    public TypePret update(TypePret t) { return repo.update(t); }

    public boolean delete(Long id) { return repo.delete(id); }
}
