package com.central.model.client;


public class Clients {

    private Long idClient;
    private String nom;
    private String prenoms;
    private String date_de_naissance;
    private String lieu_de_naissance;
    private String adresse;
    private String telephone;
    private String email;
    private String numero_identite;
    private String date_ajout;
    private TrancheRevenu revenuActuel;

    public Clients() {
    }

    public Clients(String nom, String prenoms, String date_de_naissance, String lieu_de_naissance,
            String adresse, String telephone, String email, String numero_identite,
            String date_ajout, TrancheRevenu revenuActuel) {
        this.nom = nom;
        this.prenoms = prenoms;
        this.date_de_naissance = date_de_naissance;
        this.lieu_de_naissance = lieu_de_naissance;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.numero_identite = numero_identite;
        this.date_ajout = date_ajout;
        this.revenuActuel = revenuActuel;
    }

    // Getters et Setters
    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public String getDate_de_naissance() {
        return date_de_naissance;
    }

    public void setDate_de_naissance(String date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    public String getLieu_de_naissance() {
        return lieu_de_naissance;
    }

    public void setLieu_de_naissance(String lieu_de_naissance) {
        this.lieu_de_naissance = lieu_de_naissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero_identite() {
        return numero_identite;
    }

    public void setNumero_identite(String numero_identite) {
        this.numero_identite = numero_identite;
    }

    public String getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(String date_ajout) {
        this.date_ajout = date_ajout;
    }

    public TrancheRevenu getRevenuActuel() {
        return revenuActuel;
    }

    public void setRevenuActuel(TrancheRevenu revenuActuel) {
        this.revenuActuel = revenuActuel;
    }
}
