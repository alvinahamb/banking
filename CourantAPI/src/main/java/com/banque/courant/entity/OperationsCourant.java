package com.banque.courant.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "OperationsCourant") // table en minuscules
public class OperationsCourant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOperation;

    private BigDecimal montant;
    private LocalDateTime dateOperation;
    private LocalDateTime dateValeur;
    private BigDecimal soldeActuel;
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

    public OperationsCourant(BigDecimal montant, LocalDateTime dateOperation, LocalDateTime dateValeur,
                             BigDecimal soldeActuel, HistoriqueVirement virement,
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

    public BigDecimal getMontant() { return montant; }
    public void setMontant(BigDecimal montant) { this.montant = montant; }

    public LocalDateTime getDateOperation() { return dateOperation; }
    public void setDateOperation(LocalDateTime dateOperation) { this.dateOperation = dateOperation; }

    public LocalDateTime getDateValeur() { return dateValeur; }
    public void setDateValeur(LocalDateTime dateValeur) { this.dateValeur = dateValeur; }

    public BigDecimal getSoldeActuel() { return soldeActuel; }
    public void setSoldeActuel(BigDecimal soldeActuel) { this.soldeActuel = soldeActuel; }

    public HistoriqueVirement getVirement() { return virement; }
    public void setVirement(HistoriqueVirement virement) { this.virement = virement; }

    public TypeOperation getTypeOperation() { return typeOperation; }
    public void setTypeOperation(TypeOperation typeOperation) { this.typeOperation = typeOperation; }

    public CompteCourant getCompteCourant() { return compteCourant; }
    public void setCompteCourant(CompteCourant compteCourant) { this.compteCourant = compteCourant; }
}
