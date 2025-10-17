package com.central.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class CentralService {
    private final RestTemplate restTemplate = new RestTemplate();

}
