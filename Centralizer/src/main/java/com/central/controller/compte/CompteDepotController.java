package com.central.controller.compte;

import com.central.model.depot.*;
import com.central.service.depot.*;
import com.central.service.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.lang.reflect.Type;
import java.time.LocalDate;

@Controller
@RequestMapping("/comptedepot")
public class CompteDepotController {

    @Autowired
    private CompteDepotService service;
    @Autowired
    private ClientsService clientService;
    @Autowired
    private TypeOperationDepotService typeOperationService;
    @Autowired
    private OperationsDepotService operationsDepotService;
    @Autowired
    private TauxService tauxService;
    String view = "compte/depot";

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("comptedepot", service.getAll());
        return view + "/liste";
    }

    @GetMapping("/formulaire")
    public String formulaire(Model model) {
        model.addAttribute("comptedepot", new CompteDepot());
        model.addAttribute("clients", clientService.getAll());
        model.addAttribute("taux", tauxService.getAll());
        return view + "/creer";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute CompteDepot comptedepot) {
        Taux taux = tauxService.getById(comptedepot.getIdTaux());
        System.out.println(comptedepot.getIdTaux());
        comptedepot.setTaux(taux);
        comptedepot.setIdCompteDepot(0L);
        comptedepot.setSoldeActuel(0.0);
        comptedepot.setNumeroCompte("D" + (service.getAll().size() + 1));
        comptedepot.setDateOuverture(LocalDate.now().toString());
        comptedepot.setDateCloture(LocalDate.now().toString());
        System.out.println(comptedepot.getIdClient());
        service.add(comptedepot);
        return "redirect:/comptedepot/all";
    }

    @GetMapping("/transaction/{id}")
    public String transaction(@PathVariable("id") Long id, Model model) {
        CompteDepot comptedepot = service.getById(id);
        model.addAttribute("comptedepot", comptedepot);
        model.addAttribute("typeoperations", typeOperationService.getAll());
        OperationsDepot ops = new OperationsDepot();
        ops.setIdCompteDepot(id);
        ops.setCompteDepot(comptedepot);
        ops.setTypeOperation(new TypeOperationDepot());
        model.addAttribute("operationsdepot", ops);
        return view + "/transaction";
        // return "redirect:/comptedepot/all";
    }

    @PostMapping("/createTransaction/{id}")
    public String effectuerTransaction(@PathVariable("id") Long id,
            @ModelAttribute OperationsDepot operationsdepot,
            RedirectAttributes redirectAttributes) {

        // Set the compte depot ID from path variable
        operationsdepot.setIdCompteDepot(id);
        operationsdepot.setIdVirement(null);

        // Get the operation type
        TypeOperationDepot typeOp = typeOperationService.getById(
                operationsdepot.getTypeOperation().getIdTypeOperation());

        // Get the account
        CompteDepot compte = service.getById(id);

        // Check for insufficient funds on debit operations
        if (!typeOp.getCredit() && (compte.getSoldeActuel() - operationsdepot.getMontant()) < 0) {
            redirectAttributes.addFlashAttribute("mess", "Solde insuffisant pour effectuer cette opération");
            return "redirect:/comptedepot/transaction/" + id;
        }

        // Set operation details
        operationsdepot.setIdTypeOperation(typeOp.getIdTypeOperation());
        typeOp.setIdTypeOperation(0L);
        operationsdepot.setTypeOperation(typeOp);
        operationsdepot.setDateOperation(LocalDate.now().toString());
        operationsdepot.setDateValeur(LocalDate.now().toString());

        // Calculate new balance
        double nouveauSolde = 0.0;
        if (typeOp.getCredit()) {
            // Credit operation: add to balance
            nouveauSolde = compte.getSoldeActuel() + operationsdepot.getMontant();
        } else {
            // Debit operation: subtract from balance
            nouveauSolde = compte.getSoldeActuel() - operationsdepot.getMontant();
        }

        // Update balances
        operationsdepot.setSoldeActuel(nouveauSolde);
        compte.setSoldeActuel(nouveauSolde);

        System.out.println(operationsdepot.getIdTypeOperation());
        System.out.println(typeOp.getIdTypeOperation());
        // // Save changes
        service.update(compte);
        operationsdepot.setIdOperation(0L);
        operationsDepotService.add(operationsdepot);

        redirectAttributes.addFlashAttribute("success", "Transaction effectuée avec succès");
        return "redirect:/comptedepot/all";
    }

    // @GetMapping("/formulaire/{id}")
    // public String formulaireUpdate(@PathVariable("id") Long id, Model model) {
    // Comptedepot comptedepot = service.getById(id);
    // model.addAttribute("comptedepot", comptedepot);
    // model.addAttribute("clients", clientService.getAll());
    // return view + "/creer";
    // }

    // @PostMapping("/update/{id}")
    // public String update(@PathVariable("id") Long id, @ModelAttribute
    // Comptedepot comptedepot) {
    // Comptedepot existingComptedepot = service.getById(id);
    // existingComptedepot.setNumeroCompte(comptedepot.getNumeroCompte());
    // existingComptedepot.setSoldeActuel(comptedepot.getSoldeActuel());
    // existingComptedepot.setDecouvertAutorise(comptedepot.getDecouvertAutorise());
    // service.update(id,existingComptedepot);
    // return "redirect:/comptedepot/all";
    // }
}
