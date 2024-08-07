using System.Text.Json;
using Microsoft.AspNetCore.Mvc;
using ServicioWebApiGaspar.Models;



namespace ClienteAPI_Gaspar.Controllers
{
    [Route("[controller]")]
    public class PropietariosController : Controller
    {
        private readonly IHttpClientFactory httpClientFactory;

        public PropietariosController(IHttpClientFactory clientFactory)
        {
            httpClientFactory = clientFactory;
        }

        // GET: Propietarios/ListaPropietarios_ApePaterno
        public IActionResult ListaPropietarios_ApePaterno()
        {
            return View();
        }
        [HttpPost]
        public async Task<IActionResult> ListaPropietarios_ApePaterno(string inicial)
        {
            var request = new HttpRequestMessage(HttpMethod.Get, $"http://localhost:5088/api/Propietarios/{inicial}");
            var client = httpClientFactory.CreateClient();
            var response = await client.SendAsync(request);

            if (response.IsSuccessStatusCode)
            {
                var responseStream = await response.Content.ReadAsStreamAsync();
                var propietarios = await JsonSerializer.DeserializeAsync<IEnumerable<Propietario>>(responseStream);
                return View(propietarios);
            }
            else
            {
                // Manejo de errores
                return View(new List<Propietario>());
            }
        }

        // GET: Propietarios/ListaPapeletas_NOPagadas/{dni}
        public async Task<IActionResult> ListaPapeletas_NOPagadas(string dni)
        {
            var request = new HttpRequestMessage(HttpMethod.Get, $"http://localhost:5088/api/Papeletas/{dni}");
            var client = httpClientFactory.CreateClient();
            var response = await client.SendAsync(request);

            if (response.IsSuccessStatusCode)
            {
                var responseStream = await response.Content.ReadAsStreamAsync();
                var papeletas = await JsonSerializer.DeserializeAsync<IEnumerable<Papeleta>>(responseStream);
                ViewBag.NombrePropietario = dni; // Ajusta esto según sea necesario
                return View(papeletas);
            }
            else
            {
                // Manejo de errores
                return View(new List<Papeleta>());
            }
        }
        // POST: Propietarios/PagarPapeleta/{numeroPapeleta}
        [HttpPost]
        public async Task<IActionResult> PagarPapeleta(string numeroPapeleta)
        {
            var request = new HttpRequestMessage(HttpMethod.Put, $"http://localhost:5000/api/Papeletas/{numeroPapeleta}");
            var client = httpClientFactory.CreateClient();
            var response = await client.SendAsync(request);

            if (response.IsSuccessStatusCode)
            {
                var result = await response.Content.ReadAsStringAsync();
                ViewBag.Message = result;
            }
            else
            {
                ViewBag.Message = "Error al pagar la papeleta.";
            }

            return RedirectToAction(nameof(ListaPapeletas_NOPagadas));
        }
    }

}