package com.central.model.depot;

public class TypeOperationDepot {

    private Long idTypeOperation;
    private String libelle;
    private boolean credit;

    public TypeOperationDepot() {}

    public TypeOperationDepot(Long idTypeOperation, String libelle, boolean credit) {
        this.idTypeOperation = idTypeOperation;
        this.libelle = libelle;
        this.credit = credit;
    }

    public Long getIdTypeOperation() { return idTypeOperation; }
    public void setIdTypeOperation(Long idTypeOperation) { this.idTypeOperation = idTypeOperation; }

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }

    public boolean getCredit() { return credit; }
    public void setCredit(boolean credit) { this.credit = credit; }
}

