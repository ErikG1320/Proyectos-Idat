using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CrudWebTienda.Models.DTO
{
    public class ProductoCreate
    {
        public string Nombre { get; set; }
        public double Precio { get; set; }
        public int Codigo_Fabricante { get; set; }   
    }
}