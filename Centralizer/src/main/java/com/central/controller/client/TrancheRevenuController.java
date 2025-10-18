package com.central.controller.client;

import com.central.model.client.TrancheRevenu;
import com.central.service.client.TrancheRevenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/trancherevenu")
public class TrancheRevenuController {

    @Autowired
    private TrancheRevenuService service;
    String view = "client/tranche-revenu";

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("trancherevenu", service.getAll());
        return view + "/liste";
    }

    @GetMapping("/formulaire")
    public String formulaire(Model model) {
        model.addAttribute("trancherevenu", new TrancheRevenu());
        return view + "/creer";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute TrancheRevenu trancheRevenu) {
        service.create(trancheRevenu);
        return "redirect:/trancherevenu/all";
    }

    @GetMapping("/formulaire/{id}")
    public String formulaireUpdate(@PathVariable("id") Long id, Model model) {
        TrancheRevenu trancheRevenu = service.getById(id);
        model.addAttribute("trancherevenu", trancheRevenu);
        return view + "/creer";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute TrancheRevenu trancheRevenu) {
        trancheRevenu.setIdTranche(id);
        service.update(id, trancheRevenu);
        return "redirect:/trancherevenu/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/trancherevenu/all";
    }
}

