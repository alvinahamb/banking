package com.central.controller.compte;

import com.central.model.courant.*;
import com.central.model.depot.*;
import com.central.service.courant.*;
import com.central.service.depot.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/comptecourant/typeoperation")
public class TypeOperationController {

    @Autowired
    private TypeOperationService service;
    @Autowired
    private TypeOperationDepotService depotService;
    String view = "compte/type-operation";

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
        TypeOperationDepot  tod = new TypeOperationDepot();
        tod.setIdTypeOperation(0L);
        tod.setLibelle(typeoperation.getLibelle());
        tod.setCredit(typeoperation.getCredit());
        // System.out.println("Création du type d'opération dans le dépôt : " + tod.getIdTypeOperation() + ", crédit : " + tod.getCredit());
        depotService.add(tod);
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
        // depot update
        TypeOperationDepot  tod = new TypeOperationDepot();
        tod.setIdTypeOperation(id);
        tod.setLibelle(typeoperation.getLibelle());
        tod.setCredit(typeoperation.getCredit());
        // System.out.println("Création du type d'opération dans le dépôt : " + tod.getIdTypeOperation() + ", crédit : " + tod.getCredit());
        depotService.update(tod);
        service.update(id, existingTypeOperation);
        return "redirect:/comptecourant/typeoperation/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);
        depotService.delete(id);
        return "redirect:/comptecourant/typeoperation/all";
    }
}
