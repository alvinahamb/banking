package com.central.service.depot;

import com.central.model.depot.HistoriqueStatusComptes;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class HistoriqueStatusDepotService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "http://localhost:5058/api/historiquestatus";

    public List<HistoriqueStatusComptes> getAll() {
        HistoriqueStatusComptes[] list = restTemplate.getForObject(baseUrl + "/all", HistoriqueStatusComptes[].class);
        return Arrays.asList(list);
    }

    public HistoriqueStatusComptes getById(Long id) {
        return restTemplate.getForObject(baseUrl + "/" + id, HistoriqueStatusComptes.class);
    }

    public String add(HistoriqueStatusComptes historique) {
        return restTemplate.postForObject(baseUrl + "/add", historique, String.class);
    }

    public String update(HistoriqueStatusComptes historique) {
        restTemplate.postForObject(baseUrl + "/update", historique, HistoriqueStatusComptes.class);
        return "Historique mis à jour avec succès !";
    }

    public String delete(Long id) {
        restTemplate.getForObject(baseUrl + "/delete/" + id, HistoriqueStatusComptes.class);
        return "Historique supprimé avec succès !";
    }
}
