using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ServicioWebApiGaspar.Models
{
    public class Propietario
    {
        public int PropietarioID { get; set;}
        public int DNI { get; set;}
        public string Nombre { get; set;}
        public string Distrito { get; set;}
    }
}