package com.banque.courant.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "OperationsCourant") // table en minuscules
public class OperationsCourant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOperation;

    private  double montant;
    private LocalDate dateOperation;
    private LocalDate dateValeur;
    private  double soldeActuel;
    @ManyToOne
    @JoinColumn(name = "idVirement")
    private HistoriqueVirement virement;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idTypeOperation", nullable = false)
    private TypeOperation typeOperation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idCompteCourant", nullable = false)
    private CompteCourant compteCourant;

    // Constructeurs
    public OperationsCourant() {}

    public OperationsCourant( double montant, LocalDate dateOperation, LocalDate dateValeur,
                              double soldeActuel, HistoriqueVirement virement,
                             TypeOperation typeOperation, CompteCourant compteCourant) {
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

    public  double getMontant() { return montant; }
    public void setMontant( double montant) { this.montant = montant; }

    public LocalDate getDateOperation() { return dateOperation; }
    public void setDateOperation(LocalDate dateOperation) { this.dateOperation = dateOperation; }

    public LocalDate getDateValeur() { return dateValeur; }
    public void setDateValeur(LocalDate dateValeur) { this.dateValeur = dateValeur; }

    public  double getSoldeActuel() { return soldeActuel; }
    public void setSoldeActuel( double soldeActuel) { this.soldeActuel = soldeActuel; }

    public HistoriqueVirement getVirement() { return virement; }
    public void setVirement(HistoriqueVirement virement) { this.virement = virement; }

    public TypeOperation getTypeOperation() { return typeOperation; }
    public void setTypeOperation(TypeOperation typeOperation) { this.typeOperation = typeOperation; }

    public CompteCourant getCompteCourant() { return compteCourant; }
    public void setCompteCourant(CompteCourant compteCourant) { this.compteCourant = compteCourant; }
}
