using Microsoft.EntityFrameworkCore;

namespace ServicioWebApiGaspar.Models
{
    public class DbCon :DbContext
    {
        public DbCon(DbContextOptions<DbCon> options) : base(options)
        {
        }
        public DbSet<Papeleta> Papeletas { get; set; }
        public DbSet<Propietario> Propietario { get; set; }
    }
}