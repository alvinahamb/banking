package com.banque.courant.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CompteCourant")
public class CompteCourant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompteCourant;

    private String numeroCompte;
    private Integer idClient;
    private  double soldeActuel;
    private LocalDate dateOuverture;
    private LocalDate dateCloture;
    private  double decouvertAutorise;

    // Constructeurs
    public CompteCourant() {}

    public CompteCourant(String numeroCompte, Integer idClient,  double soldeActuel,
                         LocalDate dateOuverture, LocalDate dateCloture,  double decouvertAutorise) {
        this.numeroCompte = numeroCompte;
        this.idClient = idClient;
        this.soldeActuel = soldeActuel;
        this.dateOuverture = dateOuverture;
        this.dateCloture = dateCloture;
        this.decouvertAutorise = decouvertAutorise;
    }

    // Getters & Setters
    public Long getIdCompteCourant() { return idCompteCourant; }
    public void setIdCompteCourant(Long idCompteCourant) { this.idCompteCourant = idCompteCourant; }

    public String getNumeroCompte() { return numeroCompte; }
    public void setNumeroCompte(String numeroCompte) { this.numeroCompte = numeroCompte; }

    public Integer getIdClient() { return idClient; }
    public void setIdClient(Integer idClient) { this.idClient = idClient; }

    public  double getSoldeActuel() { return soldeActuel; }
    public void setSoldeActuel( double soldeActuel) { this.soldeActuel = soldeActuel; }

    public LocalDate getDateOuverture() { return dateOuverture; }
    public void setDateOuverture(LocalDate dateOuverture) { this.dateOuverture = dateOuverture; }

    public LocalDate getDateCloture() { return dateCloture; }
    public void setDateCloture(LocalDate dateCloture) { this.dateCloture = dateCloture; }

    public  double getDecouvertAutorise() { return decouvertAutorise; }
    public void setDecouvertAutorise( double decouvertAutorise) { this.decouvertAutorise = decouvertAutorise; }
}
