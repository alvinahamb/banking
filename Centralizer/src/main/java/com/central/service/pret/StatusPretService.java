package com.central.service.pret;

import com.central.model.pret.StatusPret;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class StatusPretService {

    private final RestTemplate restTemplate = new RestTemplate();
    String url = "http://127.0.0.1:8080/PretModule/api/statuspret";

    public List<StatusPret> getAll() {
        StatusPret[] statusPrets = restTemplate.getForObject(url + "/all", StatusPret[].class);
        return Arrays.asList(statusPrets);
    }

    public StatusPret getById(int id) {
        return restTemplate.getForObject(url + "/" + id, StatusPret.class);
    }

    public StatusPret create(StatusPret statusPret) {
        return restTemplate.postForObject(url + "/create", statusPret, StatusPret.class);
    }

    public void update(int id, StatusPret statusPret) {
        restTemplate.postForObject(url + "/update/" + id, statusPret, StatusPret.class);
        // restTemplate.postForObject(url + "/create", statusPret, StatusPret.class);
    }

    public void delete(int id) {
        restTemplate.getForObject(url + "/delete/" + id, Void.class);
    }
}
