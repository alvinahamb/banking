package com.central.service.pret;

import com.central.model.pret.TypePret;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class TypePretService {
    private final RestTemplate restTemplate = new RestTemplate();
    String url = "http://127.0.0.1:8080/PretModule/api/typepret";

    public List<TypePret> getAll() {
        TypePret[] typePrets = restTemplate.getForObject(url + "/all", TypePret[].class);
        return Arrays.asList(typePrets);
    }

    public TypePret getById(int id) {
        return restTemplate.getForObject(url + "/" + id, TypePret.class);
    }

    public TypePret create(TypePret typePret) {
        return restTemplate.postForObject(url + "/create", typePret, TypePret.class);
    }

    public void update(int id, TypePret typePret) {
        restTemplate.postForObject(url + "/update/" + id, typePret, TypePret.class);
    }

    public void delete(int id) {
        restTemplate.getForObject(url + "/delete/" + id, Void.class);
    }

}
