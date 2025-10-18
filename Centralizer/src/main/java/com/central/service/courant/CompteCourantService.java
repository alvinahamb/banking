package com.central.service.courant;

import com.central.model.courant.CompteCourant;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class CompteCourantService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String url = "http://127.0.0.1:8080/CourantModule/api/comptecourant";

    public List<CompteCourant> getAll() {
        CompteCourant[] comptes = restTemplate.getForObject(url + "/all", CompteCourant[].class);
        return Arrays.asList(comptes);
    }

    public CompteCourant getById(Long id) {
        return restTemplate.getForObject(url + "/" + id, CompteCourant.class);
    }

    public CompteCourant create(CompteCourant compte) {
        return restTemplate.postForObject(url + "/create", compte, CompteCourant.class);
    }

    public void update(Long id, CompteCourant compte) {
        restTemplate.postForObject(url + "/update/" + id, compte, CompteCourant.class);
    }

    public void delete(Long id) {
        restTemplate.getForObject(url + "/delete/" + id, Void.class);
    }
}

