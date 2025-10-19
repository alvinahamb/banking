package com.central.controller.pret;

import com.central.model.pret.Echeance;
import com.central.service.pret.EcheanceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/echeances")
public class EcheanceController {

    private final EcheanceService service;
    String view = "pret/pretDetails";

    public EcheanceController(EcheanceService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        List<Echeance> echeances = service.getAll();
        model.addAttribute("echeances", echeances);
        return view+"/echeances";
    }

    @GetMapping("/pret/{idPret}")
    public String getByPret(@PathVariable Long idPret, Model model) {
        List<Echeance> echeances = service.getByPret(idPret);
        model.addAttribute("echeances", echeances);
        model.addAttribute("idPret", idPret);
        return view+"/echeances";
    }
}
