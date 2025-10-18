package com.central.service.courant;

import com.central.model.courant.HistoriqueStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class HistoriqueStatusService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String url = "http://127.0.0.1:8080/CourantModule/api/historiquestatus";

    public List<HistoriqueStatus> getAll() {
        HistoriqueStatus[] data = restTemplate.getForObject(url + "/all", HistoriqueStatus[].class);
        return Arrays.asList(data);
    }

    public HistoriqueStatus getById(Long id) {
        return restTemplate.getForObject(url + "/" + id, HistoriqueStatus.class);
    }

    public HistoriqueStatus create(HistoriqueStatus historique) {
        return restTemplate.postForObject(url + "/create", historique, HistoriqueStatus.class);
    }

    public void update(Long id, HistoriqueStatus historique) {
        restTemplate.postForObject(url + "/update/" + id, historique, HistoriqueStatus.class);
    }

    public void delete(Long id) {
        restTemplate.getForObject(url + "/delete/" + id, Void.class);
    }
}
