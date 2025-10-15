using DepotServiceAPI.Models;
using DepotServiceAPI.Services;
using Microsoft.AspNetCore.Mvc;

namespace DepotServiceAPI.Controllers
{
    [ApiController]
    [Route("api/comptedepot")]
    public class CompteDepotController(CompteDepotService service) : ControllerBase
    {
        private readonly CompteDepotService _service = service;

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
                return NotFound($"Aucun compte depot trouvé avec l'ID {id}");
            return Ok(taux);
        }

        [HttpPost("add")]
        public IActionResult Add([FromBody] CompteDepot compteDepot)
        {
            _service.Create(compteDepot);
            return Ok("compte depot ajouté avec succès !");
        }

        [HttpPut("update")]
        public IActionResult Update([FromBody] CompteDepot compteDepot)
        {
            _service.Update(compteDepot);
            return Ok("compte depot mis à jour avec succès !");
        }

        [HttpDelete("delete/{id}")]
        public IActionResult Delete(int id)
        {
            _service.Delete(id);
            return Ok("compte depot supprimé avec succès !");
        }
    }
}
