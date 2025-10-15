package com.banque.pret.ejb;

import com.banque.pret.entity.Remboursement;
import com.banque.pret.repository.RemboursementRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class RemboursementService {

    @Inject
    private RemboursementRepository repo;

    public Remboursement create(Remboursement r) { repo.save(r); return r; }

    public Remboursement getOne(Long id) { return repo.find(id); }

    public List<Remboursement> getAll() { return repo.findAll(); }

    public Remboursement update(Remboursement r) { return repo.update(r); }

    public boolean delete(Long id) { return repo.delete(id); }
}
