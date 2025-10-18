package com.central.controller.client;

import com.central.model.client.HistoriqueClients;
import com.central.service.client.HistoriqueClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historiqueclients")
public class HistoriqueClientsController {

    @Autowired
    private HistoriqueClientsService service;

    @GetMapping("/all")
    public List<HistoriqueClients> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public HistoriqueClients getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public HistoriqueClients create(@RequestBody HistoriqueClients historique) {
        return service.create(historique);
    }

    @PostMapping("/update/{id}")
    public HistoriqueClients update(@PathVariable Long id, @RequestBody HistoriqueClients historique) {
        return service.update(id, historique);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
