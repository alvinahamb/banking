package com.banque.pret.ejb;

import com.banque.pret.entity.HistoriquePret;
import com.banque.pret.repository.HistoriquePretRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class HistoriquePretService {

    @Inject
    private HistoriquePretRepository repo;

    public HistoriquePret create(HistoriquePret h) { repo.save(h); return h; }

    public HistoriquePret getOne(Long id) { return repo.find(id); }

    public List<HistoriquePret> getAll() { return repo.findAll(); }

    public HistoriquePret update(HistoriquePret h) { return repo.update(h); }

    public boolean delete(Long id) { return repo.delete(id); }
    
    public List<HistoriquePret> getByPret(Long idPret) {
        return repo.findByPret(idPret);
    }

    public HistoriquePret getLatestByPret(Long idPret) {
        return repo.findLatestByPret(idPret);
    }
}
