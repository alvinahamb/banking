package com.central.controller.pret;

import com.central.service.pret.StatusPretService;

import jakarta.websocket.server.PathParam;

import com.central.model.pret.StatusPret;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/status-pret")
public class StatusPretController {

    private final StatusPretService service;
    String view = "pret/statuspret";

    public StatusPretController(StatusPretService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("statuspret", service.getAll());
        return view + "/liste";
    }

    @GetMapping("/formulaire")
    public String createForm(Model model) {
        model.addAttribute("statuspret", new StatusPret());
        return view + "/creer";
    }

    @PostMapping("/create")
    public String createForm(@ModelAttribute StatusPret statusPret, Model model) {
        statusPret.setIdStatusPret(null);
        service.create(statusPret);
        model.addAttribute("statuspret", service.getAll());
        return view + "/liste";
    }

    @GetMapping("/formulaire/{id}")
    public String updateForm(@PathVariable int id, Model model) {
        model.addAttribute("statuspret", service.getById(id));
        return view + "/creer";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute StatusPret statusPret, @PathVariable Integer id, Model model) {
        statusPret.setIdStatusPret(id);
        service.update(id, statusPret);
        model.addAttribute("statuspret", service.getAll());
        return view + "/liste";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        service.delete(id);
        model.addAttribute("statuspret", service.getAll());
        return view + "/liste";
    }
}
