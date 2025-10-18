package com.central.service.courant;

import com.central.model.courant.HistoriqueVirement;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class HistoriqueVirementService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String url = "http://127.0.0.1:8080/CourantModule/api/historiquevirement";

    public List<HistoriqueVirement> getAll() {
        HistoriqueVirement[] data = restTemplate.getForObject(url + "/all", HistoriqueVirement[].class);
        return Arrays.asList(data);
    }

    public HistoriqueVirement getById(Long id) {
        return restTemplate.getForObject(url + "/" + id, HistoriqueVirement.class);
    }

    public HistoriqueVirement create(HistoriqueVirement virement) {
        return restTemplate.postForObject(url + "/create", virement, HistoriqueVirement.class);
    }

    public void update(Long id, HistoriqueVirement virement) {
        restTemplate.postForObject(url + "/update/" + id, virement, HistoriqueVirement.class);
    }

    public void delete(Long id) {
        restTemplate.getForObject(url + "/delete/" + id, Void.class);
    }
}
