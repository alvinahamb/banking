using DepotServiceAPI.Models;
using DepotServiceAPI.Services;
using Microsoft.AspNetCore.Mvc;

namespace DepotServiceAPI.Controllers
{
    [ApiController]
    [Route("api/taux")]
    public class TauxController(TauxService service) : ControllerBase
    {
        private readonly TauxService _service = service;

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
                return NotFound($"Aucun taux trouvé avec l'ID {id}");
            return Ok(taux);
        }

        [HttpPost("add")]
        public IActionResult Add([FromBody] Taux taux)
        {
            _service.Create(taux);
            return Ok("Taux ajouté avec succès !");
        }

        [HttpPut("update")]
        public IActionResult Update([FromBody] Taux taux)
        {
            _service.Update(taux);
            return Ok("Taux mis à jour avec succès !");
        }

        [HttpDelete("delete/{id}")]
        public IActionResult Delete(int id)
        {
            _service.Delete(id);
            return Ok("Taux supprimé avec succès !");
        }
    }
}
