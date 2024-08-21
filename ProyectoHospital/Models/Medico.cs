using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;

namespace ProyectoHospital.Models
{
    public class Medico
    {
        public int MedicoID { get; set; }
        public string Nombre { get; set; } ="";
        public string Apellido { get; set; }="";
        public int EspecialidadID { get; set; }
        public string Telefono { get; set; }="";
        public string CorreoElectronico { get; set; }="";
        public string Direccion { get; set; }="";
        public DateTime FechaContratacion { get; set; }

        public Especialidad? Especialidad { get; set; }
    }
}