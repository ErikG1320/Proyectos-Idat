using System;
using System.Collections.Generic;

namespace NeptunoWebApi.Models;

public partial class DetallesPedido
{
    public int IdPedido { get; set; }

    public int IdProducto { get; set; }

    public decimal PrecioUnidad { get; set; }

    public int Cantidad { get; set; }

    public decimal Descuento { get; set; }

    public string? Eliminado { get; set; }

    public virtual Pedido IdPedidoNavigation { get; set; } = null!;

    public virtual Producto IdProductoNavigation { get; set; } = null!;
}
