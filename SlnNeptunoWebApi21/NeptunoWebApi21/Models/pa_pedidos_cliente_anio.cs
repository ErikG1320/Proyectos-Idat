using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

using System.ComponentModel.DataAnnotations;

namespace NeptunoWebApi21.Models
{
    public class pa_pedidos_cliente_anio
    {
        [Key]
        public int IdPedido { get; set; }
        public string FechaPedido { get; set; } = "";
        public int IdEmpleado { get; set; }
        public string Apellidos { get; set; } = string.Empty;
        public int Cant_Prod { get; set; }
        public decimal Importe { get; set; }
    }
}
