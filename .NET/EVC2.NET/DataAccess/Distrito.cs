using System;
using System.Collections.Generic;

namespace DataAccess;

public partial class Distrito
{
    public string Coddis { get; set; } = null!;

    public string? Nomdis { get; set; }

    public virtual ICollection<Medico> Medicos { get; set; } = new List<Medico>();

    public virtual ICollection<Paciente> Pacientes { get; set; } = new List<Paciente>();
}
