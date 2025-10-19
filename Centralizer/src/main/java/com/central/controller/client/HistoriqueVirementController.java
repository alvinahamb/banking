package com.central.controller.client;

import com.central.model.courant.*;
import com.central.model.depot.CompteDepot;
import com.central.model.depot.OperationsDepot;
import com.central.model.depot.TypeOperationDepot;
import com.central.service.courant.*;
import com.central.service.depot.CompteDepotService;
import com.central.service.depot.OperationsDepotService;
import com.central.service.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/compte/virement/")
public class HistoriqueVirementController {

    @Autowired
    private HistoriqueVirementService service;
    @Autowired
    private CompteCourantService courant;
    @Autowired
    private CompteDepotService depot;
    @Autowired
    private TypeOperationService typeoperation;
    @Autowired
    private OperationsCourantService operationcourant;
    @Autowired
    private OperationsDepotService operationdepot;
    String view = "compte/virement";

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("virement", service.getAll());
        return view + "/liste";
    }

    @GetMapping("/formulaire")
    public String form(Model model) {
        model.addAttribute("comptedepot", depot.getAll());
        model.addAttribute("comptecourant", courant.getAll());
        model.addAttribute("virement", new HistoriqueVirement());
        return view + "/creer";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute HistoriqueVirement h, Model model, RedirectAttributes redirectAttributes) {
        // typeOperation
        List<TypeOperation> listes = typeoperation.getAll();
        TypeOperation to1 = new TypeOperation();
        TypeOperation to2 = new TypeOperation();
        for (TypeOperation typeOperation : listes) {
            if (typeOperation.getLibelle().equals("Virement emis")) {
                to1 = typeOperation;
            }
            if (typeOperation.getLibelle().equals("Virement recu")) {
                to2 = typeOperation;
            }
        }
        // comptes
        double montant = h.getMontant();
        String numeroSource = h.getNumeroCompteSource();
        String numeroDestination = h.getNumeroCompteDestination();
        // Séparer la lettre et le chiffre
        String type1 = numeroSource.substring(0, 1); // "C"
        Long id1 = Long.parseLong(numeroSource.substring(1)); // 123L
        String type2 = numeroDestination.substring(0, 1); // "D"
        Long id2 = Long.parseLong(numeroDestination.substring(1)); // 123L
        // Verification
        if (type1.equals("C")) {
            System.out.println("c");
            CompteCourant source = courant.getById(id1);
            if (source.getSoldeActuel() < montant) {
                redirectAttributes.addFlashAttribute("mess", "Solde insuffisant");
                return "redirect:/compte/virement/formulaire";
            }
        }
        if (type1.equals("D")) {
            System.out.println("d");
            CompteDepot source = depot.getById(id1);
            double moitie = source.getSoldeActuel()/2;
            double reste = source.getSoldeActuel() - montant;
            System.out.println(reste);
            System.out.println(moitie);
            // limite
            if (reste < moitie) {
                redirectAttributes.addFlashAttribute("mess", "Solde insuffisant depot");
                return "redirect:/compte/virement/formulaire";
            }
        }
        // add virement
        h.setIdOperation1(0L);
        h.setIdOperation2(0L);
        h.setDateVirement(LocalDate.now().toString());
        HistoriqueVirement newHistoriqueVirement = service.create(h);

        // Source
        if (type1.equals("C")) {
            // System.out.println("c");
            CompteCourant source = courant.getById(id1);
            double solde = source.getSoldeActuel() - montant;
            source.setSoldeActuel(solde);
            OperationsCourant operation = new OperationsCourant(null, montant,
                    LocalDate.now().toString(),
                    LocalDate.now().toString(), solde, newHistoriqueVirement, to1, source);
            courant.update(id1, source);
            operationcourant.create(operation);
        }
        if (type1.equals("D")) {
            System.out.println("d");
            CompteDepot source = depot.getById(id1);
            double solde = source.getSoldeActuel() - montant;
            System.out.println(solde);
            source.setSoldeActuel(solde);
            TypeOperationDepot tod = new TypeOperationDepot(to1.getIdTypeOperation(),
                    to1.getLibelle(),
                    to1.getCredit());
            OperationsDepot operation = new OperationsDepot(0L, montant,
                    LocalDate.now().toString(),
                    LocalDate.now().toString(), solde, newHistoriqueVirement.getIdVirement(),
                    tod.getIdTypeOperation(),
                    source.getIdCompteDepot(), null, null);
            depot.update(source);
            operationdepot.add(operation);
        }
        // destination
        if (type2.equals("C")) {
            System.out.println("c");
            CompteCourant source = courant.getById(id2);
            double solde = source.getSoldeActuel() + montant;
            source.setSoldeActuel(solde);
            OperationsCourant operation = new OperationsCourant(null, montant,
                    LocalDate.now().toString(),
                    LocalDate.now().toString(), solde, newHistoriqueVirement, to2, source);
            courant.update(id2, source);
            operationcourant.create(operation);
        }
        if (type2.equals("D")) {
            System.out.println("D");
            CompteDepot source = depot.getById(id2);
            double solde = source.getSoldeActuel() + montant;
            source.setSoldeActuel(solde);
            TypeOperationDepot tod = new TypeOperationDepot(to2.getIdTypeOperation(),
                    to2.getLibelle(),
                    to2.getCredit());
            OperationsDepot operation = new OperationsDepot(0L, montant,
                    LocalDate.now().toString(),
                    LocalDate.now().toString(), solde, newHistoriqueVirement.getIdVirement(),
                    tod.getIdTypeOperation(),
                    source.getIdCompteDepot(), null, null);
            depot.update(source);
            operationdepot.add(operation);
        }
        System.out.println("vitaaaaaa");
        return "redirect:/compte/virement/all";
    }
}
