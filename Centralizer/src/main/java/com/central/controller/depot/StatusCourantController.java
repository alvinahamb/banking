package com.central.controller.depot;

import com.central.model.courant.*;
import com.central.service.courant.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/comptecourant/status")
public class StatusCourantController {
    @Autowired
    private StatusCourantService service;
    String view = "courant/status";

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("statuscourant", service.getAll());
        for (StatusCourant sc : service.getAll()) {
            System.out.println(sc.getIdStatus());
        }
        return view + "/liste";
    }

    @GetMapping("/formulaire")
    public String formulaire(Model model) {
        model.addAttribute("statuscourant", new StatusCourant());
        return view + "/creer"; 
    }

    @PostMapping("/create")
    public String create(@ModelAttribute StatusCourant statuscourant) {
        service.create(statuscourant);
        return "redirect:/comptecourant/status/all";
    }

    @GetMapping("/formulaire/{id}")
    public String formulaireUpdate(@PathVariable("id") Long id, Model model) {
        StatusCourant statuscourant = service.getById(id);
        model.addAttribute("statuscourant", statuscourant);
        return view + "/creer";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute StatusCourant statuscourant) {
        StatusCourant existingStatusCourant = service.getById(id);
        existingStatusCourant.setLibelle(statuscourant.getLibelle());
        service.update(id, existingStatusCourant);
        return "redirect:/comptecourant/status/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/comptecourant/status/all";
    }
}
