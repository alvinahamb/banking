package com.banque.courant.ejb;

import com.banque.courant.entity.Status;
import com.banque.courant.repository.StatusRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class StatusService {

    @Inject
    private StatusRepository repo;

    public Status create(Status status) {
        repo.save(status);
        return status;
    }

    public Status getOne(Long id) {
        return repo.find(id);
    }

    public List<Status> getAll() {
        return repo.findAll();
    }

    public Status update(Status status) {
        return repo.update(status);
    }

    public boolean delete(Long id) {
        return repo.delete(id);
    }
}
