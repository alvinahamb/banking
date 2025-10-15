package com.banque.courant.ejb;

import com.banque.courant.entity.OperationsCourant;
import com.banque.courant.repository.OperationsCourantRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class OperationsCourantService {

    @Inject
    private OperationsCourantRepository repo;

    public OperationsCourant create(OperationsCourant operation) {
        repo.save(operation);
        return operation;
    }

    public OperationsCourant getOne(Long id) {
        return repo.find(id);
    }

    public List<OperationsCourant> getAll() {
        return repo.findAll();
    }

    public OperationsCourant update(OperationsCourant operation) {
        return repo.update(operation);
    }

    public boolean delete(Long id) {
        return repo.delete(id);
    }
}
