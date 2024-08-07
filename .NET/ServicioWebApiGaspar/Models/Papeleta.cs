using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ServicioWebApiGaspar.Models
{
    public class Papeleta
    {
        public int Id_Papeleta { get; set; }
        public int Nro_Papeleta { get; set; }
        public int Nro_Placa { get; set; }
        public string Descripcion_Infraccion { get; set; }
        public DateTime Fecha { get; set; } = DateTime.Now;
        public double Importe_Infraccion { get; set; } = 0;
        public string Estado { get; set; }
        public int PropietarioId { get; set; }
        public Propietario Propietario { get; set; }
    }
}