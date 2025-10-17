package com.central.controller.pret;

import com.central.service.pret.TypePretService;
import com.central.model.pret.TypePret;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/types-pret")
public class TypePretController {

    private final TypePretService service;
    String view = "pret/typespret";

    public TypePretController(TypePretService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("typespret", service.getAll());
        return view + "/liste";
    }

    @GetMapping("/formulaire")
    public String createForm(Model model) {
        model.addAttribute("typePret", new TypePret());
        return view + "/creer";
    }

    @PostMapping("/create")
    public String createForm(@ModelAttribute TypePret typePret,Model model) {
        typePret.setIdTypePret(null);
        // System.out.println("message");
        // System.out.println(typePret.getTaux_max()+"ok");
        service.create(typePret);
        model.addAttribute("typespret", service.getAll());
        return view + "/liste";
    }

    @GetMapping("/formulaire/{id}")
    public String updateForm(@PathVariable int id, Model model) {
        model.addAttribute("typePret", service.getById(id));
        return view + "/creer";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute TypePret typePret, @PathVariable Integer id, Model model) {
        typePret.setIdTypePret(id);
        service.update(id, typePret);
        model.addAttribute("typespret", service.getAll());
        return view + "/liste";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        service.delete(id);
        model.addAttribute("typespret", service.getAll());
        return view + "/liste";
    }
}
