package com.central.controller.compte;

import com.central.model.courant.*;
import com.central.model.depot.*;
import com.central.service.courant.*;
import com.central.service.depot.*;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/compte/taux")
public class TauxController {

    @Autowired
    private TauxService service;
    String view = "compte/taux";

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("taux", service.getAll());
        return view + "/liste";
    }

    @GetMapping("/formulaire")
    public String formulaire(Model model) {
        model.addAttribute("taux", new Taux());
        return view + "/creer";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Taux taux) {
        taux.setIdTaux(0L);
        taux.setDateChangement(taux.getDateChangement().toString());
        service.add(taux);
        return "redirect:/compte/taux/all";
    }

    @GetMapping("/formulaire/{id}")
    public String formulaireUpdate(@PathVariable("id") Long id, Model model) {
        Taux taux = service.getById(id);
        model.addAttribute("taux", taux);
        return view + "/creer";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute Taux taux) {
        Taux existingTaux = service.getById(id);
        existingTaux.setValeur(taux.getValeur());
        service.update(existingTaux);
        return "redirect:/compte/taux/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/compte/taux/all";
    }
}