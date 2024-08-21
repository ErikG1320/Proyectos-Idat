using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.Data.SqlClient;
using Microsoft.EntityFrameworkCore;
using MVC_EF_SP.Models;

namespace MVC_EF_SP.DATA
{
    public class DbCon : DbContext
    {
        public DbCon(DbContextOptions<DbCon> options) : base(options)
        {
        }
        public DbSet<Usuario> Usuarios { get; set; }

        protected override void OnModelCreating(ModelBuilder builder)
        {
            base.OnModelCreating(builder);
            builder.Entity<Usuario>().ToTable("Usuarios");
            builder.Entity<Usuario>().HasKey(u => u.Id_Usuario);
            builder.Entity<Usuario>().Property(u => u.Id_Usuario).HasColumnName("Id_Usuario").IsRequired();
            builder.Entity<Usuario>().Property(u => u.Nombre).HasColumnName("Nombre").HasMaxLength(50).IsRequired();
            builder.Entity<Usuario>().Property(u => u.Edad).HasColumnName("Edad").IsRequired();
            builder.Entity<Usuario>().HasIndex(u => u.Nombre).IsUnique();
        }

        public List<Usuario> ObtenerUsuariosSP()
        {
            try
            {
                return Usuarios.FromSqlRaw("EXEC sp_obtener_usuarios").ToList();
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error al obtener usuarios: {ex.Message}");
                return new List<Usuario>();
            }
        }

        public Usuario? ObtenerUsuarioporIdSP(int id)
        {
            try
            {
                var idParam = new SqlParameter("@Id_Usuario", id);
                return Usuarios.FromSqlRaw("EXEC sp_obtener_usuario @Id_Usuario", idParam).AsEnumerable().FirstOrDefault();
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error al obtener usuario por ID: {ex.Message}");
                return null;
            }
        }

        public void AgregarUsuarioSP(string nombre, int edad)
        {
            try
            {
                var nombreParam = new SqlParameter("@Nombre", nombre);
                var edadParam = new SqlParameter("@Edad", edad);
                Database.ExecuteSqlRaw("EXEC sp_insertar_usuarios @Nombre, @Edad", nombreParam, edadParam);
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error al agregar usuario: {ex.Message}");
            }
        }

        public void EditarUsuarioSP(int id, string nombre, int edad)
        {
            try
            {
                var idParam = new SqlParameter("@Id_Usuario", id);
                var nombreParam = new SqlParameter("@Nombre", nombre);
                var edadParam = new SqlParameter("@Edad", edad);
                Database.ExecuteSqlRaw("EXEC sp_editar_usuario @Id_Usuario, @Nombre, @Edad", idParam, nombreParam, edadParam);
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error al editar usuario: {ex.Message}");
            }
        }

        public void EliminarUsuarioSP(int id)
        {
            try
            {
                var idParam = new SqlParameter("@Id_Usuario", id);
                Database.ExecuteSqlRaw("EXEC sp_eliminar_usuario @Id_Usuario", idParam);
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error al eliminar usuario: {ex.Message}");
            }
        }
    }
}
