package com.central.service.client;

import com.central.model.client.HistoriqueVirement;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class HistoriqueVirementService {

    private final RestTemplate restTemplate = new RestTemplate();
    String url = "http://127.0.0.1:8080/PretModule/api/virements";

    public HistoriqueVirement create(HistoriqueVirement virement) {
        return restTemplate.postForObject(url, virement, HistoriqueVirement.class);
    }

    public HistoriqueVirement getById(Long id) {
        return restTemplate.getForObject(url + "/" + id, HistoriqueVirement.class);
    }

    public List<HistoriqueVirement> getAll() {
        HistoriqueVirement[] virements = restTemplate.getForObject(url, HistoriqueVirement[].class);
        return Arrays.asList(virements);
    }

    public HistoriqueVirement update(Long id, HistoriqueVirement virement) {
        return restTemplate.postForObject(url + "/update/" + id, virement, HistoriqueVirement.class);
    }

    public void delete(Long id) {
        restTemplate.delete(url + "/" + id);
    }
}

