using DepotServiceAPI.Models;
using DepotServiceAPI.Repositories;

namespace DepotServiceAPI.Services
{
    public class CompteDepotService(CompteDepotRepository repo)
    {
        private readonly CompteDepotRepository _repo = repo;

        public List<CompteDepot> GetAll() => _repo.GetAll();
        public CompteDepot? GetById(int id)
        {
            return _repo.GetById(id);
        }
        public void Create(CompteDepot compteDepot)
        {
            _repo.Add(compteDepot);
        }
        public void Update(CompteDepot compteDepot)
        {
            _repo.Update(compteDepot);
        }
        public void Delete(int id)
        {
            _repo.Delete(id);
        }
    }

}
