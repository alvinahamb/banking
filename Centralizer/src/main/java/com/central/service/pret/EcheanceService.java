package com.central.service.pret;

import com.central.model.pret.Echeance;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class EcheanceService {

    private final RestTemplate restTemplate = new RestTemplate();
    String url = "http://127.0.0.1:8080/PretModule/api/echeance";

    public List<Echeance> getAll() {
        Echeance[] echeances = restTemplate.getForObject(url + "/all", Echeance[].class);
        return Arrays.asList(echeances);
    }

    public Echeance getById(Long id) {
        return restTemplate.getForObject(url + "/" + id, Echeance.class);
    }

    public Echeance create(Echeance echeance) {
        return restTemplate.postForObject(url + "/create", echeance, Echeance.class);
    }

    public void update(Long id, Echeance echeance) {
        restTemplate.postForObject(url + "/update/" + id, echeance, Echeance.class);
    }

    public void delete(Long id) {
        restTemplate.getForObject(url + "/delete/" + id, Void.class);
    }

    public List<Echeance> getByPret(Long idPret) {
        Echeance[] echeances = restTemplate.getForObject(url + "/byPret/" + idPret, Echeance[].class);
        return Arrays.asList(echeances);
    }

    public Echeance lastUnpaidEcheance(Long id){
        return restTemplate.getForObject(url + "/lastEnCours/"+id, Echeance.class);
    }
}
