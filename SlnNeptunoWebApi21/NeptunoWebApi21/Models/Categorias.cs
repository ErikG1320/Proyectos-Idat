using System;
using System.Collections.Generic;

namespace NeptunoWebApi21.Models
{
    public partial class Categorias
    {
        public Categorias()
        {
            Productos = new HashSet<Productos>();
        }

        public int IdCategoria { get; set; }
        public string NombreCategoria { get; set; }
        public string Descripcion { get; set; }
        public string Eliminado { get; set; }

        public ICollection<Productos> Productos { get; set; }
    }
}
