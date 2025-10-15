using DepotServiceAPI.Models;
using DepotServiceAPI.Services;
using Microsoft.AspNetCore.Mvc;

namespace DepotServiceAPI.Controllers
{
    [ApiController]
    [Route("api/historiquestatus")]
    public class HistoriqueStatusController(HistoriqueStatusService service) : ControllerBase
    {
        private readonly HistoriqueStatusService _service = service;

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
                return NotFound($"Aucun Historique Status trouvé avec l'ID {id}");
            return Ok(taux);
        }

        [HttpPost("add")]
        public IActionResult Add([FromBody] HistoriqueStatusComptes historiqueStatusComptes)
        {
            _service.Create(historiqueStatusComptes);
            return Ok("HistoriqueStatus ajouté avec succès !");
        }

        [HttpPut("update")]
        public IActionResult Update([FromBody] HistoriqueStatusComptes historiqueStatusComptes)
        {
            _service.Update(historiqueStatusComptes);
            return Ok("HistoriqueStatus mis à jour avec succès !");
        }

        [HttpDelete("delete/{id}")]
        public IActionResult Delete(int id)
        {
            _service.Delete(id);
            return Ok("HistoriqueStatus supprimé avec succès !");
        }
    }
}
