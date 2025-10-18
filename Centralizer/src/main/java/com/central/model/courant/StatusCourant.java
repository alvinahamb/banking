package com.central.model.courant;

public class StatusCourant {

    private Long idStatus;
    private String libelle;

    // Constructeurs
    public StatusCourant() {}

    public StatusCourant(Long idStatus, String libelle) {
        this.idStatus = idStatus;
        this.libelle = libelle;
    }

    // Getters & Setters
    public Long getIdStatus() { return idStatus; }
    public void setIdStatus(Long idStatus) { this.idStatus = idStatus; }

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }
}

