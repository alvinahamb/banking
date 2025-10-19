package com.central.model.depot;

public class CompteDepot {

    private Long idCompteDepot;
    private String numeroCompte;
    private Long idClient;
    private Double soldeActuel;
    private String dateOuverture;
    private String dateCloture;
    private Long idTaux;
    private Taux taux;

    // Constructeurs
    public CompteDepot() {}

    public CompteDepot(Long idCompteDepot, String numeroCompte, Long idClient, Double soldeActuel, 
                       String dateOuverture, String dateCloture, Long idTaux, Taux taux) {
        this.idCompteDepot = idCompteDepot;
        this.numeroCompte = numeroCompte;
        this.idClient = idClient;
        this.soldeActuel = soldeActuel;
        this.dateOuverture = dateOuverture;
        this.dateCloture = dateCloture;
        this.idTaux = idTaux;
        this.taux = taux;
    }

    // Getters & Setters
    public Long getIdCompteDepot() { return idCompteDepot; }
    public void setIdCompteDepot(Long idCompteDepot) { this.idCompteDepot = idCompteDepot; }

    public String getNumeroCompte() { return numeroCompte; }
    public void setNumeroCompte(String numeroCompte) { this.numeroCompte = numeroCompte; }

    public Long getIdClient() { return idClient; }
    public void setIdClient(Long idClient) { this.idClient = idClient; }

    public Double getSoldeActuel() { return soldeActuel; }
    public void setSoldeActuel(Double soldeActuel) { this.soldeActuel = soldeActuel; }

    public String getDateOuverture() { return dateOuverture; }
    public void setDateOuverture(String dateOuverture) { this.dateOuverture = dateOuverture; }

    public String getDateCloture() { return dateCloture; }
    public void setDateCloture(String dateCloture) { this.dateCloture = dateCloture; }

    public Long getIdTaux() { return idTaux; }
    public void setIdTaux(Long idTaux) { this.idTaux = idTaux; }

    public Taux getTaux() { return taux; }
    public void setTaux(Taux taux) { this.taux = taux; }
}

