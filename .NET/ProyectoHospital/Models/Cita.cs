using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ProyectoHospital.Models;

namespace ProyectoHospital.Models
{
    public class Cita
    {
        public int CitaID { get; set; }
        public int NombrePaciente { get; set; }
        public int NombreMedico { get; set; }
        public DateTime FechaCita { get; set; }
        public string Motivo { get; set; }="";
        public string Estado { get; set; }="";

        public Paciente? Paciente { get; set; }
        public Medico? Medico { get; set; }
    }
}