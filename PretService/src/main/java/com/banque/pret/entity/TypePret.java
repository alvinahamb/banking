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
    private int taux_min;
    private int taux_max;
    private int duree_min;
    private int duree_max;

    public TypePret(String libelle, double modalite, double montant_min, double montant_max, double revenus_min,
                    int taux_min, int taux_max, int duree_min, int duree_max) {
        this.libelle = libelle;
        this.modalite = modalite;
        this.montant_min = montant_min;
        this.montant_max = montant_max;
        this.revenus_min = revenus_min;
        this.taux_min = taux_min;
        this.taux_max = taux_max;
        this.duree_min = duree_min;
        this.duree_max = duree_max;
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

    public int getTaux_min() {
        return taux_min;
    }

    public int getTaux_max() {
        return taux_max;
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

    public void setTaux_min(int taux_min) {
        this.taux_min = taux_min;
    }

    public void setTaux_max(int taux_max) {
        this.taux_max = taux_max;
    }

    public int getDuree_min() {
        return duree_min;
    }

    public void setDuree_min(int duree_min) {
        this.duree_min = duree_min;
    }

    public int getDuree_max() {
        return duree_max;
    }

    public void setDuree_max(int duree_max) {
        this.duree_max = duree_max;
    }
}
