using DepotServiceAPI.Data;
using DepotServiceAPI.Models;
using Microsoft.EntityFrameworkCore;

namespace DepotServiceAPI.Repositories
{
    public class StatusRepository(AppDbContext context)
    {
        private readonly AppDbContext _context = context;

        public List<Status> GetAll()
        {
            return [.. _context.Status];
        }

        public Status? GetById(int id)
        {
            return _context.Status.FirstOrDefault(t => t.IdStatus == id);
        }
        public void Add(Status status)
        {
            _context.Status.Add(status);
            _context.SaveChanges();
        }
        public void Update(Status status)
        {
            _context.Status.Update(status);
            _context.SaveChanges();
        }

        public void Delete(int id)
        {
            var s = _context.Status.FirstOrDefault(t => t.IdStatus == id);
            if (s != null)
            {
                _context.Status.Remove(s);
                _context.SaveChanges();
            }
        }
    }
}
