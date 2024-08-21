using System;
using System.Collections.Generic;

namespace NeptunoWebApi.Models;

public partial class Cliente
{
    public string IdCliente { get; set; } = null!;

    public string NombreCliente { get; set; } = null!;

    public string? NombreContacto { get; set; }

    public string? CargoContacto { get; set; }

    public string? Direccion { get; set; }

    public string? Ciudad { get; set; }

    public string? Region { get; set; }

    public string? CodPostal { get; set; }

    public string? Pais { get; set; }

    public string? Telefono { get; set; }

    public string? Fax { get; set; }

    public string? Eliminado { get; set; }

    public virtual ICollection<Pedido> Pedidos { get; set; } = new List<Pedido>();
}
