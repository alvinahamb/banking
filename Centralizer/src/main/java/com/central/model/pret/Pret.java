package com.central.model.pret;

public class Pret {

    private Long idPret;
    private Integer idClient;
    private double montant;
    private String date_operation;
    private String date_valeur;
    private Integer duree_mois;
    private TypePret typePret;
    private int taux;
    private HistoriquePret historiquePret;

    public Long getIdPret() { return idPret; }
    public void setIdPret(Long idPret) { this.idPret = idPret; }

    public Integer getIdClient() { return idClient; }
    public void setIdClient(Integer idClient) { this.idClient = idClient; }

    public double getMontant() { return montant; }
    public void setMontant(double montant) { this.montant = montant; }

    public String getDate_operation() { return date_operation; }
    public void setDate_operation(String date_operation) { this.date_operation = date_operation; }

    public String getDate_valeur() { return date_valeur; }
    public void setDate_valeur(String date_valeur) { this.date_valeur = date_valeur; }

    public Integer getDuree_mois() { return duree_mois; }
    public void setDuree_mois(Integer duree_mois) { this.duree_mois = duree_mois; }

    public TypePret getTypePret() { return typePret; }
    public void setTypePret(TypePret typePret) { this.typePret = typePret; }
    
    public int getTaux() { return taux; }
    public void setTaux(int taux) { this.taux = taux; }

    public HistoriquePret getHistoriquePret() { return historiquePret; }
    public void setHistoriquePret(HistoriquePret historiquePret) { this.historiquePret = historiquePret; }
}
