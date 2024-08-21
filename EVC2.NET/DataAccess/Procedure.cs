using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace DataAccess
{
    public class Procedure
    {
        public int NroCita { get; set; }
        public DateTime Fecha { get; set; }
        public string? Codpac { get; set; }
        public string? NombrePaciente { get; set; }
        public decimal Pago { get; set; }
        public string? Descripcion { get; set; }
    }
}