package com.central.service.depot;

import com.central.model.depot.TypeOperationDepot;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TypeOperationDepotService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "http://localhost:5058/api/typeoperation";

    public List<TypeOperationDepot> getAll() {
        TypeOperationDepot[] list = restTemplate.getForObject(baseUrl + "/all", TypeOperationDepot[].class);
        return Arrays.asList(list);
    }

    public TypeOperationDepot getById(Long id) {
        return restTemplate.getForObject(baseUrl + "/" + id, TypeOperationDepot.class);
    }

    public String add(TypeOperationDepot typeOperation) {
        return restTemplate.postForObject(baseUrl + "/add", typeOperation, String.class);
    }

    public String update(TypeOperationDepot typeOperation) {
        return restTemplate.postForObject(baseUrl + "/update", typeOperation, String.class);
    }

    public String delete(Long id) {
        return restTemplate.getForObject(baseUrl + "/delete/" + id, String.class);
    }
}

