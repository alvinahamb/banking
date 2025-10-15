package com.banque.pret.entity.client;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "InformationProfessionel")
public class InformationProfessionnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInfo;

    private String emploi;
    private Date date_changement;

    @ManyToOne
    @JoinColumn(name = "idTranche", nullable = false)
    private TrancheRevenu tranche;

    @ManyToOne
    @JoinColumn(name = "idClient", nullable = false)
    private Clients client;

    public InformationProfessionnel() {
    }

    public InformationProfessionnel(String emploi, Date date_changement, TrancheRevenu tranche, Clients client) {
        this.emploi = emploi;
        this.date_changement = date_changement;
        this.tranche = tranche;
        this.client = client;
    }

    public Long getIdInfo() {
        return idInfo;
    }

    public void setIdInfo(Long idInfo) {
        this.idInfo = idInfo;
    }

    public String getEmploi() {
        return emploi;
    }

    public void setEmploi(String emploi) {
        this.emploi = emploi;
    }

    public Date getDate_changement() {
        return date_changement;
    }

    public void setDate_changement(Date date_changement) {
        this.date_changement = date_changement;
    }

    public TrancheRevenu getTranche() {
        return tranche;
    }

    public void setTranche(TrancheRevenu tranche) {
        this.tranche = tranche;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }
}
