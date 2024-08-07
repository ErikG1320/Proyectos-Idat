using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using ProyectoHospital.Data;
using ProyectoHospital.Models;
using Microsoft.EntityFrameworkCore.SqlServer;

namespace ProyectoHospital.Controllers
{
    public class ClinicaController : Controller
    {
        private readonly ClinicaContext clinicaContext;
        public ClinicaController(ClinicaContext context)
        {
            clinicaContext = context;
        }
        public IActionResult Index(string id)
        {
            var listado = clinicaContext.Citas.ToList();

            if (id != null)
                listado = listado.Where(
                     x => x.Paciente.StartsWith(id)).ToList();
            return View(listado);
        }
            public IActionResult Create()
            {
                return View();
            }
            [HttpPost]
            [ValidateAntiForgeryToken]
            public IActionResult Create(Cita cita)
            {
                clinicaContext.Citas.Add(cita);
                clinicaContext.SaveChanges();
                return RedirectToAction("Index");
            }
            public IActionResult Edit()
            {
                return View();
            }
            [HttpPost]
            [ValidateAntiForgeryToken]
            public IActionResult Edit(Cita cita)
            {
                clinicaContext.Citas.Update(cita);
                clinicaContext.SaveChanges();
                return RedirectToAction("Index");
            }
            public IActionResult Details()
            {
                return View();
            }
            [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
            public IActionResult Error()
            {
                return View("Error!");
            }
        }
    }