package com.central.model.depot;

public class OperationsDepot {

    private Long idOperation;
    private double montant;
    private String dateOperation;
    private String dateValeur;
    private double soldeActuel;
    private Long idVirement;
    private Long idTypeOperation;
    private Long idCompteDepot;
    private TypeOperationDepot typeOperation;
    private CompteDepot compteDepot;

    public OperationsDepot() {}

    public OperationsDepot(Long idOperation, double montant, String dateOperation, String dateValeur,
                           double soldeActuel, Long idVirement, Long idTypeOperation,
                           Long idCompteDepot, TypeOperationDepot typeOperation, CompteDepot compteDepot) {
        this.idOperation = idOperation;
        this.montant = montant;
        this.dateOperation = dateOperation;
        this.dateValeur = dateValeur;
        this.soldeActuel = soldeActuel;
        this.idVirement = idVirement;
        this.idTypeOperation = idTypeOperation;
        this.idCompteDepot = idCompteDepot;
        this.typeOperation = typeOperation;
        this.compteDepot = compteDepot;
    }

    public Long getIdOperation() { return idOperation; }
    public void setIdOperation(Long idOperation) { this.idOperation = idOperation; }

    public double getMontant() { return montant; }
    public void setMontant(double montant) { this.montant = montant; }

    public String getDateOperation() { return dateOperation; }
    public void setDateOperation(String dateOperation) { this.dateOperation = dateOperation; }

    public String getDateValeur() { return dateValeur; }
    public void setDateValeur(String dateValeur) { this.dateValeur = dateValeur; }

    public double getSoldeActuel() { return soldeActuel; }
    public void setSoldeActuel(double soldeActuel) { this.soldeActuel = soldeActuel; }

    public Long getIdVirement() { return idVirement; }
    public void setIdVirement(Long idVirement) { this.idVirement = idVirement; }

    public Long getIdTypeOperation() { return idTypeOperation; }
    public void setIdTypeOperation(Long idTypeOperation) { this.idTypeOperation = idTypeOperation; }

    public Long getIdCompteDepot() { return idCompteDepot; }
    public void setIdCompteDepot(Long idCompteDepot) { this.idCompteDepot = idCompteDepot; }

    public TypeOperationDepot getTypeOperation() { return typeOperation; }
    public void setTypeOperation(TypeOperationDepot typeOperation) { this.typeOperation = typeOperation; }

    public CompteDepot getCompteDepot() { return compteDepot; }
    public void setCompteDepot(CompteDepot compteDepot) { this.compteDepot = compteDepot; }
}

