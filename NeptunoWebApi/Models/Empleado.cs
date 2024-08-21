using System;
using System.Collections.Generic;

namespace NeptunoWebApi.Models;

public partial class Empleado
{
    public int IdEmpleado { get; set; }

    public string Apellidos { get; set; } = null!;

    public string Nombres { get; set; } = null!;

    public string? Cargo { get; set; }

    public string? Tratamiento { get; set; }

    public DateTime? FechaNacimiento { get; set; }

    public DateTime? FechaContratacion { get; set; }

    public string? Direccion { get; set; }

    public string? Ciudad { get; set; }

    public string? Region { get; set; }

    public string? CodPostal { get; set; }

    public string? Pais { get; set; }

    public string? TelDomicilio { get; set; }

    public int? Jefe { get; set; }

    public string? Eliminado { get; set; }

    public virtual ICollection<Pedido> Pedidos { get; set; } = new List<Pedido>();
}
