package com.banque.pret.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Echeance")
public class Echeance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEcheance;

    private Double capital_debut;
    private Double montant_interet;
    private Double amortissement;
    private Double annuite;
    private Double capital_fin;
    private LocalDateTime date_echance;

    @ManyToOne
    @JoinColumn(name = "idPret", nullable = false)
    private Pret pret;

    @ManyToOne
    @JoinColumn(name = "idStatusPret", nullable = false)
    private StatusPret statusPret;

    public Echeance() {}

    public Echeance(Double capital_debut, Double montant_interet, Double amortissement,
                    Double annuite, Double capital_fin, LocalDateTime date_echance,
                    Pret pret, StatusPret statusPret) {
        this.capital_debut = capital_debut;
        this.montant_interet = montant_interet;
        this.amortissement = amortissement;
        this.annuite = annuite;
        this.capital_fin = capital_fin;
        this.date_echance = date_echance;
        this.pret = pret;
        this.statusPret = statusPret;
    }

    // Getters & Setters
    public Long getIdEcheance() { return idEcheance; }
    public void setIdEcheance(Long idEcheance) { this.idEcheance = idEcheance; }

    public Double getCapital_debut() { return capital_debut; }
    public void setCapital_debut(Double capital_debut) { this.capital_debut = capital_debut; }

    public Double getMontant_interet() { return montant_interet; }
    public void setMontant_interet(Double montant_interet) { this.montant_interet = montant_interet; }

    public Double getAmortissement() { return amortissement; }
    public void setAmortissement(Double amortissement) { this.amortissement = amortissement; }

    public Double getAnnuite() { return annuite; }
    public void setAnnuite(Double annuite) { this.annuite = annuite; }

    public Double getCapital_fin() { return capital_fin; }
    public void setCapital_fin(Double capital_fin) { this.capital_fin = capital_fin; }

    public LocalDateTime getDate_echance() { return date_echance; }
    public void setDate_echance(LocalDateTime date_echance) { this.date_echance = date_echance; }

    public Pret getPret() { return pret; }
    public void setPret(Pret pret) { this.pret = pret; }

    public StatusPret getStatusPret() { return statusPret; }
    public void setStatusPret(StatusPret statusPret) { this.statusPret = statusPret; }
}
