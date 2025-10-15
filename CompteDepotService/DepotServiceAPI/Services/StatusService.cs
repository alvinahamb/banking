using DepotServiceAPI.Models;
using DepotServiceAPI.Repositories;

namespace DepotServiceAPI.Services
{
    public class StatusService(StatusRepository repo)
    {
        private readonly StatusRepository _repo = repo;

        public List<Status> GetAll() => _repo.GetAll();
        public Status? GetById(int id)
        {
            return _repo.GetById(id);
        }
        public void Create(Status status)
        {
            _repo.Add(status);
        }
        public void Update(Status status)
        {
            _repo.Update(status);
        }
        public void Delete(int id)
        {
            _repo.Delete(id);
        }
    }

}
