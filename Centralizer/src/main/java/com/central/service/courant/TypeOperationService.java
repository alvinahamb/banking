package com.central.service.courant;

import com.central.model.courant.TypeOperation;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class TypeOperationService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String url = "http://127.0.0.1:8080/CourantModule/api/typeoperation";

    public List<TypeOperation> getAll() {
        TypeOperation[] data = restTemplate.getForObject(url + "/all", TypeOperation[].class);
        return Arrays.asList(data);
    }

    public TypeOperation getById(Long id) {
        return restTemplate.getForObject(url + "/" + id, TypeOperation.class);
    }

    public TypeOperation create(TypeOperation typeOperation) {
        return restTemplate.postForObject(url + "/create", typeOperation, TypeOperation.class);
    }

    public void update(Long id, TypeOperation typeOperation) {
        restTemplate.postForObject(url + "/update/" + id, typeOperation, TypeOperation.class);
    }

    public void delete(Long id) {
        restTemplate.getForObject(url + "/delete/" + id, Void.class);
    }
}
