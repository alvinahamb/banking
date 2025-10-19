package com.central.service.depot;

import com.central.model.depot.StatusDepot;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class StatusDepotService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "http://localhost:5058/api/status";

    public List<StatusDepot> getAll() {
        StatusDepot[] list = restTemplate.getForObject(baseUrl + "/all", StatusDepot[].class);
        return Arrays.asList(list);
    }

    public StatusDepot getById(Long id) {
        return restTemplate.getForObject(baseUrl + "/" + id, StatusDepot.class);
    }

    public String add(StatusDepot status) {
        return restTemplate.postForObject(baseUrl + "/add", status, String.class);
    }

    public String update(StatusDepot status) {
        return restTemplate.postForObject(baseUrl + "/update", status, String.class);
    }

    public String delete(Long id) {
        return restTemplate.getForObject(baseUrl + "/delete/" + id, String.class);
    }
}
