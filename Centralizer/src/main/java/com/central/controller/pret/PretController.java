package com.central.controller.pret;

import com.central.service.pret.*;
import com.central.model.pret.*;
import com.central.model.depot.*;
import com.central.model.courant.*;
import com.central.service.client.*;
import com.central.model.client.*;
import com.central.model.courant.OperationsCourant;
import com.central.model.courant.TypeOperation;
import com.central.model.depot.OperationsDepot;
import com.central.service.courant.*;
import com.central.service.depot.*;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pret")
public class PretController {

    @Autowired
    private PretService service;
    @Autowired
    private TypePretService typepretservice;
    @Autowired
    private HistoriquePretService histoService;
    @Autowired
    private ClientsService clientsService;
    @Autowired
    private CompteCourantService courant;
    @Autowired
    private CompteDepotService depot;
    @Autowired
    private EcheanceService echeanceService;
    @Autowired
    private RemboursementService remboursementService;
    @Autowired
    private TypeOperationService typeoperation;
    @Autowired
    private StatusPretService statusService;
    @Autowired
    private OperationsCourantService operationcourant;
    @Autowired
    private OperationsDepotService operationdepot;
    String view = "pret/pretDetails";

    @GetMapping("/all")
    public String getAll(Model model) {
        List<Pret> prets = service.getAll();

        // Pour chaque pret, récupérer et associer le TypePret
        for (Pret pret : prets) {
            pret.setTypePret(typepretservice.getById(pret.getTypePret().getIdTypePret()));
            // pret.setHistoriquePret(histoService.getLatestByPret((pret.getIdPret()).intValue()));
        }

        model.addAttribute("pret", prets);
        return view + "/liste";
    }

    @GetMapping("/formulaire")
    public String createForm(Model model) {
        model.addAttribute("pret", new Pret());
        model.addAttribute("typepret", typepretservice.getAll());
        return view + "/creer";
    }

    @PostMapping("/create")
    public String createForm(@ModelAttribute Pret pret, Model model) {
        pret.setIdPret(null);
        TypePret typePret = typepretservice.getById(pret.getTypePret().getIdTypePret());
        Clients client = clientsService.getById(pret.getIdClient().longValue());
        if (client == null) {
            model.addAttribute("mess", "Client inexistant.");
            model.addAttribute("typepret", typepretservice.getAll());
            return view + "/creer";
        }
        pret.setDate_operation(pret.getDate_operation().toString());
        pret.setDate_valeur(pret.getDate_operation().toString());

        // conditions de validation
        if (typePret.getMontant_min() > pret.getMontant() || pret.getMontant() > typePret.getMontant_max()) {
            model.addAttribute("mess", "Montant hors limites pour ce type de prêt.");
            model.addAttribute("typepret", typepretservice.getAll());
            return view + "/creer";
        }
        if (pret.getTaux() < typePret.getTaux_min() || pret.getTaux() > typePret.getTaux_max()) {
            model.addAttribute("mess", "Taux hors limites pour ce type de prêt.");
            model.addAttribute("typepret", typepretservice.getAll());
            return view + "/creer";
        }
        if (pret.getDuree_mois() < typePret.getDuree_min() || pret.getDuree_mois() > typePret.getDuree_max()) {
            model.addAttribute("mess", "Durée hors limites pour ce type de prêt.");
            model.addAttribute("typepret", typepretservice.getAll());
            return view + "/creer";
        }
        // conditions sur les revenus
        if (client.getRevenuActuel().getValeur_max() < typePret.getRevenus_min()) {
            model.addAttribute("mess", "Revenus insuffisants pour ce type de prêt.");
            model.addAttribute("typepret", typepretservice.getAll());
            return view + "/creer";
        }
        service.create(pret);
        model.addAttribute("pret", service.getAll());
        // model.addAttribute("mess", pret.getDate_operation());
        return view + "/liste";
    }

    @GetMapping("/remboursement/{id}")
    public String formRemboursement(@PathVariable Long id, Model model) {
        model.addAttribute("comptedepot", depot.getAll());
        model.addAttribute("comptecourant", courant.getAll());
        Echeance echeance = echeanceService.lastUnpaidEcheance(id);
        if (echeance == null) {
            model.addAttribute("mess", "Plus de echeance non paye");
            return getAll(model);
        }
        System.out.println(echeance.getDate_echance());
        model.addAttribute("echeance", echeance);

        Remboursement r = new Remboursement();
        r.setEcheance(echeance);
        model.addAttribute("remboursement", r);
        return view + "/remboursement";
    }

    @PostMapping("/reboursement/paiement/{idEcheance}")
    public String effectuerRemboursement(@PathVariable Long idEcheance, @ModelAttribute Remboursement remboursement,
            Model model) {
        // Récupérer l'échéance
        Echeance echeance = echeanceService.getById(idEcheance);
        if (echeance == null) {
            model.addAttribute("mess", "Échéance introuvable.");
            return "redirect:/pret/all";
        }
        System.out.println(idEcheance);

        String numeroCompte = remboursement.getNumero_compte();
        Double soldeCompte = null;
        String type = numeroCompte.substring(0, 1); // "C"
        Long id = Long.parseLong(numeroCompte.substring(1));

        List<TypeOperation> listes = typeoperation.getAll();
        TypeOperation to = new TypeOperation();
        for (TypeOperation typeOperation : listes) {
            if (typeOperation.getLibelle().equals("remboursement")) {
                to = typeOperation;
            }
        }

        System.out.println("id");
        System.out.println(id);
        // Vérifier si le compte existe et récupérer son solde
        if (numeroCompte.startsWith("D")) {
            try {
                soldeCompte = depot.getById(id).getSoldeActuel();
            } catch (Exception e) {
                model.addAttribute("mess", "Compte dépôt invalide.");
                return formRemboursement(echeance.getPret().getIdPret(), model);
            }
        } else if (numeroCompte.startsWith("C")) {
            try {
                soldeCompte = courant.getById(id).getSoldeActuel();
            } catch (Exception e) {
                model.addAttribute("mess", "Compte courant invalide.");
                return formRemboursement(echeance.getPret().getIdPret(), model);
            }
        }

        // Vérifier le solde
        if (soldeCompte == null || soldeCompte < remboursement.getMontant()) {
            model.addAttribute("mess", "Solde insuffisant sur le compte.");
            return formRemboursement(echeance.getPret().getIdPret(), model);
        }
        double solde = soldeCompte - remboursement.getMontant();
        // limite 50%
        if (numeroCompte.startsWith("D") && (solde < (soldeCompte / 2))) {
            System.out.println("fg");
            model.addAttribute("mess", "Solde insuffisant sur le compte.");
            return formRemboursement(echeance.getPret().getIdPret(), model);
        }
        // System.out.println("solde");
        // System.out.println(soldeCompte - remboursement.getMontant());
        // System.out.println(soldeCompte);
        // System.out.println(remboursement.getMontant());
        // System.out.println(soldeCompte / 2);
        // System.out.print("ok");
        // Effectuer le débit sur le compte
        double soldeActuel = soldeCompte - remboursement.getMontant();
        try {
            if (numeroCompte.startsWith("D")) {
                CompteDepot cd = depot.getById(id);
                cd.setSoldeActuel(soldeActuel);
                depot.update(cd);

                OperationsDepot operation = new OperationsDepot(0L, remboursement.getMontant(),
                        remboursement.getDate_remboursement().toString(),
                        remboursement.getDate_remboursement().toString(), soldeActuel, 0L,
                        to.getIdTypeOperation(),
                        cd.getIdCompteDepot(), null, null);
                operationdepot.add(operation);
            } else {
                CompteCourant cc = courant.getById(id);
                cc.setSoldeActuel(soldeCompte - remboursement.getMontant());
                courant.update(id, cc);
                OperationsCourant operation = new OperationsCourant(null, remboursement.getMontant(),
                        remboursement.getDate_remboursement().toString(),
                        remboursement.getDate_remboursement().toString(), soldeActuel, null, to, cc);
                courant.update(id, courant.getById(id));
                operationcourant.create(operation);

            }
        } catch (Exception e) {
            model.addAttribute("mess", "Erreur lors du débit du compte.");
            return formRemboursement(echeance.getPret().getIdPret(), model);
        }

        // Mettre à jour l'échéance
        List<StatusPret> status = statusService.getAll();
        StatusPret sp = new StatusPret();
        for (StatusPret s : status) {
            if (s.getLibelle().equals("paye")) {
                sp = s;
            }
        }

        echeance.setStatusPret(sp);
        echeanceService.update(idEcheance, echeance);

        // // Créer le remboursement
        remboursement.setEcheance(echeance);
        remboursement.setPret(echeance.getPret());
        remboursementService.create(remboursement);

        model.addAttribute("mess", "Remboursement effectué avec succès.");
        return "redirect:/pret/all";
    }

    // @PostMapping("/update/{id}")
    // public String update(@ModelAttribute Pret Pret, @PathVariable Integer id,
    // Model model) {
    // Pret.setIdPret(id);
    // service.update(id, Pret);
    // model.addAttribute("pret", service.getAll());
    // return view + "/liste";
    // }

    // @GetMapping("/delete/{id}")
    // public String delete(@PathVariable int id, Model model) {
    // service.delete(id);
    // model.addAttribute("pret", service.getAll());
    // return view + "/liste";
    // }
}
