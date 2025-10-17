package com.central.controller.pret;

import com.central.model.pret.HistoriquePret;
import com.central.service.pret.HistoriquePretService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/historiques-pret")
public class HistoriquePretController {

    private final HistoriquePretService service;
    String view = "pret/pretDetails";

    public HistoriquePretController(HistoriquePretService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        List<HistoriquePret> historiques = service.getAll();
        model.addAttribute("historiques", historiques);
        return view;
    }

    @GetMapping("/byPret/{idPret}")
    public String getByPret(@PathVariable("idPret") Integer idPret, Model model) {
        List<HistoriquePret> historiques = service.getByPret(idPret);
        model.addAttribute("historiques", historiques);
        model.addAttribute("idPret", idPret);
        return view + "/historique";
    }
}
