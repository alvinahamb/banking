package com.central.model.depot;

public class Taux {

    private Long idTaux;
    private double valeur;
    private String dateChangement;

    public Taux() {}

    public Taux(Long idTaux, double valeur, String dateChangement) {
        this.idTaux = idTaux;
        this.valeur = valeur;
        this.dateChangement = dateChangement;
    }

    public Long getIdTaux() { return idTaux; }
    public void setIdTaux(Long idTaux) { this.idTaux = idTaux; }

    public double getValeur() { return valeur; }
    public void setValeur(double valeur) { this.valeur = valeur; }

    public String getDateChangement() { return dateChangement; }
    public void setDateChangement(String dateChangement) { this.dateChangement = dateChangement; }
}

