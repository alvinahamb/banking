using System.ComponentModel.DataAnnotations;

namespace DepotServiceAPI.Models
{
    public class Status
    {
        [Key]
        public int IdStatus { get; set; }
        [Required]
        public required string Libelle { get; set; }
    }

}
