using DepotServiceAPI.Models;
using DepotServiceAPI.Repositories;

namespace DepotServiceAPI.Services
{
    public class HistoriqueStatusService(HistoriqueStatusRepository repo)
    {
        private readonly HistoriqueStatusRepository _repo = repo;

        public List<HistoriqueStatusComptes> GetAll() => _repo.GetAll();
        public HistoriqueStatusComptes? GetById(int id)
        {
            return _repo.GetById(id);
        }
        public void Create(HistoriqueStatusComptes historiqueStatusComptes)
        {
            _repo.Add(historiqueStatusComptes);
        }
        public void Update(HistoriqueStatusComptes historiqueStatusComptes)
        {
            _repo.Update(historiqueStatusComptes);
        }
        public void Delete(int id)
        {
            _repo.Delete(id);
        }
    }

}
