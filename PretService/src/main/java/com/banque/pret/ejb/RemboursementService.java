package com.banque.pret.ejb;

import com.banque.pret.entity.*;
import com.banque.pret.repository.*;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class RemboursementService {

    @Inject
    private RemboursementRepository repo;
    @Inject
    private StatusPretRepository statusRepo;
    @Inject
    private EcheanceRepository echeanceRepo;

    public Remboursement create(Remboursement r) { 
        Echeance echeance = r.getEcheance();
        StatusPret statusPret = statusRepo.findByLibelle("paye");
        echeance.setStatusPret(statusPret);
        System.out.println("Echeance ID: " + echeance.getIdEcheance() + ", Current Status: " + echeance.getStatusPret().getLibelle());
        System.out.println(statusPret.getLibelle());
        // echeanceRepo.update(echeance);
        repo.save(r); return r; 
    }

    public Remboursement getOne(Long id) { return repo.find(id); }

    public List<Remboursement> getAll() { return repo.findAll(); }

    public Remboursement update(Remboursement r) { return repo.update(r); }

    public boolean delete(Long id) { return repo.delete(id); }
}
