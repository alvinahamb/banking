package com.banque.pret.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "HistoriquePret")
public class HistoriquePret {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistoriquePret;

    @ManyToOne
    @JoinColumn(name = "idPret")
    private Pret pret;

    @ManyToOne
    @JoinColumn(name = "idStatusPret")
    private StatusPret statusPret;

    private LocalDate date_changement;

    public HistoriquePret() {}

    public HistoriquePret(Pret pret, StatusPret statusPret, LocalDate date_changement) {
        this.pret = pret;
        this.statusPret = statusPret;
        this.date_changement = date_changement;
    }

    // Getters & Setters
    public Long getIdHistoriquePret() { return idHistoriquePret; }
    public void setIdHistoriquePret(Long idHistoriquePret) { this.idHistoriquePret = idHistoriquePret; }

    public Pret getPret() { return pret; }
    public void setPret(Pret pret) { this.pret = pret; }

    public StatusPret getStatusPret() { return statusPret; }
    public void setStatusPret(StatusPret statusPret) { this.statusPret = statusPret; }

    public LocalDate getDate_changement() { return date_changement; }
    public void setDate_changement(LocalDate date_changement) { this.date_changement = date_changement; }
}
