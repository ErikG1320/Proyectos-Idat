using System;
using System.Collections.Generic;

namespace NeptunoWebApi21.Models
{
    public partial class Clientes
    {
        public Clientes()
        {
            Pedidos = new HashSet<Pedidos>();
        }

        public string IdCliente { get; set; }
        public string NombreCliente { get; set; }
        public string NombreContacto { get; set; }
        public string CargoContacto { get; set; }
        public string Direccion { get; set; }
        public string Ciudad { get; set; }
        public string Region { get; set; }
        public string CodPostal { get; set; }
        public string Pais { get; set; }
        public string Telefono { get; set; }
        public string Fax { get; set; }
        public string Eliminado { get; set; }

        public ICollection<Pedidos> Pedidos { get; set; }
    }
}
