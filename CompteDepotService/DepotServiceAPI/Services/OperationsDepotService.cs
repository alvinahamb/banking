using DepotServiceAPI.Models;
using DepotServiceAPI.Repositories;

namespace DepotServiceAPI.Services
{
    public class OperationsDepotService(OperationsDepotRepository repo)
    {
        private readonly OperationsDepotRepository _repo = repo;

        public List<OperationsDepot> GetAll() => _repo.GetAll();
        public OperationsDepot? GetById(int id)
        {
            return _repo.GetById(id);
        }
        public void Create(OperationsDepot operationsDepot)
        {
            _repo.Add(operationsDepot);
        }
        public void Update(OperationsDepot operationsDepot)
        {
            _repo.Update(operationsDepot);
        }
        public void Delete(int id)
        {
            _repo.Delete(id);
        }
    }

}
