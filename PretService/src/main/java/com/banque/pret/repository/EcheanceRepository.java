package com.banque.pret.repository;

import com.banque.pret.entity.Echeance;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class EcheanceRepository {

    @PersistenceContext(unitName = "EcheancePU")
    private EntityManager em;

    public void save(Echeance e) {
        em.persist(e);
    }

    public Echeance find(Long id) {
        return em.find(Echeance.class, id);
    }

    public List<Echeance> findAll() {
        return em.createQuery("SELECT e FROM Echeance e", Echeance.class).getResultList();
    }

    public Echeance update(Echeance e) {
        return em.merge(e);
    }

    public boolean delete(Long id) {
        Echeance e = em.find(Echeance.class, id);
        if (e != null) {
            em.remove(e);
            return true;
        }
        return false;
    }

    public List<Echeance> findByPretId(Long idPret) {
        return em.createQuery(
                "SELECT e FROM Echeance e WHERE e.pret.idPret = :idPret", Echeance.class)
                .setParameter("idPret", idPret)
                .getResultList();
    }

    public Echeance findFirstNonPayeByPret(Long idPret) {
    List<Echeance> result = em.createQuery(
        "SELECT e FROM Echeance e JOIN e.statusPret s " +
        "WHERE e.pret.idPret = :idPret AND s.libelle = :libelle " +
        "ORDER BY e.date_echance ASC",
        Echeance.class)
        .setParameter("idPret", idPret)
        .setParameter("libelle", "non paye")
        .setMaxResults(1)
        .getResultList();

    return result.isEmpty() ? null : result.get(0);
}


}
