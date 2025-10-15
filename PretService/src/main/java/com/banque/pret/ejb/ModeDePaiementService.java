package com.banque.pret.ejb;

import com.banque.pret.entity.ModeDePaiement;
import com.banque.pret.repository.ModeDePaiementRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class ModeDePaiementService {
    @Inject
    private ModeDePaiementRepository repo;

    public ModeDePaiement create(ModeDePaiement t) { repo.save(t); return t; }

    public ModeDePaiement getOne(Long id) { return repo.find(id); }

    public List<ModeDePaiement> getAll() { return repo.findAll(); }

    public ModeDePaiement update(ModeDePaiement t) { return repo.update(t); }

    public boolean delete(Long id) { return repo.delete(id); }
}
