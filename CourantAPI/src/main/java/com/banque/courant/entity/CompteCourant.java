package com.banque.courant.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "CompteCourant")
public class CompteCourant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompteCourant;

    private String numeroCompte;
    private Integer idClient;
    private BigDecimal soldeActuel;
    private LocalDateTime dateOuverture;
    private LocalDateTime dateCloture;
    private BigDecimal decouvertAutorise;

    // Constructeurs
    public CompteCourant() {}

    public CompteCourant(String numeroCompte, Integer idClient, BigDecimal soldeActuel,
                         LocalDateTime dateOuverture, LocalDateTime dateCloture, BigDecimal decouvertAutorise) {
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

    public BigDecimal getSoldeActuel() { return soldeActuel; }
    public void setSoldeActuel(BigDecimal soldeActuel) { this.soldeActuel = soldeActuel; }

    public LocalDateTime getDateOuverture() { return dateOuverture; }
    public void setDateOuverture(LocalDateTime dateOuverture) { this.dateOuverture = dateOuverture; }

    public LocalDateTime getDateCloture() { return dateCloture; }
    public void setDateCloture(LocalDateTime dateCloture) { this.dateCloture = dateCloture; }

    public BigDecimal getDecouvertAutorise() { return decouvertAutorise; }
    public void setDecouvertAutorise(BigDecimal decouvertAutorise) { this.decouvertAutorise = decouvertAutorise; }
}
