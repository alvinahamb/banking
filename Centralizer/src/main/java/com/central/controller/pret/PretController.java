package com.central.controller.pret;

import com.central.service.pret.*;
import com.central.model.pret.*;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pret")
public class PretController {

    private final PretService service;
    private final TypePretService typepretservice;
    private final HistoriquePretService histoService;
    String view = "pret/pretDetails";

    public PretController(PretService service, TypePretService typepretservice, HistoriquePretService histoService) {
        this.service = service;
        this.typepretservice = typepretservice;
        this.histoService = histoService;
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        List<Pret> prets = service.getAll();

        // Pour chaque pret, récupérer et associer le TypePret
        for (Pret pret : prets) {
            pret.setTypePret(typepretservice.getById(pret.getTypePret().getIdTypePret()));
            pret.setHistoriquePret(histoService.getLatestByPret((pret.getIdPret()).intValue()));
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
        pret.setDate_operation(LocalDate.now().toString());
        pret.setDate_valeur(LocalDate.now().toString());

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
        // miss 
        // conditions sur les revenus
        service.create(pret);
        model.addAttribute("pret", service.getAll());
        // model.addAttribute("mess", pret.getDate_operation());
        return view + "/liste";
    }

    // @GetMapping("/formulaire/{id}")
    // public String updateForm(@PathVariable int id, Model model) {
    // model.addAttribute("pret", service.getById(id));
    // return view + "/creer";
    // }

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
