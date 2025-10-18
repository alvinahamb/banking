package com.banque.pret.entity.client;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    private String nom;
    private String prenoms;
    private LocalDate date_de_naissance;
    private String lieu_de_naissance;
    private String adresse;
    private String telephone;
    private String email;
    private String numero_identite;
    private LocalDate date_ajout;

    @ManyToOne
    @JoinColumn(name = "idTranche", nullable = false)
    private TrancheRevenu revenuActuel;

    public Clients() {
    }

    public Clients(String nom, String prenoms, LocalDate date_de_naissance, String lieu_de_naissance,
                   String adresse, String telephone, String email, String numero_identite,
                   LocalDate date_ajout, TrancheRevenu revenuActuel) {
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

    public LocalDate getDate_de_naissance() {
        return date_de_naissance;
    }

    public void setDate_de_naissance(LocalDate date_de_naissance) {
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

    public LocalDate getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(LocalDate date_ajout) {
        this.date_ajout = date_ajout;
    }

    public TrancheRevenu getrevenuActuel() {
        return revenuActuel;
    }

    public void setrevenuActuel(TrancheRevenu revenuActuel) {
        this.revenuActuel = revenuActuel;
    }
}
