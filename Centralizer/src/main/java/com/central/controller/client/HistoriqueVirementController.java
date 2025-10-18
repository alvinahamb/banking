package com.central.controller.client;

import com.central.model.client.HistoriqueVirement;
import com.central.service.client.HistoriqueVirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/virements")
public class HistoriqueVirementController {

    @Autowired
    private HistoriqueVirementService service;

    @PostMapping
    public HistoriqueVirement create(@RequestBody HistoriqueVirement virement) {
        return service.create(virement);
    }

    @GetMapping("/{id}")
    public HistoriqueVirement getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<HistoriqueVirement> getAll() {
        return service.getAll();
    }

    @PostMapping("/update/{id}")
    public HistoriqueVirement update(@PathVariable Long id, @RequestBody HistoriqueVirement virement) {
        return service.update(id, virement);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
