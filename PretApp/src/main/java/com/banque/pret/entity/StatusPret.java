package com.banque.pret.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "StatusPret")
public class StatusPret {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStatusPret;

    private String libelle;

    public StatusPret(String libelle) {
        this.libelle = libelle;
    }

    public StatusPret() {
    }

    // Getters
    public Long getIdStatusPret() {
        return idStatusPret;
    }

    public String getLibelle() {
        return libelle;
    }

    // Setters
    public void setIdStatusPret(Long idStatusPret) {
        this.idStatusPret = idStatusPret;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
