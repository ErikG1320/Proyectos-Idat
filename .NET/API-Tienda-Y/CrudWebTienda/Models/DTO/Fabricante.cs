using System.ComponentModel.DataAnnotations;

namespace CrudWebTienda.Models.DTO
{
    public class Fabricante
    {
        [Key]
        public int IdFab { get; set; }
        public string Nombre { get; set; }
        public ICollection<Producto> Productos { get; set; }
    }
}