using System.ComponentModel.DataAnnotations;

namespace DepotServiceAPI.Models
{
    public class Taux
    {
        [Key]
        public int IdTaux { get; set; }
        [Required]
        public double Valeur { get; set; }
    }

}
