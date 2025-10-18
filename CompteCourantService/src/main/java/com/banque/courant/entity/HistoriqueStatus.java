package com.banque.courant.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "HistoriqueStatus")
public class HistoriqueStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistoriqueCourant;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idCompteCourant", nullable = false)
    private CompteCourant compteCourant;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idStatus", nullable = false)
    private Status status;

    @Column(name = "dateChangement")
    private LocalDate dateChangement;

    // Constructeurs
    public HistoriqueStatus() {}

    public HistoriqueStatus(CompteCourant compteCourant, Status status, LocalDate dateChangement) {
        this.compteCourant = compteCourant;
        this.status = status;
        this.dateChangement = dateChangement;
    }

    // Getters & Setters
    public Long getIdHistoriqueCourant() { return idHistoriqueCourant; }
    public void setIdHistoriqueCourant(Long idHistoriqueCourant) { this.idHistoriqueCourant = idHistoriqueCourant; }

    public CompteCourant getCompteCourant() { return compteCourant; }
    public void setCompteCourant(CompteCourant compteCourant) { this.compteCourant = compteCourant; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public LocalDate getDateChangement() { return dateChangement; }
    public void setDateChangement(LocalDate dateChangement) { this.dateChangement = dateChangement; }
}
