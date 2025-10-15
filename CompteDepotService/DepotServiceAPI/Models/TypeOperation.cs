using System.ComponentModel.DataAnnotations;

namespace DepotServiceAPI.Models
{
    public class TypeOperation
    {
        [Key]
        public int IdTypeOperation { get; set; }
        [Required]
        public required string Libelle { get; set; }
        [Required]
        public Boolean Credit { get; set; }
    }

}
