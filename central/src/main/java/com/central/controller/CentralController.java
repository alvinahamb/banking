package com.central.controller;

import com.central.service.CentralService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CentralController {

    private final CentralService service;

    public CentralController(CentralService service) {
        this.service = service;
    }

    @GetMapping("/types-pret")
    public String afficherTypesPret(Model model) {
        model.addAttribute("types", service.getTypesPret());
        return "typespret";
    }
}
