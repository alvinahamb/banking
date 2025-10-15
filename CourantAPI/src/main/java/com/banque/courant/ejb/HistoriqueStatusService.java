package com.banque.courant.ejb;

import com.banque.courant.entity.HistoriqueStatus;
import com.banque.courant.repository.HistoriqueStatusRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class HistoriqueStatusService {

    @Inject
    private HistoriqueStatusRepository repo;

    public HistoriqueStatus create(HistoriqueStatus historique) {
        repo.save(historique);
        return historique;
    }

    public HistoriqueStatus getOne(Long id) {
        return repo.find(id);
    }

    public List<HistoriqueStatus> getAll() {
        return repo.findAll();
    }

    public HistoriqueStatus update(HistoriqueStatus historique) {
        return repo.update(historique);
    }

    public boolean delete(Long id) {
        return repo.delete(id);
    }
}
