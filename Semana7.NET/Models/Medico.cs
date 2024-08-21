using System;
using System.Collections.Generic;

namespace Semana7.NET.Models;

public partial class Medico
{
    public string Codmed { get; set; } = null!;

    public string? Nommed { get; set; }

    public int? AnioColegio { get; set; }

    public string? Codesp { get; set; }

    public string? Coddis { get; set; }

    public string? Eliminado { get; set; }

    public virtual ICollection<Cita> Cita { get; set; } = new List<Cita>();

    public virtual Distrito? CoddisNavigation { get; set; }

    public virtual Especialidad? CodespNavigation { get; set; }
}
