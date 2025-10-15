using DepotServiceAPI.Models;
using DepotServiceAPI.Repositories;

namespace DepotServiceAPI.Services
{
    public class TypeOperationService(TypeOperationRepository repo)
    {
        private readonly TypeOperationRepository _repo = repo;

        public List<TypeOperation> GetAll() => _repo.GetAll();
        public TypeOperation? GetById(int id)
        {
            return _repo.GetById(id);
        }
        public void Create(TypeOperation typeOperation)
        {
            _repo.Add(typeOperation);
        }
        public void Update(TypeOperation typeOperation)
        {
            _repo.Update(typeOperation);
        }
        public void Delete(int id)
        {
            _repo.Delete(id);
        }
    }

}
