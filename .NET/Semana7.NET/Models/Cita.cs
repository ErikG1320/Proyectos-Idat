using System;
using System.Collections.Generic;

namespace Semana7.NET.Models;

public partial class Cita
{
    public int Nrocita { get; set; }

    public string Codmed { get; set; } = null!;

    public string Codpac { get; set; } = null!;

    public decimal? Pago { get; set; }

    public DateTime? Fecha { get; set; }

    public int? Estado { get; set; }

    public string? Descrip { get; set; }

    public virtual Medico CodmedNavigation { get; set; } = null!;

    public virtual Paciente CodpacNavigation { get; set; } = null!;
}
