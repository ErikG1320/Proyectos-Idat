using System.Data.SqlClient;

namespace DataAccess
{
    public class ProductoData
    {
        private readonly string _connectionString;
        public ProductoData(string connectionString)
        {
            _connectionString = connectionString;
        }

        public List<Producto> GetAllProductos()
        {
            List<Producto> productos = new List<Producto>();
            try
            {
                using (SqlConnection connection = new SqlConnection(_connectionString))
                {
                    string query = "SELECT Id,Nombre,Marca,Cantidad,Precio,Descripcion,Fecha FROM Productos";
                    connection.Open();
                    SqlCommand command = new SqlCommand(query, connection);
                    SqlDataReader reader = command.ExecuteReader();
                    while (reader.Read())
                    {
                        productos.Add(new Producto
                        {
                            Id = reader.GetInt32(0),
                            Nombre = reader.GetString(1),
                            Marca = reader.GetString(2),
                            Cantidad = reader.GetInt32(3),
                            Precio = reader.GetDecimal(4),
                            Descripcion = reader.GetString(5),
                            Fecha = reader.GetDateTime(6)
                        });
                    }
                }
            }
            catch (SqlException ex)
            {
                // Manejo de excepciones específicas de SQL
                Console.WriteLine(ex.Message);
            }
            catch (Exception ex)
            {
                // Manejo de excepciones generales
                Console.WriteLine(ex.Message);
            }
            return productos;
        }

        public Producto GetProductoById(int Id)
        {
            Producto producto = new Producto();
            try
            {
                using (SqlConnection connection = new SqlConnection(_connectionString))
                {
                    string query = "SELECT Id, Nombre, Marca, Cantidad, Precio, Descripcion, Fecha FROM Productos WHERE Id = @Id";
                    SqlCommand command = new SqlCommand(query, connection);
                    command.Parameters.AddWithValue("@Id", Id);
                    connection.Open();
                    SqlDataReader reader = command.ExecuteReader();
                    if (reader.Read())
                    {
                        producto = new Producto
                        {
                            Id = reader.GetInt32(0),
                            Nombre = reader.GetString(1),
                            Marca = reader.GetString(2),
                            Cantidad = reader.GetInt32(3),
                            Precio = reader.GetDecimal(4),
                            Descripcion = reader.GetString(5),
                            Fecha = reader.GetDateTime(6)
                        };
                    }
                }
            }
            catch (SqlException ex)
            {
                // Manejo de excepciones específicas de SQL
                Console.WriteLine(ex.Message);
            }
            catch (Exception ex)
            {
                // Manejo de excepciones generales
                Console.WriteLine(ex.Message);
            }
            return producto;
        }

        public void AddProducto(Producto producto)
        {
            try
            {
                using (SqlConnection connection = new SqlConnection(_connectionString))
                {
                    string query = "INSERT INTO Productos (Nombre, Marca, Cantidad, Precio, Descripcion, Fecha) VALUES (@Nombre, @Marca, @Cantidad, @Precio, @Descripcion, @Fecha)";
                    SqlCommand command = new SqlCommand(query, connection);
                    command.Parameters.AddWithValue("@Nombre", producto.Nombre);
                    command.Parameters.AddWithValue("@Marca", producto.Marca);
                    command.Parameters.AddWithValue("@Cantidad", producto.Cantidad);
                    command.Parameters.AddWithValue("@Precio", producto.Precio);
                    command.Parameters.AddWithValue("@Descripcion", producto.Descripcion);
                    command.Parameters.AddWithValue("@Fecha", producto.Fecha);
                    connection.Open();
                    command.ExecuteNonQuery();
                }
            }
            catch (SqlException ex)
            {
                // Manejo de excepciones específicas de SQL
                Console.WriteLine(ex.Message);
            }
            catch (Exception ex)
            {
                // Manejo de excepciones generales
                Console.WriteLine(ex.Message);
            }
        }
        public void UpdateProducto(Producto producto)
        {
            try
            {
                using (SqlConnection connection = new SqlConnection(_connectionString))
                {
                    string query = "UPDATE Productos SET Nombre = @Nombre, Marca = @Marca, Cantidad = @Cantidad, Precio = @Precio, Descripcion = @Descripcion, Fecha = @Fecha WHERE Id = @Id";
                    SqlCommand command = new SqlCommand(query, connection);
                    command.Parameters.AddWithValue("@Id", producto.Id);
                    command.Parameters.AddWithValue("@Nombre", producto.Nombre);
                    command.Parameters.AddWithValue("@Marca", producto.Marca);
                    command.Parameters.AddWithValue("@Cantidad", producto.Cantidad);
                    command.Parameters.AddWithValue("@Precio", producto.Precio);
                    command.Parameters.AddWithValue("@Descripcion", producto.Descripcion);
                    command.Parameters.AddWithValue("@Fecha", producto.Fecha);

                    connection.Open();
                    int result = command.ExecuteNonQuery();

                    // Paso para verificar si la actualización fue exitosa basándote en el resultado
                    if (result > 0)
                    {
                        Console.WriteLine("Producto actualizado con éxito.");
                    }
                    else
                    {
                        Console.WriteLine("No se actualizó ningún producto.");
                    }
                }
            }
            catch (SqlException ex)
            {
                // Manejo de excepciones específicas de SQL
                Console.WriteLine(ex.Message);
            }
            catch (Exception ex)
            {
                // Manejo de excepciones generales
                Console.WriteLine(ex.Message);
            }
        }
        public void DeleteProducto(int Id)
        {
            try
            {
                using (SqlConnection connection = new SqlConnection(_connectionString))
                {
                    string query = "DELETE FROM Productos WHERE Id = @Id";
                    SqlCommand command = new SqlCommand(query, connection);
                    command.Parameters.AddWithValue("@Id", Id);
                    connection.Open();
                    int result = command.ExecuteNonQuery();
                    // Puedes verificar si la eliminación fue exitosa basándote en el resultado
                    if (result > 0)
                    {
                        Console.WriteLine("Producto eliminado con éxito.");
                    }
                    else
                    {
                        Console.WriteLine("No se eliminó ningún producto.");
                    }
                }
            }
            catch (SqlException ex)
            {
                // Manejo de excepciones específicas de SQL
                Console.WriteLine(ex.Message);
            }
            catch (Exception ex)
            {
                // Manejo de excepciones generales
                Console.WriteLine(ex.Message);
            }
        }
    }
}
