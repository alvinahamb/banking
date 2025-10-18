package com.central.model.client;

public class TrancheRevenu {

    private Long idTranche;
    private double valeur_min;
    private double valeur_max;

    public TrancheRevenu() {
    }

    public TrancheRevenu(double valeur_min, double valeur_max) {
        this.valeur_min = valeur_min;
        this.valeur_max = valeur_max;
    }

    public Long getIdTranche() {
        return idTranche;
    }

    public void setIdTranche(Long idTranche) {
        this.idTranche = idTranche;
    }

    public double getValeur_min() {
        return valeur_min;
    }

    public void setValeur_min(double valeur_min) {
        this.valeur_min = valeur_min;
    }

    public double getValeur_max() {
        return valeur_max;
    }

    public void setValeur_max(double valeur_max) {
        this.valeur_max = valeur_max;
    }
}
