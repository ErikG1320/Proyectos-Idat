using System;
using System.Collections.Generic;

namespace NeptunoWebApi21.Models
{
    public partial class Pedidos
    {
        public Pedidos()
        {
            DetallesPedidos = new HashSet<DetallesPedidos>();
        }

        public int IdPedido { get; set; }
        public string IdCliente { get; set; }
        public int? IdEmpleado { get; set; }
        public DateTime? FechaPedido { get; set; }
        public DateTime? FechaEntrega { get; set; }
        public DateTime? FechaEnvio { get; set; }
        public int? FormaEnvio { get; set; }
        public decimal? Cargo { get; set; }
        public string Destinatario { get; set; }
        public string DireccionDestinatario { get; set; }
        public string CiudadDestinatario { get; set; }
        public string RegionDestinatario { get; set; }
        public string CodPostalDestinatario { get; set; }
        public string PaisDestinatario { get; set; }
        public string Eliminado { get; set; }

        public Clientes IdClienteNavigation { get; set; }
        public Empleados IdEmpleadoNavigation { get; set; }
        public ICollection<DetallesPedidos> DetallesPedidos { get; set; }
    }
}
