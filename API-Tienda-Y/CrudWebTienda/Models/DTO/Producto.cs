using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace CrudWebTienda.Models.DTO
{
    public class Producto
    {
        [Key]
        public int IdCod { get; set; }
        public string Nombre { get; set; }
        public double Precio { get; set; }
        public int Cod_Fabricante { get; set; }
        [JsonIgnore]
        public Fabricante Fabricante { get; set; }
    }
}