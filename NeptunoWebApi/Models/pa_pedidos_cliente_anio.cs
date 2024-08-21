using System.ComponentModel.DataAnnotations;

namespace NeptunoWebApi.Models
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
