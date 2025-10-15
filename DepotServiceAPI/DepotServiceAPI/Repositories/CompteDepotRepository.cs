using DepotServiceAPI.Data;
using DepotServiceAPI.Models;
using Microsoft.EntityFrameworkCore;

namespace DepotServiceAPI.Repositories
{
    public class CompteDepotRepository(AppDbContext context)
    {
        private readonly AppDbContext _context = context;

        public List<CompteDepot> GetAll()
        {
            return [.. _context.CompteDepot.Include(c => c.Taux)];
        }

        public CompteDepot? GetById(int id)
        {
            return _context.CompteDepot
                           .Include(c => c.Taux) // 🔹 idem ici
                           .FirstOrDefault(t => t.IdCompteDepot == id);
        }
        public void Add(CompteDepot compteDepot)
        {
            // Récupérer l'objet Taux existant depuis la base
            var tauxExistant = _context.Taux.Find(compteDepot.IdTaux) ?? throw new Exception($"Aucun Taux trouvé avec l'ID {compteDepot.IdTaux}");

            // Attacher le Taux existant à l'entité pour éviter qu'EF en crée un nouveau
            compteDepot.Taux = tauxExistant;
            _context.CompteDepot.Add(compteDepot);
            _context.SaveChanges();
        }
        public void Update(CompteDepot compteDepot)
        {
            var tauxExistant = _context.Taux.Find(compteDepot.IdTaux) ?? throw new Exception($"Aucun Taux trouvé avec l'ID {compteDepot.IdTaux}");

            compteDepot.Taux = tauxExistant;
            _context.CompteDepot.Update(compteDepot);
            _context.SaveChanges();
        }

        public void Delete(int id)
        {
            var c = _context.CompteDepot.FirstOrDefault(t => t.IdCompteDepot == id);
            if (c != null)
            {
                _context.CompteDepot.Remove(c);
                _context.SaveChanges();
            }
        }
    }
}
