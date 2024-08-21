using System;
using System.Collections.Generic;

namespace NeptunoWebApi.Models;

public partial class Pedido
{
    public int IdPedido { get; set; }

    public string IdCliente { get; set; } = null!;

    public int? IdEmpleado { get; set; }

    public DateTime? FechaPedido { get; set; }

    public DateTime? FechaEntrega { get; set; }

    public DateTime? FechaEnvio { get; set; }

    public int? FormaEnvio { get; set; }

    public decimal? Cargo { get; set; }

    public string? Destinatario { get; set; }

    public string? DireccionDestinatario { get; set; }

    public string? CiudadDestinatario { get; set; }

    public string? RegionDestinatario { get; set; }

    public string? CodPostalDestinatario { get; set; }

    public string? PaisDestinatario { get; set; }

    public string? Eliminado { get; set; }

    public virtual ICollection<DetallesPedido> DetallesPedidos { get; set; } = new List<DetallesPedido>();

    public virtual Cliente IdClienteNavigation { get; set; } = null!;

    public virtual Empleado? IdEmpleadoNavigation { get; set; }
}
