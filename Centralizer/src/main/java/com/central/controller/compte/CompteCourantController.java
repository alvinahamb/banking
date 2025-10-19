package com.central.controller.compte;

import com.central.model.courant.*;
import com.central.service.courant.*;
import com.central.service.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.time.LocalDate;

@Controller
@RequestMapping("/comptecourant")
public class CompteCourantController {

    @Autowired
    private CompteCourantService service;
    @Autowired
    private ClientsService clientService;
    @Autowired
    private TypeOperationService typeOperationService;
    @Autowired
    private OperationsCourantService operationsCourantService;
    String view = "compte/courant";

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("comptecourant", service.getAll());
        return view + "/liste";
    }

    @GetMapping("/formulaire")
    public String formulaire(Model model) {
        model.addAttribute("comptecourant", new CompteCourant());
        model.addAttribute("clients", clientService.getAll());
        return view + "/creer";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute CompteCourant comptecourant) {
        comptecourant.setSoldeActuel(0.0);
        comptecourant.setNumeroCompte("C" + (service.getAll().size() + 1));
        comptecourant.setDateOuverture(comptecourant.getDateOuverture().toString());
        comptecourant.setDateCloture(null);
        System.out.println(comptecourant.getIdClient());
        service.create(comptecourant);
        return "redirect:/comptecourant/all";
    }

    @GetMapping("/transaction/{id}")
    public String transaction(@PathVariable("id") Long id, Model model) {
        CompteCourant comptecourant = service.getById(id);
        model.addAttribute("comptecourant", comptecourant);
        model.addAttribute("typeoperations", typeOperationService.getAll());

        OperationsCourant ops = new OperationsCourant();
        ops.setCompteCourant(comptecourant);
        ops.setTypeOperation(new TypeOperation()); // <-- initialisation ici
        model.addAttribute("operationscourant", ops);
        return view + "/transaction";
    }

    @GetMapping("/createTransaction/{id}")
    public String effectuerTransaction(@PathVariable("id") Long id,@ModelAttribute OperationsCourant operationscourant) {
        operationscourant.setVirement(null);
        TypeOperation typeOp = typeOperationService.getById(operationscourant.getTypeOperation().getIdTypeOperation());
        CompteCourant compte = service.getById(operationscourant.getCompteCourant().getIdCompteCourant());
        if ((compte.getSoldeActuel()-operationscourant.getMontant())<0 && typeOp.getCredit() == false) {
            // Solde insuffisant pour un débit
            return "redirect:/comptecourant/transaction/" + compte.getIdCompteCourant() + "?error=insufficient_funds";
        }
        operationscourant.setTypeOperation(typeOp);
        operationscourant.setDateOperation(operationscourant.getDateOperation().toString());
        operationscourant.setDateValeur(operationscourant.getDateOperation());
        if (typeOp.getCredit()==false) {
            double solde = compte.getSoldeActuel() - operationscourant.getMontant();
            operationscourant.setSoldeActuel(solde);
            compte.setSoldeActuel(solde);
        } else {
            double solde = compte.getSoldeActuel() + operationscourant.getMontant();
            operationscourant.setSoldeActuel(solde);
            compte.setSoldeActuel(solde);
        }
        service.update(compte.getIdCompteCourant(), compte);
        operationsCourantService.create(operationscourant);
        return "redirect:/comptecourant/all";
    }

    // @GetMapping("/formulaire/{id}")
    // public String formulaireUpdate(@PathVariable("id") Long id, Model model) {
    // CompteCourant comptecourant = service.getById(id);
    // model.addAttribute("comptecourant", comptecourant);
    // model.addAttribute("clients", clientService.getAll());
    // return view + "/creer";
    // }

    // @PostMapping("/update/{id}")
    // public String update(@PathVariable("id") Long id, @ModelAttribute
    // CompteCourant comptecourant) {
    // CompteCourant existingCompteCourant = service.getById(id);
    // existingCompteCourant.setNumeroCompte(comptecourant.getNumeroCompte());
    // existingCompteCourant.setSoldeActuel(comptecourant.getSoldeActuel());
    // existingCompteCourant.setDecouvertAutorise(comptecourant.getDecouvertAutorise());
    // service.update(id,existingCompteCourant);
    // return "redirect:/comptecourant/all";
    // }
}
