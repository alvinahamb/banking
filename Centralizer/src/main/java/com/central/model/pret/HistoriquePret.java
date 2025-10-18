package com.central.model.pret;


public class HistoriquePret {

    private Long idHistoriquePret;
    private Pret pret;
    private StatusPret statusPret;
    private String date_changement;

    public Long getIdHistoriquePret() { return idHistoriquePret; }
    public void setIdHistoriquePret(Long idHistoriquePret) { this.idHistoriquePret = idHistoriquePret; }

    public Pret getPret() { return pret; }
    public void setPret(Pret pret) { this.pret = pret; }

    public StatusPret getStatusPret() { return statusPret; }
    public void setStatusPret(StatusPret statusPret) { this.statusPret = statusPret; }

    public String getDate_changement() { return date_changement; }
    public void setDate_changement(String date_changement) { this.date_changement = date_changement; }
}
