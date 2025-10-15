package com.banque.courant.entity;

import javax.swing.text.StyledEditorKit.BoldAction;

import jakarta.persistence.*;

@Entity
@Table(name = "TypeOperation")
public class TypeOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeOperation;

    private String libelle;
    private boolean credit;

    public TypeOperation(String libelle,Boolean credit) {
        this.libelle = libelle;
        this.credit = credit;
    }

    public TypeOperation() {}

    // Getters & Setters
    public Long getId() {return idTypeOperation;}
    public void setId(Long id) {this.idTypeOperation = id;}

    public String getLibelle() {return libelle;}
    public void setLibelle(String libelle) {this.libelle = libelle;}

    public Boolean getCredit() {return this.credit;}
    public void setCredit(Boolean credit) {this.credit = credit;}
}
