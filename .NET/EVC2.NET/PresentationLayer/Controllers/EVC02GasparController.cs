using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using BusinessLayer;
using DataAccess;
using Microsoft.AspNetCore.Mvc;
// using Microsoft.Extensions.Logging;

namespace PresentationLayer.Controllers
{
    [Route("[controller]")]
    public class EVC02GasparController(ClinicaService clinicaService) : Controller
    {
        private readonly ClinicaService _ClinicaService = clinicaService;
        public IActionResult ConsultarCitasPorMedicoYAnio(string codmed, int anio)
        {
            List<Procedure> Consultas = _ClinicaService.ConsultarCitasPorMedicoYAnio(codmed, anio);
            return View(Consultas);
        }
        public IActionResult ListarCitas ()
        {
            List<Cita> citas = _ClinicaService.GetAllCita();
            return View(citas);
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View("Error!");
        }
    }
}