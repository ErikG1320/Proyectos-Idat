﻿using System;
using System.Collections.Generic;

namespace DataAccess;

public partial class Especialidad
{
    public string Codesp { get; set; } = null!;

    public string? Nomesp { get; set; }

    public decimal? Costo { get; set; }

    public virtual ICollection<Medico> Medicos { get; set; } = new List<Medico>();
}
