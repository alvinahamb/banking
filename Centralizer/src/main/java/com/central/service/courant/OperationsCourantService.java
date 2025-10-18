package com.central.service.courant;

import com.central.model.courant.OperationsCourant;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class OperationsCourantService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String url = "http://127.0.0.1:8080/CourantModule/api/operationscourant";

    public List<OperationsCourant> getAll() {
        OperationsCourant[] data = restTemplate.getForObject(url + "/all", OperationsCourant[].class);
        return Arrays.asList(data);
    }

    public OperationsCourant getById(Long id) {
        return restTemplate.getForObject(url + "/" + id, OperationsCourant.class);
    }

    public OperationsCourant create(OperationsCourant operation) {
        return restTemplate.postForObject(url + "/create", operation, OperationsCourant.class);
    }

    public void update(Long id, OperationsCourant operation) {
        restTemplate.postForObject(url + "/update/" + id, operation, OperationsCourant.class);
    }

    public void delete(Long id) {
        restTemplate.getForObject(url + "/delete/" + id, Void.class);
    }
}
