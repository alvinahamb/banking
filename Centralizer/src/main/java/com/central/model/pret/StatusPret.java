package com.central.model.pret;

public class StatusPret {

    private Integer idStatusPret;
    private String libelle;

    // Constructeurs
    public StatusPret() {
    }

    public StatusPret(String libelle) {
        this.libelle = libelle;
    }

    // Getters
    public Integer getIdStatusPret() {
        return idStatusPret;
    }

    public String getLibelle() {
        return libelle;
    }

    // Setters
    public void setIdStatusPret(Integer id) {
        this.idStatusPret = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
