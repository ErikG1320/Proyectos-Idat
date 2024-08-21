﻿using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;

namespace DataAccess;

public partial class Bdclinica2024Context : DbContext
{
    public Bdclinica2024Context()
    {
    }

    public Bdclinica2024Context(DbContextOptions<Bdclinica2024Context> options)
        : base(options)
    {

    }

    public virtual DbSet<Cita> Citas { get; set; }

    public virtual DbSet<Distrito> Distritos { get; set; }

    public virtual DbSet<Especialidad> Especialidades { get; set; }

    public virtual DbSet<Medico> Medicos { get; set; }

    public virtual DbSet<Paciente> Pacientes { get; set; }

//     protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
// #warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
//         => optionsBuilder.UseSqlServer("");

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.UseCollation("Modern_Spanish_CI_AI");

        modelBuilder.Entity<Cita>(entity =>
        {
            entity.HasKey(e => e.Nrocita).HasName("pk_nrocita");

            entity.Property(e => e.Nrocita)
                .ValueGeneratedNever()
                .HasColumnName("nrocita");
            entity.Property(e => e.Codmed)
                .HasMaxLength(5)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("codmed");
            entity.Property(e => e.Codpac)
                .HasMaxLength(6)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("codpac");
            entity.Property(e => e.Descrip)
                .HasMaxLength(400)
                .IsUnicode(false)
                .HasColumnName("descrip");
            entity.Property(e => e.Estado)
                .HasDefaultValue(0)
                .HasColumnName("estado");
            entity.Property(e => e.Fecha)
                .HasDefaultValueSql("(getdate()+(1))")
                .HasColumnType("datetime")
                .HasColumnName("fecha");
            entity.Property(e => e.Pago)
                .HasColumnType("decimal(8, 2)")
                .HasColumnName("pago");
            entity.Property(e => e.Turno).HasColumnName("turno");

            entity.HasOne(d => d.CodmedNavigation).WithMany(p => p.Cita)
                .HasForeignKey(d => d.Codmed)
                .HasConstraintName("fk_citas_codmed");

            entity.HasOne(d => d.CodpacNavigation).WithMany(p => p.Cita)
                .HasForeignKey(d => d.Codpac)
                .HasConstraintName("fk_citas_codpac");
        });

        modelBuilder.Entity<Distrito>(entity =>
        {
            entity.HasKey(e => e.Coddis).HasName("pk_coddis");

            entity.ToTable("Distrito");

            entity.Property(e => e.Coddis)
                .HasMaxLength(3)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("coddis");
            entity.Property(e => e.Nomdis)
                .HasMaxLength(35)
                .IsUnicode(false)
                .HasColumnName("nomdis");
        });

        modelBuilder.Entity<Especialidad>(entity =>
        {
            entity.HasKey(e => e.Codesp).HasName("pk_codesp");

            entity.ToTable("Especialidad");

            entity.Property(e => e.Codesp)
                .HasMaxLength(3)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("codesp");
            entity.Property(e => e.Costo)
                .HasColumnType("decimal(8, 2)")
                .HasColumnName("costo");
            entity.Property(e => e.Nomesp)
                .HasMaxLength(40)
                .IsUnicode(false)
                .HasColumnName("nomesp");
        });

        modelBuilder.Entity<Medico>(entity =>
        {
            entity.HasKey(e => e.Codmed).HasName("pk_codmed");

            entity.Property(e => e.Codmed)
                .HasMaxLength(5)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("codmed");
            entity.Property(e => e.AnioColegio).HasColumnName("anio_colegio");
            entity.Property(e => e.Coddis)
                .HasMaxLength(3)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("coddis");
            entity.Property(e => e.Codesp)
                .HasMaxLength(3)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("codesp");
            entity.Property(e => e.Estado)
                .HasDefaultValue(1)
                .HasColumnName("estado");
            entity.Property(e => e.Nommed)
                .HasMaxLength(40)
                .IsUnicode(false)
                .HasColumnName("nommed");

            entity.HasOne(d => d.CoddisNavigation).WithMany(p => p.Medicos)
                .HasForeignKey(d => d.Coddis)
                .HasConstraintName("fk_medicos_coddis");

            entity.HasOne(d => d.CodespNavigation).WithMany(p => p.Medicos)
                .HasForeignKey(d => d.Codesp)
                .HasConstraintName("fk_medicos_codesp");
        });

        modelBuilder.Entity<Paciente>(entity =>
        {
            entity.HasKey(e => e.Codpac).HasName("pk_codpac");

            entity.Property(e => e.Codpac)
                .HasMaxLength(6)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("codpac");
            entity.Property(e => e.Coddis)
                .HasMaxLength(3)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("coddis");
            entity.Property(e => e.Dirpac)
                .HasMaxLength(50)
                .IsUnicode(false)
                .HasColumnName("dirpac");
            entity.Property(e => e.Dnipac)
                .HasMaxLength(8)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("dnipac");
            entity.Property(e => e.Estado).HasColumnName("estado");
            entity.Property(e => e.Nompac)
                .HasMaxLength(50)
                .IsUnicode(false)
                .HasColumnName("nompac");
            entity.Property(e => e.TelCel)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("tel_cel");

            entity.HasOne(d => d.CoddisNavigation).WithMany(p => p.Pacientes)
                .HasForeignKey(d => d.Coddis)
                .HasConstraintName("fk_pacientes_coddis");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
