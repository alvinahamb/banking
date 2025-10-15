package com.banque.courant.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStatus;

    private String libelle;

    public Status(String libelle) {
        this.libelle = libelle;
    }

    public Status() {}

    // Getters & Setters
    public Long getId() {return idStatus;}
    public void setId(Long idStatus) { this.idStatus = idStatus;}

    public String getLibelle() {return libelle;}
    public void setLibelle(String libelle) {this.libelle = libelle;}
}
