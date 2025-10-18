package com.central.model.courant;


public class OperationsCourant {

    private Long idOperation;
    private double montant;
    private String dateOperation;
    private String dateValeur;
    private double soldeActuel;
    private HistoriqueVirement virement;
    private TypeOperation typeOperation;
    private CompteCourant compteCourant;

    // Constructeurs
    public OperationsCourant() {}

    public OperationsCourant(Long idOperation, double montant, String dateOperation,
                             String dateValeur, double soldeActuel, HistoriqueVirement virement,
                             TypeOperation typeOperation, CompteCourant compteCourant) {
        this.idOperation = idOperation;
        this.montant = montant;
        this.dateOperation = dateOperation;
        this.dateValeur = dateValeur;
        this.soldeActuel = soldeActuel;
        this.virement = virement;
        this.typeOperation = typeOperation;
        this.compteCourant = compteCourant;
    }

    // Getters & Setters
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

    public HistoriqueVirement getVirement() { return virement; }
    public void setVirement(HistoriqueVirement virement) { this.virement = virement; }

    public TypeOperation getTypeOperation() { return typeOperation; }
    public void setTypeOperation(TypeOperation typeOperation) { this.typeOperation = typeOperation; }

    public CompteCourant getCompteCourant() { return compteCourant; }
    public void setCompteCourant(CompteCourant compteCourant) { this.compteCourant = compteCourant; }
}
