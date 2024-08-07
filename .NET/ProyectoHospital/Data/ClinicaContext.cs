using Microsoft.EntityFrameworkCore;
using ProyectoHospital.Models;

namespace ProyectoHospital.Data
{
    public class ClinicaContext : DbContext
    {
        public ClinicaContext(DbContextOptions<ClinicaContext> options)
            : base(options)
        {
        }

        public DbSet<Paciente> Pacientes { get; set; }
        public DbSet<Medico> Medicos { get; set; }
        public DbSet<Cita> Citas { get; set; }
        public DbSet<HistorialMedico> HistorialMedicos { get; set; }
        public DbSet<Especialidad> Especialidades { get; set; }
        public DbSet<ConsultaOnline> ConsultasOnline { get; set; }
    }
}
