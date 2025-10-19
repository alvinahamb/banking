package com.banque.pret.ejb.client;

import com.banque.pret.entity.client.*;
import com.banque.pret.repository.client.*;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.List;

@Stateless
public class ClientsService {

    @Inject
    private ClientsRepository repo;
    @Inject
    private InformationProfessionnelRepository infoProRepo;

    public Clients create(Clients c) {
        repo.save(c);
        return c;
    }

    public Clients getOne(Long id) {
        return repo.find(id);
    }

    public List<Clients> getAll() {
        return repo.findAll();
    }

    public Clients update(Clients c) {
        InformationProfessionnel info = new InformationProfessionnel("", null, c.getrevenuActuel(), c);
        infoProRepo.save(info);
        return repo.update(c);
    }

    public boolean delete(Long id) {
        return repo.delete(id);
    }
}
