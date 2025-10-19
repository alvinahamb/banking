package com.banque.pret.ejb;

import com.banque.pret.entity.*;
import com.banque.pret.repository.*;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;
import java.time.LocalDate;

@Stateless
public class PretService {

    @Inject
    private PretRepository repo;
    @Inject
    private EcheanceRepository echeanceRepo;
    @Inject
    private StatusPretRepository statusRepo;
    @Inject
    private TypePretRepository typePretRepo;
    @Inject
    private HistoriquePretRepository histoRepo;

    public Pret create(Pret p) {
        repo.save(p);

        // Historique
        // StatusPret statusPret = statusRepo.findByLibelle("en cours");
        // HistoriquePret historiquePret = new HistoriquePret(p, statusPret, LocalDate.now());
        // histoRepo.save(historiquePret);

        // Création des échéances
        TypePret typePret = typePretRepo.find((Long) p.getTypePret().getIdTypePret());
        StatusPret statusEcheance = statusRepo.findByLibelle("non paye");
        double modalite_mois = typePret.getModalite();
        double taux_periodique = (p.getTaux() / 100.0) * (modalite_mois / 12);
        double duree_mois = (double) p.getDuree_mois();
        int nbreEcheance = (int) (duree_mois / modalite_mois);

        double capital_debut = p.getMontant();
        double annuite = p.getMontant() * (taux_periodique / (1 - Math.pow(1 + taux_periodique, -nbreEcheance)));

        for (int i = 0; i < nbreEcheance; i++) {
            double interet = round(capital_debut * taux_periodique);
            double amortissement = round(annuite - interet);
            double capital_fin = round(capital_debut - amortissement);
            double capitalDebutArrondi = round(capital_debut);
            double annuiteArrondie = round(annuite);

            // Calcul de la date d'échéance
            LocalDate dateEcheance = p.getDate_operation().plusMonths((long) (modalite_mois * (i + 1)));
            
            Echeance echeance = new Echeance(
                    capitalDebutArrondi,
                    interet,
                    amortissement,
                    annuiteArrondie,
                    capital_fin,
                    dateEcheance,
                    p,
                    statusEcheance);
            echeanceRepo.save(echeance);
            capital_debut = capital_fin;
        }

        return p;
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    public Pret getOne(Long id) {
        return repo.find(id);
    }

    public List<Pret> getAll() {
        return repo.findAll();
    }

    public Pret update(Pret p) {
        return repo.update(p);
    }

    public boolean delete(Long id) {
        return repo.delete(id);
    }

}
