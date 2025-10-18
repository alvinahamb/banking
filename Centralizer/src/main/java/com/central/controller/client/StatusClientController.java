package com.central.controller.client;

import com.central.model.client.*;
import com.central.service.client.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/statusclient")
public class StatusClientController {

    @Autowired
    private StatusClientService service;
    String view = "client/status";

    @GetMapping("/all")
    public String getAll(Model model) {
        List<StatusClient> statusClient = service.getAll();
        model.addAttribute("statusclient", statusClient);
        return view+"/liste";
    }

    @GetMapping("/formulaire")
    public String formulaire(Model model) {
        model.addAttribute("statusclient", new StatusClient());
        return view + "/creer";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute StatusClient statusClient) {
        service.create(statusClient);
        return "redirect:/statusclient/all";
    }

    @GetMapping("/formulaire/{id}")
    public String formulaireUpdate(@PathVariable("id") Long id, Model model) {
        StatusClient statusClient = service.getById(id);
        model.addAttribute("statusclient", statusClient);
        return view + "/creer";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute StatusClient statusClient) {
        statusClient.setIdStatusClient(id);
        service.update(id, statusClient);
        return "redirect:/statusclient/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/statusclient/all";
    }
}

