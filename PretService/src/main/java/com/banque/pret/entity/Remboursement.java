package com.banque.pret.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Remboursement")
public class Remboursement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRemboursement;

    private Integer idClient;
    private Double montant;
    private LocalDate date_remboursement;
    private String numero_compte;

    @ManyToOne
    @JoinColumn(name = "idEcheance", nullable = false)
    private Echeance echeance;

    @ManyToOne
    @JoinColumn(name = "idPret", nullable = false)
    private Pret pret;

    public Remboursement() {}

    public Remboursement(Integer idClient, Double montant, LocalDate date_remboursement,
                         String numero_compte, Echeance echeance, Pret pret) {
        this.idClient = idClient;
        this.montant = montant;
        this.date_remboursement = date_remboursement;
        this.numero_compte = numero_compte;
        this.echeance = echeance;
        this.pret = pret;
    }

    // Getters & Setters
    public Long getIdRemboursement() { return idRemboursement; }
    public void setIdRemboursement(Long idRemboursement) { this.idRemboursement = idRemboursement; }

    public Integer getIdClient() { return idClient; }
    public void setIdClient(Integer idClient) { this.idClient = idClient; }

    public Double getMontant() { return montant; }
    public void setMontant(Double montant) { this.montant = montant; }

    public LocalDate getDate_remboursement() { return date_remboursement; }
    public void setDate_remboursement(LocalDate date_remboursement) { this.date_remboursement = date_remboursement; }

    public String getNumero_compte() { return numero_compte; }
    public void setNumero_compte(String numero_compte) { this.numero_compte = numero_compte; }

    public Echeance getEcheance() { return echeance; }
    public void setEcheance(Echeance echeance) { this.echeance = echeance; }

    public Pret getPret() { return pret; }
    public void setPret(Pret pret) { this.pret = pret; }
}
