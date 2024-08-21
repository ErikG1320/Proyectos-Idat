using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using DataAccess;

namespace BusinessLayer
{
    public class ClinicaService
    {
        private readonly ClinicaData _clinicaData;
        public ClinicaService(string connectionString)
        {
            _clinicaData = new ClinicaData(connectionString);
        }
        public List<Procedure> ConsultarCitasPorMedicoYAnio(string codmed, int anio)
        {
            return _clinicaData.ConsultarCitasPorMedicoYAnio(codmed, anio);
        }
        public List<Cita> GetAllCita()
        {
            return _clinicaData.GetAllCita();
        }
    }
}