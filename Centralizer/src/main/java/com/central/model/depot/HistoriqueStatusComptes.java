package com.central.model.depot;

public class HistoriqueStatusComptes {

    private Long idHistoriqueDepot;
    private Long idCompteDepot;
    private Long idStatus;
    private String dateChangement;
    private CompteDepot compteDepot;
    private StatusDepot status;

    public HistoriqueStatusComptes() {}

    public HistoriqueStatusComptes(Long idHistoriqueDepot, Long idCompteDepot, Long idStatus,
                                   String dateChangement, CompteDepot compteDepot, StatusDepot status) {
        this.idHistoriqueDepot = idHistoriqueDepot;
        this.idCompteDepot = idCompteDepot;
        this.idStatus = idStatus;
        this.dateChangement = dateChangement;
        this.compteDepot = compteDepot;
        this.status = status;
    }

    public Long getIdHistoriqueDepot() { return idHistoriqueDepot; }
    public void setIdHistoriqueDepot(Long idHistoriqueDepot) { this.idHistoriqueDepot = idHistoriqueDepot; }

    public Long getIdCompteDepot() { return idCompteDepot; }
    public void setIdCompteDepot(Long idCompteDepot) { this.idCompteDepot = idCompteDepot; }

    public Long getIdStatus() { return idStatus; }
    public void setIdStatus(Long idStatus) { this.idStatus = idStatus; }

    public String getDateChangement() { return dateChangement; }
    public void setDateChangement(String dateChangement) { this.dateChangement = dateChangement; }

    public CompteDepot getCompteDepot() { return compteDepot; }
    public void setCompteDepot(CompteDepot compteDepot) { this.compteDepot = compteDepot; }

    public StatusDepot getStatus() { return status; }
    public void setStatus(StatusDepot status) { this.status = status; }
}

