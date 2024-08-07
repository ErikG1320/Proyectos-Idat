using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace DataAccess
{
    public class Producto
    {
        public int Id { get; set;}
        public string Nombre { get; set;} = "";
        public string Marca { get; set;} = "";
        public int Cantidad { get; set;} = 0;
        public decimal Precio { get; set;}
        public string Descripcion { get; set;} = "";
        public DateTime Fecha { get; set;} = DateTime.Now;
    }
}