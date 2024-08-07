using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ProyectoHospital.Models
{
    public class MedicoPaciente
    {
        public int MedicoPacienteID { get; set; }
        public int MedicoID { get; set; }
        public int PacienteID { get; set; }

    }
}