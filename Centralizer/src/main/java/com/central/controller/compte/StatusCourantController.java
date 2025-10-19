package com.central.controller.compte;

import com.central.model.courant.*;
import com.central.service.courant.*;
import com.central.model.depot.*;
import com.central.service.depot.*;

import java.io.ObjectInputFilter.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/comptecourant/status")
public class StatusCourantController {
    @Autowired
    private StatusCourantService service;
    @Autowired
    private StatusDepotService statusDepotService;
    String view = "compte/status";

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
        StatusDepot statusDepot = new StatusDepot();
        statusDepot.setIdStatus(0L);
        statusDepot.setLibelle(statuscourant.getLibelle());
        statusDepotService.add(statusDepot);
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
        StatusDepot statusDepot = statusDepotService.getById(id);
        statusDepot.setLibelle(statuscourant.getLibelle());
        statusDepotService.update(statusDepot);
        service.update(id, existingStatusCourant);
        return "redirect:/comptecourant/status/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        statusDepotService.delete(id);
        return "redirect:/comptecourant/status/all";
    }
}
