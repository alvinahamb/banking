package com.central.service;

import com.central.model.TypePret;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class CentralService {
    private final RestTemplate restTemplate = new RestTemplate();

    public List<TypePret> getTypesPret() {
        String url = "http://127.0.0.1:8080/PretModule/api/typepret/all"; // URL du microservice Pret
        TypePret[] types = restTemplate.getForObject(url, TypePret[].class);
        return Arrays.asList(types);
    }
}
