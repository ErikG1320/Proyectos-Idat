using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;

namespace Pruebas.net.Controllers
{
    public class UsuariosController : Controller
    {
        // bool Encontrado=false;
        public IActionResult Index()
        {
            return View();
        }
        public IActionResult Registro(bool Encontrado)
        {
            if (Encontrado)
            {
                return Content("Registro encontrado");
            }
            else 
            {
                return StatusCode(505);
            }
            // return Content("<h1>Registro</h1>");
        }
    }
}