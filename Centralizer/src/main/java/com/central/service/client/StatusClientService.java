package com.central.service.client;

import com.central.model.client.StatusClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class StatusClientService {

    private final RestTemplate restTemplate = new RestTemplate();
    String url = "http://127.0.0.1:8080/PretModule/api/statusclient";

    public List<StatusClient> getAll() {
        StatusClient[] status = restTemplate.getForObject(url + "/all", StatusClient[].class);
        return Arrays.asList(status);
    }

    public StatusClient getById(Long id) {
        return restTemplate.getForObject(url + "/" + id, StatusClient.class);
    }

    public StatusClient create(StatusClient statusClient) {
        return restTemplate.postForObject(url + "/create", statusClient, StatusClient.class);
    }

    public StatusClient update(Long id, StatusClient statusClient) {
        return restTemplate.postForObject(url + "/update/" + id, statusClient, StatusClient.class);
    }

    public void delete(Long id) {
        restTemplate.getForObject(url + "/delete/" + id, Void.class);
    }
}

