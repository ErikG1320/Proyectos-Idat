using System;
using System.Collections.Generic;

namespace Semana7.NET.Models;

public partial class Paciente
{
    public string Codpac { get; set; } = null!;

    public string Nompac { get; set; } = null!;

    public string? Dnipac { get; set; }

    public string? TelCel { get; set; }

    public string? Dirpac { get; set; }

    public string? Coddis { get; set; }

    public string? Eliminado { get; set; }

    public virtual ICollection<Cita> Cita { get; set; } = new List<Cita>();

    public virtual Distrito? CoddisNavigation { get; set; }
}
