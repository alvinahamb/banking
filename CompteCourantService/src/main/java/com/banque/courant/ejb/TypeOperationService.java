package com.banque.courant.ejb;

import com.banque.courant.entity.TypeOperation;
import com.banque.courant.repository.TypeOperationRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class TypeOperationService {

    @Inject
    private TypeOperationRepository repo;

    public TypeOperation create(TypeOperation typeOperation) {
        repo.save(typeOperation);
        return typeOperation;
    }

    public TypeOperation getOne(Long id) {
        return repo.find(id);
    }

    public List<TypeOperation> getAll() {
        return repo.findAll();
    }

    public TypeOperation update(TypeOperation typeOperation) {
        return repo.update(typeOperation);
    }

    public boolean delete(Long id) {
        return repo.delete(id);
    }
}
