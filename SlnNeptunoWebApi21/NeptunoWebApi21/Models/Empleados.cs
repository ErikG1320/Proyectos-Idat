using System;
using System.Collections.Generic;

namespace NeptunoWebApi21.Models
{
    public partial class Empleados
    {
        public Empleados()
        {
            Pedidos = new HashSet<Pedidos>();
        }

        public int IdEmpleado { get; set; }
        public string Apellidos { get; set; }
        public string Nombres { get; set; }
        public string Cargo { get; set; }
        public string Tratamiento { get; set; }
        public DateTime? FechaNacimiento { get; set; }
        public DateTime? FechaContratacion { get; set; }
        public string Direccion { get; set; }
        public string Ciudad { get; set; }
        public string Region { get; set; }
        public string CodPostal { get; set; }
        public string Pais { get; set; }
        public string TelDomicilio { get; set; }
        public int? Jefe { get; set; }
        public string Eliminado { get; set; }

        public ICollection<Pedidos> Pedidos { get; set; }
    }
}
