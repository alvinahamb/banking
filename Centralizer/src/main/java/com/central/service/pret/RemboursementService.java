package com.central.service.pret;

import com.central.model.pret.Remboursement;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class RemboursementService {

    private final RestTemplate restTemplate = new RestTemplate();
    String url = "http://127.0.0.1:8080/PretModule/api/remboursement";

    public List<Remboursement> getAll() {
        Remboursement[] remboursements = restTemplate.getForObject(url + "/all", Remboursement[].class);
        return Arrays.asList(remboursements);
    }

    public Remboursement getById(int id) {
        return restTemplate.getForObject(url + "/" + id, Remboursement.class);
    }

    public Remboursement create(Remboursement remboursement) {
        return restTemplate.postForObject(url + "/create", remboursement, Remboursement.class);
    }

    public void update(int id, Remboursement remboursement) {
        restTemplate.postForObject(url + "/update/" + id, remboursement, Remboursement.class);
    }

    public void delete(int id) {
        restTemplate.getForObject(url + "/delete/" + id, Void.class);
    }
}

