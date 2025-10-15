package com.banque.courant.ejb;

import com.banque.courant.entity.HistoriqueVirement;
import com.banque.courant.repository.HistoriqueVirementRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class HistoriqueVirementService {

    @Inject
    private HistoriqueVirementRepository repo;

    public HistoriqueVirement create(HistoriqueVirement virement) {
        repo.save(virement);
        return virement;
    }

    public HistoriqueVirement getOne(Long id) {
        return repo.find(id);
    }

    public List<HistoriqueVirement> getAll() {
        return repo.findAll();
    }

    public HistoriqueVirement update(HistoriqueVirement virement) {
        return repo.update(virement);
    }

    public boolean delete(Long id) {
        return repo.delete(id);
    }
}
