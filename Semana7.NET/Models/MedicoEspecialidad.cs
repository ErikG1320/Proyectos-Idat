using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace Semana7.NET.Models
{
    public class MedicoEspecialidad
    {
        [Key]
        public int codmed { get; set; }
        public string nommed { get; set; }
        public string nomesp { get; set; }
        public int cant_citas { get; set; }
    }
}