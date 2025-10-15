using DepotServiceAPI.Models;
using DepotServiceAPI.Services;
using Microsoft.AspNetCore.Mvc;

namespace DepotServiceAPI.Controllers
{
    [ApiController]
    [Route("api/typeoperation")]
    public class TypeOperationController(TypeOperationService service) : ControllerBase
    {
        private readonly TypeOperationService _service = service;

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
                return NotFound($"Type Operation trouvé avec l'ID {id}");
            return Ok(taux);
        }

        [HttpPost("add")]
        public IActionResult Add([FromBody] TypeOperation typeOperation)
        {
            _service.Create(typeOperation);
            return Ok("Type Operation ajouté avec succès !");
        }

        [HttpPut("update")]
        public IActionResult Update([FromBody] TypeOperation typeOperation)
        {
            _service.Update(typeOperation);
            return Ok("Type Operation mis à jour avec succès !");
        }

        [HttpDelete("delete/{id}")]
        public IActionResult Delete(int id)
        {
            _service.Delete(id);
            return Ok("Type Operation supprimé avec succès !");
        }
    }
}
