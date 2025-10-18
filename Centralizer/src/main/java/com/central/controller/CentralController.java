package com.central.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CentralController {

    @GetMapping
    public String Pret() {
        return "pret/pret-acceuil";
    }

    @GetMapping("client")
    public String Client(){
        return "client/acceuil";
    }
}
