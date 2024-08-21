using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;

namespace NeptunoWebApi.Models;

public partial class Neptuno2023Context : DbContext
{
    public Neptuno2023Context()
    {
    }

    public Neptuno2023Context(DbContextOptions<Neptuno2023Context> options)
        : base(options)
    {
    }

    public virtual DbSet<Categoria> Categorias { get; set; }

    public virtual DbSet<Cliente> Clientes { get; set; }

    public virtual DbSet<DetallesPedido> DetallesPedidos { get; set; }

    public virtual DbSet<Empleado> Empleados { get; set; }

    public virtual DbSet<Pedido> Pedidos { get; set; }

    public virtual DbSet<Producto> Productos { get; set; }

    public virtual DbSet<Proveedore> Proveedores { get; set; }

    //
    public virtual DbSet<pa_pedidos_cliente_anio> pa_pedidos_cliente_anio { get; set; }

    //
    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        //#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
        // => optionsBuilder.UseSqlServer("server=localhost;database=Neptuno2023;integrated security=true;Trust Server Certificate=false;Encrypt=false;");
    }
    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Categoria>(entity =>
        {
            entity.HasKey(e => e.IdCategoria);

            entity.Property(e => e.IdCategoria).ValueGeneratedNever();
            entity.Property(e => e.Descripcion)
                .HasMaxLength(200)
                .IsUnicode(false);
            entity.Property(e => e.Eliminado)
                .HasMaxLength(2)
                .IsUnicode(false)
                .HasDefaultValue("No")
                .IsFixedLength();
            entity.Property(e => e.NombreCategoria)
                .HasMaxLength(30)
                .IsUnicode(false);
        });

        modelBuilder.Entity<Cliente>(entity =>
        {
            entity.HasKey(e => e.IdCliente);

            entity.Property(e => e.IdCliente)
                .HasMaxLength(5)
                .IsUnicode(false);
            entity.Property(e => e.CargoContacto)
                .HasMaxLength(30)
                .IsUnicode(false);
            entity.Property(e => e.Ciudad)
                .HasMaxLength(15)
                .IsUnicode(false);
            entity.Property(e => e.CodPostal)
                .HasMaxLength(10)
                .IsUnicode(false);
            entity.Property(e => e.Direccion)
                .HasMaxLength(60)
                .IsUnicode(false);
            entity.Property(e => e.Eliminado)
                .HasMaxLength(2)
                .IsUnicode(false)
                .HasDefaultValue("No")
                .IsFixedLength();
            entity.Property(e => e.Fax)
                .HasMaxLength(24)
                .IsUnicode(false);
            entity.Property(e => e.NombreCliente)
                .HasMaxLength(50)
                .IsUnicode(false);
            entity.Property(e => e.NombreContacto)
                .HasMaxLength(30)
                .IsUnicode(false);
            entity.Property(e => e.Pais)
                .HasMaxLength(15)
                .IsUnicode(false);
            entity.Property(e => e.Region)
                .HasMaxLength(15)
                .IsUnicode(false);
            entity.Property(e => e.Telefono)
                .HasMaxLength(24)
                .IsUnicode(false);
        });

        modelBuilder.Entity<DetallesPedido>(entity =>
        {
            entity.HasKey(e => new { e.IdPedido, e.IdProducto });

            entity.ToTable("Detalles_Pedidos");

            entity.Property(e => e.Descuento).HasColumnType("decimal(7, 2)");
            entity.Property(e => e.Eliminado)
                .HasMaxLength(2)
                .IsUnicode(false)
                .HasDefaultValue("No")
                .IsFixedLength();
            entity.Property(e => e.PrecioUnidad).HasColumnType("decimal(8, 2)");

            entity.HasOne(d => d.IdPedidoNavigation).WithMany(p => p.DetallesPedidos)
                .HasForeignKey(d => d.IdPedido)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK_Detalles_Pedidos_Pedidos");

            entity.HasOne(d => d.IdProductoNavigation).WithMany(p => p.DetallesPedidos)
                .HasForeignKey(d => d.IdProducto)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK_Detalles_Pedidos_Productos");
        });

        modelBuilder.Entity<Empleado>(entity =>
        {
            entity.HasKey(e => e.IdEmpleado);

            entity.Property(e => e.IdEmpleado).ValueGeneratedNever();
            entity.Property(e => e.Apellidos)
                .HasMaxLength(30)
                .IsUnicode(false);
            entity.Property(e => e.Cargo)
                .HasMaxLength(30)
                .IsUnicode(false);
            entity.Property(e => e.Ciudad)
                .HasMaxLength(15)
                .IsUnicode(false);
            entity.Property(e => e.CodPostal)
                .HasMaxLength(10)
                .IsUnicode(false);
            entity.Property(e => e.Direccion)
                .HasMaxLength(60)
                .IsUnicode(false);
            entity.Property(e => e.Eliminado)
                .HasMaxLength(2)
                .IsUnicode(false)
                .HasDefaultValue("No")
                .IsFixedLength();
            entity.Property(e => e.FechaContratacion).HasColumnType("datetime");
            entity.Property(e => e.FechaNacimiento).HasColumnType("datetime");
            entity.Property(e => e.Nombres)
                .HasMaxLength(20)
                .IsUnicode(false);
            entity.Property(e => e.Pais)
                .HasMaxLength(15)
                .IsUnicode(false);
            entity.Property(e => e.Region)
                .HasMaxLength(15)
                .IsUnicode(false);
            entity.Property(e => e.TelDomicilio)
                .HasMaxLength(24)
                .IsUnicode(false);
            entity.Property(e => e.Tratamiento)
                .HasMaxLength(25)
                .IsUnicode(false);
        });

        modelBuilder.Entity<Pedido>(entity =>
        {
            entity.HasKey(e => e.IdPedido);

            entity.Property(e => e.IdPedido).ValueGeneratedNever();
            entity.Property(e => e.Cargo).HasColumnType("money");
            entity.Property(e => e.CiudadDestinatario)
                .HasMaxLength(15)
                .IsUnicode(false);
            entity.Property(e => e.CodPostalDestinatario)
                .HasMaxLength(10)
                .IsUnicode(false);
            entity.Property(e => e.Destinatario)
                .HasMaxLength(40)
                .IsUnicode(false);
            entity.Property(e => e.DireccionDestinatario)
                .HasMaxLength(60)
                .IsUnicode(false);
            entity.Property(e => e.Eliminado)
                .HasMaxLength(2)
                .IsUnicode(false)
                .HasDefaultValue("No")
                .IsFixedLength();
            entity.Property(e => e.FechaEntrega).HasColumnType("datetime");
            entity.Property(e => e.FechaEnvio).HasColumnType("datetime");
            entity.Property(e => e.FechaPedido).HasColumnType("datetime");
            entity.Property(e => e.IdCliente)
                .HasMaxLength(5)
                .IsUnicode(false);
            entity.Property(e => e.PaisDestinatario)
                .HasMaxLength(15)
                .IsUnicode(false);
            entity.Property(e => e.RegionDestinatario)
                .HasMaxLength(15)
                .IsUnicode(false);

            entity.HasOne(d => d.IdClienteNavigation).WithMany(p => p.Pedidos)
                .HasForeignKey(d => d.IdCliente)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK_Pedidos_Clientes");

            entity.HasOne(d => d.IdEmpleadoNavigation).WithMany(p => p.Pedidos)
                .HasForeignKey(d => d.IdEmpleado)
                .HasConstraintName("FK_Pedidos_Empleados");
        });

        modelBuilder.Entity<Producto>(entity =>
        {
            entity.HasKey(e => e.IdProducto);

            entity.Property(e => e.IdProducto).ValueGeneratedNever();
            entity.Property(e => e.CantidadPorUnidad)
                .HasMaxLength(20)
                .IsUnicode(false);
            entity.Property(e => e.Eliminado)
                .HasMaxLength(2)
                .IsUnicode(false)
                .HasDefaultValue("No")
                .IsFixedLength();
            entity.Property(e => e.NombreProducto)
                .HasMaxLength(40)
                .IsUnicode(false);
            entity.Property(e => e.PrecioUnidad).HasColumnType("money");

            entity.HasOne(d => d.IdCategoriaNavigation).WithMany(p => p.Productos)
                .HasForeignKey(d => d.IdCategoria)
                .HasConstraintName("FK_Productos_Categorias");

            entity.HasOne(d => d.IdProveedorNavigation).WithMany(p => p.Productos)
                .HasForeignKey(d => d.IdProveedor)
                .HasConstraintName("FK_Productos_Proveedores");
        });

        modelBuilder.Entity<Proveedore>(entity =>
        {
            entity.HasKey(e => e.IdProveedor);

            entity.Property(e => e.IdProveedor).ValueGeneratedNever();
            entity.Property(e => e.CargoContacto)
                .HasMaxLength(30)
                .IsUnicode(false);
            entity.Property(e => e.Ciudad)
                .HasMaxLength(15)
                .IsUnicode(false);
            entity.Property(e => e.CodPostal)
                .HasMaxLength(10)
                .IsUnicode(false);
            entity.Property(e => e.Direccion)
                .HasMaxLength(60)
                .IsUnicode(false);
            entity.Property(e => e.Eliminado)
                .HasMaxLength(2)
                .IsUnicode(false)
                .HasDefaultValue("No")
                .IsFixedLength();
            entity.Property(e => e.NombreContacto)
                .HasMaxLength(30)
                .IsUnicode(false);
            entity.Property(e => e.NombreProveedor)
                .HasMaxLength(40)
                .IsUnicode(false);
            entity.Property(e => e.PaginaPrincipal).IsUnicode(false);
            entity.Property(e => e.Pais)
                .HasMaxLength(15)
                .IsUnicode(false);
            entity.Property(e => e.Region)
                .HasMaxLength(15)
                .IsUnicode(false);
            entity.Property(e => e.Telefono)
                .HasMaxLength(24)
                .IsUnicode(false);
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
