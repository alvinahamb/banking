using DepotServiceAPI.Data;
using DepotServiceAPI.Models;
using Microsoft.EntityFrameworkCore;

namespace DepotServiceAPI.Repositories
{
    public class OperationsDepotRepository(AppDbContext context)
    {
        private readonly AppDbContext _context = context;
        private readonly CompteDepotRepository _repo = new(context);

        public List<OperationsDepot> GetAll()
        {
            return [.. _context.OperationsDepot
                .Include(t=> t.TypeOperation)
                .Include(c=>c.CompteDepot)
                .ThenInclude(cd => cd.Taux)];
        }

        public OperationsDepot? GetById(int id)
        {
            return _context.OperationsDepot
                .Include(t => t.TypeOperation)
                .Include(c => c.CompteDepot)
                .ThenInclude(cd => cd.Taux)
                .FirstOrDefault(t => t.IdOperation == id);
        }
        public void Add(OperationsDepot operationsDepot)
        {
            var to = _context.TypeOperation.Find(operationsDepot.IdOperation) ?? throw new Exception($"Aucune type d'operation trouvée");
            CompteDepot? cd = _repo.GetById(operationsDepot.IdCompteDepot) ?? throw new Exception($"Aucun compte trouvé");

            operationsDepot.TypeOperation = to;
            operationsDepot.CompteDepot = cd;
            _context.OperationsDepot.Add(operationsDepot);
            _context.SaveChanges();
        }
        public void Update(OperationsDepot operationsDepot)
        {
            var to = _context.TypeOperation.Find(operationsDepot.IdOperation) ?? throw new Exception($"Aucune type d'operation trouvée");
            CompteDepot? cd = _repo.GetById(operationsDepot.IdCompteDepot) ?? throw new Exception($"Aucun compte trouvé");

            operationsDepot.TypeOperation = to;
            operationsDepot.CompteDepot = cd;
            _context.OperationsDepot.Update(operationsDepot);
            _context.SaveChanges();
        }

        public void Delete(int id)
        {
            var o = _context.OperationsDepot.FirstOrDefault(t => t.IdOperation == id);
            if (o != null)
            {
                _context.OperationsDepot.Remove(o);
                _context.SaveChanges();
            }
        }
    }
}
