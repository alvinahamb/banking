package com.central.service.client;

import com.central.model.client.HistoriqueClients;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class HistoriqueClientsService {

    private final RestTemplate restTemplate = new RestTemplate();
    String url = "http://127.0.0.1:8080/PretModule/api/historiqueclients";

    public List<HistoriqueClients> getAll() {
        HistoriqueClients[] historiques = restTemplate.getForObject(url + "/all", HistoriqueClients[].class);
        return Arrays.asList(historiques);
    }

    public HistoriqueClients getById(Long id) {
        return restTemplate.getForObject(url + "/" + id, HistoriqueClients.class);
    }

    public HistoriqueClients create(HistoriqueClients historique) {
        return restTemplate.postForObject(url + "/create", historique, HistoriqueClients.class);
    }

    public HistoriqueClients update(Long id, HistoriqueClients historique) {
        return restTemplate.postForObject(url + "/update/" + id, historique, HistoriqueClients.class);
    }

    public void delete(Long id) {
        restTemplate.getForObject(url + "/delete/" + id, Void.class);
    }
}

