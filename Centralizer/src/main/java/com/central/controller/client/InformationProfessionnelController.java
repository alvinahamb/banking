package com.central.controller.client;

import com.central.model.client.*;
import com.central.service.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/info")
public class InformationProfessionnelController {

    @Autowired
    private InformationProfessionnelService service;

    @GetMapping("/all")
    public List<InformationProfessionnel> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public InformationProfessionnel getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public InformationProfessionnel create(@RequestBody InformationProfessionnel info) {
        return service.create(info);
    }

    @PostMapping("/update/{id}")
    public InformationProfessionnel update(@PathVariable Long id, @RequestBody InformationProfessionnel info) {
        return service.update(id, info);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
