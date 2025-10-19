package com.central.service.depot;

import com.central.model.depot.CompteDepot;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CompteDepotService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "http://localhost:5058/api/comptedepot";

    public List<CompteDepot> getAll() {
        CompteDepot[] list = restTemplate.getForObject(baseUrl + "/all", CompteDepot[].class);
        return Arrays.asList(list);
    }

    public CompteDepot getById(Long id) {
        return restTemplate.getForObject(baseUrl + "/" + id, CompteDepot.class);
    }

    public String add(CompteDepot compte) {
        return restTemplate.postForObject(baseUrl + "/add", compte, String.class);
    }

    public String update(CompteDepot compte) {
        return restTemplate.postForObject(baseUrl + "/update", compte, String.class);
    }

    public String delete(Long id) {
        restTemplate.getForObject(baseUrl + "/delete/" + id, CompteDepot.class);
        return "Compte dépôt supprimé avec succès !";
    }
}
