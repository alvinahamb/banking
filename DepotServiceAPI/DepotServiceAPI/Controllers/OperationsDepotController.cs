using DepotServiceAPI.Models;
using DepotServiceAPI.Services;
using Microsoft.AspNetCore.Mvc;

namespace DepotServiceAPI.Controllers
{
    [ApiController]
    [Route("api/operationsdepot")]
    public class OperationsDepotController(OperationsDepotService service) : ControllerBase
    {
        private readonly OperationsDepotService _service = service;

        [HttpGet("all")]
        public IActionResult GetAll()
        {
            return Ok(_service.GetAll());
        }

        [HttpGet("{id}")]
        public IActionResult GetById(int id)
        {
            var o = _service.GetById(id);
            if (o == null)
                return NotFound($"Aucun OperationsDepot trouvé avec l'ID {id}");
            return Ok(o);
        }

        [HttpPost("add")]
        public IActionResult Add([FromBody] OperationsDepot operationsDepot)
        {
            _service.Create(operationsDepot);
            return Ok("OperationsDepot ajouté avec succès !");
        }

        [HttpPut("update")]
        public IActionResult Update([FromBody] OperationsDepot operationsDepot)
        {
            _service.Update(operationsDepot);
            return Ok("OperationsDepot mis à jour avec succès !");
        }

        [HttpDelete("delete/{id}")]
        public IActionResult Delete(int id)
        {
            _service.Delete(id);
            return Ok("OperationsDepot supprimé avec succès !");
        }
    }
}
