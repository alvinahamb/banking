using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace DepotServiceAPI.Models
{
    public class OperationsDepot
    {
        [Key]
        public int IdOperation { get; set; }
        [Required]
        public double Montant { get; set; }
        [Required]
        public DateTime DateOperation { get; set; }
        public DateTime DateValeur { get; set; }
        [Required]
        public double SoldeActuel { get; set; }
        public int? IdVirement { get; set; }

        [Required]
        [ForeignKey("TypeOperation")]
        public int IdTypeOperation { get; set; }

        [Required]
        [ForeignKey("CompteDepot")]
        public int IdCompteDepot { get; set; }
        //[NotMapped]
        public TypeOperation? TypeOperation { get; set; }
        //[NotMapped]
        public CompteDepot? CompteDepot { get; set; }

    }

}
