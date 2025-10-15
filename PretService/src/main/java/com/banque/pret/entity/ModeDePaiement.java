package com.banque.pret.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ModeDePaiement")
public class ModeDePaiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModeDePaiement;

    private String libelle;

    public ModeDePaiement(String libelle) {
        this.libelle = libelle;
    }

    public ModeDePaiement() {
    }

    // Getters
    public Long getIdModeDePaiement() {
        return idModeDePaiement;
    }

    public String getLibelle() {
        return libelle;
    }

    // Setters
    public void setIdModeDePaiement(Long idModeDePaiement) {
        this.idModeDePaiement = idModeDePaiement;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
