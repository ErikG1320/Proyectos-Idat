using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ProyectoHospital.Models
{
    public class HistorialMedico
    {
        public int HistorialID { get; set; }
        public int PacienteID { get; set; }
        public DateTime Fecha { get; set; }
        public string Descripcion { get; set; }="";
        public string Tratamiento { get; set; }="";

        public Paciente? Paciente { get; set; }
    }
}