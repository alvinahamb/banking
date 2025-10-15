using DepotServiceAPI.Data;
using DepotServiceAPI.Models;
using Microsoft.EntityFrameworkCore;

namespace DepotServiceAPI.Repositories
{
    public class TypeOperationRepository(AppDbContext context)
    {
        private readonly AppDbContext _context = context;

        public List<TypeOperation> GetAll()
        {
            return [.. _context.TypeOperation];
        }

        public TypeOperation? GetById(int id)
        {
            return _context.TypeOperation.FirstOrDefault(t => t.IdTypeOperation == id);
        }
        public void Add(TypeOperation typeOperation)
        {
            _context.TypeOperation.Add(typeOperation);
            _context.SaveChanges();
        }
        public void Update(TypeOperation typeOperation)
        {
            _context.TypeOperation.Update(typeOperation);
            _context.SaveChanges();
        }

        public void Delete(int id)
        {
            var t = _context.TypeOperation.FirstOrDefault(t => t.IdTypeOperation == id);
            if (t != null)
            {
                _context.TypeOperation.Remove(t);
                _context.SaveChanges();
            }
        }
    }
}
