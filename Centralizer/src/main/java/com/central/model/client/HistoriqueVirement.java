package com.central.model.client;

import java.time.LocalDate;

public class HistoriqueVirement {
    
    private Long idVirement;
    private Long idOperationDebit;
    private Long idOperationCredit;
    private String numeroCompteSource;
    private String numeroCompteDestination;
    private Double montant;
    private LocalDate dateVirement;

    public HistoriqueVirement() {
    }

    public HistoriqueVirement(Long idOperationDebit, Long idOperationCredit, String numeroCompteSource,
            String numeroCompteDestination, Double montant, LocalDate dateVirement) {
        this.idOperationDebit = idOperationDebit;
        this.idOperationCredit = idOperationCredit;
        this.numeroCompteSource = numeroCompteSource;
        this.numeroCompteDestination = numeroCompteDestination;
        this.montant = montant;
        this.dateVirement = dateVirement;
    }
    
    public Long getIdVirement() {
        return idVirement;
    }
    public void setIdVirement(Long idVirement) {
        this.idVirement = idVirement;
    }

    public Long getIdOperationDebit() {
        return idOperationDebit;
    }
    public void setIdOperationDebit(Long idOperationDebit) {
        this.idOperationDebit = idOperationDebit;
    }

    public Long getIdOperationCredit() {
        return idOperationCredit;
    }
    public void setIdOperationCredit(Long idOperationCredit) {
        this.idOperationCredit = idOperationCredit;
    }

    public String getNumeroCompteSource() {
        return numeroCompteSource;
    }
    public void setNumeroCompteSource(String numeroCompteSource) {
        this.numeroCompteSource = numeroCompteSource;
    }

    public String getNumeroCompteDestination() {
        return numeroCompteDestination;
    }
    public void setNumeroCompteDestination(String numeroCompteDestination) {
        this.numeroCompteDestination = numeroCompteDestination;
    }

    public Double getMontant() {
        return montant;
    }
    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public LocalDate getDateVirement() {
        return dateVirement;
    }
    public void setDateVirement(LocalDate dateVirement) {
        this.dateVirement = dateVirement;
    }
}
