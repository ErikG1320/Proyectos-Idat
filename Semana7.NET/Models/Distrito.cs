using System;
using System.Collections.Generic;

namespace Semana7.NET.Models;

public partial class Distrito
{
    public string Coddis { get; set; } = null!;

    public string Nomdis { get; set; } = null!;

    public string? Eliminado { get; set; }

    public virtual ICollection<Medico> Medicos { get; set; } = new List<Medico>();

    public virtual ICollection<Paciente> Pacientes { get; set; } = new List<Paciente>();
}
