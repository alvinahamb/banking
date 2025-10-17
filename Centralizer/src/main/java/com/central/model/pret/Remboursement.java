package com.central.model.pret;

;

public class Remboursement {

    private Long idRemboursement;
    private Integer idClient;
    private Double montant;
    private String date_remboursement;
    private String numero_compte;
    private Echeance echeance;
    private Pret pret;

    public Long getIdRemboursement() { return idRemboursement; }
    public void setIdRemboursement(Long idRemboursement) { this.idRemboursement = idRemboursement; }

    public Integer getIdClient() { return idClient; }
    public void setIdClient(Integer idClient) { this.idClient = idClient; }

    public Double getMontant() { return montant; }
    public void setMontant(Double montant) { this.montant = montant; }

    public String getDate_remboursement() { return date_remboursement; }
    public void setDate_remboursement(String date_remboursement) { this.date_remboursement = date_remboursement; }

    public String getNumero_compte() { return numero_compte; }
    public void setNumero_compte(String numero_compte) { this.numero_compte = numero_compte; }

    public Echeance getEcheance() { return echeance; }
    public void setEcheance(Echeance echeance) { this.echeance = echeance; }

    public Pret getPret() { return pret; }
    public void setPret(Pret pret) { this.pret = pret; }
}
