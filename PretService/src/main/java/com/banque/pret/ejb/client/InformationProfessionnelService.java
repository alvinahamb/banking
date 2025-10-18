package com.banque.pret.ejb.client;

import com.banque.pret.entity.client.InformationProfessionnel;
import com.banque.pret.repository.client.InformationProfessionnelRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.List;

@Stateless
public class InformationProfessionnelService {

    @Inject
    private InformationProfessionnelRepository repo;

    public InformationProfessionnel create(InformationProfessionnel i) { 
        i.setDate_changement(LocalDate.now());
        repo.save(i); return i; }

    public InformationProfessionnel getOne(Long id) { return repo.find(id); }

    public List<InformationProfessionnel> getAll() { return repo.findAll(); }

    public InformationProfessionnel update(InformationProfessionnel i) { return repo.update(i); }

    public boolean delete(Long id) { return repo.delete(id); }
}
