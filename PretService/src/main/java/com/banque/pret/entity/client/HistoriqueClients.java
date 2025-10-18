package com.banque.pret.entity.client;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "HistoriqueClients")
public class HistoriqueClients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorique;

    @ManyToOne
    @JoinColumn(name = "idClients")
    private Clients client;

    @ManyToOne
    @JoinColumn(name = "idStatusClient")
    private StatusClient statusClient;

    private LocalDate date_changement;

    public HistoriqueClients() {
    }

    public HistoriqueClients(Clients client, StatusClient statusClient,LocalDate date_changement) {
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

    public LocalDate getDate_changement() {
        return date_changement;
    }

    public void setDate_changement(LocalDate date_changement) {
        this.date_changement = date_changement;
    }
}
