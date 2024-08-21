using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using Pruebas.net.Models;
namespace Pruebas.net.Controllers;

public class HomeController : Controller
{
    private IHostEnvironment _env;

    public HomeController(IHostEnvironment env, ILogger<HomeController> logger)
    {
        _env = env;
        _logger = logger;
    }
    private readonly ILogger<HomeController> _logger;

    // public HomeController(ILogger<HomeController> logger)
    // {
    //     _logger = logger;
    // }
    public FileStreamResult pdf()
{
    var path = Path.Combine(_env.ContentRootPath, "wwwroot/downloads", "Prueba.pdf");
    var path404=Path.Combine(_env.ContentRootPath,"wwwrrot/downloads","pdfnotfound.pdf");
    if (System.IO.File.Exists(path))
    {
        return new FileStreamResult(new FileStream(path, FileMode.Open), "application/pdf");
    }
    else
    {
            return new FileStreamResult(new FileStream(path, FileMode.Open), "application/pdf");
    }
}
    public IActionResult Index()
    {
        return View();
    }
    public ViewResult Acerca()
    {
        return View();
    }
    public string HolaMundo(string nombre)
    {
        return "Hola " + nombre;
    }
    public IActionResult Privacy()
    {
        return View();
    }

    [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
    public IActionResult Error()
    {
        return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
    }
}
