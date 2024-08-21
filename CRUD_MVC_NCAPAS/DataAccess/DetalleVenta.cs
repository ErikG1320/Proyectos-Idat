namespace DataAccess
{
    public class DetalleVenta
    {
        public int Id { get; set; }
        public int Venta_Id { get; set; }
        public int Producto_Id { get; set; }
        public int Cantidad { get; set; }
        public double Precio { get; set; }
    }
}