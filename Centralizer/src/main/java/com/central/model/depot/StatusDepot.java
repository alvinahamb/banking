package com.central.model.depot;

public class StatusDepot {

    private Long idStatus;
    private String libelle;

    public StatusDepot() {}

    public StatusDepot(Long idStatus, String libelle) {
        this.idStatus = idStatus;
        this.libelle = libelle;
    }

    public Long getIdStatus() { return idStatus; }
    public void setIdStatus(Long idStatus) { this.idStatus = idStatus; }

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }
}

