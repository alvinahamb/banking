using DepotServiceAPI.Models;
using DepotServiceAPI.Services;
using Microsoft.AspNetCore.Mvc;

namespace DepotServiceAPI.Controllers
{
    [ApiController]
    [Route("api/status")]
    public class StatusController(StatusService service) : ControllerBase
    {
        private readonly StatusService _service = service;

        [HttpGet("all")]
        public IActionResult GetAll()
        {
            return Ok(_service.GetAll());
        }

        [HttpGet("{id}")]
        public IActionResult GetById(int id)
        {
            var taux = _service.GetById(id);
            if (taux == null)
                return NotFound($"Aucun Status trouvé avec l'ID {id}");
            return Ok(taux);
        }

        [HttpPost("add")]
        public IActionResult Add([FromBody] Status status)
        {
            _service.Create(status);
            return Ok("Status ajouté avec succès !");
        }

        [HttpPut("update")]
        public IActionResult Update([FromBody] Status status)
        {
            _service.Update(status);
            return Ok("Status mis à jour avec succès !");
        }

        [HttpDelete("delete/{id}")]
        public IActionResult Delete(int id)
        {
            _service.Delete(id);
            return Ok("Status supprimé avec succès !");
        }
    }
}
