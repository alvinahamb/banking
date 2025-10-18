package com.central.model.courant;

import java.time.LocalDate;

public class HistoriqueVirement {

    private Long idVirement;
    private Long idOperation1;
    private Long idOperation2;
    private double montant;
    private String numeroCompteSource;
    private String numeroCompteDestination;
    private LocalDate dateVirement;

    // Constructeurs
    public HistoriqueVirement() {}

    public HistoriqueVirement(Long idVirement, double montant, String numeroCompteSource,
                              String numeroCompteDestination, LocalDate dateVirement,
                              Long idOperation1, Long idOperation2) {
        this.idVirement = idVirement;
        this.montant = montant;
        this.numeroCompteSource = numeroCompteSource;
        this.numeroCompteDestination = numeroCompteDestination;
        this.dateVirement = dateVirement;
        this.idOperation1 = idOperation1;
        this.idOperation2 = idOperation2;
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

    public LocalDate getDateVirement() { return dateVirement; }
    public void setDateVirement(LocalDate dateVirement) { this.dateVirement = dateVirement; }

    public Long getIdOperation1() { return idOperation1; }
    public void setIdOperation1(Long idOperation1) { this.idOperation1 = idOperation1; }

    public Long getIdOperation2() { return idOperation2; }
    public void setIdOperation2(Long idOperation2) { this.idOperation2 = idOperation2; }
}

