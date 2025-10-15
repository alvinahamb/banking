package com.banque.pret.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TypePret")
public class TypePret {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypePret; // identifiant primaire

    private String libelle;
    private double modalite;
    private double montant_min;
    private double montant_max;
    private double revenus_min;
    private int taux;

    public TypePret(String libelle, double modalite, double montant_min, double montant_max, double revenus_min,
            int taux) {
        this.libelle = libelle;
        this.modalite = modalite;
        this.montant_min = montant_min;
        this.montant_max = montant_max;
        this.revenus_min = revenus_min;
        this.taux = taux;
    }

    public TypePret() {
    }

    // Getters
    public Long getIdTypePret() {
        return idTypePret;
    }

    public String getLibelle() {
        return libelle;
    }

    public double getModalite() {
        return modalite;
    }

    public double getMontant_min() {
        return montant_min;
    }

    public double getMontant_max() {
        return montant_max;
    }

    public double getRevenus_min() {
        return revenus_min;
    }

    public int getTaux() {
        return taux;
    }

    // Setters
    public void setIdTypePret(Long idTypePret) {
        this.idTypePret = idTypePret;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setModalite(double modalite) {
        this.modalite = modalite;
    }

    public void setMontant_min(double montant_min) {
        this.montant_min = montant_min;
    }

    public void setMontant_max(double montant_max) {
        this.montant_max = montant_max;
    }

    public void setRevenus_min(double revenus_min) {
        this.revenus_min = revenus_min;
    }

    public void setTaux(int taux) {
        this.taux = taux;
    }
}
