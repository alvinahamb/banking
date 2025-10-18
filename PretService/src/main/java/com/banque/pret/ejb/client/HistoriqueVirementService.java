package com.banque.pret.ejb.client;

import com.banque.pret.repository.client.*;
import com.banque.pret.entity.client.HistoriqueVirement;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class HistoriqueVirementService {

    @Inject
    private HistoriqueVirementRepository repo;

    public void create(HistoriqueVirement virement) {
        repo.create(virement);
    }

    public HistoriqueVirement find(Long id) {
        return repo.find(id);
    }

    public List<HistoriqueVirement> findAll() {
        return repo.findAll();
    }

    public HistoriqueVirement update(HistoriqueVirement virement) {
        return repo.update(virement);
    }

    public void delete(Long id) {
        repo.delete(id);
    }
}
