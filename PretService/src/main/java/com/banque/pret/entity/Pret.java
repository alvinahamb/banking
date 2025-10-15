package com.banque.pret.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.banque.pret.entity.client.Clients;
import java.util.List;

@Entity
@Table(name = "Pret")
public class Pret {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPret;

    private Integer idClient;
    private Integer montant;
    private LocalDateTime date_operation;
    private LocalDateTime date_valeur;
    private Integer duree_mois;

    @ManyToOne
    @JoinColumn(name = "idTypePret", nullable = false)
    private TypePret typePret;

    // Constructeurs
    public Pret() {
    }

    public Pret(Integer idClient, Integer montant, LocalDateTime date_operation, LocalDateTime date_valeur,
            Integer duree_mois, TypePret typePret) {
        this.idClient = idClient;
        this.montant = montant;
        this.date_operation = date_operation;
        this.date_valeur = date_valeur;
        this.duree_mois = duree_mois;
        this.typePret = typePret;
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

    public Integer getMontant() {
        return montant;
    }

    public void setMontant(Integer montant) {
        this.montant = montant;
    }

    public LocalDateTime getDate_operation() {
        return date_operation;
    }

    public void setDate_operation(LocalDateTime date_operation) {
        this.date_operation = date_operation;
    }

    public LocalDateTime getDate_valeur() {
        return date_valeur;
    }

    public void setDate_valeur(LocalDateTime date_valeur) {
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

}
