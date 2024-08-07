using Microsoft.EntityFrameworkCore;

namespace CrudWebTienda.Models.DTO
{
    public class TiendaContext : DbContext
    {
        public TiendaContext(DbContextOptions<TiendaContext> options)
            : base(options)
        {
        }
        public DbSet<Fabricante> Fabricantes {get; set; }
        public DbSet<Producto> Productos { get; set; }
        protected override void OnModelCreating(ModelBuilder builder)
        {
            builder.Entity<Producto>()
            .HasOne(p => p.Fabricante)
            .WithMany(f => f.Productos)
            .HasForeignKey(p => p.Cod_Fabricante);
            builder.Entity<Producto>()
            .Property(p => p.IdCod)
            .ValueGeneratedOnAdd();

            builder.Entity<Fabricante>()
            .Property(f => f.IdFab)
            .ValueGeneratedOnAdd();
        }
    }
}