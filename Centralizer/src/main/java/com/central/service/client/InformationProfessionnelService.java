package com.central.service.client;

import com.central.model.client.InformationProfessionnel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class InformationProfessionnelService {

    private final RestTemplate restTemplate = new RestTemplate();
    String url = "http://127.0.0.1:8080/PretModule/api/info";

    public List<InformationProfessionnel> getAll() {
        InformationProfessionnel[] infos = restTemplate.getForObject(url + "/all", InformationProfessionnel[].class);
        return Arrays.asList(infos);
    }

    public InformationProfessionnel getById(Long id) {
        return restTemplate.getForObject(url + "/" + id, InformationProfessionnel.class);
    }

    public InformationProfessionnel create(InformationProfessionnel info) {
        return restTemplate.postForObject(url + "/create", info, InformationProfessionnel.class);
    }

    public InformationProfessionnel update(Long id, InformationProfessionnel info) {
        return restTemplate.postForObject(url + "/update/" + id, info, InformationProfessionnel.class);
    }

    public void delete(Long id) {
        restTemplate.getForObject(url + "/delete/" + id, Void.class);
    }

    public InformationProfessionnel getLatestByClient(Long clientId) {
        return restTemplate.getForObject(url + "/latestbyclient/" + clientId, InformationProfessionnel.class);
    }
}

