using System;
using System.Collections.Generic;

namespace NeptunoWebApi21.Models
{
    public partial class DetallesPedidos
    {
        public int IdPedido { get; set; }
        public int IdProducto { get; set; }
        public decimal PrecioUnidad { get; set; }
        public int Cantidad { get; set; }
        public decimal Descuento { get; set; }
        public string Eliminado { get; set; }

        public Pedidos IdPedidoNavigation { get; set; }
        public Productos IdProductoNavigation { get; set; }
    }
}
