package com.central.model.client;


public class StatusClient {

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
