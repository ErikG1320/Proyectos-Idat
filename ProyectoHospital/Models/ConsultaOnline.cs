using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ProyectoHospital.Models
{
    public class ConsultaOnline
    {
        public int ConsultaID { get; set; }
        public int PacienteID { get; set; }
        public int MedicoID { get; set; }
        public DateTime FechaConsulta { get; set; }
        public string Motivo { get; set; }="";
        public string Diagnostico { get; set; }="";
        public string Tratamiento { get; set; }="";

        public Paciente? Paciente { get; set; }
        public Medico? Medico { get; set; }
    }
}