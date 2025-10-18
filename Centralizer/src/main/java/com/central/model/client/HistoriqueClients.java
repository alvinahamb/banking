package com.central.model.client;

import java.util.Date;

public class HistoriqueClients {

    private Long idHistorique;
    private Clients client;
    private StatusClient statusClient;
    private Date date_changement;

    public HistoriqueClients() {
    }

    public HistoriqueClients(Clients client, StatusClient statusClient, Date date_changement) {
        this.client = client;
        this.statusClient = statusClient;
        this.date_changement = date_changement;
    }

    public Long getIdHistorique() {
        return idHistorique;
    }

    public void setIdHistorique(Long idHistorique) {
        this.idHistorique = idHistorique;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public StatusClient getStatusClient() {
        return statusClient;
    }

    public void setStatusClient(StatusClient statusClient) {
        this.statusClient = statusClient;
    }

    public Date getDate_changement() {
        return date_changement;
    }

    public void setDate_changement(Date date_changement) {
        this.date_changement = date_changement;
    }
}
