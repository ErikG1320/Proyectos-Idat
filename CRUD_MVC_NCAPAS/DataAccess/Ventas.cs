namespace DataAccess
{
    public class Ventas
    {
        public int Id { get; set; }
        public DateTime Fecha { get; set; }
        public string Cliente { get; set; } = "";
        public double Total { get; set; } = 0;
    }
}