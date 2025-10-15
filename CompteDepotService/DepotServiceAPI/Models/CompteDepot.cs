using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;

namespace DepotServiceAPI.Models
{
    public class CompteDepot
    {
        [Key]
        public int IdCompteDepot { get; set; }
        public required string NumeroCompte { get; set; }
        [Required]
        public int IdClient { get; set; }
        [Required]
        public double SoldeActuel { get; set; }
        [Required]
        public DateTime DateOuverture { get; set; }
        public DateTime DateCloture { get; set; }
        [Required]
        [ForeignKey("Taux")]
        public int IdTaux { get; set; }

        //[JsonIgnore]
        public Taux? Taux { get; set; }
    }

}
