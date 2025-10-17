package com.central.model.pret;

public class TypePret {
    private Integer idTypePret;
    private String libelle;
    private int modalite;
    private double montant_min;
    private double montant_max;
    private double revenus_min;
    private int taux_min;
    private int taux_max;

    // Getters et setters
    public Integer getIdTypePret() { return idTypePret; }
    public void setIdTypePret(Integer idTypePret) { this.idTypePret = idTypePret; }

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }

    public int getModalite() { return modalite; }
    public void setModalite(int modalite) { this.modalite = modalite; }

    public double getMontant_min() { return montant_min; }
    public void setMontant_min(double montant_min) { this.montant_min = montant_min; }

    public double getMontant_max() { return montant_max; }
    public void setMontant_max(double montant_max) { this.montant_max = montant_max; }

    public double getRevenus_min() { return revenus_min; }
    public void setRevenus_min(double revenus_min) { this.revenus_min = revenus_min; }

    public int getTaux_min() { return taux_min; }
    public void setTaux_min(int taux_min) { this.taux_min = taux_min;  } 

    public int getTaux_max() { return taux_max; }
    public void setTaux_max(int taux_max) { this.taux_max = taux_max; }
}
