using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ProyectoHospital.Models
{
    public class Paciente
    {
        public int PacienteID { get; set; }
        public string Nombre { get; set; }="";
        public string Apellido { get; set; }="";
        public DateTime FechaNacimiento { get; set; }
        public char Genero { get; set; }
        public string Telefono { get; set; }="";
        public string CorreoElectronico { get; set; }="";
        public string Direccion { get; set; }="";
        public DateTime FechaRegistro { get; set; }

        internal bool StartsWith(string id)
        {
            throw new NotImplementedException();
        }
    }
}