using DepotServiceAPI.Data;
using DepotServiceAPI.Models;
using Microsoft.EntityFrameworkCore;

namespace DepotServiceAPI.Repositories
{
    public class TauxRepository(AppDbContext context)
    {
        private readonly AppDbContext _context = context;

        public List<Taux> GetAll()
        {
            return [.. _context.Taux];
        }

        public Taux? GetById(int id)
        {
            return _context.Taux.FirstOrDefault(t => t.IdTaux == id);
        }
        public void Add(Taux taux)
        {
            _context.Taux.Add(taux);
            _context.SaveChanges();
        }
        public void Update(Taux taux)
        {
            _context.Taux.Update(taux);
            _context.SaveChanges();
        }

        public void Delete(int id)
        {
            var taux = _context.Taux.FirstOrDefault(t => t.IdTaux == id);
            if (taux != null)
            {
                _context.Taux.Remove(taux);
                _context.SaveChanges();
            }
        }
    }
}
