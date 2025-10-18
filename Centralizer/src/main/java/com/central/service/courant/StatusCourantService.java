package com.central.service.courant;

import com.central.model.courant.StatusCourant;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class StatusCourantService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String url = "http://127.0.0.1:8080/CourantModule/api/status";

    public List<StatusCourant> getAll() {
        StatusCourant[] data = restTemplate.getForObject(url + "/all", StatusCourant[].class);
        return Arrays.asList(data);
    }

    public StatusCourant getById(Long id) {
        return restTemplate.getForObject(url + "/" + id, StatusCourant.class);
    }

    public StatusCourant create(StatusCourant status) {
        return restTemplate.postForObject(url + "/create", status, StatusCourant.class);
    }

    public void update(Long id, StatusCourant status) {
        restTemplate.postForObject(url + "/update/" + id, status, StatusCourant.class);
    }

    public void delete(Long id) {
        restTemplate.getForObject(url + "/delete/" + id, Void.class);
    }
}
