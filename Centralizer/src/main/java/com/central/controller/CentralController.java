package com.central.controller;

import com.central.service.CentralService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CentralController {

    @GetMapping
    public String Pret() {
        return "pret/pret-acceuil";
    }
}
