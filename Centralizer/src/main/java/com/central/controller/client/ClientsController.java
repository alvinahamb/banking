package com.central.controller.client;

import com.central.model.client.*;
import com.central.service.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import java.util.List;
import java.time.LocalDate;

@Controller
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private ClientsService service;
    @Autowired
    private TrancheRevenuService trancherevenu;
    @Autowired
    private InformationProfessionnelService info;
    String view = "client/client";

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("clients", service.getAll());
        for (Clients c : service.getAll()) {
            c.setRevenuActuel(trancherevenu.getById(c.getRevenuActuel().getIdTranche()));
        }
        return view + "/liste";
    }

    @GetMapping("/formulaire")
    public String formulaire(Model model) {
        model.addAttribute("clients", new Clients());
        model.addAttribute("trancherevenu", trancherevenu.getAll());
        return view + "/creer";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Clients clients) {
        clients.setDate_de_naissance(clients.getDate_de_naissance().toString());
        clients.setDate_ajout(clients.getDate_ajout().toString());
        TrancheRevenu trancheRevenu = trancherevenu.getById(clients.getRevenuActuel().getIdTranche());
        System.out.println(trancheRevenu.getIdTranche());
        clients.setRevenuActuel(trancheRevenu);
        service.create(clients);
        return "redirect:/clients/all";
    }

    @GetMapping("/formulaire/{id}")
    public String formulaireUpdate(@PathVariable("id") Long id, Model model) {
        Clients clients = service.getById(id);
        model.addAttribute("clients", clients);
        model.addAttribute("trancherevenu", trancherevenu.getAll());
        return view + "/creer";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute Clients clients) {
        clients.setIdClient(id);
        Clients existingClient = service.getById(id);
        clients.setDate_ajout(existingClient.getDate_ajout());
        service.update(id, clients);
        return "redirect:/clients/all";
    }
}
