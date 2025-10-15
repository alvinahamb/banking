using DepotServiceAPI.Data;
using DepotServiceAPI.Models;
using Microsoft.EntityFrameworkCore;

namespace DepotServiceAPI.Repositories
{
    public class HistoriqueStatusRepository(AppDbContext context)
    {
        private readonly AppDbContext _context = context;
        private readonly CompteDepotRepository _repo = new(context);

        public List<HistoriqueStatusComptes> GetAll()
        {
            return [.. _context.HistoriqueStatusComptes
                .Include(s=> s.Status)
                .Include(c=>c.CompteDepot)
                .ThenInclude(cd => cd.Taux)];
        }

        public HistoriqueStatusComptes? GetById(int id)
        {
            return _context.HistoriqueStatusComptes
                .Include(s => s.Status)
                .Include(c => c.CompteDepot)
                .ThenInclude(cd => cd.Taux)
                .FirstOrDefault(t => t.IdHistoriqueDepot == id);
        }
        public void Add(HistoriqueStatusComptes historiqueStatusComptes)
        {
            var s = _context.Status.Find(historiqueStatusComptes.IdStatus) ?? throw new Exception($"Aucun status trouvé");
            CompteDepot? cd = _repo.GetById(historiqueStatusComptes.IdCompteDepot) ?? throw new Exception($"Aucun compte trouvé");

            historiqueStatusComptes.Status = s;
            historiqueStatusComptes.CompteDepot = cd;
            _context.HistoriqueStatusComptes.Add(historiqueStatusComptes);
            _context.SaveChanges();
        }
        public void Update(HistoriqueStatusComptes historiqueStatusComptes)
        {
            var s = _context.Status.Find(historiqueStatusComptes.IdStatus) ?? throw new Exception($"Aucun status trouvé");
            CompteDepot? cd = _repo.GetById(historiqueStatusComptes.IdCompteDepot) ?? throw new Exception($"Aucun compte trouvé");

            historiqueStatusComptes.Status = s;
            historiqueStatusComptes.CompteDepot = cd;
            _context.HistoriqueStatusComptes.Update(historiqueStatusComptes);
            _context.SaveChanges();
        }

        public void Delete(int id)
        {
            var h = _context.HistoriqueStatusComptes.FirstOrDefault(t => t.IdHistoriqueDepot == id);
            if (h != null)
            {
                _context.HistoriqueStatusComptes.Remove(h);
                _context.SaveChanges();
            }
        }
    }
}
