package com.banque.courant.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "HistoriqueVirement") // nom de la table en minuscules
public class HistoriqueVirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVirement;

    private double montant;
    private String numeroCompteSource;
    private String numeroCompteDestination;
    private LocalDateTime dateVirement;

    // Constructeurs
    public HistoriqueVirement() {}

    public HistoriqueVirement(double montant, String numeroCompteSource, String numeroCompteDestination, LocalDateTime dateVirement) {
        this.montant = montant;
        this.numeroCompteSource = numeroCompteSource;
        this.numeroCompteDestination = numeroCompteDestination;
        this.dateVirement = dateVirement;
    }

    // Getters & Setters
    public Long getIdVirement() { return idVirement; }
    public void setIdVirement(Long idVirement) { this.idVirement = idVirement; }

    public double getMontant() { return montant; }
    public void setMontant(double montant) { this.montant = montant; }

    public String getNumeroCompteSource() { return numeroCompteSource; }
    public void setNumeroCompteSource(String numeroCompteSource) { this.numeroCompteSource = numeroCompteSource; }

    public String getNumeroCompteDestination() { return numeroCompteDestination; }
    public void setNumeroCompteDestination(String numeroCompteDestination) { this.numeroCompteDestination = numeroCompteDestination; }

    public LocalDateTime getDateVirement() { return dateVirement; }
    public void setDateVirement(LocalDateTime dateVirement) { this.dateVirement = dateVirement; }
}
