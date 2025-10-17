package com.banque.pret.ejb;

import com.banque.pret.entity.Echeance;
import com.banque.pret.repository.EcheanceRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class EcheanceService {

    @Inject
    private EcheanceRepository repo;

    public Echeance create(Echeance e) {
        repo.save(e);
        return e;
    }

    public Echeance getOne(Long id) {
        return repo.find(id);
    }

    public List<Echeance> getAll() {
        return repo.findAll();
    }

    public Echeance update(Echeance e) {
        return repo.update(e);
    }

    public boolean delete(Long id) {
        return repo.delete(id);
    }

    public List<Echeance> getByPretId(Long idPret) {
        return repo.findByPretId(idPret);
    }
}
