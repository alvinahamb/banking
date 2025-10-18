package com.central.service.client;


import com.central.model.client.Clients;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ClientsService {

    private final RestTemplate restTemplate = new RestTemplate();
    String url = "http://127.0.0.1:8080/PretModule/api/clients";

    public List<Clients> getAll() {
        Clients[] clients = restTemplate.getForObject(url + "/all", Clients[].class);
        return Arrays.asList(clients);
    }

    public Clients getById(Long id) {
        return restTemplate.getForObject(url + "/" + id, Clients.class);
    }

    public Clients create(Clients client) {
        return restTemplate.postForObject(url + "/create", client, Clients.class);
    }

    public Clients update(Long id, Clients client) {
        return restTemplate.postForObject(url + "/update/" + id, client, Clients.class);
    }

    public void delete(Long id) {
        restTemplate.getForObject(url + "/delete/" + id, Void.class);
    }
}
