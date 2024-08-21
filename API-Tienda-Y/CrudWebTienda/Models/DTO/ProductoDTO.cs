using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CrudWebTienda.Models.DTO
{
    public class ProductoDTO
    {
        public int IdCod { get; set; }
        public string Nombre { get; set; }
        public double Precio { get; set; }
        public string Nombre_Fabricante { get; set; }
    }
}