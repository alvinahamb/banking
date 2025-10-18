package com.central.service.client;

import com.central.model.client.TrancheRevenu;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TrancheRevenuService {

    private final RestTemplate restTemplate = new RestTemplate();
    String url = "http://127.0.0.1:8080/PretModule/api/trancherevenu";

    public List<TrancheRevenu> getAll() {
        TrancheRevenu[] tranches = restTemplate.getForObject(url + "/all", TrancheRevenu[].class);
        return Arrays.asList(tranches);
    }

    public TrancheRevenu getById(Long id) {
        return restTemplate.getForObject(url + "/" + id, TrancheRevenu.class);
    }

    public TrancheRevenu create(TrancheRevenu tranche) {
        return restTemplate.postForObject(url + "/create", tranche, TrancheRevenu.class);
    }

    public TrancheRevenu update(Long id, TrancheRevenu tranche) {
        return restTemplate.postForObject(url + "/update/" + id, tranche, TrancheRevenu.class);
    }

    public void delete(Long id) {
        restTemplate.getForObject(url + "/delete/" + id, Void.class);
    }
}

