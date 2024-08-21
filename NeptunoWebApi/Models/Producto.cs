using System;
using System.Collections.Generic;

namespace NeptunoWebApi.Models;

public partial class Producto
{
    public int IdProducto { get; set; }

    public string NombreProducto { get; set; } = null!;

    public int? IdProveedor { get; set; }

    public int? IdCategoria { get; set; }

    public string? CantidadPorUnidad { get; set; }

    public decimal? PrecioUnidad { get; set; }

    public short? UnidadesEnExistencia { get; set; }

    public short? UnidadesEnPedido { get; set; }

    public short? NivelNuevoPedido { get; set; }

    public bool Suspendido { get; set; }

    public string? Eliminado { get; set; }

    public virtual ICollection<DetallesPedido> DetallesPedidos { get; set; } = new List<DetallesPedido>();

    public virtual Categoria? IdCategoriaNavigation { get; set; }

    public virtual Proveedore? IdProveedorNavigation { get; set; }
}
