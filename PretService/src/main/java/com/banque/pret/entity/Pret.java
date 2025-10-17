package com.banque.pret.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import com.banque.pret.entity.client.Clients;
import java.util.List;

@Entity
@Table(name = "Pret")
public class Pret {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPret;

    private Integer idClient;
    private double montant;
    private LocalDate date_operation;
    private LocalDate date_valeur;
    private Integer duree_mois;
    private int taux;

    @ManyToOne
    @JoinColumn(name = "idTypePret", nullable = false)
    private TypePret typePret;

    // Constructeurs
    public Pret() {
    }

    public Pret(Integer idClient, double montant, LocalDate date_operation, LocalDate date_valeur,
            Integer duree_mois, TypePret typePret,int taux) {
        this.idClient = idClient;
        this.montant = montant;
        this.date_operation = date_operation;
        this.date_valeur = date_valeur;
        this.duree_mois = duree_mois;
        this.typePret = typePret;
        this.taux = taux;
    }

    // Getters & Setters
    public Long getIdPret() {
        return idPret;
    }

    public void setIdPret(Long idPret) {
        this.idPret = idPret;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public LocalDate getDate_operation() {
        return date_operation;
    }

    public void setDate_operation(LocalDate date_operation) {
        this.date_operation = date_operation;
    }

    public LocalDate getDate_valeur() {
        return date_valeur;
    }

    public void setDate_valeur(LocalDate date_valeur) {
        this.date_valeur = date_valeur;
    }

    public Integer getDuree_mois() {
        return duree_mois;
    }

    public void setDuree_mois(Integer duree_mois) {
        this.duree_mois = duree_mois;
    }

    public TypePret getTypePret() {
        return typePret;
    }

    public void setTypePret(TypePret typePret) {
        this.typePret = typePret;
    }
    
    public int getTaux() {
        return taux;
    }
    
    public void setTaux(int taux) {
        this.taux = taux;
    }
}
