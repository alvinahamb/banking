using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace DepotServiceAPI.Models
{
    public class HistoriqueStatusComptes
    {
        [Key]
        public int IdHistoriqueDepot { get; set; }

        [Required]
        [ForeignKey("CompteDepot")]
        public int IdCompteDepot { get; set; }

        [Required]
        [ForeignKey("Status")]
        public int IdStatus { get; set; }

        [Required]
        public DateTime DateChangement { get; set; }
        //[NotMapped]
        public CompteDepot? CompteDepot { get; set; }
        //[NotMapped]
        public Status? Status { get; set; }
    }
}
