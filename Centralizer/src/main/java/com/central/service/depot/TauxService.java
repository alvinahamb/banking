package com.central.service.depot;

import com.central.model.depot.Taux;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TauxService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "http://localhost:5058/api/taux";

    public List<Taux> getAll() {
        Taux[] list = restTemplate.getForObject(baseUrl + "/all", Taux[].class);
        return Arrays.asList(list);
    }

    public Taux getById(Long id) {
        return restTemplate.getForObject(baseUrl + "/" + id, Taux.class);
    }

    public String add(Taux taux) {
        return restTemplate.postForObject(baseUrl + "/add", taux, String.class);
    }

    public String update(Taux taux) {
        return restTemplate.postForObject(baseUrl + "/update", taux, String.class);
    }

    public String delete(Long id) {
        return restTemplate.getForObject(baseUrl + "/delete/" + id, String.class);
    }
}
