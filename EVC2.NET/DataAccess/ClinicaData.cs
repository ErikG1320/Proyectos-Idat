using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;

namespace DataAccess
{
    public class ClinicaData
    {
        private readonly string _connectionString;

        public ClinicaData(string connectionString)
        {
            _connectionString = connectionString;
        }

        public List<Procedure> ConsultarCitasPorMedicoYAnio(string codmed, int anio)
        {
            List<Procedure> citas = new List<Procedure>();

            using (SqlConnection connection = new SqlConnection(_connectionString))
            {
                connection.Open();

                using (SqlCommand command = new SqlCommand("MedicocitasYaño", connection))
                {
                    command.CommandType = CommandType.StoredProcedure;
                    command.Parameters.AddWithValue("@codmed", codmed);
                    command.Parameters.AddWithValue("@Anio", anio);

                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            // Crear un objeto Procedure y asignar los valores desde el lector
                            Procedure cita = new Procedure
                            {
                                NroCita = reader.GetInt32(0),
                                Fecha = reader.GetDateTime(1),
                                Codpac = reader.GetString(3),
                                NombrePaciente = reader.GetString(4),
                                Pago = reader.GetDecimal(5),
                                Descripcion = reader.GetString(6)
                            };
                            citas.Add(cita);
                        }
                    }
                }
            }
            return citas;
        }

        public List<Cita> GetAllCita()
        {
            List<Cita> citas = new List<Cita>();
            using (SqlConnection connection = new SqlConnection(_connectionString))
            {
                connection.Open();
                using (SqlCommand command = new SqlCommand("Citas", connection))
                {
                    command.CommandType = CommandType.StoredProcedure;
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            Cita cita = new Cita
                            {
                                Nrocita = reader.GetInt32(0),
                                Fecha = reader.GetDateTime(1),
                                Codmed = reader.GetString(2),
                                Codpac = reader.GetString(3),
                                Pago = reader.GetDecimal(4),
                                Estado = reader.GetInt32(5),
                                Descrip = reader.GetString(6)
                            };
                            citas.Add(cita);
                        }
                    }
                }
            }
            return citas;
        }
    }
}
