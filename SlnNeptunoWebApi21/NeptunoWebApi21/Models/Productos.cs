using System;
using System.Collections.Generic;

namespace NeptunoWebApi21.Models
{
    public partial class Productos
    {
        public Productos()
        {
            DetallesPedidos = new HashSet<DetallesPedidos>();
        }

        public int IdProducto { get; set; }
        public string NombreProducto { get; set; }
        public int? IdProveedor { get; set; }
        public int? IdCategoria { get; set; }
        public string CantidadPorUnidad { get; set; }
        public decimal? PrecioUnidad { get; set; }
        public short? UnidadesEnExistencia { get; set; }
        public short? UnidadesEnPedido { get; set; }
        public short? NivelNuevoPedido { get; set; }
        public bool Suspendido { get; set; }
        public string Eliminado { get; set; }

        public Categorias IdCategoriaNavigation { get; set; }
        public Proveedores IdProveedorNavigation { get; set; }
        public ICollection<DetallesPedidos> DetallesPedidos { get; set; }
    }
}
