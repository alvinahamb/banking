package com.central.service.pret;

import com.central.model.pret.Pret;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class PretService {

    private final RestTemplate restTemplate = new RestTemplate();
    String url = "http://127.0.0.1:8080/PretModule/api/pret";

    public List<Pret> getAll() {
        Pret[] prets = restTemplate.getForObject(url + "/all", Pret[].class);
        return Arrays.asList(prets);
    }

    public Pret getById(int id) {
        return restTemplate.getForObject(url + "/" + id, Pret.class);
    }

    public Pret create(Pret pret) {
        return restTemplate.postForObject(url + "/create", pret, Pret.class);
    }

    public void update(int id, Pret pret) {
        restTemplate.postForObject(url + "/update/" + id, pret, Pret.class);
    }

    public void delete(int id) {
        restTemplate.getForObject(url + "/delete/" + id, Void.class);
    }
}
