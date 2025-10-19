package com.central.service.depot;

import com.central.model.depot.OperationsDepot;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class OperationsDepotService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "http://localhost:5058/api/operationsdepot";

    public List<OperationsDepot> getAll() {
        OperationsDepot[] list = restTemplate.getForObject(baseUrl + "/all", OperationsDepot[].class);
        return Arrays.asList(list);
    }

    public OperationsDepot getById(Long id) {
        return restTemplate.getForObject(baseUrl + "/" + id, OperationsDepot.class);
    }

    public String add(OperationsDepot op) {
        return restTemplate.postForObject(baseUrl + "/add", op, String.class);
    }

    public String update(OperationsDepot op) {
        restTemplate.postForObject(baseUrl + "/update", op, OperationsDepot.class);
        return "Opération mise à jour avec succès !";
    }

    public String delete(Long id) {
        restTemplate.getForObject(baseUrl + "/delete/" + id, OperationsDepot.class);
        return "Opération supprimée avec succès !";
    }
}
