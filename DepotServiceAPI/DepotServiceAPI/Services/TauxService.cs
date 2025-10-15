using DepotServiceAPI.Models;
using DepotServiceAPI.Repositories;

namespace DepotServiceAPI.Services
{
    public class TauxService(TauxRepository repo)
    {
        private readonly TauxRepository _repo = repo;

        public List<Taux> GetAll() => _repo.GetAll();
        public Taux? GetById(int id)
        {
            return _repo.GetById(id);
        }
        public void Create(Taux taux)
        {
            _repo.Add(taux);
        }
        public void Update(Taux taux)
        {
            _repo.Update(taux);
        }
        public void Delete(int id)
        {
            _repo.Delete(id);
        }
    }

}
