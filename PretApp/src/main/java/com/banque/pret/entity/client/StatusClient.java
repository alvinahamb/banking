package com.banque.pret.entity.client;

import jakarta.persistence.*;

@Entity
@Table(name = "StatusClient")
public class StatusClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStatusClient;

    private String libelle;

    public StatusClient() {
    }

    public StatusClient(String libelle) {
        this.libelle = libelle;
    }

    public Long getIdStatusClient() {
        return idStatusClient;
    }

    public void setIdStatusClient(Long idStatusClient) {
        this.idStatusClient = idStatusClient;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
