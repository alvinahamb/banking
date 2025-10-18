package com.central.controller.depot;

import com.central.model.courant.*;
import com.central.service.courant.*;
import com.central.service.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.time.LocalDate;

@Controller
@RequestMapping("/comptecourant/typeoperation")
public class TypeOperationController {

    @Autowired
    private TypeOperationService service;
    String view = "courant/type-operation";

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("typeoperation", service.getAll());
        return view + "/liste";
    }

    @GetMapping("/formulaire")
    public String formulaire(Model model) {
        model.addAttribute("typeoperation", new TypeOperation());
        return view + "/creer";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute TypeOperation typeoperation) {
        service.create(typeoperation);
        System.out.println(typeoperation.getCredit());
        return "redirect:/comptecourant/typeoperation/all";
    }

    @GetMapping("/formulaire/{id}")
    public String formulaireUpdate(@PathVariable("id") Long id, Model model) {
        TypeOperation typeoperation = service.getById(id);
        model.addAttribute("typeoperation", typeoperation);
        return view + "/creer";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute TypeOperation typeoperation) {
        TypeOperation existingTypeOperation = service.getById(id);
        existingTypeOperation.setLibelle(typeoperation.getLibelle());
        existingTypeOperation.setCredit(typeoperation.getCredit());
        service.update(id, existingTypeOperation);
        return "redirect:/comptecourant/typeoperation/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/comptecourant/typeoperation/all";
    }
}
