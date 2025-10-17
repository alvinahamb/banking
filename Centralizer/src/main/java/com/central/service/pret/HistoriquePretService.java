package com.central.service.pret;

import com.central.model.pret.HistoriquePret;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class HistoriquePretService {

    private final RestTemplate restTemplate = new RestTemplate();
    String url = "http://127.0.0.1:8080/PretModule/api/historiquepret";

    public List<HistoriquePret> getAll() {
        HistoriquePret[] historiques = restTemplate.getForObject(url + "/all", HistoriquePret[].class);
        return Arrays.asList(historiques);
    }

    public HistoriquePret getById(int id) {
        return restTemplate.getForObject(url + "/" + id, HistoriquePret.class);
    }

    public HistoriquePret create(HistoriquePret historiquePret) {
        return restTemplate.postForObject(url + "/create", historiquePret, HistoriquePret.class);
    }

    public void update(int id, HistoriquePret historiquePret) {
        restTemplate.postForObject(url + "/update/" + id, historiquePret, HistoriquePret.class);
    }

    public void delete(int id) {
        restTemplate.getForObject(url + "/delete/" + id, Void.class);
    }

    public List<HistoriquePret> getByPret(Integer id) {
        HistoriquePret[] historiques = restTemplate.getForObject(url + "/byPret/" + id, HistoriquePret[].class);
        return Arrays.asList(historiques);
    }

    public HistoriquePret getLatestByPret(Integer idPret) {
        return restTemplate.getForObject(url + "/latestByPret/" + idPret, HistoriquePret.class);
    }
}
