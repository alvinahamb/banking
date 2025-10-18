package com.central.model.courant;

import java.time.LocalDate;

public class HistoriqueStatus {

    private Long idHistoriqueCourant;
    private CompteCourant compteCourant;
    private StatusCourant status;
    private LocalDate dateChangement;

    // Constructeurs
    public HistoriqueStatus() {}

    public HistoriqueStatus(Long idHistoriqueCourant, CompteCourant compteCourant, StatusCourant status, LocalDate dateChangement) {
        this.idHistoriqueCourant = idHistoriqueCourant;
        this.compteCourant = compteCourant;
        this.status = status;
        this.dateChangement = dateChangement;
    }

    // Getters & Setters
    public Long getIdHistoriqueCourant() { return idHistoriqueCourant; }
    public void setIdHistoriqueCourant(Long idHistoriqueCourant) { this.idHistoriqueCourant = idHistoriqueCourant; }

    public CompteCourant getCompteCourant() { return compteCourant; }
    public void setCompteCourant(CompteCourant compteCourant) { this.compteCourant = compteCourant; }

    public StatusCourant getStatus() { return status; }
    public void setStatus(StatusCourant status) { this.status = status; }

    public LocalDate getDateChangement() { return dateChangement; }
    public void setDateChangement(LocalDate dateChangement) { this.dateChangement = dateChangement; }
}

